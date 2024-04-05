/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unindra.kkp_kelompok4.dao;

import edu.unindra.kkp_kelompok4.Services.serviceDistributor;
import edu.unindra.kkp_kelompok4.model.modelDistributor;
import edu.unindra.kkp_kelompok4.model.modelItem;
import edu.unindra.kkp_kelompok4.model.modelTypeItem;
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
 * @author fadli
 */
public class DAO_Distributor implements serviceDistributor{
    
    private Connection conn;
    
    public DAO_Distributor() {
        conn = new koneksi().connect();
    }

    @Override
    public void addData(modelDistributor modis) {
       PreparedStatement stat=null;
		String sql = "INSERT INTO distributor(distributorId,distributorName,distributorTelp,distributorAddress)VALUES (?,?,?,?)";
		try {
			stat=(PreparedStatement) conn.prepareStatement(sql);
			stat.setString(1, modis.getDistributorId());
			stat.setString(2, modis.getDistributorName());
			stat.setString(3,modis.getDistributorTlp());
			stat.setString(4, modis.getDistributorAddress());
				
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
    public void renewData(modelDistributor modis) {
    PreparedStatement stat = null;
    String sql = "UPDATE distributor SET distributorName=?, distributorTelp=?, distributorAddress=? WHERE distributorId=?";
        try {
            stat = conn.prepareStatement(sql);
            stat.setString(1, modis.getDistributorName());
            stat.setString(2, modis.getDistributorTlp());
            stat.setString(3, modis.getDistributorAddress());
            stat.setString(4, modis.getDistributorId());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diperbarui");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal memperbarui data");
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
    public void deleteData(modelDistributor modis) {
        PreparedStatement stat=null;
		String sql = "DELETE From distributor where distributorId=?";
		try {
			stat=(PreparedStatement) conn.prepareStatement(sql);
			stat.setString(1,modis.getDistributorId());
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
    public modelDistributor getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<modelDistributor> getData() {
       PreparedStatement stat=null;
		List list = new ArrayList();
		ResultSet rs = null;
		String sql ="Select * From distributor";
		
		try {
		stat = conn.prepareStatement(sql);
		rs = stat.executeQuery();
			while (rs.next()) {				
				modelDistributor model = new modelDistributor();
				
				model.setDistributorId(rs.getString("distributorId"));
				model.setDistributorName(rs.getString("distributorName"));
				model.setDistributorTlp(rs.getString("distributorTelp"));
				model.setDistributorAddress(rs.getString("distributorAddress"));
				
			
				list.add(model);
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
    public List<modelDistributor> search(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<modelDistributor> searching(String id) {
      PreparedStatement stat = null;
      List list = new ArrayList();
      ResultSet rs = null;
      String sql = "SELECT * FROM distributor WHERE distributorId LIKE '%"+id+"%' OR distributorName LIKE '%"+id+"%' OR distributorTelp LIKE '%"+id+"%' OR distributorAddress LIKE '%"+id+"%'";
      try{
          stat = conn.prepareStatement(sql);
          rs = stat.executeQuery();
          while (rs.next()) {				
				modelDistributor model = new modelDistributor();
				
				model.setDistributorId(rs.getString("distributorId"));
				model.setDistributorName(rs.getString("distributorName"));
				model.setDistributorTlp(rs.getString("distributorTelp"));
				model.setDistributorAddress(rs.getString("distributorAddress"));
				
			
				list.add(model);
			}
          
      }catch(SQLException ex){
          java.util.logging.Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE,null,ex);
          return null;
      }finally{
          if(stat !=null){
              try{
              stat.close();
          }catch(SQLException ex){
                     java.util.logging.Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE,null,ex);
                  }
          }
            if(rs !=null){
              try{
              rs.close();
          }catch(SQLException ex){
                     java.util.logging.Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE,null,ex);
                  }
      }
    }
        return null;
    }
    

    @Override
    public String number() {
        PreparedStatement stat = null;
		ResultSet rs = null;
			String listing = null;
		LocalDate now = LocalDate.now();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter noFormat = DateTimeFormatter.ofPattern("yyMM");

		String tgl = now.format(dateFormatter);
		String no = now.format(noFormat);
		
		String sql = "SELECT SUBSTR(distributorID, -3) AS Number " +
				"FROM distributor " +
				"WHERE distributorId LIKE 'DST" + no + "%' " +
				"ORDER BY distributorID DESC " +
				"LIMIT 1";

		try {
			stat=conn.prepareStatement(sql);
			rs = stat.executeQuery();
			
			if (rs.next()) {
				int number =Integer.parseInt(rs.getString("number"));
				number++;
				listing="DST"+no+String.format("%03d",number);
				
			}else{
				listing="DST"+no+"001";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
