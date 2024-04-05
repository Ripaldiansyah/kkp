package edu.unindra.kkp_kelompok4.model;

/**
 *
 * @author ripal
 */
public class modelItem {
	private String itemCode,itemName,itemUnit;
	private modelTypeItem type_item;
	private Integer price, stock;

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemUnit() {
		return itemUnit;
	}

	public void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit;
	}

	public modelTypeItem getType_item() {
		return type_item;
	}

	public void setType_item(modelTypeItem type_item) {
		this.type_item = type_item;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	
}
