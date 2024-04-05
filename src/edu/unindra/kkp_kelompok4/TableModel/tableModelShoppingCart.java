/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.TableModel;

import edu.unindra.kkp_kelompok4.model.modelShoppingCart;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ripal
 */
public class tableModelShoppingCart extends AbstractTableModel{

	private List<modelShoppingCart> list =new ArrayList<>();
	
	public void addItem(modelShoppingCart shoppingCart){
		list.add(shoppingCart);
		fireTableRowsInserted(list.size() -1, list.size()-1);
		JOptionPane.showMessageDialog(null, "Data barang berhasil ditambahkan");
	}
	
	public void renewItem(int row, modelShoppingCart shoppingCart){
		 list.remove(row);
		list.add(row,shoppingCart);
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
	
	public void setData(List<modelShoppingCart> list){
		clear();
		this.list.addAll(list);
		fireTableDataChanged();
	}
	
	public void setData(int index,modelShoppingCart shoppingCart){
		list.set(index, shoppingCart);
		fireTableRowsUpdated(index, index);
	}
	
	public modelShoppingCart getData (int index){
		return list.get(index);
	}
	
	@Override
	public int getRowCount() {
		return list.size();
	}
	private final String[] columnNames = {"No","Kode Item","Nama Barang","Satuan Barang","Harga Barang","Total Barang","Sub Total","Distributor"};
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
			case 4 : return list.get(rowIndex).getDetaileCheckin().getTotalItem();
			case 5 : return list.get(rowIndex).getDetaileCheckin().getSubTotalItem();
			case 6 : return list.get(rowIndex).getDistributor().getDistributorName();
			
			
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
