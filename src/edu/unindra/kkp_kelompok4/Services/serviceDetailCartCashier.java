/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.unindra.kkp_kelompok4.Services;

import edu.unindra.kkp_kelompok4.model.modelCashierCart;
import java.util.List;

/**
 *
 * @author ripal
 */
public interface serviceDetailCartCashier {
	void addItem(modelCashierCart cashierCart);
	void renewItem (modelCashierCart cashierCart);
	void deleteCart (modelCashierCart cashierCart);
	void deleteAllCart();
	List <modelCashierCart> getCarts();
	
	modelCashierCart getById (String id);
	List <modelCashierCart> getItem();
	
	
}
