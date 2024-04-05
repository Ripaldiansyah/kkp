/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.TableModel;

import edu.unindra.kkp_kelompok4.model.modelDetailCashier;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ripal
 */
public class tableModelDetailCashier extends AbstractTableModel{

	private List<modelDetailCashier> list =new ArrayList<>();
	
	public void addItem(modelDetailCashier detailCashier){
		list.add(detailCashier);
		fireTableRowsInserted(list.size() -1, list.size()-1);
		JOptionPane.showMessageDialog(null, "Data barang berhasil ditambahkan");
	}
	
	public void renewItem(int row, modelDetailCashier detailCashier){
		list.add(row,detailCashier);
		fireTableDataChanged();
		JOptionPane.showMessageDialog(null, "Data barang berhasil diperbarui");
	}
	
	public void deleteItem(int index,modelDetailCashier detailCashier){
		list.add(index,detailCashier);
		fireTableRowsDeleted(index, index);
		JOptionPane.showMessageDialog(null, "Data barang berhasil dihapus");
	}
	
	public void clear(){
		list.clear();
		fireTableDataChanged();
	}
	
	public void setData(List<modelDetailCashier> list){
		clear();
		this.list.addAll(list);
		fireTableDataChanged();
	}
	
	public void setData(int index,modelDetailCashier detailCheckin){
		list.set(index, detailCheckin);
		fireTableRowsUpdated(index, index);
	}
	
	public modelDetailCashier getData (int index){
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
