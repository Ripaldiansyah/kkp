/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.TableModel;

import edu.unindra.kkp_kelompok4.model.modelDetailCheckin;
import edu.unindra.kkp_kelompok4.model.modelEmployee;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ripal
 */
public class tableModelDetailCheckin extends AbstractTableModel{

	private List<modelDetailCheckin> list =new ArrayList<>();
	
	public void addItem(modelDetailCheckin detailCheckin){
		list.add(detailCheckin);
		fireTableRowsInserted(list.size() -1, list.size()-1);
		JOptionPane.showMessageDialog(null, "Data barang berhasil ditambahkan");
	}
	
	public void renewItem(int row, modelDetailCheckin detailCheckin){
		list.add(row,detailCheckin);
		fireTableDataChanged();
		JOptionPane.showMessageDialog(null, "Data barang berhasil diperbarui");
	}
	
	public void deleteItem(int index,modelDetailCheckin detailCheckin){
		list.add(index,detailCheckin);
		fireTableRowsDeleted(index, index);
		JOptionPane.showMessageDialog(null, "Data barang berhasil dihapus");
	}
	
	public void clear(){
		list.clear();
		fireTableDataChanged();
	}
	
	public void setData(List<modelDetailCheckin> list){
		clear();
		this.list.addAll(list);
		fireTableDataChanged();
	}
	
	public void setData(int index,modelDetailCheckin detailCheckin){
		list.set(index, detailCheckin);
		fireTableRowsUpdated(index, index);
	}
	
	public modelDetailCheckin getData (int index){
		return list.get(index);
	}
	
	@Override
	public int getRowCount() {
		return list.size();
	}
	private final String[] columnNames = {"No","No Pemesanan","Kode Barang","Nama Barang","Harga","Jumlah Pesanan","Sub Total","Nama Distributor","Keterangan","Penerima","Tanngal terima"};
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	if (columnIndex == 0) {
        return " " + (rowIndex + 1);
	}else{
	switch (columnIndex - 1) {
            case 0:
                return list.get(rowIndex).getItemCheckin().getNoCheckin();
            case 1:
                return list.get(rowIndex).getItems().getItemCode();
            case 2:
                return list.get(rowIndex).getItems().getItemName();
            case 3:
                return list.get(rowIndex).getItems().getPrice();
            case 4:
                return list.get(rowIndex).getTotalItem();
            case 5:
                return list.get(rowIndex).getSubTotalItem();
            case 6:
                return list.get(rowIndex).getDistributor().getDistributorName();
            case 7:
                return list.get(rowIndex).getStatus();
            case 8:
                modelEmployee employee = list.get(rowIndex).getEmployee();
                return employee != null ? employee.getEmployeeName() : "Belum diterima";
            case 9:
                return list.get(rowIndex).getDateReceived();

            default:
                return null;
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
