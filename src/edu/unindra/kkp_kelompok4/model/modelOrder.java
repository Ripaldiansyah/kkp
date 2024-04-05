/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.model;

/**
 *
 * @author ripal
 */
public class modelOrder {
	private String noOrder,dateOrder;
	private int totalOrder;
	private modelDistributor distributor_Id;
	private modelEmployee employee_Name;

	public String getNoOrder() {
		return noOrder;
	}

	public void setNoOrder(String noOrder) {
		this.noOrder = noOrder;
	}

	public String getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(String dateOrder) {
		this.dateOrder = dateOrder;
	}

	public int getTotalOrder() {
		return totalOrder;
	}

	public void setTotalOrder(int totalOrder) {
		this.totalOrder = totalOrder;
	}

	public modelDistributor getDistributor_Id() {
		return distributor_Id;
	}

	public void setDistributor_Id(modelDistributor distributor_Id) {
		this.distributor_Id = distributor_Id;
	}

	public modelEmployee getEmployee_Name() {
		return employee_Name;
	}

	public void setEmployee_Name(modelEmployee employee_Name) {
		this.employee_Name = employee_Name;
	}
	
	
	
}
