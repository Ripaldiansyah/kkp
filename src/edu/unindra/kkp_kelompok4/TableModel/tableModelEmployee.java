/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.TableModel;
import edu.unindra.kkp_kelompok4.model.modelEmployee;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ripal
 */
public class tableModelEmployee extends AbstractTableModel{
	private List<modelEmployee> list =new ArrayList<>();
	
	public void addItem(modelEmployee employee){
		list.add(employee);
		fireTableRowsInserted(list.size() -1, list.size()-1);
		JOptionPane.showMessageDialog(null, "Data Karyawan berhasil ditambahkan");
	}
	
	public void renewItem(int row, modelEmployee employee){
		list.add(row,employee);
		fireTableDataChanged();
		JOptionPane.showMessageDialog(null, "Data Karyawan berhasil diperbarui");
	}
	
	public void deleteItem(int index){
		list.remove(index);
		fireTableRowsDeleted(index, index);
		JOptionPane.showMessageDialog(null, "Data Karyawan berhasil dihapus");
	}
	
	public void clear(){
		list.clear();
		fireTableDataChanged();
	}
	
	
	public void setData(List<modelEmployee> list){
		clear();
		this.list.addAll(list);
		fireTableDataChanged();
	}
//	
	public void setData(int index,modelEmployee employee){
		list.set(index, employee);
		fireTableRowsUpdated(index, index);
	}
	
	public modelEmployee getData (int index){
		return list.get(index);
	}

	@Override
	public int getRowCount() {
		return list.size();
	}
	private final String[] columnNames = {
						"No",
						"ID Karyawan",
						"Nama Karyawan",
						"Jenis Kelamin",
						"Tempat, Tanggal Lahir",
                                                "No telphone",
						"Alamat",
						"Jabatan"
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
			case 0 : return list.get(rowIndex).getIdEmployee();
			case 1 : return list.get(rowIndex).getEmployeeName();
			case 2 : return list.get(rowIndex).getGender();
			case 3 : {
			String placeOfBirth = list.get(rowIndex).getPlaceOfBirth();
			java.sql.Date dateOfBirth = list.get(rowIndex).getDateOfBirth();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
			String placeAndDateOfBirth = placeOfBirth + ", " + dateFormat.format(dateOfBirth);
			return placeAndDateOfBirth;
			}
			case 4 : return list.get(rowIndex).getPhoneNumber();
			case 5 : return list.get(rowIndex).getAddress();
			case 6 : return list.get(rowIndex).getRole();
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
