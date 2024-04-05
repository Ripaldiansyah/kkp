/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.model;

/**
 *
 * @author ripal
 */
public class modelItemCheckout {
	private String noCheckout,dateCheckout;
	private int totalCheckout;
	private modelEmployee employee_Name;

	public String getNoCheckout() {
		return noCheckout;
	}

	public void setNoCheckout(String noCheckout) {
		this.noCheckout = noCheckout;
	}

	public String getDateCheckout() {
		return dateCheckout;
	}

	public void setDateCheckout(String dateCheckout) {
		this.dateCheckout = dateCheckout;
	}

	public int getTotalCheckout() {
		return totalCheckout;
	}

	public void setTotalCheckout(int totalCheckout) {
		this.totalCheckout = totalCheckout;
	}

	public modelEmployee getEmployee_Name() {
		return employee_Name;
	}

	public void setEmployee_Name(modelEmployee employee_Name) {
		this.employee_Name = employee_Name;
	}

	
}
