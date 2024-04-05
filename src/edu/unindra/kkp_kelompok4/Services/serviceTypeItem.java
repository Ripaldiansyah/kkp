/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.unindra.kkp_kelompok4.Services;

import edu.unindra.kkp_kelompok4.model.modelTypeItem;
import java.util.List;

/**
 *
 * @author ripal
 */
public interface serviceTypeItem {
	void addItem (modelTypeItem model_TypeItem);
	void renewItem (modelTypeItem model_TypeItem);
	void deleteItem (modelTypeItem model_TypeItem);
	void getDataComboBox();
	
	modelTypeItem getById(String id);
	
	List<modelTypeItem> getItems();
	List<modelTypeItem> searchItem(String id);
	List <modelTypeItem> getCarts();
	String numbering();
	
	boolean nameValidationTypeOfItem(modelTypeItem model_TypeItem);
}
