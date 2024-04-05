/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.unindra.kkp_kelompok4.Services;

import edu.unindra.kkp_kelompok4.model.modelDetailCashier;
import edu.unindra.kkp_kelompok4.model.modelCashierCart;
import edu.unindra.kkp_kelompok4.model.modelDetailCashierDraft;
import java.util.List;

/**
 *
 * @author ripal
 */
public interface serviceDetailCashier {
	void addDetailTransaction(modelDetailCashier detailCashier);
	void addDetailTransactionDraft(modelDetailCashierDraft detailCashier);
	void sumItem (modelDetailCashier detailCashier);
	void deleteTransaction (modelDetailCashier detailCashier);
	void deleteTransactionDraft (modelDetailCashierDraft detailCashier);
	
	List<modelCashierCart> getById (String id);
	List<modelCashierCart> getByDraft (String id);
	List<modelDetailCashierDraft> getByIdDraft (String id);
	List <modelDetailCashier> getItem(String id);
	List <modelDetailCashier> SearchingItem(String id);
	
}
