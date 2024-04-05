/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.model;

/**
 *
 * @author ripal
 */
public class modelDetailCashier {
	private modelCashier cashier;
	private modelItem items;
	private int totalItem, subTotalItem;
	

	public modelCashier getCashier() {
		return cashier;
	}

	public void setCashier(modelCashier cashier) {
		this.cashier = cashier;
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
	
	
}
