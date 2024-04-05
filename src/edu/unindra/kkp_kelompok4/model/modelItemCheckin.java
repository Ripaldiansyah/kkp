/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.model;

/**
 *
 * @author ripal
 */
public class modelItemCheckin {
	private String noCheckin,dateCheckin,transactionName,statusTransaction;
	private modelEmployee employee;
	private int totalCheckin;

	public String getStatusTransaction() {
		return statusTransaction;
	}

	public void setStatusTransaction(String statusTransaction) {
		this.statusTransaction = statusTransaction;
	}
	
	

	public String getTransactionName() {
		return transactionName;
	}

	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}

	public modelEmployee getEmployee() {
		return employee;
	}

	public void setEmployee(modelEmployee employee) {
		this.employee = employee;
	}

	
	
	public String getNoCheckin() {
		return noCheckin;
	}

	public void setNoCheckin(String noCheckin) {
		this.noCheckin = noCheckin;
	}

	public String getDateCheckin() {
		return dateCheckin;
	}

	public void setDateCheckin(String dateCheckin) {
		this.dateCheckin = dateCheckin;
	}

	public int getTotalCheckin() {
		return totalCheckin;
	}

	public void setTotalCheckin(int totalCheckin) {
		this.totalCheckin = totalCheckin;
	}


	
}
