/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.dao;

import edu.unindra.kkp_kelompok4.Services.serviceDetailIncomingItems;
import edu.unindra.kkp_kelompok4.model.*;
import edu.unindra.kkp_kelompok4.resource.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ripal
 */
public class DAO_DetailIncomingItems implements serviceDetailIncomingItems{
	private Connection conn;
	public DAO_DetailIncomingItems() {
        conn = new koneksi().connect();
}

	@Override
	public void submitDetail(modelDetailIncomingItems detailIncomingItems) {
	PreparedStatement stat = null;
	String sql = "UPDATE detailCheckin SET dateReceived = ?, idEmployee=?, status=? WHERE noCheckin = ?";
	try {
	    stat = conn.prepareStatement(sql);
	    
	    
	    stat.setString(1, detailIncomingItems.getDateReceived());
	    stat.setString(2, detailIncomingItems.getEmployee().getIdEmployee());
	    stat.setString(3, detailIncomingItems.getStatus());
	    stat.setString(4, detailIncomingItems.getNoCheckin());

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
	public List<modelDetailIncomingItems> getById(String id) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public List<modelDetailIncomingItems> getItem(String id) {
	PreparedStatement stat = null;
	List<modelDetailIncomingItems> list = new ArrayList<>();
	ResultSet rs = null;
	String sql = "SELECT DC.noCheckin, DC.itemCode, DC.distributorId, DST.distributorName, IL.itemName, "
		+ "IL.price, DC.totalCheckIn, DC.subTotalCheckin, DC.status, DC.idEmployee, ET.employeeName, DC.dateReceived "
		+ "FROM detailCheckin DC "
		+ "INNER JOIN incomingItems IT ON  IT.noCheckin=DC.noCheckin "
		+ "INNER JOIN itemsList IL ON IL.itemCode=DC.itemCode "
		+ "INNER JOIN distributor DST ON DST.distributorId = DC.distributorId "
		+ "LEFT JOIN employeeTable ET ON DC.idEmployee = ET.idEmployee "
		+ "WHERE DC.noCheckin='" + id + "' ORDER BY IT.noCheckin ASC";
	try {
	    stat = conn.prepareStatement(sql);
	    rs = stat.executeQuery();
	    list.removeAll(list);
	    while (rs.next()) {
		modelIncomingItems incomingItems = new modelIncomingItems();
		modelDetailIncomingItems detailIncomingItems = new modelDetailIncomingItems();
		modelItem item = new modelItem();
		modelEmployee employee = new modelEmployee();
		modelDistributor distributor = new modelDistributor();

		incomingItems.setNoCheckin(String.valueOf(rs.getString("noCheckin")));
		detailIncomingItems.setIncomingItems(incomingItems);

		item.setItemCode(rs.getString("itemCode"));
		item.setItemName(rs.getString("itemName"));
		item.setPrice(rs.getInt("price"));
		detailIncomingItems.setTotalItem(rs.getInt("totalCheckin"));
		detailIncomingItems.setSubTotalItem(rs.getInt("subTotalCheckin"));

		distributor.setDistributorId(rs.getString("distributorId"));
		distributor.setDistributorName(rs.getString("distributorName"));

		detailIncomingItems.setStatus(rs.getString("status"));
		employee.setEmployeeName(rs.getString("employeeName"));

		detailIncomingItems.setDateReceived(rs.getString("dateReceived"));
		detailIncomingItems.setItems(item);
		detailIncomingItems.setEmployee(employee);
		detailIncomingItems.setDistributor(distributor);

		list.add(detailIncomingItems);
	    }

	    return list;
	} catch (Exception e) {
	    Logger.getLogger(DAO_DetailCheckin.class.getName()).log(Level.SEVERE, null, e);
	    return null;
	} finally {
	    if (stat != null) {
		try {
		    stat.close();
		} catch (Exception e) {
		    Logger.getLogger(DAO_DetailCheckin.class.getName()).log(Level.SEVERE, null, e);
		}
	    }
	    if (rs != null) {
		try {
		    rs.close();
		} catch (Exception e) {
		    Logger.getLogger(DAO_DetailCheckin.class.getName()).log(Level.SEVERE, null, e);
		}
	    }
	}
    }


	@Override
	public List<modelDetailIncomingItems> SearchingItem(String id) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void checkStatusConfirm(modelDetailIncomingItems detailIncomingItems) {
	PreparedStatement stat = null;
	String sql = "UPDATE detailCheckin SET dateReceived = ?, idEmployee = ?, status = ? WHERE noCheckin = ? AND itemCode = ? AND distributorId = ?";
	try {
	    stat = conn.prepareStatement(sql);
	    
	    
	    stat.setString(1, detailIncomingItems.getDateReceived());
	    stat.setString(2, detailIncomingItems.getEmployee().getIdEmployee());
	    stat.setString(3, detailIncomingItems.getStatus());
	    stat.setString(4, detailIncomingItems.getNoCheckin());
	    stat.setString(5, detailIncomingItems.getItems().getItemCode());
	    stat.setString(6, detailIncomingItems.getDistributor().getDistributorId());

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
	public modelDetailIncomingItems getById(String id, String distri, String itemCode) {
	PreparedStatement stat = null;
	ResultSet rs = null;
	String sql = "SELECT DC.Status, DC.DistributorId, D.distributorName FROM detailCheckin DC INNER JOIN distributor D"
		+ " ON D.distributorId = DC.distributorId WHERE DC.noCheckin = ? AND D.distributorName = ? AND DC.itemCode = ?";

	try {
		stat = conn.prepareStatement(sql);
		stat.setString(1, id);
		stat.setString(2, distri);
		stat.setString(3, itemCode);
		rs = stat.executeQuery();
		
		if (rs.next()) {
			modelDetailIncomingItems detailIncomingItems = new modelDetailIncomingItems();
			modelDistributor distributor = new modelDistributor();
			
			detailIncomingItems.setStatus(rs.getString("status"));
			distributor.setDistributorId(rs.getString("distributorId"));
			distributor.setDistributorName(rs.getString("distributorName"));
			detailIncomingItems.setDistributor(distributor);
			return detailIncomingItems;
			
		}

	    } catch (Exception e) {
		Logger.getLogger(DAO_DetailCartCheckIn.class.getName()).log(Level.SEVERE, null, e);
	    } finally {
	    if (stat != null) {
		try {
		    stat.close();
		} catch (Exception e) {
		    Logger.getLogger(DAO_DetailCartCheckIn.class.getName()).log(Level.SEVERE, null, e);
		}
	    }
	    if (rs != null) {
		try {
		    rs.close();
		} catch (Exception e) {
		    Logger.getLogger(DAO_DetailCartCheckIn.class.getName()).log(Level.SEVERE, null, e);
		}
	    }
	}
		return null;

	
	}
	

	}
	

