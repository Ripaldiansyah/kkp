/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.TableModel;

import edu.unindra.kkp_kelompok4.model.modelDetailCheckin;
import edu.unindra.kkp_kelompok4.model.modelDetailIncomingItems;
import edu.unindra.kkp_kelompok4.model.modelEmployee;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ripal
 */
public class tableModelDetailIncomingItems extends AbstractTableModel{

	private List<modelDetailIncomingItems> list =new ArrayList<>();
	
	public void addItem(modelDetailIncomingItems detailIncomingItems){
		list.add(detailIncomingItems);
		fireTableRowsInserted(list.size() -1, list.size()-1);
		JOptionPane.showMessageDialog(null, "Data barang berhasil ditambahkan");
	}
	
	public void renewItem(int row, modelDetailIncomingItems detailIncomingItems){
		list.add(row,detailIncomingItems);
		fireTableDataChanged();
		JOptionPane.showMessageDialog(null, "Data barang berhasil diperbarui");
	}
	
	public void deleteItem(int index,modelDetailIncomingItems detailIncomingItems){
		list.add(index,detailIncomingItems);
		fireTableRowsDeleted(index, index);
		JOptionPane.showMessageDialog(null, "Data barang berhasil dihapus");
	}
	
	public void clear(){
		list.clear();
		fireTableDataChanged();
	}
	
	public void setData(List<modelDetailIncomingItems> list){
		clear();
		this.list.addAll(list);
		fireTableDataChanged();
	}
	
	public void setData(int index,modelDetailIncomingItems detailCheckin){
		list.set(index, detailCheckin);
		fireTableRowsUpdated(index, index);
	}
	
	public modelDetailIncomingItems getData (int index){
		return list.get(index);
	}
	
	@Override
	public int getRowCount() {
		return list.size();
	}
	private final String[] columnNames = {"No","No Pemesanan","Kode Barang","Nama Barang","Harga","Jumlah Pesanan","Sub Total","Nama Distributor","Keterangan","Penerima","Tanggal Terima"};
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	if (columnIndex == 0) {
	    return " " + (rowIndex + 1);
	} else {
        switch (columnIndex - 1) {
            case 0:
                return list.get(rowIndex).getIncomingItems().getNoCheckin();
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
