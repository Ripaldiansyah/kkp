/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.unindra.kkp_kelompok4.Services;


import edu.unindra.kkp_kelompok4.model.modelCashier;
import java.util.List;
/**
 *
 * @author ripal
 */
public interface serviceCashier {
	void addTransaction (modelCashier cashier);
	void deteleTransaction (modelCashier cashier);
	void deteleTransactionDraft (modelCashier cashier);
	void updateTransaction (modelCashier cashier);
	void addDraft(modelCashier cashier);
	
	modelCashier getById (String id);
	List <modelCashier> getItem();
	List <modelCashier> getItemDrafList();
	List <modelCashier> Search(String id);
	String number();
}
