/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.unindra.kkp_kelompok4.Services;


import edu.unindra.kkp_kelompok4.model.modelItemCheckin;
import java.util.List;
/**
 *
 * @author ripal
 */
public interface serviceCheckIn {
	void addTransaction (modelItemCheckin itemCheckin);
	void deteleTransaction (modelItemCheckin itemCheckin);
	void updateTransaction (modelItemCheckin itemCheckin);
	void updateStatusTransaction (modelItemCheckin itemCheckin);
	void confirmAll (modelItemCheckin itemCheckin);
	void confirm (modelItemCheckin itemCheckin);
	
	modelItemCheckin getById (String id);
	List <modelItemCheckin> getItem();
	List <modelItemCheckin> Search(String id);
	String number();
}
