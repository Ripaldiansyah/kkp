package edu.unindra.kkp_kelompok4.report;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

import edu.unindra.kkp_kelompok4.Services.serviceEmployee;
import edu.unindra.kkp_kelompok4.Services.serviceReport;
import edu.unindra.kkp_kelompok4.dao.DAO_Employee;
import edu.unindra.kkp_kelompok4.dao.DAO_Report;
import edu.unindra.kkp_kelompok4.model.modelEmployee;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ripal
 */
public class reportOrderWareHouse extends javax.swing.JPanel {
	private serviceEmployee servEmployee = new DAO_Employee();
	private serviceReport reportService = new DAO_Report();
    public reportOrderWareHouse() {
	    initComponents();
	    printButton.setVisible(false);
	    cancelButtonMain.setVisible(false);
	    filterPanel.setVisible(false);
	    hideFilterItem();
	
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                mainPanel = new javax.swing.JPanel();
                dataPanel = new javax.swing.JPanel();
                titleLabel2 = new javax.swing.JLabel();
                panelReport = new javax.swing.JPanel();
                printButton = new javax.swing.JButton();
                cancelButtonMain = new javax.swing.JButton();
                filterPanel = new javax.swing.JPanel();
                panelFilterItem = new javax.swing.JPanel();
                listFilter = new javax.swing.JComboBox<>();
                titleLabel3 = new javax.swing.JLabel();
                filter = new javax.swing.JPanel();
                dummyPanel = new javax.swing.JPanel();
                periodePanel = new javax.swing.JPanel();
                dateOrder1 = new com.toedter.calendar.JDateChooser();
                jLabel5 = new javax.swing.JLabel();
                dateOrder2 = new com.toedter.calendar.JDateChooser();
                jLabel6 = new javax.swing.JLabel();
                statusPanel = new javax.swing.JPanel();
                statusList = new javax.swing.JComboBox<>();
                staffPanel = new javax.swing.JPanel();
                jLabel4 = new javax.swing.JLabel();
                listNameCashier = new javax.swing.JComboBox<>();
                totalOrderPanel = new javax.swing.JPanel();
                totalShoping1 = new javax.swing.JTextField();
                jLabel1 = new javax.swing.JLabel();
                totalShoping2 = new javax.swing.JTextField();
                jLabel2 = new javax.swing.JLabel();
                panelViewReport = new javax.swing.JPanel();

                setLayout(new java.awt.CardLayout());

                mainPanel.setLayout(new java.awt.CardLayout());

                dataPanel.setBackground(new java.awt.Color(255, 255, 255));
                dataPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                titleLabel2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
                titleLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                titleLabel2.setText("Laporan Pembelian Barang");
                dataPanel.add(titleLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 660, 54));

                printButton.setBackground(new java.awt.Color(102, 102, 255));
                printButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
                printButton.setForeground(new java.awt.Color(255, 255, 255));
                printButton.setText("Print");
                printButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                printButtonActionPerformed(evt);
                        }
                });

                cancelButtonMain.setBackground(new java.awt.Color(255, 0, 0));
                cancelButtonMain.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
                cancelButtonMain.setForeground(new java.awt.Color(255, 255, 255));
                cancelButtonMain.setText("Batal");
                cancelButtonMain.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                cancelButtonMainActionPerformed(evt);
                        }
                });

                filterPanel.setLayout(new java.awt.CardLayout());

                listFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Filter laporan -", "Tampilkan semua", "Periode", "Status Pembelian", "Nama Staff Gudang", "Total Pembelian" }));
                listFilter.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                listFilterActionPerformed(evt);
                        }
                });

                titleLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
                titleLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                titleLabel3.setText("Filter Pembelian");

                filter.setLayout(new java.awt.CardLayout());

                javax.swing.GroupLayout dummyPanelLayout = new javax.swing.GroupLayout(dummyPanel);
                dummyPanel.setLayout(dummyPanelLayout);
                dummyPanelLayout.setHorizontalGroup(
                        dummyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 218, Short.MAX_VALUE)
                );
                dummyPanelLayout.setVerticalGroup(
                        dummyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 382, Short.MAX_VALUE)
                );

                filter.add(dummyPanel, "card2");

                dateOrder1.setDateFormatString("dd MMMM yyyy");

                jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
                jLabel5.setText("Dari tanggal");

                dateOrder2.setDateFormatString("dd MMMM yyyy");

                jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
                jLabel6.setText("Sampai tanggal");

                javax.swing.GroupLayout periodePanelLayout = new javax.swing.GroupLayout(periodePanel);
                periodePanel.setLayout(periodePanelLayout);
                periodePanelLayout.setHorizontalGroup(
                        periodePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(periodePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(periodePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dateOrder2, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                        .addComponent(dateOrder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(periodePanelLayout.createSequentialGroup()
                                                .addGroup(periodePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel5))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                );
                periodePanelLayout.setVerticalGroup(
                        periodePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(periodePanelLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateOrder1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateOrder2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(197, Short.MAX_VALUE))
                );

                filter.add(periodePanel, "card2");

                statusList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Status Pembelian -", "Barang telah diterima", "Barang dalam pemesanan", "Barang terkirim sebagian", "Surat Jalan Belum dicetak" }));

                javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
                statusPanel.setLayout(statusPanelLayout);
                statusPanelLayout.setHorizontalGroup(
                        statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(statusPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(statusList, 0, 194, Short.MAX_VALUE)
                                .addContainerGap())
                );
                statusPanelLayout.setVerticalGroup(
                        statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(statusPanelLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(statusList, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(311, Short.MAX_VALUE))
                );

                filter.add(statusPanel, "card2");

                jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
                jLabel4.setText("Nama Kasir");

                listNameCashier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Nama Staff Gudang -" }));

                javax.swing.GroupLayout staffPanelLayout = new javax.swing.GroupLayout(staffPanel);
                staffPanel.setLayout(staffPanelLayout);
                staffPanelLayout.setHorizontalGroup(
                        staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(staffPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(listNameCashier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(staffPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(0, 128, Short.MAX_VALUE)))
                                .addContainerGap())
                );
                staffPanelLayout.setVerticalGroup(
                        staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(staffPanelLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(listNameCashier, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(304, Short.MAX_VALUE))
                );

                filter.add(staffPanel, "card2");

                totalShoping1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

                jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
                jLabel1.setText("Rentang Belanja");

                totalShoping2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

                jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
                jLabel2.setText("Sampai dengan");

                javax.swing.GroupLayout totalOrderPanelLayout = new javax.swing.GroupLayout(totalOrderPanel);
                totalOrderPanel.setLayout(totalOrderPanelLayout);
                totalOrderPanelLayout.setHorizontalGroup(
                        totalOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(totalOrderPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(totalOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(totalShoping1)
                                        .addComponent(totalShoping2)
                                        .addGroup(totalOrderPanelLayout.createSequentialGroup()
                                                .addGroup(totalOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2))
                                                .addGap(0, 99, Short.MAX_VALUE)))
                                .addContainerGap())
                );
                totalOrderPanelLayout.setVerticalGroup(
                        totalOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(totalOrderPanelLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalShoping1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalShoping2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(223, Short.MAX_VALUE))
                );

                filter.add(totalOrderPanel, "card2");

                javax.swing.GroupLayout panelFilterItemLayout = new javax.swing.GroupLayout(panelFilterItem);
                panelFilterItem.setLayout(panelFilterItemLayout);
                panelFilterItemLayout.setHorizontalGroup(
                        panelFilterItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFilterItemLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelFilterItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(listFilter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFilterItemLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(titleLabel3)
                                                .addGap(25, 25, 25)))
                                .addContainerGap())
                        .addComponent(filter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                panelFilterItemLayout.setVerticalGroup(
                        panelFilterItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelFilterItemLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titleLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(listFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(25, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout panelReportLayout = new javax.swing.GroupLayout(panelReport);
                panelReport.setLayout(panelReportLayout);
                panelReportLayout.setHorizontalGroup(
                        panelReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelReportLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(filterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelReportLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(panelReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(panelFilterItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cancelButtonMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(printButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
                );
                panelReportLayout.setVerticalGroup(
                        panelReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelReportLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(panelFilterItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 7, Short.MAX_VALUE)
                                .addGap(46, 46, 46)
                                .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelButtonMain, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))
                );

                dataPanel.add(panelReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 240, 770));

                panelViewReport.setBackground(new java.awt.Color(255, 255, 255));

                javax.swing.GroupLayout panelViewReportLayout = new javax.swing.GroupLayout(panelViewReport);
                panelViewReport.setLayout(panelViewReportLayout);
                panelViewReportLayout.setHorizontalGroup(
                        panelViewReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 530, Short.MAX_VALUE)
                );
                panelViewReportLayout.setVerticalGroup(
                        panelViewReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 740, Short.MAX_VALUE)
                );

                dataPanel.add(panelViewReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 530, 740));

                mainPanel.add(dataPanel, "card2");

                add(mainPanel, "card2");
        }// </editor-fold>//GEN-END:initComponents

        private void cancelButtonMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonMainActionPerformed
               panelDisplay();
        }//GEN-LAST:event_cancelButtonMainActionPerformed

        private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
		buttonReportItem();
		
        }//GEN-LAST:event_printButtonActionPerformed

        private void selectItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectItemActionPerformed

		
        }//GEN-LAST:event_selectItemActionPerformed

    private void priceItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceItemActionPerformed

        private void listFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listFilterActionPerformed
                reportItem();
        }//GEN-LAST:event_listFilterActionPerformed

 private void panelDisplay(){
	
	mainPanel.removeAll();
	mainPanel.add(new reportOrderWareHouse());
        mainPanel.repaint();
        mainPanel.revalidate();
}



        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton cancelButtonMain;
        private javax.swing.JPanel dataPanel;
        private com.toedter.calendar.JDateChooser dateOrder1;
        private com.toedter.calendar.JDateChooser dateOrder2;
        private javax.swing.JPanel dummyPanel;
        private javax.swing.JPanel filter;
        private javax.swing.JPanel filterPanel;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JComboBox<String> listFilter;
        private javax.swing.JComboBox<String> listNameCashier;
        private javax.swing.JPanel mainPanel;
        private javax.swing.JPanel panelFilterItem;
        private javax.swing.JPanel panelReport;
        private javax.swing.JPanel panelViewReport;
        private javax.swing.JPanel periodePanel;
        private javax.swing.JButton printButton;
        private javax.swing.JPanel staffPanel;
        private javax.swing.JComboBox<String> statusList;
        private javax.swing.JPanel statusPanel;
        private javax.swing.JLabel titleLabel2;
        private javax.swing.JLabel titleLabel3;
        private javax.swing.JPanel totalOrderPanel;
        private javax.swing.JTextField totalShoping1;
        private javax.swing.JTextField totalShoping2;
        // End of variables declaration//GEN-END:variables

	
	
	
	
	private void printReportAll(){
		panelViewReport.removeAll();
		reportService.reportOrder(panelViewReport);
	}
	
	private void printReportPeriode(){
		panelViewReport.removeAll();
		String date = "dd MMMM yyyy";
		SimpleDateFormat formatDate = new SimpleDateFormat(date);
		String dateOrder1 = String.valueOf(formatDate.format(this.dateOrder1.getDate()));
		String dateOrder2 = String.valueOf(formatDate.format(this.dateOrder2.getDate()));
		reportService.reportOrderByPeriode(dateOrder1, dateOrder2, panelViewReport);
	}
	private void printReportStatus(){
		panelViewReport.removeAll();
		String status = statusList.getSelectedItem().toString();
		reportService.reportOrderFilterStatus(status,panelViewReport);
	}
	
	private void printReportEmployee(){
		panelViewReport.removeAll();
		String employee = listNameCashier.getSelectedItem().toString();
		reportService.reportOrderFilterEmployee(employee,panelViewReport);
	}
	
	private void printReportTotal(){
		panelViewReport.removeAll();
		int totalShoping1 = Integer.parseInt(this.totalShoping1.getText()) ;
		int totalShoping2 = Integer.parseInt(this.totalShoping2.getText()) ;
		reportService.reportOrderFilterTotal(totalShoping1,totalShoping2,panelViewReport);
	}
	
	
	private void reportItem(){
		filterPanel.setVisible(true);
		if (listFilter.getSelectedIndex()==0) {
			hideFilterItem();
			disableButton();
		}else if (listFilter.getSelectedIndex()==1) {
			hideFilterItem();
			enableButton();
		}else if (listFilter.getSelectedIndex()==2) {
			hideFilterItem();
			enableButton();
			periodePanel.setVisible(true);
		}else if (listFilter.getSelectedIndex()==3) {
			hideFilterItem();
			enableButton();
			statusPanel.setVisible(true);
		}else if (listFilter.getSelectedIndex()==4) { 
			hideFilterItem();
			enableButton();
			dataEmployee();
			staffPanel.setVisible(true);
		}else if (listFilter.getSelectedIndex()==5) {
			hideFilterItem();
			enableButton();
			totalOrderPanel.setVisible(true);
		}
	}
	
	private void buttonReportItem(){
		if (listFilter.getSelectedIndex()==1) {
			printReportAll();
		}else if (listFilter.getSelectedIndex()==2) {
			printReportPeriode();
		}else if (listFilter.getSelectedIndex()==3) {
			printReportStatus();
		}else if (listFilter.getSelectedIndex()==4) {
			printReportEmployee();
		}else if (listFilter.getSelectedIndex()==5) {
			String priceValid1=totalShoping1.getText();
			String priceValid2=totalShoping2.getText();
			if (priceValid1.equals("") | (priceValid2.equals(""))) {
				JOptionPane.showMessageDialog(null, "Masukan rentang stock");
			}else {
				printReportTotal();
	}
		}
		
		
	}
	
	private void hideFilterItem(){
		dummyPanel.setVisible(false);
		statusPanel.setVisible(false);
		periodePanel.setVisible(false);
		staffPanel.setVisible(false);
		totalOrderPanel.setVisible(false);
	}
	
	private void disableButton(){
		printButton.setVisible(false);
		cancelButtonMain.setVisible(false);
	}
	
	private void enableButton(){
		printButton.setVisible(true);
		cancelButtonMain.setVisible(true);
	}
	
	private void dataEmployee(){
		List<modelEmployee> employeeList = servEmployee.getEmployeesWarehouse();
		for (modelEmployee employee : employeeList) {
		listNameCashier.removeItem(employee.getEmployeeName());
		listNameCashier.addItem( employee.getEmployeeName());
		
	}
}
	
}



