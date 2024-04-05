package edu.unindra.kkp_kelompok4.model;


/**
 *
 * @author ripal
 */
 public class modelLogin {
    private String username,password,employeeName;
    private byte [] pictures;
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
    
    
	public byte[] getPictures() {
		    return pictures;
	}

	public void setPictures(byte [] pictures) {
		    this.pictures = pictures;}

	public String getUsername() {
	    return username;
	}

	public void setUsername(String username) {
	    this.username = username;
	}

	public String getPassword() {
	    return password;
	}

	public void setPassword(String password) {
	    this.password = password;
	}
 }
