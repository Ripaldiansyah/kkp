/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.unindra.kkp_kelompok4.Services;


import edu.unindra.kkp_kelompok4.model.modelDetailIncomingItems;
import edu.unindra.kkp_kelompok4.model.modelIncomingItems;
import edu.unindra.kkp_kelompok4.model.modelItemCheckin;
import java.util.List;
/**
 *
 * @author ripal
 */
public interface serviceIncomingItems {
	void sendOrder (modelIncomingItems incomingItems);
	void deleteTransaction (modelIncomingItems incomingItems);
	boolean checkOrder(modelIncomingItems incomingItems);
	boolean checkOrderDeleted(modelIncomingItems incomingItems);
	boolean checkOrderDetail(modelDetailIncomingItems detailIncomingItems);
	void updateStatus (modelIncomingItems incomingItems);
	
	modelItemCheckin getById (String id);
	List <modelIncomingItems> getItem();
	List <modelIncomingItems> Search(String id);
}
