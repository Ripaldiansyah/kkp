/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.dao;

import edu.unindra.kkp_kelompok4.Services.serviceDetailCheckin;
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
public class DAO_DetailCheckin implements serviceDetailCheckin{
	private Connection conn;
	public DAO_DetailCheckin() {
        conn = new koneksi().connect();
}
	
	@Override
	public void addDetailTransaction(modelDetailCheckin detailCheckin) {
	PreparedStatement stat = null;
	String sql = "INSERT INTO detailCheckin (noCheckin, itemCode, totalCheckin, subTotalCheckin, status, distributorId, idEmployee, dateReceived) SELECT ?, itemCode, totalCheckin, subTotalCheckin, status, distributorid, ?, ? FROM shoppingCartCheckin";
	try {
	    stat = conn.prepareStatement(sql);
	    stat.setString(1, detailCheckin.getItemCheckin().getNoCheckin());
	    stat.setString(2, detailCheckin.getEmployee().getIdEmployee());
	    stat.setString(3, detailCheckin.getDateReceived());
	    stat.executeUpdate();
	} catch (Exception e) {
	    Logger.getLogger(DAO_DetailCheckin.class.getName()).log(Level.SEVERE, null, e);
	} finally {
	    if (stat != null) {
		try {
		    stat.close();
		} catch (Exception e) {
		    Logger.getLogger(DAO_DetailCheckin.class.getName()).log(Level.SEVERE, null, e);
		}
	    }
	}
    }


	@Override
	public void sumItem(modelDetailCheckin detaileCheckin) {
	PreparedStatement stat=null;
		List list = new ArrayList();
		ResultSet rs = null;
		String sql = "SELECT SUM(subTotalCheckIn) from shoppingCartCheckin";
			try {
				stat= conn.prepareStatement(sql);
				rs=stat.executeQuery();
				if (rs.next()) {
					detaileCheckin.setSubTotalItem(rs.getInt(1));
					
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
				if (rs!=null) {
					try {
						rs.close();
					} catch (Exception e) {
						Logger.getLogger(DAO_CheckIn.class.getName()).log(Level.SEVERE,null,e);
					}
				}
			}
	}

	

	@Override
	public List<modelShoppingCart> getById(String id) {
	PreparedStatement selectStat = null;
	PreparedStatement insertStat = null;
	ResultSet rs = null;
	String selectSql = "SELECT * FROM detailCheckin WHERE noCheckin = ?";
	String insertSql = "INSERT INTO shoppingCartCheckin (itemCode, totalCheckin, subTotalCheckin, status, distributorId) "
			    + "VALUES (?, ?, ?, ?, ?)";

	List<modelShoppingCart> carts = new ArrayList<>();

	try {
	    // Execute SELECT query
	    selectStat = conn.prepareStatement(selectSql);
	    selectStat.setString(1, id);
	    rs = selectStat.executeQuery();

	    while (rs.next()) {
		modelShoppingCart cart = new modelShoppingCart();
		modelItem items = new modelItem();
		modelDetailCheckin detailCheckin = new modelDetailCheckin();
		modelDistributor distributor = new modelDistributor();

		distributor.setDistributorId(rs.getString("distributorId"));
		items.setItemCode(rs.getString("itemCode"));

		detailCheckin.setTotalItem(rs.getInt("totalCheckin"));
		detailCheckin.setSubTotalItem(rs.getInt("subTotalCheckin"));
		detailCheckin.setStatus(rs.getString("status"));

		cart.setDetaileCheckin(detailCheckin);
		cart.setItem(items);
		cart.setDistributor(distributor);

		// Execute INSERT query
		insertStat = conn.prepareStatement(insertSql);
		insertStat.setString(1, items.getItemCode());
		insertStat.setInt(2, detailCheckin.getTotalItem());
		insertStat.setInt(3, detailCheckin.getSubTotalItem());
		insertStat.setString(4, detailCheckin.getStatus());
		insertStat.setString(5, distributor.getDistributorId());
		insertStat.executeUpdate();

		carts.add(cart);
	    }
	} catch (Exception e) {
	    Logger.getLogger(DAO_DetailCheckin.class.getName()).log(Level.SEVERE, null, e);
	} finally {
	    if (selectStat != null) {
		try {
		    selectStat.close();
		} catch (Exception e) {
		    Logger.getLogger(DAO_DetailCheckin.class.getName()).log(Level.SEVERE, null, e);
		}
	    }
	    if (insertStat != null) {
		try {
		    insertStat.close();
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

    return carts;
}


	@Override
	public List<modelDetailCheckin> getItem(String id) {
		PreparedStatement stat = null;
		List<modelDetailCheckin> list = new ArrayList<>();
		ResultSet rs = null;
		String sql = "SELECT DC.noCheckin, DC.itemCode, DC.distributorId, DST.distributorName, IL.itemName, "
			+ "IL.price, DC.totalCheckIn, DC.subTotalCheckin, DC.status, DC.idEmployee, ET.employeeName, DC.dateReceived "
			+ "FROM detailCheckin DC "
			+ "INNER JOIN itemCheckin IT ON  IT.noCheckin=DC.noCheckin "
			+ "INNER JOIN itemsList IL ON IL.itemCode=DC.itemCode "
			+ "INNER JOIN distributor DST ON DST.distributorId = DC.distributorId "
			+ "LEFT JOIN employeeTable ET ON DC.idEmployee = ET.idEmployee "
			+ "WHERE DC.noCheckin='" + id + "' ORDER BY IT.noCheckin ASC";
		try {
		    stat = conn.prepareStatement(sql);
		    rs = stat.executeQuery();
		    list.removeAll(list);
		    while (rs.next()) {
			modelItemCheckin itemCheckin = new modelItemCheckin();
			modelDetailCheckin detailCheckin = new modelDetailCheckin();
			modelItem item = new modelItem();
			modelEmployee employee = new modelEmployee();
			modelDistributor distributor = new modelDistributor();

			itemCheckin.setNoCheckin(String.valueOf(rs.getString("noCheckin")));
			detailCheckin.setItemCheckin(itemCheckin);

			item.setItemCode(rs.getString("itemCode"));
			item.setItemName(rs.getString("itemName"));
			item.setPrice(rs.getInt("price"));
			detailCheckin.setTotalItem(rs.getInt("totalCheckin"));
			detailCheckin.setSubTotalItem(rs.getInt("subTotalCheckin"));

			distributor.setDistributorId(rs.getString("distributorId"));
			distributor.setDistributorName(rs.getString("distributorName"));

			detailCheckin.setStatus(rs.getString("status"));
			employee.setEmployeeName(rs.getString("employeeName"));

			detailCheckin.setDateReceived(rs.getString("dateReceived"));
			detailCheckin.setItems(item);
			detailCheckin.setEmployee(employee);
			detailCheckin.setDistributor(distributor);

			list.add(detailCheckin);
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
	public List<modelDetailCheckin> SearchingItem(String id) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void deleteTransaction(modelDetailCheckin detailCheckin) {
	PreparedStatement stat = null;
try {
    String sql = "DELETE FROM detailCheckin WHERE noCheckin = ?";
    stat = conn.prepareStatement(sql);
    stat.setString(1, detailCheckin.getItemCheckin().getNoCheckin());
    stat.executeUpdate();
} catch (Exception e) {
    Logger.getLogger(DAO_DetailCheckin.class.getName()).log(Level.SEVERE, null, e);
} finally {
    if (stat != null) {
        try {
            stat.close();
        } catch (Exception e) {
            Logger.getLogger(DAO_DetailCheckin.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}

	}
	
}
