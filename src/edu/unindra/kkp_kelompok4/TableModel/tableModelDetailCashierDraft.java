/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.TableModel;

import edu.unindra.kkp_kelompok4.model.modelDetailCashierDraft;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ripal
 */
public class tableModelDetailCashierDraft extends AbstractTableModel{

	private List<modelDetailCashierDraft> list =new ArrayList<>();
	
	public void addItem(modelDetailCashierDraft detailCashier){
		list.add(detailCashier);
		fireTableRowsInserted(list.size() -1, list.size()-1);
		JOptionPane.showMessageDialog(null, "Data barang berhasil ditambahkan");
	}
	
	public void renewItem(int row, modelDetailCashierDraft detailCashier){
		list.add(row,detailCashier);
		fireTableDataChanged();
		JOptionPane.showMessageDialog(null, "Data barang berhasil diperbarui");
	}
	
	public void deleteItem(int index,modelDetailCashierDraft detailCashier){
		list.add(index,detailCashier);
		fireTableRowsDeleted(index, index);
		JOptionPane.showMessageDialog(null, "Data barang berhasil dihapus");
	}
	
	public void clear(){
		list.clear();
		fireTableDataChanged();
	}
	
	public void setData(List<modelDetailCashierDraft> list){
		clear();
		this.list.addAll(list);
		fireTableDataChanged();
	}
	
	public void setData(int index,modelDetailCashierDraft detailCheckin){
		list.set(index, detailCheckin);
		fireTableRowsUpdated(index, index);
	}
	
	public modelDetailCashierDraft getData (int index){
		return list.get(index);
	}
	
	@Override
	public int getRowCount() {
		return list.size();
	}
	private final String[] columnNames = {"No","Kode Barang","Nama Barang","Satuan","Harga","Jumlah","Total Belanja"};
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
			
			case 0 : return list.get(rowIndex).getItems().getItemCode();
			case 1 : return list.get(rowIndex).getItems().getItemName();
			case 2 : return list.get(rowIndex).getItems().getItemUnit();
			case 3 : return list.get(rowIndex).getItems().getPrice();
			case 4 : return list.get(rowIndex).getTotalItem();
			case 5 : return list.get(rowIndex).getSubTotalItem();
			
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
