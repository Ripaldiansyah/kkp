/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.TableModel;
import edu.unindra.kkp_kelompok4.model.modelItem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ripal
 */
public class tableModelItem extends AbstractTableModel{
	private List<modelItem> list =new ArrayList<>();
	
	public void addItem(modelItem model_Item){
		list.add(model_Item);
		fireTableRowsInserted(list.size() -1, list.size()-1);
		JOptionPane.showMessageDialog(null, "Data barang berhasil ditambahkan");
	}
	
	public void renewItem(int row, modelItem model_Item){
		list.add(row,model_Item);
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
	
	public void setData(List<modelItem> list){
		clear();
		this.list.addAll(list);
		fireTableDataChanged();
	}
	
	public void setData(int index,modelItem model_Item){
		list.set(index, model_Item);
		fireTableRowsUpdated(index, index);
	}
	
	public modelItem getData (int index){
		return list.get(index);
	}

	@Override
	public int getRowCount() {
		return list.size();
	}
	private final String[] columnNames = {
						"No",
						"Kode Barang",
						"Kode jenis",
						"Nama Jenis",
						"Nama Barang",
						"Satuan",
						"Harga",
						"Stock"
					     };
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
			case 0 : return list.get(rowIndex).getItemCode();
			case 1 : return list.get(rowIndex).getType_item().getCodeType();
			case 2 : return list.get(rowIndex).getType_item().getNameType();
			case 3 : return list.get(rowIndex).getItemName();
			case 4 : return list.get(rowIndex).getItemUnit();
			case 5 : return list.get(rowIndex).getPrice();
			case 6 : return list.get(rowIndex).getStock();
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
		
//		switch(column==0) {
//			case 0 : return "Kode Barang";
//			case 1 : return "Nama Barang";
//			case 2 : return "Harga";
//			case 3 : return "Type Barang";
//			case 4 : return "Total Barang";
//			case 5 : return "Nama Suppliier";
//			default: return null;
//		}
