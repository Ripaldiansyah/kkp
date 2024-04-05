/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.model;

/**
 *
 * @author ripal
 */
public class modelShoppingCart {
	private modelItem item;
	private modelDetailCheckin detaileCheckin;
	private modelDistributor distributor;
	private modelDistributor originalDistributor;
	private modelItem originalItem;
	private modelDetailCheckin originalTotal;
	

	public modelDetailCheckin getOriginalTotal() {
		return originalTotal;
	}

	public void setOriginalTotal(modelDetailCheckin originalTotal) {
		this.originalTotal = originalTotal;
	}
	
	

	public modelItem getOriginalItem() {
		return originalItem;
	}

	public void setOriginalItem(modelItem originalItem) {
		this.originalItem = originalItem;
	}
	
	
	
	public modelDistributor getOriginalDistributor() {
		return originalDistributor;
	}

	public void setOriginalDistributor(modelDistributor originalDistributor) {
		this.originalDistributor = originalDistributor;
	}
	
	

	public modelDistributor getDistributor() {
		return distributor;
	}

	public void setDistributor(modelDistributor distributor) {
		this.distributor = distributor;
	}
	
	public modelItem getItem() {
		return item;
	}

	public void setItem(modelItem item) {
		this.item = item;
	}

	public modelDetailCheckin getDetaileCheckin() {
		return detaileCheckin;
	}

	public void setDetaileCheckin(modelDetailCheckin detaileCheckin) {
		this.detaileCheckin = detaileCheckin;
	}

	
	
}
