/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.model;

/**
 *
 * @author ripal
 */
public class modelCashierCart {
	private modelItem item;
	private modelDetailCashier detailCashier;
	private modelDetailCashierDraft detailCashierDraft;

	public modelDetailCashierDraft getDetailCashierDraft() {
		return detailCashierDraft;
	}

	public void setDetailCashierDraft(modelDetailCashierDraft detailCashierDraft) {
		this.detailCashierDraft = detailCashierDraft;
	}

	
	public modelItem getItem() {
		return item;
	}

	public void setItem(modelItem item) {
		this.item = item;
	}

	public modelDetailCashier getDetailCashier() {
		return detailCashier;
	}

	public void setDetailCashier(modelDetailCashier detailCashier) {
		this.detailCashier = detailCashier;
	}
	
	

	
	
}
