/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.dao;

import edu.unindra.kkp_kelompok4.Services.serviceDetailCashier;
import edu.unindra.kkp_kelompok4.model.modelCashier;
import edu.unindra.kkp_kelompok4.model.modelCashierCart;
import edu.unindra.kkp_kelompok4.model.modelDetailCashier;
import edu.unindra.kkp_kelompok4.model.modelDetailCashierDraft;
import edu.unindra.kkp_kelompok4.model.modelItem;
import edu.unindra.kkp_kelompok4.resource.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ripal
 */
public class DAO_DetailCashier implements serviceDetailCashier{
	private Connection conn;
	public DAO_DetailCashier() {
        conn = new koneksi().connect();
}

	@Override
	public void addDetailTransaction(modelDetailCashier detailCashier) {
	PreparedStatement stat=null;
	String sql = "INSERT INTO detailCashierOrder (orderId, itemCode,totalOrder,subTotalOrder) SELECT '"
		+detailCashier.getCashier().getOrderId()
		+"', itemCode, totalOrder, subTotalOrder FROM shoppingCartCashier"
		;
		try {
			stat=conn.prepareStatement(sql);
			stat.executeUpdate();
			
		}  catch (Exception e) {
			Logger.getLogger(DAO_DetailCheckin.class.getName()).log(Level.SEVERE,null,e);	
		}finally{
				if (stat!=null) {
					try {
						stat.close();
					} catch (Exception e) {
						Logger.getLogger(DAO_DetailCheckin.class.getName()).log(Level.SEVERE,null,e);
					}
				}
			}
	}

	@Override
	public void sumItem(modelDetailCashier detailCashier) {
		PreparedStatement stat=null;
		List list = new ArrayList();
		ResultSet rs = null;
		String sql = "SELECT SUM(subTotalOrder) from shoppingCartCashier";
			try {
				stat= conn.prepareStatement(sql);
				rs=stat.executeQuery();
				if (rs.next()) {
					detailCashier.setSubTotalItem(rs.getInt(1));
					
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
	public void deleteTransaction(modelDetailCashier detailCashier) {
	PreparedStatement stat = null;
	String sql = "DELETE FROM detailCashierOrder WHERE orderId = ?";
	try {
	    stat = conn.prepareStatement(sql);
	    stat.setString(1, detailCashier.getCashier().getOrderId());
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

	@Override
	public List<modelCashierCart> getById(String id) {
	PreparedStatement selectStat = null;
	PreparedStatement insertStat = null;
	ResultSet rs = null;
	String selectSql = "SELECT * FROM detailCashierOrder WHERE orderId = ?";
	String insertSql = "INSERT INTO shoppingCartCashier (itemCode,totalOrder, subTotalOrder) "
			    + "VALUES (?, ?, ?)";

	List<modelCashierCart> carts = new ArrayList<>();

	try {
	    // Execute SELECT query
	    selectStat = conn.prepareStatement(selectSql);
	    selectStat.setString(1, id);
	    rs = selectStat.executeQuery();

	    while (rs.next()) {
		modelCashierCart cart = new modelCashierCart();
		modelItem items = new modelItem();
		modelDetailCashier detailCashier = new modelDetailCashier();

		items.setItemCode(rs.getString("itemCode"));
		detailCashier.setTotalItem(rs.getInt("totalOrder"));
		detailCashier.setSubTotalItem(rs.getInt("subTotalOrder"));

		cart.setDetailCashier(detailCashier);
		cart.setItem(items);
 
		insertStat = conn.prepareStatement(insertSql);
		insertStat.setString(1, items.getItemCode());
		insertStat.setInt(2, detailCashier.getTotalItem());
		insertStat.setInt(3, detailCashier.getSubTotalItem());

		insertStat.executeUpdate();
		carts.add(cart);
	    }
	} catch (Exception e) {
	    Logger.getLogger(DAO_DetailCashier.class.getName()).log(Level.SEVERE, null, e);
	} finally {
	    if (selectStat != null) {
		try {
		    selectStat.close();
		} catch (Exception e) {
		    Logger.getLogger(DAO_DetailCashier.class.getName()).log(Level.SEVERE, null, e);
		}
	    }
	    if (insertStat != null) {
		try {
		    insertStat.close();
		} catch (Exception e) {
		    Logger.getLogger(DAO_DetailCashier.class.getName()).log(Level.SEVERE, null, e);
		}
	    }
	    if (rs != null) {
		try {
		    rs.close();
		} catch (Exception e) {
		    Logger.getLogger(DAO_DetailCashier.class.getName()).log(Level.SEVERE, null, e);
		}
	    }
    }

    return carts;
	}

	@Override
	public List<modelDetailCashier> getItem(String id) {
	PreparedStatement stat=null;
		List list = new ArrayList();
		ResultSet rs = null;
		String sql ="SELECT DCO.orderId, DCO.itemCode, IL.itemName, IL.itemUnit, "
			   + "IL.price, DCO.totalOrder, DCO.subTotalOrder "
			   + "FROM detailCashierOrder DCO "
				+ "INNER JOIN cashier CH ON  CH.orderId=DCO.orderId "
			   + "INNER JOIN itemsList IL ON IL.itemCode=DCO.itemCode "
			   + "WHERE DCO.orderId='"+id+"'ORDER BY CH.orderId ASC";
		
		try {
		stat = conn.prepareStatement(sql);
		rs = stat.executeQuery();
			while (rs.next()) {				
				modelCashier cashier = new modelCashier();
				modelDetailCashier detailCashier = new modelDetailCashier();
				modelItem item = new modelItem();
				
				
				cashier.setOrderId(String.valueOf(rs.getString("orderId")));
				detailCashier.setCashier(cashier);
				
				item.setItemCode(rs.getString("itemCode"));
				item.setItemName(rs.getString("itemName"));
				item.setItemUnit(rs.getString("itemUnit"));
				item.setPrice(rs.getInt("price"));
				detailCashier.setTotalItem(rs.getInt("totalOrder"));
				detailCashier.setSubTotalItem(rs.getInt("subTotalOrder"));
				
				
				detailCashier.setItems(item);
			
				
				list.add(detailCashier);
			}
			return list;
		} catch (Exception e) {
			Logger.getLogger(DAO_Items.class.getName()).log(Level.SEVERE,null,e);
			return null;
		}finally{
			if (stat!=null) {
				try {
					stat.close();
				} catch (Exception e) {
					Logger.getLogger(DAO_Items.class.getName()).log(Level.SEVERE,null,e);
				}
			}
			if (rs!=null) {
				try {
					rs.close();
				} catch (Exception e) {
					Logger.getLogger(DAO_Items.class.getName()).log(Level.SEVERE,null,e);
				}
			}
		}
		
	}

	@Override
	public List<modelDetailCashier> SearchingItem(String id) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public List<modelDetailCashierDraft> getByIdDraft(String id) {
		PreparedStatement stat=null;
		List list = new ArrayList();
		ResultSet rs = null;
		String sql ="SELECT DCD.orderId, DCD.itemCode, IL.itemName, IL.itemUnit, "
			   + "IL.price, DCD.totalOrder, DCD.subTotalOrder "
			   + "FROM detailCashierDraft DCD "
			   + "INNER JOIN cashierDraft CH ON  CH.orderId=DCD.orderId "
			   + "INNER JOIN itemsList IL ON IL.itemCode=DCD.itemCode "
			   + "WHERE DCD.orderId='"+id+"'ORDER BY CH.orderId ASC";
		
		try {
		stat = conn.prepareStatement(sql);
		rs = stat.executeQuery();
			while (rs.next()) {				
				modelCashier cashier = new modelCashier();
				modelDetailCashierDraft detailCashier = new modelDetailCashierDraft();
				modelItem item = new modelItem();
				
				
				cashier.setOrderId(String.valueOf(rs.getString("orderId")));
				detailCashier.setCashier(cashier);
				
				item.setItemCode(rs.getString("itemCode"));
				item.setItemName(rs.getString("itemName"));
				item.setItemUnit(rs.getString("itemUnit"));
				item.setPrice(rs.getInt("price"));
				detailCashier.setTotalItem(rs.getInt("totalOrder"));
				detailCashier.setSubTotalItem(rs.getInt("subTotalOrder"));
				
				
				detailCashier.setItems(item);
			
				
				list.add(detailCashier);
			}
			return list;
		} catch (Exception e) {
			Logger.getLogger(DAO_Items.class.getName()).log(Level.SEVERE,null,e);
			return null;
		}finally{
			if (stat!=null) {
				try {
					stat.close();
				} catch (Exception e) {
					Logger.getLogger(DAO_Items.class.getName()).log(Level.SEVERE,null,e);
				}
			}
			if (rs!=null) {
				try {
					rs.close();
				} catch (Exception e) {
					Logger.getLogger(DAO_Items.class.getName()).log(Level.SEVERE,null,e);
				}
			}
		}
	}

	@Override
	public void addDetailTransactionDraft(modelDetailCashierDraft detailCashier) {
		PreparedStatement stat=null;
	String sql = "INSERT INTO detailCashierDraft (orderId, itemCode,totalOrder,subTotalOrder) SELECT '"
		+detailCashier.getCashier().getOrderId()
		+"', itemCode, totalOrder, subTotalOrder FROM shoppingCartCashier"
		;
		try {
			stat=conn.prepareStatement(sql);
			stat.executeUpdate();
			
		}  catch (Exception e) {
			Logger.getLogger(DAO_DetailCheckin.class.getName()).log(Level.SEVERE,null,e);	
		}finally{
				if (stat!=null) {
					try {
						stat.close();
					} catch (Exception e) {
						Logger.getLogger(DAO_DetailCheckin.class.getName()).log(Level.SEVERE,null,e);
					}
				}
			}
	}

	@Override
	public List<modelCashierCart> getByDraft(String id) {
		PreparedStatement selectStat = null;
	PreparedStatement insertStat = null;
	ResultSet rs = null;
	String selectSql = "SELECT * FROM detailCashierDraft WHERE orderId = ?";
	String insertSql = "INSERT INTO shoppingCartCashier (itemCode,totalOrder, subTotalOrder) "
			    + "VALUES (?, ?, ?)";

	List<modelCashierCart> carts = new ArrayList<>();

	try {
	    // Execute SELECT query
	    selectStat = conn.prepareStatement(selectSql);
	    selectStat.setString(1, id);
	    rs = selectStat.executeQuery();

	    while (rs.next()) {
		modelCashierCart cart = new modelCashierCart();
		modelItem items = new modelItem();
		modelDetailCashierDraft detailCashier = new modelDetailCashierDraft();

		items.setItemCode(rs.getString("itemCode"));
		detailCashier.setTotalItem(rs.getInt("totalOrder"));
		detailCashier.setSubTotalItem(rs.getInt("subTotalOrder"));

		cart.setDetailCashierDraft(detailCashier);
		cart.setItem(items);
 
		insertStat = conn.prepareStatement(insertSql);
		insertStat.setString(1, items.getItemCode());
		insertStat.setInt(2, detailCashier.getTotalItem());
		insertStat.setInt(3, detailCashier.getSubTotalItem());

		insertStat.executeUpdate();
		carts.add(cart);
	    }
	} catch (Exception e) {
	    Logger.getLogger(DAO_DetailCashier.class.getName()).log(Level.SEVERE, null, e);
	} finally {
	    if (selectStat != null) {
		try {
		    selectStat.close();
		} catch (Exception e) {
		    Logger.getLogger(DAO_DetailCashier.class.getName()).log(Level.SEVERE, null, e);
		}
	    }
	    if (insertStat != null) {
		try {
		    insertStat.close();
		} catch (Exception e) {
		    Logger.getLogger(DAO_DetailCashier.class.getName()).log(Level.SEVERE, null, e);
		}
	    }
	    if (rs != null) {
		try {
		    rs.close();
		} catch (Exception e) {
		    Logger.getLogger(DAO_DetailCashier.class.getName()).log(Level.SEVERE, null, e);
		}
	    }
	}
		return carts;
	}

	@Override
	public void deleteTransactionDraft(modelDetailCashierDraft detailCashier) {
	PreparedStatement stat = null;
	String sql = "DELETE FROM detailCashierDraft WHERE orderId = ?";
	try {
	    stat = conn.prepareStatement(sql);
	    stat.setString(1, detailCashier.getCashier().getOrderId());
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
