/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.dao;

import edu.unindra.kkp_kelompok4.Services.serviceCheckIn;
import edu.unindra.kkp_kelompok4.Services.serviceIncomingItems;
import edu.unindra.kkp_kelompok4.model.modelDetailIncomingItems;
import edu.unindra.kkp_kelompok4.model.modelDistributor;
import edu.unindra.kkp_kelompok4.model.modelEmployee;
import edu.unindra.kkp_kelompok4.model.modelIncomingItems;
import edu.unindra.kkp_kelompok4.model.modelItemCheckin;
import edu.unindra.kkp_kelompok4.resource.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ripal
 */
public class DAO_IncomingItems implements serviceIncomingItems{
	private Connection conn;
	public DAO_IncomingItems() {
        conn = new koneksi().connect();
}

	@Override
	public void sendOrder(modelIncomingItems incomingItems) {
	PreparedStatement stat=null;
	String sql = "INSERT INTO incomingItems (noCheckin) VALUES (?)";
		try {
			stat=conn.prepareStatement(sql);
			
			stat.setString(1, incomingItems.getNoCheckin());
			
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
	public List<modelIncomingItems> getItem() {
	PreparedStatement stat = null;
	List<modelIncomingItems> list = new ArrayList<>();
	ResultSet rs = null;
	String sql = "SELECT ii.noCheckin, ic.dateCheckin, ic.totalCheckin, ic.transactionName, ic.idEmployee, et.employeeName, ic.statusTransaction FROM incomingItems ii INNER JOIN itemCheckin ic ON ii.noCheckin = ic.noCheckin INNER JOIN employeeTable et ON ic.idEmployee = et.idEmployee";

	try {
	    stat = conn.prepareStatement(sql);
	    rs = stat.executeQuery();

	    while (rs.next()) {
		modelIncomingItems checkin = new modelIncomingItems();
		modelEmployee employee = new modelEmployee();
		modelItemCheckin itemCheckin = new modelItemCheckin();

		checkin.setNoCheckin(rs.getString("noCheckIn"));
		

		// Mengambil data dari tabel itemCheckin
		itemCheckin.setDateCheckin(rs.getString("dateCheckin"));
		itemCheckin.setTotalCheckin(rs.getInt("totalCheckin"));
		itemCheckin.setTransactionName(rs.getString("transactionName"));
		itemCheckin.setStatusTransaction(rs.getString("statusTransaction"));
		employee.setIdEmployee(rs.getString("idEmployee"));
		employee.setEmployeeName(rs.getString("employeeName"));
		itemCheckin.setEmployee(employee);
		
		checkin.setItemCheckin(itemCheckin);
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
	public List<modelIncomingItems> Search(String id) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public boolean checkOrder(modelIncomingItems incomingItems) {
		String checkSql = "SELECT 1 FROM incomingItems WHERE noCheckIn = ?";
		PreparedStatement stat=null;
		try {
		    stat = conn.prepareStatement(checkSql);
		    stat.setString(1, incomingItems.getNoCheckin());
		    ResultSet result = stat.executeQuery();
		    if (result.next()) {
			return true;
		    } else {
			return false;
		    }
		} catch (SQLException ex) {
		    Logger.getLogger(DAO_IncomingItems.class.getName()).log(Level.SEVERE, null, ex);
		    return false; 
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
	public boolean checkOrderDetail(modelDetailIncomingItems detailIncomingItems) {
		String checkSql = "SELECT 1 FROM detailCheckin WHERE status = ? AND noCheckin=?";
		PreparedStatement stat=null;
		try {
		    stat = conn.prepareStatement(checkSql);
		    stat.setString(1, detailIncomingItems.getStatus());
		    stat.setString(2, detailIncomingItems.getNoCheckin());
		    ResultSet result = stat.executeQuery();
		    if (result.next()) {
			return true;
		    } else {
			return false;
		    }
		} catch (SQLException ex) {
		    Logger.getLogger(DAO_IncomingItems.class.getName()).log(Level.SEVERE, null, ex);
		    return false; 
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
	public void updateStatus(modelIncomingItems incomingItems) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void deleteTransaction(modelIncomingItems incomingItems) {
	PreparedStatement stat=null;
		String sql  = "DELETE From incomingItems where noCheckin=?";
		try {
			stat=(PreparedStatement) conn.prepareStatement(sql);
			stat.setString(1,incomingItems.getNoCheckin());
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
	public boolean checkOrderDeleted(modelIncomingItems incomingItems) {
		String checkSql = "SELECT 1 FROM itemCheckin WHERE noCheckIn = ? AND statusTransaction = ?";
		PreparedStatement stat=null;
		try {
		    stat = conn.prepareStatement(checkSql);
		    stat.setString(1, incomingItems.getNoCheckin());
		    stat.setString(2, "Transaksi dihapus oleh Bagian Admin");
		    ResultSet result = stat.executeQuery();
		    if (result.next()) {
			return true;
		    } else {
			return false;
		    }
		} catch (SQLException ex) {
		    Logger.getLogger(DAO_IncomingItems.class.getName()).log(Level.SEVERE, null, ex);
		    return false; 
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

		
}
