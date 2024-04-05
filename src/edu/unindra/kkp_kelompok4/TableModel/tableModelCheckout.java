/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.TableModel;

import edu.unindra.kkp_kelompok4.model.modelItemCheckout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ripal
 */
public class tableModelCheckout extends AbstractTableModel{

	private List<modelItemCheckout> list =new ArrayList<>();
	
	public void addItem(modelItemCheckout checkoutItem){
		list.add(checkoutItem);
		fireTableRowsInserted(list.size() -1, list.size()-1);
		JOptionPane.showMessageDialog(null, "Data barang berhasil ditambahkan");
	}
	
	public void renewItem(int row, modelItemCheckout checkoutItem){
		list.add(row,checkoutItem);
		fireTableDataChanged();
		JOptionPane.showMessageDialog(null, "Data barang berhasil diperbarui");
	}
	
	public void deleteItem(int index,modelItemCheckout checkoutItem){
		list.add(index,checkoutItem);
		fireTableRowsDeleted(index, index);
		JOptionPane.showMessageDialog(null, "Data barang berhasil dihapus");
	}
	
	public void clear(){
		list.clear();
		fireTableDataChanged();
	}
	
	public void setData(List<modelItemCheckout> list){
		clear();
		this.list.addAll(list);
		fireTableDataChanged();
	}
	
	public void setData(int index,modelItemCheckout checkoutItem){
		list.set(index, checkoutItem);
		fireTableRowsUpdated(index, index);
	}
	
	public modelItemCheckout getData (int index){
		return list.get(index);
	}

	@Override
	public int getRowCount() {
		return list.size();
	}
	private final String[] columnNames = {"No Barang Keluar","Tanggal barang keluar","Total Barang Keluar","Nama Karyawan"};
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
			case 0 : return list.get(rowIndex).getNoCheckout();
			case 1 : return list.get(rowIndex).getDateCheckout();
			case 2 : return list.get(rowIndex).getTotalCheckout();
			case 3 : return list.get(rowIndex).getEmployee_Name().getEmployeeName();
			
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
