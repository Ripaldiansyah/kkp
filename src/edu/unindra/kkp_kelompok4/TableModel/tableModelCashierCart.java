/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.TableModel;

import edu.unindra.kkp_kelompok4.model.modelCashierCart;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ripal
 */
public class tableModelCashierCart extends AbstractTableModel{

	private List<modelCashierCart> list =new ArrayList<>();
	
	public void addItem(modelCashierCart cashierCart){
		list.add(cashierCart);
		fireTableRowsInserted(list.size() -1, list.size()-1);
		JOptionPane.showMessageDialog(null, "Data barang berhasil ditambahkan");
	}
	
	public void renewItem(int row, modelCashierCart cashierCart){
		 list.remove(row);
		list.add(row,cashierCart);
		fireTableDataChanged();
		JOptionPane.showMessageDialog(null, "Data barang berhasil diperbarui");
	}
	
	public void deleteItem(int index){
		list.remove(index);
		fireTableRowsDeleted(index, index);
		JOptionPane.showMessageDialog(null, "Data barang berhasil dihapus");
	}
	
	public void clear(){
		list.clear();
		fireTableDataChanged();
	}
	
	public void setData(List<modelCashierCart> list){
		clear();
		this.list.addAll(list);
		fireTableDataChanged();
	}
	
	public void setData(int index,modelCashierCart cashierCart){
		list.set(index, cashierCart);
		fireTableRowsUpdated(index, index);
	}
	
	public modelCashierCart getData (int index){
		return list.get(index);
	}
	
	@Override
	public int getRowCount() {
		return list.size();
	}
	private final String[] columnNames = {"No","Kode Item","Nama Barang","Satuan Barang","Harga Barang","Total Barang","Sub Total"};
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
			case 0 : return list.get(rowIndex).getItem().getItemCode();
			case 1 : return list.get(rowIndex).getItem().getItemName();
			case 2 : return list.get(rowIndex).getItem().getItemUnit();
			case 3 : return list.get(rowIndex).getItem().getPrice();
			case 4 : return list.get(rowIndex).getDetailCashier().getTotalItem();
			case 5 : return list.get(rowIndex).getDetailCashier().getSubTotalItem();
			
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
