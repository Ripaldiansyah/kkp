/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.dao;

import edu.unindra.kkp_kelompok4.Services.serviceDetailCartCashier;
import edu.unindra.kkp_kelompok4.model.modelCashierCart;
import edu.unindra.kkp_kelompok4.model.modelDetailCashier;
import edu.unindra.kkp_kelompok4.model.modelItem;
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
public class DAO_DetailCartCashier implements serviceDetailCartCashier{
	
	private Connection conn;
	public DAO_DetailCartCashier() {
        conn = new koneksi().connect();
}

	@Override
	public void addItem(modelCashierCart cashierCart) {
	PreparedStatement insertStat = null;
    PreparedStatement updateStat = null;
    String insertSql = "INSERT INTO shoppingCartCashier(itemCode, totalOrder, subTotalOrder) "
                     + "VALUES (?, ?, ?)";
    String updateSql = "UPDATE shoppingCartCashier "
                     + "SET totalOrder = totalOrder + ?, "
                     + "    subTotalOrder = subTotalOrder + ? "
                     + "WHERE itemCode = ?";
    
    try {
        // Check if the record exists
        String checkSql = "SELECT 1 FROM shoppingCartCashier WHERE itemCode = ?";
        PreparedStatement checkStat = conn.prepareStatement(checkSql);
        checkStat.setString(1, cashierCart.getItem().getItemCode());
        ResultSet checkResult = checkStat.executeQuery();
        boolean recordExists = checkResult.next();
        checkResult.close();
        checkStat.close();
        if (recordExists) {
            updateStat = conn.prepareStatement(updateSql);
            updateStat.setInt(1, cashierCart.getDetailCashier().getTotalItem());
            updateStat.setInt(2, cashierCart.getDetailCashier().getSubTotalItem());
            updateStat.setString(3, cashierCart.getItem().getItemCode());
            updateStat.executeUpdate();
        } else {
            insertStat = conn.prepareStatement(insertSql);
            insertStat.setString(1, cashierCart.getItem().getItemCode());
            insertStat.setInt(2, cashierCart.getDetailCashier().getTotalItem());
            insertStat.setInt(3, cashierCart.getDetailCashier().getSubTotalItem());
            insertStat.executeUpdate();
        }
    } catch (Exception e) {
        Logger.getLogger(DAO_DetailCartCashier.class.getName()).log(Level.SEVERE, null, e);
    } finally {
        if (insertStat != null) {
            try {
                insertStat.close();
            } catch (Exception e) {
                Logger.getLogger(DAO_DetailCartCashier.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        if (updateStat != null) {
            try {
                updateStat.close();
            } catch (Exception e) {
                Logger.getLogger(DAO_DetailCartCashier.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
	}

	@Override
	public void renewItem(modelCashierCart cashierCart) {
		PreparedStatement insertStat = null;
    PreparedStatement updateStat = null;
    String updateSql = "UPDATE shoppingCartCashier "
                     + "SET totalOrder = ?, "
                     + "subTotalOrder = ? "
                     + "WHERE itemCode = ?";
    
    try {
        // Check if the record exists
        String checkSql = "SELECT 1 FROM shoppingCartCashier WHERE itemCode = ?";
        PreparedStatement checkStat = conn.prepareStatement(checkSql);
        checkStat.setString(1, cashierCart.getItem().getItemCode());
        ResultSet checkResult = checkStat.executeQuery();
        boolean recordExists = checkResult.next();
        checkResult.close();
        checkStat.close();
        if (recordExists) {
            updateStat = conn.prepareStatement(updateSql);
            updateStat.setInt(1, cashierCart.getDetailCashier().getTotalItem());
            updateStat.setInt(2, cashierCart.getDetailCashier().getSubTotalItem());
            updateStat.setString(3, cashierCart.getItem().getItemCode());
            updateStat.executeUpdate();
        } 
    } catch (Exception e) {
        Logger.getLogger(DAO_DetailCartCashier.class.getName()).log(Level.SEVERE, null, e);
    } finally {
        if (insertStat != null) {
            try {
                insertStat.close();
            } catch (Exception e) {
                Logger.getLogger(DAO_DetailCartCashier.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        if (updateStat != null) {
            try {
                updateStat.close();
            } catch (Exception e) {
                Logger.getLogger(DAO_DetailCartCashier.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
	}

	@Override
	public void deleteCart(modelCashierCart cashierCart) {
	PreparedStatement stat = null;
	String sql = "DELETE FROM shoppingCartCashier WHERE itemCode = ?";
	try {
	    stat = (PreparedStatement) conn.prepareStatement(sql);
	    stat.setString(1, cashierCart.getItem().getItemCode());
	    stat.executeUpdate();
	} catch (Exception e) {
	    Logger.getLogger(DAO_DetailCartCashier.class.getName()).log(Level.SEVERE, null, e);
	} finally {
	    if (stat != null) {
		try {
		    stat.close();
		} catch (Exception e) {
		    Logger.getLogger(DAO_DetailCartCashier.class.getName()).log(Level.SEVERE, null, e);
		}
	    }
	}
	}

	@Override
	public void deleteAllCart() {
	PreparedStatement stat = null;
	try {
	    String sql = "DELETE FROM shoppingCartCashier";
	    stat = conn.prepareStatement(sql);
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
	public modelCashierCart getById(String id) {
	throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public List<modelCashierCart> getItem() {
	 PreparedStatement stat = null;
    List<modelCashierCart> list = new ArrayList<>();
    ResultSet rs = null;
    String sql = "SELECT SC.itemCode, SC.totalOrder, SC.subTotalOrder, IL.itemName, IL.price, IL.itemUnit "
                 + "FROM shoppingCartCashier SC "
                 + "INNER JOIN itemsList IL ON IL.itemCode = SC.itemCode";
    try {
        stat = conn.prepareStatement(sql);
        rs = stat.executeQuery();
        while (rs.next()) {
            modelCashierCart cashierCart = new modelCashierCart();
            modelItem items = new modelItem();
            modelDetailCashier detailCashier = new modelDetailCashier();

            items.setItemCode(rs.getString("itemCode"));
            items.setItemName(rs.getString("itemName"));
            items.setPrice(rs.getInt("price"));
            items.setItemUnit(rs.getString("ItemUnit"));

            detailCashier.setTotalItem(rs.getInt("totalOrder"));
            detailCashier.setSubTotalItem(rs.getInt("subTotalOrder"));

            cashierCart.setItem(items);
            cashierCart.setDetailCashier(detailCashier);

            list.add(cashierCart);
        }
        return list;
    } catch (Exception e) {
        Logger.getLogger(DAO_DetailCartCashier.class.getName()).log(Level.SEVERE, null, e);
    } finally {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                Logger.getLogger(DAO_DetailCartCashier.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        if (stat != null) {
            try {
                stat.close();
            } catch (Exception e) {
                Logger.getLogger(DAO_DetailCartCashier.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    return list;
	}
	
	
//	public void searchItem(String id){
//		PreparedStatement stat = null;
//		List list = new ArrayList();
//		ResultSet rs = null;
//		String sql = "SELECT * FROM itemsList WHERE itemCode LIKE '%"+id+"%' OR itemName LIKE '%"+id+"%'";
//		
//	}

	@Override
	public List<modelCashierCart> getCarts() {
		PreparedStatement stat = null;
		List<modelCashierCart> list = new ArrayList<>();
		ResultSet rs = null;
		String sql = "SELECT * FROM itemsList";
		try {
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			while (rs.next()) {
				modelItem items = new modelItem();
				modelCashierCart cashierCart = new modelCashierCart();
				
				items.setItemCode(rs.getString("itemCode"));
				items.setItemName(rs.getString("itemName"));
				
				cashierCart.setItem(items);
				list.add(cashierCart);
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

	
	public void getDataComboBox() {
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM itemsList";
		try {
			conn.prepareStatement(sql);
			rs = stat.executeQuery();
			while (rs.next()) {				
			modelItem items = new modelItem();
			modelCashierCart cashierCart = new modelCashierCart();
				
			items.setItemCode(rs.getString("itemCode"));
			items.setItemName(rs.getString("itemName"));
				
			cashierCart.setItem(items);	
			}
			
			
		} catch (Exception e) {
		}
	}
}
