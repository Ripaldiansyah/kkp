/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.unindra.kkp_kelompok4.Services;

import edu.unindra.kkp_kelompok4.model.modelItem;
import java.util.List;

/**
 *
 * @author ripal
 */
public interface serviceItem {
	void addItem(modelItem model_item);
	void renewItem(modelItem model_item);
	void deleteItem(modelItem model_item);
	
	void getById (modelItem model_item);
	
	List<modelItem> getDataById();
	List<modelItem>getData();
	
	List<modelItem>searchingData(String id);
	List<modelItem>searching_Data(String id);
	
	String number();
	String numbering();
	
	
}
