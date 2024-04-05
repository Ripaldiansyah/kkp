/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.TableModel;

import edu.unindra.kkp_kelompok4.model.modelTypeItem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ripal
 */
public class tableModelTypeItem extends AbstractTableModel{
	private List<modelTypeItem> list =new ArrayList<>();
	
	public void addItem(modelTypeItem model_TypeItem){
		list.add(model_TypeItem);
		fireTableRowsInserted(list.size() -1, list.size()-1);
		JOptionPane.showMessageDialog(null, "Data Jenis barang berhasil ditambahkan");
	}
	
	public void renewItem(int row, modelTypeItem model_TypeItem){
		list.add(row,model_TypeItem);
		fireTableDataChanged();
		JOptionPane.showMessageDialog(null, "Data Jenis barang berhasil diperbarui");
	}
	
	public void deleteItem(int index){
		list.remove(index);
		fireTableRowsDeleted(index, index);
		JOptionPane.showMessageDialog(null, "Data Jenis barang berhasil dihapus");
	}
	
	public void clear(){
		list.clear();
		fireTableDataChanged();
	}
	
	public void setData(List<modelTypeItem> list){
		clear();
		this.list.addAll(list);
		fireTableDataChanged();
	}
	
	public void setData(int index,modelTypeItem model_TypeItem){
		list.set(index, model_TypeItem);
		fireTableRowsUpdated(index, index);
	}
	
	public modelTypeItem getData (int index){
		return list.get(index);
	}

	@Override
	public int getRowCount() {
		return list.size();
	}
	private final String[] columnNames = {"No","Kode Barang","Nama Jenis Barang"};
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
			case 0 : return list.get(rowIndex).getCodeType();
			case 1 : return list.get(rowIndex).getNameType();
			
			default: return null;
			
		}
		}
	}
	@Override
	public String getColumnName(int column){
		
			return columnNames[column];
	}
	
}
