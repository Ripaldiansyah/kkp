/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unindra.kkp_kelompok4.TableModel;

import edu.unindra.kkp_kelompok4.model.modelDistributor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author fadli
 */
public class tableModelDistributor extends AbstractTableModel {
    
    private List<modelDistributor>list = new ArrayList<>();
    public void addData(modelDistributor modis){
        list.add(modis);
        fireTableRowsInserted(list.size()-1 , list.size() -1);
        JOptionPane.showMessageDialog(null,"Data berhasil Ditambahkan");
    }
    public void renewItem(int row,modelDistributor modis){
         list.add(modis);
        fireTableDataChanged();
        JOptionPane.showMessageDialog(null,"Data berhasil Diperbaruhi");
    }
    public void deleteData(int index){
         list.remove(index);
        fireTableRowsDeleted(index,index);
        JOptionPane.showMessageDialog(null,"Data berhasil Dihapus");
    }
    public void clear(){
        list.clear();
        fireTableDataChanged();
    }
    public void setData(List<modelDistributor> list){
		clear();
		this.list.addAll(list);
		fireTableDataChanged();
	}
    public void setData(int index,modelDistributor modis){
        list.set(index,modis);
        fireTableRowsUpdated(index,index);
    }
    public modelDistributor getData(int index){
        return list.get(index);
    }
    
    
    @Override
  public int getRowCount() {
    return list.size();
}

private String[] columnNames = {
				"No",
				"ID DISTRIBUTOR",
				"NAMA DISTRIBUTOR",
				"NOMOR TELEPHONE",
				"ALAMAT"
			       };

@Override
public int getColumnCount() {
    return columnNames.length;    
}

@Override
public Object getValueAt(int rowIndex, int columnIndex) {
    if (columnIndex == 0) {
        return " " + (rowIndex+1);
    } else {
        switch(columnIndex - 1) {
            case 0: return list.get(rowIndex).getDistributorId();
            case 1: return list.get(rowIndex).getDistributorName();
            case 2: return list.get(rowIndex).getDistributorTlp();
            case 3: return list.get(rowIndex).getDistributorAddress();
            default: return null;
        }
    }
}

public String getColumnName(int column) {
    return columnNames[column];
}


 
}
