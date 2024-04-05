/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.unindra.kkp_kelompok4.Services;

import edu.unindra.kkp_kelompok4.model.modelDetailCheckin;
import edu.unindra.kkp_kelompok4.model.modelDetailIncomingItems;
import edu.unindra.kkp_kelompok4.model.modelShoppingCart;
import java.util.List;

/**
 *
 * @author ripal
 */
public interface serviceDetailIncomingItems {
	void submitDetail(modelDetailIncomingItems detailIncomingItems);
	void checkStatusConfirm(modelDetailIncomingItems detailIncomingItems);
	
	modelDetailIncomingItems getById (String id,String distri,String itemCode);
	
	
	List<modelDetailIncomingItems> getById (String id);
	List <modelDetailIncomingItems> getItem(String id);
	List <modelDetailIncomingItems> SearchingItem(String id);
	
}
