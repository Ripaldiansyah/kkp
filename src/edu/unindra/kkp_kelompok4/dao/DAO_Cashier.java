/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.dao;

import edu.unindra.kkp_kelompok4.Services.serviceCashier;
import edu.unindra.kkp_kelompok4.model.modelCashier;
import edu.unindra.kkp_kelompok4.model.modelEmployee;
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
import javax.swing.JOptionPane;

/**
 *
 * @author ripal
 */
public class DAO_Cashier implements serviceCashier{

	private Connection conn;
	public DAO_Cashier() {
        conn = new koneksi().connect();
}
	
	@Override
	public void addTransaction(modelCashier cashier) {
	PreparedStatement stat=null;
	String insertSql = "INSERT INTO cashier (orderId, dateOrder,totalOrder,idEmployee,payment,totalAmount,changePayment) VALUES (?,?,?,?,?,?,?)";
	String updateSql = "UPDATE cashier SET dateOrder = ?, totalOrder = ?, idEmployee = ?, payment = ?, totalAmount=?, changePayment=?  WHERE orderId = ?";
	  String deleteSql = "DELETE FROM cashier WHERE orderId = ? ";
	 try {
        // Check if the record exists
        String checkSql = "SELECT 1 FROM cashier WHERE orderId = ?";
        PreparedStatement checkStat = conn.prepareStatement(checkSql);
        checkStat.setString(1, cashier.getOrderId());
		
        ResultSet checkResult = checkStat.executeQuery();
        boolean recordExists = checkResult.next();
        checkResult.close();
        checkStat.close();
        if (recordExists) {
        stat = conn.prepareStatement(updateSql);
        stat.setString(1, cashier.getDateOrder());
	stat.setInt(2, cashier.getTotalOrder());
	stat.setString(3, cashier.getEmployee().getIdEmployee());
	stat.setString(4, cashier.getPayment());
	stat.setInt(5, cashier.getPaymentAmount());
	stat.setInt(6, cashier.getChangePayment());
	stat.setString(7, cashier.getOrderId());
        stat.executeUpdate();
        } else {
	stat = conn.prepareStatement(insertSql);
        stat.setString(1, cashier.getOrderId());
	stat.setString(2, cashier.getDateOrder());
	stat.setInt(3, cashier.getTotalOrder());
	stat.setString(4, cashier.getEmployee().getIdEmployee());
	stat.setString(5, cashier.getPayment());
	stat.setInt(6, cashier.getPaymentAmount());
	stat.setInt(7, cashier.getChangePayment());
        stat.executeUpdate();
        }
    } catch (Exception e) {
        Logger.getLogger(DAO_Cashier.class.getName()).log(Level.SEVERE, null, e);
    } finally {
        if (stat != null) {
            try {
                stat.close();
            } catch (Exception e) {
                Logger.getLogger(DAO_Cashier.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        }
    }
//
//		try {
//			stat=conn.prepareStatement(insertSql);
//			
//			stat.setString(1, cashier.getOrderId());
//			stat.setString(2, cashier.getDateOrder());
//			stat.setInt(3, cashier.getTotalOrder());
//			stat.setString(4, cashier.getEmployeeName());
//			stat.setString(5, cashier.getPayment());
//			
//			stat.executeUpdate();
//			
//		}  catch (Exception e) {
//			Logger.getLogger(DAO_CheckIn.class.getName()).log(Level.SEVERE,null,e);	
//		}finally{
//				if (stat!=null) {
//					try {
//						stat.close();
//					} catch (Exception e) {
//						Logger.getLogger(DAO_CheckIn.class.getName()).log(Level.SEVERE,null,e);
//					}
//				}
//			}
	

	@Override
	public void deteleTransaction(modelCashier cashier) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void updateTransaction(modelCashier cashier) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public modelCashier getById(String id) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public List<modelCashier> getItem() {
	PreparedStatement stat = null;
	List<modelCashier> list = new ArrayList<>();
	ResultSet rs = null;
	String sql = "SELECT * FROM cashier";

	try {
	    stat = conn.prepareStatement(sql);
	    rs = stat.executeQuery();

	    while (rs.next()) {
		modelCashier cashier = new modelCashier();
		modelEmployee employee = new modelEmployee();
		cashier.setOrderId(rs.getString("orderId"));
		cashier.setDateOrder(rs.getString("dateOrder"));
		cashier.setTotalOrder(rs.getInt("totalOrder"));
		cashier.setPayment(rs.getString("payment"));

		// Ambil idEmployee dari resultSet
		String idEmployee = rs.getString("idEmployee");

		// Buat kueri untuk mengambil employeeName berdasarkan idEmployee
		String employeeSql = "SELECT employeeName FROM employeeTable WHERE idEmployee = ?";
		PreparedStatement employeeStat = conn.prepareStatement(employeeSql);
		employeeStat.setString(1, idEmployee);
		ResultSet employeeRs = employeeStat.executeQuery();

		// Jika data karyawan ditemukan, set employeeName pada objek cashier
		if (employeeRs.next()) {
		    employee.setIdEmployee(idEmployee);
		    employee.setEmployeeName(employeeRs.getString("employeeName"));
		}

		employeeStat.close();
		employeeRs.close();

		cashier.setEmployee(employee);
		cashier.setPaymentAmount(rs.getInt("totalAmount"));
		cashier.setChangePayment(rs.getInt("changePayment"));

		list.add(cashier);
	    }

	    return list;
	} catch (Exception e) {
	    Logger.getLogger(DAO_Cashier.class.getName()).log(Level.SEVERE, null, e);
	    return null;
	} finally {
	    if (stat != null) {
		try {
		    stat.close();
		} catch (Exception e) {
		    Logger.getLogger(DAO_Cashier.class.getName()).log(Level.SEVERE, null, e);
		}
	    }

	    if (rs != null) {
		try {
		    rs.close();
		} catch (Exception e) {
		    Logger.getLogger(DAO_Cashier.class.getName()).log(Level.SEVERE, null, e);
		}
	    }
	}
    }


	@Override
	public List<modelCashier> Search(String id) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public String number() {
	PreparedStatement stat = null;
		ResultSet rs = null;
		String listing = null;
		LocalDate now = LocalDate.now();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

		String tgl = now.format(dateFormatter);
		
		String sql = "SELECT SUBSTR(orderId, -3) AS Number " +
				"FROM cashier " +
				"WHERE orderId LIKE 'ORDER" + tgl + "%' " +
				"UNION " +
				"SELECT SUBSTR(orderId, -3) AS Number " +
				"FROM cashierDraft " +
				"WHERE orderId LIKE 'ORDER" + tgl + "%' " +
				"ORDER BY Number DESC " +
				"LIMIT 1";
		try {
			stat=conn.prepareStatement(sql);
			rs = stat.executeQuery();
			
			if (rs.next()) {
				int number =Integer.parseInt(rs.getString("number"));
				number++;
				listing="ORDER"+tgl+String.format("%03d",number);
				
			}else{
				listing="ORDER"+tgl+"001";
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
	public void addDraft(modelCashier cashier) {
		PreparedStatement stat=null;
		String insertSql = "INSERT INTO cashierDraft (orderId, dateOrder,totalOrder,idEmployee,payment,transactionName) VALUES (?,?,?,?,?,?)";
		String updateSql = "UPDATE cashierDraft SET dateOrder = ?, totalOrder = ?, idEmployee = ?, payment = ?, transactionName=? WHERE orderId = ?";
		  String deleteSql = "DELETE FROM cashierDraft WHERE orderId = ? ";
		 try {
		// Check if the record exists
		String checkSql = "SELECT 1 FROM cashierDraft WHERE orderId = ?";
		PreparedStatement checkStat = conn.prepareStatement(checkSql);
		checkStat.setString(1, cashier.getOrderId());

		ResultSet checkResult = checkStat.executeQuery();
		boolean recordExists = checkResult.next();
		checkResult.close();
		checkStat.close();
		if (recordExists) {
		stat = conn.prepareStatement(updateSql);
		modelEmployee employee = new modelEmployee();
		stat.setString(1, cashier.getDateOrder());
		stat.setInt(2, cashier.getTotalOrder());
		stat.setString(3, cashier.getEmployee().getIdEmployee());
		stat.setString(4, cashier.getPayment());
		stat.setString(5, cashier.getDraftName());
		stat.setString(6, cashier.getOrderId());
		stat.executeUpdate();
		} else {
		stat = conn.prepareStatement(insertSql);
		
		stat.setString(1, cashier.getOrderId());
		stat.setString(2, cashier.getDateOrder());
		stat.setInt(3, cashier.getTotalOrder());
		stat.setString(4, cashier.getEmployee().getIdEmployee());
		stat.setString(5, cashier.getPayment());
		stat.setString(6, cashier.getDraftName());
		stat.executeUpdate();
		}
	    } catch (Exception e) {
		Logger.getLogger(DAO_Cashier.class.getName()).log(Level.SEVERE, null, e);
	    } finally {
		if (stat != null) {
		    try {
			stat.close();
		    } catch (Exception e) {
			Logger.getLogger(DAO_Cashier.class.getName()).log(Level.SEVERE, null, e);
		    }
		}
		}
	}

	@Override
	public List<modelCashier> getItemDrafList() {
	PreparedStatement stat = null;
	List<modelCashier> list = new ArrayList<>();
	ResultSet rs = null;
	String sql = "SELECT * FROM cashierDraft";

	try {
	    stat = conn.prepareStatement(sql);
	    rs = stat.executeQuery();

	    while (rs.next()) {
		modelCashier cashier = new modelCashier();
		modelEmployee employee = new modelEmployee();
		cashier.setOrderId(rs.getString("orderId"));
		cashier.setDateOrder(rs.getString("dateOrder"));
		cashier.setTotalOrder(rs.getInt("totalOrder"));
		cashier.setPayment(rs.getString("payment"));
		cashier.setDraftName(rs.getString("transactionName"));

		// Ambil idEmployee dari resultSet
		String idEmployee = rs.getString("idEmployee");

		// Buat kueri untuk mengambil employeeName berdasarkan idEmployee
		String employeeSql = "SELECT employeeName FROM employeeTable WHERE idEmployee = ?";
		PreparedStatement employeeStat = conn.prepareStatement(employeeSql);
		employeeStat.setString(1, idEmployee);
		ResultSet employeeRs = employeeStat.executeQuery();

		// Jika data karyawan ditemukan, set employeeName pada objek cashier
		if (employeeRs.next()) {
		    employee.setIdEmployee(idEmployee);
		    employee.setEmployeeName(employeeRs.getString("employeeName"));
		}

		employeeStat.close();
		employeeRs.close();

		cashier.setEmployee(employee);

		list.add(cashier);
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
	public void deteleTransactionDraft(modelCashier cashier) {
	PreparedStatement stat = null;
	String sql = "DELETE FROM cashierDraft WHERE orderId = ?";
	try {
	    stat = conn.prepareStatement(sql);
	    stat.setString(1, cashier.getOrderId());
	    stat.executeUpdate();
	} catch (Exception e) {
	    Logger.getLogger(DAO_DetailCashier.class.getName()).log(Level.SEVERE, null, e);
	} finally {
	    if (stat != null) {
		try {
		    stat.close();
		} catch (Exception e) {
		    Logger.getLogger(DAO_DetailCashier.class.getName()).log(Level.SEVERE, null, e);
		}
	    }
	}
	}
	
}
