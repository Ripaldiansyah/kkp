/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.unindra.kkp_kelompok4.Services;

import edu.unindra.kkp_kelompok4.model.modelShoppingCart;
import java.util.List;

/**
 *
 * @author ripal
 */
public interface serviceDetailCartCheckin {
	void addItem(modelShoppingCart shoppingCart);
	void renewItem (modelShoppingCart shoppingCart);
	void deleteCart (modelShoppingCart shoppingCart);
	void deleteAllCart();
	
	modelShoppingCart getById (String id,String distri);
	List <modelShoppingCart> getItem();
	
	
}
