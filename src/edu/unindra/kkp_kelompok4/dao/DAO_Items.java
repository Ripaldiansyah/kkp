/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.dao;

import java.sql.*;
import edu.unindra.kkp_kelompok4.model.modelItem;
import edu.unindra.kkp_kelompok4.model.modelTypeItem;
import edu.unindra.kkp_kelompok4.resource.koneksi;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import javax.swing.JOptionPane;
import edu.unindra.kkp_kelompok4.Services.serviceItem;

/**
 *
 * @author ripal
 */
public class DAO_Items implements serviceItem{
	
	private Connection conn;
	
	public DAO_Items(){
		conn = new koneksi().connect();
	}

	@Override
	public void addItem(modelItem model_item) {
		PreparedStatement stat=null;
		String sql = "INSERT INTO itemsList (itemCode,typeCode,itemName,itemUnit,price,stock)VALUES (?,?,?,?,?,?)";
		try {
			stat=(PreparedStatement) conn.prepareStatement(sql);
			stat.setString(1, model_item.getItemCode());
			stat.setString(2, model_item.getType_item().getCodeType());
			stat.setString(3,model_item.getItemName());
			stat.setString(4, model_item.getItemUnit());
			stat.setInt(5, model_item.getPrice());
			stat.setInt(6, model_item.getStock());
			
			stat.executeUpdate();
		} catch (Exception e) {
			Logger.getLogger(DAO_Items.class.getName()).log(Level.SEVERE,null,e);
		}finally{
			if (stat!=null) {
				try {
					stat.close();
				} catch (Exception e) {
					Logger.getLogger(DAO_Items.class.getName()).log(Level.SEVERE,null,e);
				}
			}
		}
	}

	@Override
	public void renewItem(modelItem model_item) {
		PreparedStatement stat=null;
		String sql = "UPDATE itemsList SET typeCode=?, itemName=? , itemUnit=?, price=? ,stock=? where itemCode='"+model_item.getItemCode()+"'";
		try {
			stat=(PreparedStatement) conn.prepareStatement(sql);
			stat.setString(1, model_item.getType_item().getCodeType());
			stat.setString(2, model_item.getItemName());
			stat.setString(3,model_item.getItemUnit());
			stat.setInt(4, model_item.getPrice());
			stat.setInt(5, model_item.getStock());
			
			stat.executeUpdate();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Data Berhasil diperbarui");
			Logger.getLogger(DAO_Items.class.getName()).log(Level.SEVERE,null,e);
		}finally{
			if (stat!=null) {
				try {
					stat.close();
				} catch (Exception e) {
					Logger.getLogger(DAO_Items.class.getName()).log(Level.SEVERE,null,e);
				}
			}
		}
	}

	@Override
	public void deleteItem(modelItem model_item) {
		PreparedStatement stat=null;
		String sql = "DELETE From itemsList where itemCode=?";
		try {
			stat=(PreparedStatement) conn.prepareStatement(sql);
			stat.setString(1,model_item.getItemCode());
			stat.executeUpdate();
		} catch (Exception e) {
			Logger.getLogger(DAO_Items.class.getName()).log(Level.SEVERE,null,e);
		}finally{
			if (stat!=null) {
				try {
					stat.close();
				} catch (Exception e) {
					Logger.getLogger(DAO_Items.class.getName()).log(Level.SEVERE,null,e);
				}
			}
		}
	}

	@Override
	public void getById(modelItem model_item) {
		PreparedStatement stat=null;
		ResultSet rs = null;
		String sql ="SELECT * FROM itemsList where itemCode='"+model_item.getItemCode()+"'";
		
		
		try {
		stat = conn.prepareStatement(sql);
		rs = stat.executeQuery();
			while (rs.next()) {
				
				model_item.setItemName(rs.getString("itemName"));
				model_item.setItemUnit(rs.getString("itemUnit"));
				model_item.setPrice(rs.getInt("price"));
			}
			
				
	}catch (Exception e) {
			java.util.logging.Logger.getLogger(DAO_AccountSetting.class.getName()).log(java.util.logging.Level.SEVERE,null,e);
			
		}finally{
			if (stat!=null) {
				try {
					stat.close();
				} catch (Exception e) {
					
					java.util.logging.Logger.getLogger(DAO_AccountSetting.class.getName()).log(java.util.logging.Level.SEVERE,null,e);
				
				}
			}
		
		}
		
	}

	@Override
	public List<modelItem> getDataById() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public List<modelItem> getData() {
		PreparedStatement stat=null;
		List list = new ArrayList();
		ResultSet rs = null;
		String sql ="Select IL.itemCode,IL.typeCode,TIL.nameType,IL.itemName,IL.itemUnit,IL.price,IL.stock FROM itemsList IL inner join typeItemList TIL On TIL.typeCode=IL.typeCode";
		
		try {
		stat = conn.prepareStatement(sql);
		rs = stat.executeQuery();
			while (rs.next()) {				
				modelItem model_item = new modelItem();
				modelTypeItem model_TypeItem = new modelTypeItem();
				
				model_item.setItemCode(rs.getString("itemCode"));
				model_TypeItem.setCodeType(rs.getString("typeCode"));
				model_TypeItem.setNameType(rs.getString("nameType"));
				model_item.setItemName(rs.getString("itemName"));
				model_item.setItemUnit(rs.getString("itemUnit"));
				model_item.setPrice(rs.getInt("price"));
				model_item.setStock(rs.getInt("stock"));
				
				model_item.setType_item(model_TypeItem);
				list.add(model_item);
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
	public List<modelItem> searchingData(String id) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public List<modelItem> searching_Data(String id) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public String number() {
		PreparedStatement stat = null;
		ResultSet rs = null;
		String listing = null;
		LocalDate now = LocalDate.now();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		DateTimeFormatter noFormat = DateTimeFormatter.ofPattern("yyMM");

		String tgl = now.format(dateFormatter);
//		String no = now.format(noFormat);
		
		String sql = "SELECT SUBSTR(itemCode, -3) AS Number " +
				"FROM itemsList " +
				"WHERE itemCode LIKE 'B" + tgl + "%' " +
				"ORDER BY itemCode DESC " +
				"LIMIT 1";
			;
		try {
			stat=conn.prepareStatement(sql);
			rs = stat.executeQuery();
			
			if (rs.next()) {
				int number =Integer.parseInt(rs.getString("number"));
				number++;
				listing="B"+tgl+String.format("%03d",number);
				
			}else{
				listing="B"+tgl+"001";
			}
		} catch (Exception e) {
			Logger.getLogger(DAO_Items.class.getName()).log(Level.SEVERE,null,e);
		}finally{
			if (stat!=null) {
				try {
					stat.close();
				} catch (Exception e) {
					Logger.getLogger(DAO_Items.class.getName()).log(Level.SEVERE,null,e);
				}
			}
		}
		return listing;
		
	}

	@Override
	public String numbering() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}
	
	
}
