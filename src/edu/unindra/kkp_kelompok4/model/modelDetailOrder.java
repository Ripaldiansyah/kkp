/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.model;

/**
 *
 * @author ripal
 */
public class modelDetailOrder {
	private modelOrder no_Order, total_Order;
	private modelItem item_Code;
	private int subTotalOrder;
	private String status;

	public modelOrder getNo_Order() {
		return no_Order;
	}

	public void setNo_Order(modelOrder no_Order) {
		this.no_Order = no_Order;
	}

	public modelOrder getTotal_Order() {
		return total_Order;
	}

	public void setTotal_Order(modelOrder total_Order) {
		this.total_Order = total_Order;
	}

	public modelItem getItem_Code() {
		return item_Code;
	}

	public void setItem_Code(modelItem item_Code) {
		this.item_Code = item_Code;
	}

	public int getSubTotalOrder() {
		return subTotalOrder;
	}

	public void setSubTotalOrder(int subTotalOrder) {
		this.subTotalOrder = subTotalOrder;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
