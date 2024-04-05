/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.unindra.kkp_kelompok4.Services;

import edu.unindra.kkp_kelompok4.model.modelDetailCheckin;
import edu.unindra.kkp_kelompok4.model.modelShoppingCart;
import java.util.List;

/**
 *
 * @author ripal
 */
public interface serviceDetailCheckin {
	void addDetailTransaction(modelDetailCheckin detaileCheckin);
	void sumItem (modelDetailCheckin detaileCheckin);
	void deleteTransaction (modelDetailCheckin detailCheckin);
	
	List<modelShoppingCart> getById (String id);
	List <modelDetailCheckin> getItem(String id);
	List <modelDetailCheckin> SearchingItem(String id);
	
}
