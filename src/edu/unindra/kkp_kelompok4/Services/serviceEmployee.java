/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.unindra.kkp_kelompok4.Services;

import edu.unindra.kkp_kelompok4.model.modelEmployee;
import java.util.List;

/**
 *
 * @author ripal
 */
public interface serviceEmployee {
	void addItem(modelEmployee employee);
	void renewItem(modelEmployee employee);
	void deleteItem(modelEmployee employee);
	void checkUsername(modelEmployee employee);
	modelEmployee pinSetting(String employee);
	
	modelEmployee getById (String id);
	List <modelEmployee> getCarts();
	List <modelEmployee> getEmployeesWarehouse();
//	List<modelEmployee> getDataByName();
	List<modelEmployee>getData();
//	
//	List<modelEmployee>searchingData(String id);
//	List<modelEmployee>searching_Data(String id);
//	
	String number();
//	String numbering();
	
	
}
