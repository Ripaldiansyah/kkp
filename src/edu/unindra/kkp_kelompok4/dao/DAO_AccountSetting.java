/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.dao;

import edu.unindra.kkp_kelompok4.Services.serviceAccountSetting;
import edu.unindra.kkp_kelompok4.model.modelAccountSetting;
import edu.unindra.kkp_kelompok4.resource.koneksi;
import edu.unindra.kkp_kelompok4.home.homeApp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ripal
 */
public class DAO_AccountSetting implements serviceAccountSetting{
	private Connection conn = new koneksi().connect();

	@Override
	public void profileSetting(modelAccountSetting account) {
		PreparedStatement stat=null;
		String sql = "UPDATE employeeTable SET employeeName=? , gender=?, placeOfBirth=? ,dateOfBirth=?, address=?,email=?, pictures=?, phoneNumber=? where idEmployee='"+account.getIdEmployee()+"'";
		try {
			stat=(PreparedStatement) conn.prepareStatement(sql);
			stat.setString(1, account.getEmployeeName());
			stat.setString(2, account.getGender());
			stat.setString(3,account.getPlaceOfBirth());
			stat.setDate(4,account.getDateOfBirth());
                        stat.setString(5,account.getAddress());
                        stat.setString(6,account.getEmail());
			stat.setBytes(7,account.getPictures());
			stat.setString(8, account.getPhoneNumber());
			
			stat.executeUpdate();
////			byte[] newPicture = account.getPictures();
////			homeApp home = new homeApp (account.getIdEmployee(),account.getEmployeeName(),"owmer",newPicture);
//			home.updateProfilePicture(newPicture);

		
		 JOptionPane.showMessageDialog(null, "Data berhasil diperbarui");
		 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal memperbarui data");
            java.util.logging.Logger.getLogger(DAO_AccountSetting	.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (Exception e) {
                    java.util.logging.Logger.getLogger(DAO_AccountSetting.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
                }
            }
        }
	}

	@Override
	public void displayAccount(modelAccountSetting account) {
	PreparedStatement stat=null;
		ResultSet rs = null;
		String sql ="SELECT * FROM employeeTable where idEmployee='"+account.getIdEmployee()+"'";
		try {
		stat = conn.prepareStatement(sql);
		rs = stat.executeQuery();
			while (rs.next()) {
    account.setPictures(rs.getBytes("pictures"));
    account.setEmployeeName(rs.getString("employeeName"));
    account.setGender(rs.getString("gender"));

    // Mengambil tanggal sebagai string
    String dateOfBirthStr = rs.getString("dateOfBirth");

    // Konversi tanggal menjadi objek java.sql.Date secara manual
    if (dateOfBirthStr != null) {
        long dateOfBirthMillis = Long.parseLong(dateOfBirthStr);
        Date dateOfBirth = new Date(dateOfBirthMillis);
        account.setDateOfBirth(dateOfBirth);
    }

    account.setPlaceOfBirth(rs.getString("placeOfBirth"));
    account.setEmail(rs.getString("email"));
    account.setRole(rs.getString("role"));
    account.setPin(rs.getString("Pin"));
    account.setAddress(rs.getString("address"));
    account.setPassword(rs.getString("password_hash"));
    account.setPhoneNumber(rs.getString("phoneNumber"));
}

			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "AKUN TERHAPUS ATAU TIDAK DITEMUKAN HUBUNGI ADMINISTRATOR");
			java.util.logging.Logger.getLogger(DAO_AccountSetting.class.getName()).log(java.util.logging.Level.SEVERE,null,e);
			
		}finally{
			if (stat!=null) {
				try {
					stat.close();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "AKUN TERHAPUS ATAU TIDAK DITEMUKAN HUBUNGI ADMINISTRATOR");
					java.util.logging.Logger.getLogger(DAO_AccountSetting.class.getName()).log(java.util.logging.Level.SEVERE,null,e);
				
				}
			}
		}
	}

	@Override
	public void passwordChange(modelAccountSetting account) {
    PreparedStatement stat = null;
String sql = "UPDATE employeeTable SET password_hash=? WHERE idEmployee=?";
try {
    stat = conn.prepareStatement(sql);
    stat.setString(1, account.getPassword()); // Mengatur parameter pertama dengan hash password baru
    stat.setString(2, account.getIdEmployee()); // Mengatur parameter kedua dengan ID karyawan
    
    stat.executeUpdate();

    JOptionPane.showMessageDialog(null, "Password berhasil diubah");
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Gagal memperbarui password");
    java.util.logging.Logger.getLogger(DAO_AccountSetting.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
} finally {
    if (stat != null) {
        try {
            stat.close();
        } catch (Exception e) {
            java.util.logging.Logger.getLogger(DAO_AccountSetting.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
    }
}

}

	
	
	@Override
	public void pinChange(modelAccountSetting account) {
	 PreparedStatement stat = null;
	String sql = "UPDATE employeeTable SET pin=? WHERE idEmployee=?";
	try {
	    stat = conn.prepareStatement(sql);
	    stat.setString(1, account.getPin()); // Mengatur parameter pertama dengan hash password baru
	    stat.setString(2, account.getIdEmployee()); // Mengatur parameter kedua dengan ID karyawan

	    stat.executeUpdate();

	    JOptionPane.showMessageDialog(null, "PIN berhasil diubah");
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, "Gagal memperbarui PIN");
	    java.util.logging.Logger.getLogger(DAO_AccountSetting.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
	} finally {
	    if (stat != null) {
		try {
		    stat.close();
		} catch (Exception e) {
		    java.util.logging.Logger.getLogger(DAO_AccountSetting.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
		}
	    }
	}

}
		
	}
	
