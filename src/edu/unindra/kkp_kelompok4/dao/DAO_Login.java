/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.dao;

import edu.unindra.kkp_kelompok4.home.homeApp;
import edu.unindra.kkp_kelompok4.login.encryptLogin;
import edu.unindra.kkp_kelompok4.login.formLogin;
import edu.unindra.kkp_kelompok4.resource.koneksi;
import edu.unindra.kkp_kelompok4.model.modelLogin;
import edu.unindra.kkp_kelompok4.Services.serviceLogin;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ripal
 */
public class DAO_Login implements serviceLogin{
	private Connection conn = new koneksi().connect();
	@Override
	public void prosesLogin(modelLogin loginModel) {
	  String sql = "SELECT * FROM employeeTable WHERE LOWER(username)=LOWER(?) AND password_hash=?";
//	    String sql = ("Select * from employeeTable where username='"+loginModel.getUsername()+"' and password_hash ='"+loginModel.getPassword())+"'";
	   PreparedStatement stat=null;
	   ResultSet rs=null;
	   String idEmployee,employeeName,role=null;
	   byte[] picture;
    try {
        stat = conn.prepareStatement(sql);
	stat.setString(1, loginModel.getUsername());
        stat.setString(2, encryptLogin.getMD5(loginModel.getPassword()));

        rs = stat.executeQuery();
        if (rs.next()) {
            idEmployee = rs.getString("idEmployee");
            employeeName = rs.getString("employeeName");
            role = rs.getString("role");
	    picture = rs.getBytes("pictures");
		    
	    modelLogin model = new modelLogin();
	    model.setPictures(picture);
	    
	    
            homeApp menu = new homeApp(idEmployee, employeeName, role, picture);
            menu.setVisible(true);
            menu.revalidate();
	    formLogin login = new formLogin();
	    login.close=true;

        }else{
            JOptionPane.showMessageDialog(null, "Username atau Password salah","Kesalahan",JOptionPane.INFORMATION_MESSAGE);
	    formLogin login = new formLogin();
	    login.close=false;
	    
        }

    }
    catch (SQLException ex) {
        Logger.getLogger(DAO_Login.class.getName()).log(Level.SEVERE, null, ex);

    }finally{
        if (stat!=null) {
            try {
                stat.close();
            }catch(SQLException ex){
                Logger.getLogger(DAO_Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();

        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        String hashedPassword = encryptLogin.getMD5(password);
        System.out.println("Password yang di-hash: " + hashedPassword);

        // Buat objek modelLogin dan set nilai username dan password
        modelLogin loginModel = new modelLogin();
        loginModel.setUsername(username);
        loginModel.setPassword(hashedPassword);

        System.out.println("Username dalam objek modelLogin: " + loginModel.getUsername());
        System.out.println("Password dalam objek modelLogin: " + loginModel.getPassword());
    }
}

	
	
//	
