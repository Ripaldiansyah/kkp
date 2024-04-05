/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.unindra.kkp_kelompok4.Services;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

/**
 *
 * @author ripal
 */
public interface serviceReport {
	void reportItem();
	void reportItemFilterUnit(String no, JPanel jp);
	void reportItemFilterType(String type, JPanel jp);
	void reportItemFilterStock(int stock1,int stock2, JPanel jp);
	void reportItemFilterPrice(int price1,int price12, JPanel jp);
	void reportStruk(String no);
	void orderItem(String no);
	void deliveryOrder(String no);
	void reportItemPanel(JPanel jp);
	
	
	void reportTransactionItem(JPanel jp);
	void reportTransactionItemByPeriode(String dateOrder1,String dateOrder2, JPanel jp);
	void reportTransactionItemByPayment(String payment, JPanel jp);
	void reportTransactionItemByCashier(String cashier, JPanel jp);
	void reportTransactionItemByTotalShoping(int totalShoping1,int totalShoping2, JPanel jp);
	
	void reportDetailOrder(JPanel jp);
	void reportDetailOrderByPeriode(String dateOrder1,String dateOrder2, JPanel jp);
	void reportDetailOrderFilterStatus(String status,JPanel jp);
	void reportDetailOrderFilterEmployee(String employee,JPanel jp);
	void reportDetailOrderFilterTotal(int totalShoping1,int totalShoping2, JPanel jp);
	
	void reportOrder(JPanel jp);
	void reportOrderByPeriode(String dateOrder1,String dateOrder2, JPanel jp);
	void reportOrderFilterStatus(String status,JPanel jp);
	void reportOrderFilterEmployee(String employee,JPanel jp);
	void reportOrderFilterTotal(int totalShoping1,int totalShoping2, JPanel jp);
	
	void reportPerformanceCashier(String name,String date,JPanel jp);
}
