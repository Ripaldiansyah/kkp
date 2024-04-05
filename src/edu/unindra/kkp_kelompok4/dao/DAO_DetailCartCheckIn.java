/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.dao;

import edu.unindra.kkp_kelompok4.Services.serviceDetailCartCheckin;
import edu.unindra.kkp_kelompok4.model.modelDetailCheckin;
import edu.unindra.kkp_kelompok4.model.modelDistributor;
import edu.unindra.kkp_kelompok4.model.modelItem;
import edu.unindra.kkp_kelompok4.model.modelShoppingCart;
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
public class DAO_DetailCartCheckIn implements serviceDetailCartCheckin{

	private Connection conn;
	public DAO_DetailCartCheckIn() {
        conn = new koneksi().connect();
}
	@Override
	public void addItem(modelShoppingCart shoppingCart) {
    PreparedStatement insertStat = null;
    PreparedStatement updateStat = null;
    String insertSql = "INSERT INTO shoppingCartCheckin (itemCode, totalCheckin, subTotalCheckin, status, distributorId) "
                     + "VALUES (?, ?, ?, ?, ?)";
    String updateSql = "UPDATE shoppingCartCheckin "
                     + "SET totalCheckin = totalCheckin + ?, "
                     + "    subTotalCheckin = subTotalCheckin + ? "
                     + "WHERE itemCode = ? AND distributorId = ?";
    
    try {
        // Check if the record exists
        String checkSql = "SELECT 1 FROM shoppingCartCheckin WHERE itemCode = ? AND distributorId = ?";
        PreparedStatement checkStat = conn.prepareStatement(checkSql);
        checkStat.setString(1, shoppingCart.getItem().getItemCode());
        checkStat.setString(2, shoppingCart.getDistributor().getDistributorId());
        ResultSet checkResult = checkStat.executeQuery();
        boolean recordExists = checkResult.next();
        checkResult.close();
        checkStat.close();
        if (recordExists) {
            updateStat = conn.prepareStatement(updateSql);
            updateStat.setInt(1, shoppingCart.getDetaileCheckin().getTotalItem());
            updateStat.setInt(2, shoppingCart.getDetaileCheckin().getSubTotalItem());
            updateStat.setString(3, shoppingCart.getItem().getItemCode());
            updateStat.setString(4, shoppingCart.getDistributor().getDistributorId());
            updateStat.executeUpdate();
        } else {
            insertStat = conn.prepareStatement(insertSql);
            insertStat.setString(1, shoppingCart.getItem().getItemCode());
            insertStat.setInt(2, shoppingCart.getDetaileCheckin().getTotalItem());
            insertStat.setInt(3, shoppingCart.getDetaileCheckin().getSubTotalItem());
            insertStat.setString(4, shoppingCart.getDetaileCheckin().getStatus());
            insertStat.setString(5, shoppingCart.getDistributor().getDistributorId());
            insertStat.executeUpdate();
        }
    } catch (Exception e) {
        Logger.getLogger(DAO_Employee.class.getName()).log(Level.SEVERE, null, e);
    } finally {
        if (insertStat != null) {
            try {
                insertStat.close();
            } catch (Exception e) {
                Logger.getLogger(DAO_Employee.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        if (updateStat != null) {
            try {
                updateStat.close();
            } catch (Exception e) {
                Logger.getLogger(DAO_Employee.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}

	@Override
	public void renewItem(modelShoppingCart shoppingCart) {
    PreparedStatement updateStat = null;
    PreparedStatement deleteStat = null;
            modelDetailCheckin detailCheckin = new modelDetailCheckin();
    String insertSql = "UPDATE shoppingCartCheckin "
                     + "SET totalCheckin = totalCheckin + ?, "
                     + "    subTotalCheckin = subTotalCheckin + ? "
                     + "WHERE itemCode = ? AND distributorId = ?";
                     //Jika barang berubah
    
     String insertSql2 = "UPDATE shoppingCartCheckin "
                     + "SET totalCheckin = ?, "
                     + "    subTotalCheckin = ? "
                     + "WHERE itemCode = ? AND distributorId = ?";
    
    String updateSql = "UPDATE shoppingCartCheckin "
			+ "SET totalCheckin = ?, "
			+ "    subTotalCheckin = ?, "
			+ "    distributorId = ?, "
			+ "	    itemCode = ? "
			+ "WHERE itemCode = '"+shoppingCart.getOriginalItem().getItemCode()
			+"' AND distributorId = '"+shoppingCart.getOriginalDistributor().getDistributorId()+"'";
    
    String deleteSql = "DELETE FROM shoppingCartCheckin WHERE itemCode = ? AND distributorId = ?";
    
    try {
	String checkSql = "SELECT 1 FROM shoppingCartCheckin WHERE itemCode = ? AND distributorId = ?";  //check apakah sudah ada yang memakai id tersebut
        PreparedStatement checkStat = conn.prepareStatement(checkSql);
        checkStat.setString(1, shoppingCart.getItem().getItemCode());
        checkStat.setString(2, shoppingCart.getDistributor().getDistributorId());
        ResultSet checkResult = checkStat.executeQuery();
        boolean recordExists = checkResult.next();
        checkResult.close();
        checkStat.close();
//	JOptionPane.showMessageDialog(null, shoppingCart.getDetaileCheckin().getTotalItem() +" "+ shoppingCart.getOriginalTotal().getTotalItem());
        
	if (recordExists) { 
           if ((shoppingCart.getOriginalItem().getItemCode().equals(shoppingCart.getItem().getItemCode())) && (shoppingCart.getOriginalDistributor().getDistributorId().equals(shoppingCart.getDistributor().getDistributorId())) && (shoppingCart.getDetaileCheckin().getTotalItem()<=shoppingCart.getOriginalTotal().getTotalItem()) ) {
                //id sama distri sama cuma totalnya berubah jadi lebih kecil atau sama dengan
                int subTotal = shoppingCart.getItem().getPrice() * shoppingCart.getDetaileCheckin().getTotalItem();
			updateStat = conn.prepareStatement(insertSql2);
			updateStat.setInt(1, shoppingCart.getDetaileCheckin().getTotalItem());
			updateStat.setInt(2,subTotal);
			updateStat.setString(3, shoppingCart.getItem().getItemCode());
			updateStat.setString(4, shoppingCart.getDistributor().getDistributorId());
			updateStat.executeUpdate();
            }else 
                if ((shoppingCart.getOriginalItem().getItemCode().equals(shoppingCart.getItem().getItemCode())) && (shoppingCart.getOriginalDistributor().getDistributorId().equals(shoppingCart.getDistributor().getDistributorId()))) {
            //jika id sama distributor idnya gak berubah maka jangan hapus
                int subTotal = shoppingCart.getItem().getPrice() * shoppingCart.getDetaileCheckin().getTotalItem();
			updateStat = conn.prepareStatement(insertSql);
			updateStat.setInt(1, shoppingCart.getDetaileCheckin().getTotalItem());
			updateStat.setInt(2,subTotal);
			updateStat.setString(3, shoppingCart.getItem().getItemCode());
			updateStat.setString(4, shoppingCart.getDistributor().getDistributorId());
			updateStat.executeUpdate();
            }else{ 
                int subTotal = shoppingCart.getItem().getPrice() * shoppingCart.getDetaileCheckin().getTotalItem();
			updateStat = conn.prepareStatement(insertSql);
			updateStat.setInt(1, shoppingCart.getDetaileCheckin().getTotalItem());
			updateStat.setInt(2,subTotal);
			updateStat.setString(3, shoppingCart.getItem().getItemCode());
			updateStat.setString(4, shoppingCart.getDistributor().getDistributorId());
			updateStat.executeUpdate();
                        
                        deleteStat = conn.prepareStatement(deleteSql);
			deleteStat.setString(1, shoppingCart.getOriginalItem().getItemCode());
			deleteStat.setString(2, shoppingCart.getOriginalDistributor().getDistributorId());
			deleteStat.executeUpdate();
            }
            }else{
	        int subTotal = shoppingCart.getItem().getPrice() * shoppingCart.getDetaileCheckin().getTotalItem();
		updateStat = conn.prepareStatement(updateSql);
		updateStat.setInt(1, shoppingCart.getDetaileCheckin().getTotalItem());
		updateStat.setInt(2, subTotal);
		updateStat.setString(3, shoppingCart.getDistributor().getDistributorId());
		updateStat.setString(4, shoppingCart.getItem().getItemCode());
		updateStat.executeUpdate();
	}
    } catch (Exception e) {
        Logger.getLogger(DAO_Items.class.getName()).log(Level.SEVERE, null, e);
    } finally {
        if (updateStat != null) {
            try {
                updateStat.close();
            } catch (Exception e) {
                Logger.getLogger(DAO_Items.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}

	@Override
	public void deleteCart(modelShoppingCart shoppingCart) {
	PreparedStatement stat = null;
	String sql = "DELETE FROM shoppingCartCheckin WHERE itemCode = ? AND distributorId = ?";
	try {
	    stat = (PreparedStatement) conn.prepareStatement(sql);
	    stat.setString(1, shoppingCart.getItem().getItemCode());
	    stat.setString(2, shoppingCart.getDistributor().getDistributorId());
	    stat.executeUpdate();
	} catch (Exception e) {
	    Logger.getLogger(DAO_Items.class.getName()).log(Level.SEVERE, null, e);
	} finally {
	    if (stat != null) {
		try {
		    stat.close();
		} catch (Exception e) {
		    Logger.getLogger(DAO_Items.class.getName()).log(Level.SEVERE, null, e);
		}
	    }
	}
    }


	@Override
	public modelShoppingCart getById(String id, String distri) {
	PreparedStatement stat = null;
	ResultSet rs = null;
	String sql = "SELECT SCC.*, D.distributorName "
		   + "FROM shoppingCartCheckin SCC "
		   + "INNER JOIN distributor D ON SCC.distributorId = D.distributorId "
		   + "WHERE SCC.itemCode = ? AND D.distributorName = '"+distri+"'";

	try {
	    stat = conn.prepareStatement(sql);
	    stat.setString(1, id);
	    rs = stat.executeQuery();

	    if (rs.next()) {
		modelDistributor distributor = new modelDistributor();
		modelShoppingCart shoppingCart = new modelShoppingCart();

		distributor.setDistributorId(rs.getString("distributorId"));
		distributor.setDistributorName(rs.getString("distributorName"));

		shoppingCart.setDistributor(distributor);
		return shoppingCart;
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


	@Override
	public List<modelShoppingCart> getItem() {
    PreparedStatement stat = null;
    List<modelShoppingCart> list = new ArrayList<>();
    ResultSet rs = null;
    String sql = "SELECT SC.itemCode, SC.totalCheckin, SC.subTotalCheckin, SC.status, D.distributorId, D.distributorName, IL.itemName, IL.price, IL.itemUnit "
                 + "FROM shoppingCartCheckin SC "
                 + "INNER JOIN itemsList IL ON IL.itemCode = SC.itemCode "
                 + "INNER JOIN distributor D ON D.distributorId = SC.distributorId";
    try {
        stat = conn.prepareStatement(sql);
        rs = stat.executeQuery();
        while (rs.next()) {
            modelShoppingCart shoppingCart = new modelShoppingCart();
            modelItem items = new modelItem();
            modelDetailCheckin detailCheckin = new modelDetailCheckin();
            modelDistributor distributor = new modelDistributor();

            items.setItemCode(rs.getString("itemCode"));
            items.setItemName(rs.getString("itemName"));
            items.setPrice(rs.getInt("price"));
            items.setItemUnit(rs.getString("ItemUnit"));

            detailCheckin.setTotalItem(rs.getInt("totalCheckin"));
            detailCheckin.setSubTotalItem(rs.getInt("subTotalCheckin"));

            distributor.setDistributorId(rs.getString("distributorId"));
            distributor.setDistributorName(rs.getString("distributorName"));

            shoppingCart.setItem(items);
            shoppingCart.setDetaileCheckin(detailCheckin);
            shoppingCart.setDistributor(distributor);
            list.add(shoppingCart);
        }
        return list;
    } catch (Exception e) {
        Logger.getLogger(DAO_Employee.class.getName()).log(Level.SEVERE, null, e);
    } finally {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                Logger.getLogger(DAO_Employee.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        if (stat != null) {
            try {
                stat.close();
            } catch (Exception e) {
                Logger.getLogger(DAO_Employee.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    return list;
}

	@Override
	public void deleteAllCart() {
	PreparedStatement stat = null;
	try {
	    String sql = "DELETE FROM shoppingCartCheckin";
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
	
}
