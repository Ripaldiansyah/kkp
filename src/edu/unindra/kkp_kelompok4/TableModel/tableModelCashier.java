/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.TableModel;

import edu.unindra.kkp_kelompok4.model.modelCashier;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ripal
 */
public class tableModelCashier extends AbstractTableModel{

	private List<modelCashier> list =new ArrayList<>();
	
	public void addItem(modelCashier cashier){
		list.add(cashier);
		fireTableRowsInserted(list.size() -1, list.size()-1);
		JOptionPane.showMessageDialog(null, "Transaksi berhasil ditambahkan");
	}
	
	public void renewItem(int row, modelCashier cashier){
		list.add(row,cashier);
		fireTableDataChanged();
		JOptionPane.showMessageDialog(null, "Transaksi berhasil diperbarui");
	}
	
	public void deleteItem(int index){
		list.remove(index);
		fireTableRowsDeleted(index, index);
		JOptionPane.showMessageDialog(null, "transaksi berhasil dihapus");
	}
	
	public void clear(){
		list.clear();
		fireTableDataChanged();
	}
	
	public void setData(List<modelCashier> list){
		clear();
		this.list.addAll(list);
		fireTableDataChanged();
	}
	
	public void setData(int index,modelCashier itemCheckin){
		list.set(index, itemCheckin);
		fireTableRowsUpdated(index, index);
	}
	
	public modelCashier getData (int index){
		return list.get(index);
	}
	
	@Override
	public int getRowCount() {
		return list.size();
	}
	private final String[] columnNames = {"No","Order Id","Tanggal Transaksi","Total Transaksi","Total Pembayaran","Kembali","Metode Pembayaran","Kasir"};
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return " "+(rowIndex+1);
		}else{
		switch(columnIndex -1){
			case 0 : return list.get(rowIndex).getOrderId();
			case 1 : return list.get(rowIndex).getDateOrder();
			case 2 : return list.get(rowIndex).getTotalOrder();
			case 3 : return list.get(rowIndex).getPaymentAmount();
			case 4 : return list.get(rowIndex).getChangePayment();
			case 5 : return list.get(rowIndex).getPayment();
			case 6 : return list.get(rowIndex).getEmployee().getEmployeeName();
			
			default: return null;
		}
		}
	}
	@Override
	public String getColumnName(int column){
		if (column==0) {
			return "  "+columnNames[column];
		}else{
			return columnNames[column];
		}
	}

	
	
}
