/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.model;

/**
 *
 * @author ripal
 */
public class modelDetailIncomingItems {
	private modelIncomingItems incomingItems;
	private modelItem items;
	private int totalItem, subTotalItem;
	private String status, dateReceived,noCheckin;
	private modelEmployee employee;
	private modelDistributor distributor;

	public String getNoCheckin() {
		return noCheckin;
	}

	public void setNoCheckin(String noCheckin) {
		this.noCheckin = noCheckin;
	}

	
	
	public modelEmployee getEmployee() {
		return employee;
	}

	public void setEmployee(modelEmployee employee) {
		this.employee = employee;
	}
	
	

	public String getDateReceived() {
		return dateReceived;
	}

	public void setDateReceived(String dateReceived) {
		this.dateReceived = dateReceived;
	}

	public modelDistributor getDistributor() {
		return distributor;
	}

	public void setDistributor(modelDistributor distributor) {
		this.distributor = distributor;
	}

	

	public modelIncomingItems getIncomingItems() {
		return incomingItems;
	}

	public void setIncomingItems(modelIncomingItems incomingItems) {
		this.incomingItems = incomingItems;
	}
	
	

	
	public modelItem getItems() {
		return items;
	}

	public void setItems(modelItem items) {
		this.items = items;
	}

	public int getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}

	public int getSubTotalItem() {
		return subTotalItem;
	}

	public void setSubTotalItem(int subTotalItem) {
		this.subTotalItem = subTotalItem;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
