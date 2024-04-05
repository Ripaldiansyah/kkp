/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.dao;

import edu.unindra.kkp_kelompok4.Services.serviceCheckIn;
import edu.unindra.kkp_kelompok4.model.modelDistributor;
import edu.unindra.kkp_kelompok4.model.modelEmployee;
import edu.unindra.kkp_kelompok4.model.modelItemCheckin;
import edu.unindra.kkp_kelompok4.resource.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ripal
 */
public class DAO_CheckIn implements serviceCheckIn{
	private Connection conn;
	public DAO_CheckIn() {
        conn = new koneksi().connect();
}
	
	
	@Override
	public void addTransaction(modelItemCheckin itemCheckin) {
	PreparedStatement stat=null;
	String sql = "INSERT INTO itemCheckin (noCheckin, dateCheckin,totalCheckin,transactionName,idEmployee,statusTransaction) VALUES (?,?,?,?,?,?)";
		try {
			stat=conn.prepareStatement(sql);
			
			stat.setString(1, itemCheckin.getNoCheckin());
			stat.setString(2, itemCheckin.getDateCheckin());
			stat.setInt(3, itemCheckin.getTotalCheckin());
			stat.setString(4, itemCheckin.getTransactionName());
			stat.setString(5, itemCheckin.getEmployee().getIdEmployee());
			stat.setString(6, itemCheckin.getStatusTransaction());
			
			stat.executeUpdate();
			
		}  catch (Exception e) {
			Logger.getLogger(DAO_CheckIn.class.getName()).log(Level.SEVERE,null,e);	
		}finally{
				if (stat!=null) {
					try {
						stat.close();
					} catch (Exception e) {
						Logger.getLogger(DAO_CheckIn.class.getName()).log(Level.SEVERE,null,e);
					}
				}
			}
	}

	@Override
	public modelItemCheckin getById(String id) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public List<modelItemCheckin> getItem() {
	PreparedStatement stat = null;
	List<modelItemCheckin> list = new ArrayList<>();
	ResultSet rs = null;
	String sql = "SELECT * FROM itemCheckin";
	try {
	    stat = conn.prepareStatement(sql);
	    rs = stat.executeQuery();
	    while (rs.next()) {
		modelItemCheckin checkin = new modelItemCheckin();
		modelEmployee employee = new modelEmployee();

		checkin.setNoCheckin(rs.getString("noCheckin"));
		checkin.setDateCheckin(rs.getString("dateCheckin"));
		checkin.setTotalCheckin(rs.getInt("totalCheckin"));
		checkin.setTransactionName(rs.getString("transactionName"));
		checkin.setStatusTransaction(rs.getString("statusTransaction"));
		String idEmployee = rs.getString("idEmployee");

		// Mengambil nama employee berdasarkan employeeId
		String employeeSql = "SELECT employeeName FROM employeeTable WHERE idEmployee = ?";
		PreparedStatement employeeStat = conn.prepareStatement(employeeSql);
		employeeStat.setString(1, idEmployee);
		ResultSet employeeResult = employeeStat.executeQuery();

		if (employeeResult.next()) {
		    employee.setIdEmployee(idEmployee);
		    employee.setEmployeeName(employeeResult.getString("employeeName"));
		}

		employeeResult.close();
		employeeStat.close();

		checkin.setEmployee(employee);
		list.add(checkin);
	    }
	    return list;
	} catch (Exception e) {
	    Logger.getLogger(DAO_CheckIn.class.getName()).log(Level.SEVERE, null, e);
	    return null;
	} finally {
	    if (stat != null) {
		try {
		    stat.close();
		} catch (Exception e) {
		    Logger.getLogger(DAO_CheckIn.class.getName()).log(Level.SEVERE, null, e);
		}
	    }
	    if (rs != null) {
		try {
		    rs.close();
		} catch (Exception e) {
		    Logger.getLogger(DAO_CheckIn.class.getName()).log(Level.SEVERE, null, e);
		}
	    }
	}
    }



	@Override
	public List<modelItemCheckin> Search(String id) {
		PreparedStatement stat = null;
		List list = new ArrayList();
		ResultSet rs = null;
		String sql = "SELECT * FROM itemCheckin WHERE transactionName LIKE '%"+id+"%' OR noCheckin LIKE '%"+id+"%' OR dateCheckin LIKE '%"+id+"%'"
			+ "OR totalCheckin LIKE '%"+id+"%' OR totalCheckin LIKE '%"+id+"%' OR idEmployee LIKE '%"+id+"%'";
		try {
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			
			while (rs.next()) {				
				modelItemCheckin checkin = new modelItemCheckin();
				modelEmployee employee = new modelEmployee();
				checkin.setNoCheckin(rs.getString("noCheckin"));
				checkin.setDateCheckin(rs.getString("dateCheckin"));
				checkin.setTotalCheckin(rs.getInt("totalCheckin"));
				checkin.setTransactionName(rs.getString("transactionName"));
				employee.setIdEmployee(rs.getString("idEmployee"));
				checkin.setEmployee(employee);
//				
				list.add(checkin);
			}
			return list;
		} catch (Exception e) {
			Logger.getLogger(DAO_CheckIn.class.getName()).log(Level.SEVERE,null,e);
			return null;
		}finally{
			if (stat!=null) {
				try {
					stat.close();
				} catch (Exception e) {
					Logger.getLogger(DAO_CheckIn.class.getName()).log(Level.SEVERE,null,e);
				}
			}
		}
		
	}

	@Override
	public String number() {
		PreparedStatement stat = null;
		ResultSet rs = null;
		String listing = null;
		LocalDate now = LocalDate.now();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

		String tgl = now.format(dateFormatter);
		
		String sql = "SELECT SUBSTR(noCheckin, -3) AS Number " +
				"FROM itemCheckin " +
				"WHERE noCheckin LIKE 'ORDER-BRG-" + tgl + "%' " +
				"ORDER BY noCheckin DESC " +
				"LIMIT 1";
			;
		try {
			stat=conn.prepareStatement(sql);
			rs = stat.executeQuery();
			
			if (rs.next()) {
				int number =Integer.parseInt(rs.getString("number"));
				number++;
				listing="ORDER-BRG-"+tgl+String.format("%03d",number);
				
			}else{
				listing="ORDER-BRG-"+tgl+"001";
			}
		} catch (Exception e) {
			Logger.getLogger(DAO_CheckIn.class.getName()).log(Level.SEVERE,null,e);
		}finally{
			if (stat!=null) {
				try {
					stat.close();
				} catch (Exception e) {
					Logger.getLogger(DAO_CheckIn.class.getName()).log(Level.SEVERE,null,e);
				}
			}
		}
		return listing;
	}

	@Override
	public void deteleTransaction(modelItemCheckin itemCheckin) {
	PreparedStatement stat=null;
		String sqlItemCheckin  = "DELETE From itemCheckin where noCheckin=?";
		String sqlDetailCheckin = "DELETE FROM detailCheckin WHERE noCheckin = ?";
		try {
			stat=(PreparedStatement) conn.prepareStatement(sqlItemCheckin);
			stat.setString(1,itemCheckin.getNoCheckin());
			stat.executeUpdate();
			stat.close();
			stat = (PreparedStatement) conn.prepareStatement(sqlDetailCheckin);
			stat.setString(1, itemCheckin.getNoCheckin());
			stat.executeUpdate();
		} catch (Exception e) {
			Logger.getLogger(DAO_CheckIn.class.getName()).log(Level.SEVERE,null,e);
		}finally{
			if (stat!=null) {
				try {
					stat.close();
				} catch (Exception e) {
					Logger.getLogger(DAO_CheckIn.class.getName()).log(Level.SEVERE,null,e);
				}
			}
		}
	}

	@Override
	public void updateTransaction(modelItemCheckin itemCheckin) {
	PreparedStatement stat = null;
	String sql = "UPDATE itemCheckin SET dateCheckin = ?, totalCheckin = ?, transactionName = ?, idEmployee = ? WHERE noCheckin = ?";
	try {
	    stat = conn.prepareStatement(sql);
	    
	    
	    stat.setString(1, itemCheckin.getDateCheckin());
	    stat.setInt(2, itemCheckin.getTotalCheckin());
	    stat.setString(3, itemCheckin.getTransactionName());
	    stat.setString(4, itemCheckin.getEmployee().getIdEmployee());
	    stat.setString(5, itemCheckin.getNoCheckin());

	    stat.executeUpdate();

	} catch (Exception e) {
	    Logger.getLogger(DAO_CheckIn.class.getName()).log(Level.SEVERE, null, e);    
	} finally {
	    if (stat != null) {
		try {
		    stat.close();
		} catch (Exception e) {
		    Logger.getLogger(DAO_CheckIn.class.getName()).log(Level.SEVERE, null, e);
		}
	    }
	}
}

	@Override
	public void updateStatusTransaction(modelItemCheckin itemCheckin) {
	PreparedStatement stat = null;
	String sql = "UPDATE itemCheckin SET statusTransaction = ? WHERE noCheckin = ?";
	try {
	    stat = conn.prepareStatement(sql);
	    
	    
	    stat.setString(1, itemCheckin.getStatusTransaction());
	    stat.setString(2, itemCheckin.getNoCheckin());

	    stat.executeUpdate();

	} catch (Exception e) {
	    Logger.getLogger(DAO_CheckIn.class.getName()).log(Level.SEVERE, null, e);    
	} finally {
	    if (stat != null) {
		try {
		    stat.close();
		} catch (Exception e) {
		    Logger.getLogger(DAO_CheckIn.class.getName()).log(Level.SEVERE, null, e);
		}
	    }
	}
	}

	@Override
	public void confirmAll(modelItemCheckin itemCheckin) {
	PreparedStatement stat = null;
	String sql = "UPDATE itemCheckin SET statusTransaction = ? WHERE noCheckin = ?";
	try {
	    stat = conn.prepareStatement(sql);
	    
	    
	    stat.setString(1, itemCheckin.getStatusTransaction());
	    stat.setString(2, itemCheckin.getNoCheckin());

	    stat.executeUpdate();

	} catch (Exception e) {
	    Logger.getLogger(DAO_CheckIn.class.getName()).log(Level.SEVERE, null, e);    
	} finally {
	    if (stat != null) {
		try {
		    stat.close();
		} catch (Exception e) {
		    Logger.getLogger(DAO_CheckIn.class.getName()).log(Level.SEVERE, null, e);
		}
	    }
	}
	}

	@Override
	public void confirm(modelItemCheckin itemCheckin) {
	PreparedStatement stat = null;
	String sql = "UPDATE itemCheckin SET statusTransaction = ? WHERE noCheckin = ?";
	try {
	    stat = conn.prepareStatement(sql);
	    
	    
	    stat.setString(1, itemCheckin.getStatusTransaction());
	    stat.setString(2, itemCheckin.getNoCheckin());

	    stat.executeUpdate();

	} catch (Exception e) {
	    Logger.getLogger(DAO_CheckIn.class.getName()).log(Level.SEVERE, null, e);    
	} finally {
	    if (stat != null) {
		try {
		    stat.close();
		} catch (Exception e) {
		    Logger.getLogger(DAO_CheckIn.class.getName()).log(Level.SEVERE, null, e);
		}
	    }
	}
	}

}
