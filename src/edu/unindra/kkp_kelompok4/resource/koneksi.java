package edu.unindra.kkp_kelompok4.resource;

import java.sql.*;

/**
 *
 * @author ripal
 */
public class koneksi {
    
    private Connection koneksi;
    public Connection connect(){
        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("Berhasil Koneksi");
        } catch (ClassNotFoundException ex){
            System.out.println("Gagal koneksi"+ex);  
        }
//        String url ="jdbc:mysql://db4free.net/ripal_kasir?useUnicode=true&characterEncoding=UTF-8";
	String url ="jdbc:sqlite:src/edu/unindra/kkp_kelompok4/resource/database/kkp.db";
        try {
//            koneksi = DriverManager.getConnection(url,"root","");
            koneksi = DriverManager.getConnection(url,"root","");
            System.out.println("Berhasil Koneksi Database");
        } catch (Exception ex){
            System.out.println("Gagal koneksi Database"+ex);
        }
        return koneksi;
    }
     public void testConnection() {
        if (koneksi != null) {
            System.out.println("Koneksi Berhasil");
        } else {
            System.out.println("Koneksi Gagal");
        }
    }
     
     public static void main(String[] args) {
    koneksi conn = new koneksi();
    Connection dbConn = conn.connect();
    conn.testConnection();
     }
}
