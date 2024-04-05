/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.dao;

import java.sql.*;
import edu.unindra.kkp_kelompok4.Services.serviceTypeItem;
import edu.unindra.kkp_kelompok4.model.modelItem;
import edu.unindra.kkp_kelompok4.model.modelTypeItem;
import edu.unindra.kkp_kelompok4.resource.koneksi;
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
public class DAO_typeItem implements serviceTypeItem{
	
	private Connection conn;
	
	public DAO_typeItem(){
		conn = new koneksi().connect();
	}

	@Override
	public void addItem(modelTypeItem model_TypeItem) {
		PreparedStatement stat=null;
		String sql = "INSERT INTO typeItemList (typeCode,nameType)VALUES (?,?)";
		try {
			stat= conn.prepareStatement(sql);
			stat.setString(1, model_TypeItem.getCodeType());
			stat.setString(2, model_TypeItem.getNameType());
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
	public void renewItem(modelTypeItem model_TypeItem) {
		PreparedStatement stat=null;
		String sql = "UPDATE typeItemList SET nameType=? where typeCode=?";
		try {
			stat= conn.prepareStatement(sql);
			stat.setString(1, model_TypeItem.getCodeType());
			stat.setString(2, model_TypeItem.getNameType());
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
	public void deleteItem(modelTypeItem model_TypeItem) {
		PreparedStatement stat=null;
			String sql = "DELETE From typeItemList where typeCode=?";
			try {
				stat= conn.prepareStatement(sql);
				stat.setString(1, model_TypeItem.getCodeType());
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
	public modelTypeItem getById(String id) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public List<modelTypeItem> getItems() {
		PreparedStatement stat=null;
		List list = new ArrayList();
		ResultSet rs = null;
		String sql = "SELECT * from typeItemList";
			try {
				stat= conn.prepareStatement(sql);
				rs=stat.executeQuery();
				while (rs.next()) {
					modelTypeItem model_TypeItem = new modelTypeItem();
					
					model_TypeItem.setCodeType(rs.getString("typeCode"));
					model_TypeItem.setNameType(rs.getString("nameType"));
					
					list.add(model_TypeItem);
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
	public List<modelTypeItem> searchItem(String id) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public String numbering() {
		PreparedStatement stat = null;
		ResultSet rs = null;
		String listing = null;
		LocalDate now = LocalDate.now();
//		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter noFormat = DateTimeFormatter.ofPattern("yyMM");

//		String tgl = now.format(dateFormatter);
		String no = now.format(noFormat);
		
		String sql = "SELECT SUBSTR(typeCode, -3) AS Number " +
				"FROM typeItemList " +
				"WHERE typeCode LIKE 'JNS-BRG" + no + "%' " +
				"ORDER BY typeCode DESC " +
				"LIMIT 1";
			;
		try {
			stat=conn.prepareStatement(sql);
			rs = stat.executeQuery();
			
			if (rs.next()) {
				int number =Integer.parseInt(rs.getString("number"));
				number++;
				listing="JNS-BRG"+no+String.format("%03d",number);
				
			}else{
				listing="JNS-BRG"+no+"001";
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
	public boolean nameValidationTypeOfItem(modelTypeItem model_TypeItem) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void getDataComboBox() {
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM typeItemList";
		try {
			conn.prepareStatement(sql);
			rs = stat.executeQuery();
			while (rs.next()) {				
			modelTypeItem typeItem = new modelTypeItem();
			typeItem.setNameType(rs.getString("nameType"));
			}
			
			
		} catch (Exception e) {
		}
	}

	@Override
	public List<modelTypeItem> getCarts() {
	PreparedStatement stat = null;
		List<modelTypeItem> list = new ArrayList<>();
		ResultSet rs = null;
		String sql = "SELECT * FROM typeItemList";
		try {
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			while (rs.next()) {
				modelTypeItem typeItem = new modelTypeItem();
				
				typeItem.setNameType(rs.getString("nameType"));

				list.add(typeItem);
			}
			return list;
		} catch (Exception e) {
			Logger.getLogger(DAO_typeItem.class.getName()).log(Level.SEVERE,null,e);
			return null;
		}finally{
			if (stat!=null) {
				try {
					stat.close();
				} catch (Exception e) {
					Logger.getLogger(DAO_typeItem.class.getName()).log(Level.SEVERE,null,e);
				}
			}
	}
	}
	
	
	
}
