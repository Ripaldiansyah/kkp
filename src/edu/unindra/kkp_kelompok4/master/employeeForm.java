
package edu.unindra.kkp_kelompok4.master;

import edu.unindra.kkp_kelompok4.TableModel.tableModelEmployee;
import edu.unindra.kkp_kelompok4.dao.DAO_Employee;
import java.util.List;
import edu.unindra.kkp_kelompok4.Services.serviceEmployee;
import edu.unindra.kkp_kelompok4.home.homeApp;
import edu.unindra.kkp_kelompok4.lock.NumberOnlyFilter;
import edu.unindra.kkp_kelompok4.model.modelEmployee;
import javax.swing.JOptionPane;
import edu.unindra.kkp_kelompok4.login.encryptLogin;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.text.AbstractDocument;


public class employeeForm extends javax.swing.JPanel {
    private modelEmployee employee = new modelEmployee();
    private serviceEmployee service = new DAO_Employee();
    private tableModelEmployee tabelModel = new tableModelEmployee();
    public static boolean checkUser =false;
    public employeeForm() {
        initComponents();
	infoUsername.setVisible(false);
	((AbstractDocument) jtPhoneNumber.getDocument()).setDocumentFilter(new NumberOnlyFilter());

	employeeTable.setModel(tabelModel);
	loadData();
	jtIdEmployee.setEnabled(false);
	jtGmail.setEditable(false);
	infoActive.setVisible(false);
	
	
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                bgGender = new javax.swing.ButtonGroup();
                mainPanel = new javax.swing.JPanel();
                dataPanel = new javax.swing.JPanel();
                titleLabel = new javax.swing.JLabel();
                addButton = new javax.swing.JButton();
                deleteButton = new javax.swing.JButton();
                cancelButtonMain = new javax.swing.JButton();
                jScrollPane1 = new javax.swing.JScrollPane();
                employeeTable = new javax.swing.JTable();
                addPanel = new javax.swing.JPanel();
                titleLabel1 = new javax.swing.JLabel();
                cancelButton = new javax.swing.JButton();
                add_Button = new javax.swing.JButton();
                jScrollPane2 = new javax.swing.JScrollPane();
                jcRole = new javax.swing.JPanel();
                employeeId = new javax.swing.JLabel();
                employeeNamePanel = new javax.swing.JPanel();
                iconName = new javax.swing.JLabel();
                jtNameEmployee = new javax.swing.JTextField();
                jtIdEmployee = new javax.swing.JTextField();
                employeeName2 = new javax.swing.JLabel();
                Gender = new javax.swing.JLabel();
                male = new javax.swing.JRadioButton();
                female = new javax.swing.JRadioButton();
                placeOfBirth = new javax.swing.JLabel();
                dateOfBirth = new javax.swing.JLabel();
                address = new javax.swing.JLabel();
                jScrollPane4 = new javax.swing.JScrollPane();
                tfAddress = new javax.swing.JTextArea();
                email = new javax.swing.JLabel();
                username = new javax.swing.JLabel();
                phoneNumber = new javax.swing.JLabel();
                lRole = new javax.swing.JLabel();
                cbRole = new javax.swing.JComboBox<>();
                dateOfBirthField = new com.toedter.calendar.JDateChooser();
                placeOfBirthPanel = new javax.swing.JPanel();
                iconPob = new javax.swing.JLabel();
                jtPlaceOfBirth = new javax.swing.JTextField();
                emailPanel = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jtEmail = new javax.swing.JTextField();
                jtGmail = new javax.swing.JTextField();
                usernamePanel = new javax.swing.JPanel();
                jLabel3 = new javax.swing.JLabel();
                jtUsername = new javax.swing.JTextField();
                phoneNumberPanel = new javax.swing.JPanel();
                jLabel4 = new javax.swing.JLabel();
                jtPhoneNumber = new javax.swing.JTextField();
                infoUsername = new javax.swing.JLabel();
                checkUsernameLabel = new javax.swing.JLabel();
                infoActive = new javax.swing.JLabel();

                setLayout(new java.awt.CardLayout());

                mainPanel.setLayout(new java.awt.CardLayout());

                dataPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                titleLabel.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
                titleLabel.setText("Data Karyawan");
                dataPanel.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 13, -1, 54));

                addButton.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
                addButton.setText("Tambah");
                addButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                addButtonActionPerformed(evt);
                        }
                });
                dataPanel.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 74, 89, 32));

                deleteButton.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
                deleteButton.setText("Hapus");
                deleteButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                deleteButtonActionPerformed(evt);
                        }
                });
                dataPanel.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 74, 89, 32));

                cancelButtonMain.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
                cancelButtonMain.setText("Batal");
                cancelButtonMain.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                cancelButtonMainActionPerformed(evt);
                        }
                });
                dataPanel.add(cancelButtonMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 74, 89, 32));

                employeeTable.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null}
                        },
                        new String [] {
                                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
                        }
                ) {
                        Class[] types = new Class [] {
                                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types [columnIndex];
                        }
                });
                employeeTable.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                employeeTableMouseClicked(evt);
                        }
                        public void mouseEntered(java.awt.event.MouseEvent evt) {
                                employeeTableMouseEntered(evt);
                        }
                });
                jScrollPane1.setViewportView(employeeTable);

                dataPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 750, -1));

                mainPanel.add(dataPanel, "card2");

                titleLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
                titleLabel1.setText("Tambah Data Karyawan");

                cancelButton.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
                cancelButton.setText("Batal");
                cancelButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                cancelButtonActionPerformed(evt);
                        }
                });

                add_Button.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
                add_Button.setText("Tambah");
                add_Button.setToolTipText("");
                add_Button.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                add_ButtonActionPerformed(evt);
                        }
                });

                jScrollPane2.setBorder(null);

                jcRole.setPreferredSize(new java.awt.Dimension(761, 1000));
                jcRole.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                employeeId.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
                employeeId.setText("ID Karyawan");
                jcRole.add(employeeId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 31));

                employeeNamePanel.setBackground(new java.awt.Color(255, 255, 255));
                employeeNamePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                employeeNamePanel.setLayout(new javax.swing.BoxLayout(employeeNamePanel, javax.swing.BoxLayout.LINE_AXIS));

                iconName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/unindra/kkp_kelompok4/resource/image/Master/icons8_registration_35px_2.png"))); // NOI18N
                iconName.setPreferredSize(new java.awt.Dimension(45, 35));
                employeeNamePanel.add(iconName);

                jtNameEmployee.setBorder(null);
                employeeNamePanel.add(jtNameEmployee);

                jcRole.add(employeeNamePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 230, 40));

                jtIdEmployee.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                jcRole.add(jtIdEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 234, 33));

                employeeName2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
                employeeName2.setText("Nama Karyawan");
                jcRole.add(employeeName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 31));

                Gender.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
                Gender.setText("Jenis Kelamain");
                jcRole.add(Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 31));

                bgGender.add(male);
                male.setText("Laki-Laki");
                jcRole.add(male, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

                bgGender.add(female);
                female.setText("Perempuan");
                jcRole.add(female, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, -1, -1));

                placeOfBirth.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
                placeOfBirth.setText("Tempat Lahir");
                jcRole.add(placeOfBirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, 31));

                dateOfBirth.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
                dateOfBirth.setText("Tanggal Lahir");
                jcRole.add(dateOfBirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, 31));

                address.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
                address.setText("Alamat");
                jcRole.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, 31));

                tfAddress.setColumns(20);
                tfAddress.setRows(5);
                tfAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                jScrollPane4.setViewportView(tfAddress);

                jcRole.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 230, 104));

                email.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
                email.setText("Email");
                jcRole.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, -1, 31));

                username.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
                username.setText("Username");
                jcRole.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, -1, 31));

                phoneNumber.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
                phoneNumber.setText("No HP");
                jcRole.add(phoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, -1, 31));

                lRole.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
                lRole.setText("Role");
                jcRole.add(lRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 390, -1, 31));

                cbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Role -", "OWNER", "CASHIER", "WAREHOUSE", "ADMIN" }));
                cbRole.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                jcRole.add(cbRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, 104, -1));

                dateOfBirthField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                dateOfBirthField.setDateFormatString("dd MMMM yyyy");
                jcRole.add(dateOfBirthField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 231, 40));

                placeOfBirthPanel.setBackground(new java.awt.Color(255, 255, 255));
                placeOfBirthPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                placeOfBirthPanel.setLayout(new javax.swing.BoxLayout(placeOfBirthPanel, javax.swing.BoxLayout.LINE_AXIS));

                iconPob.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/unindra/kkp_kelompok4/resource/image/Master/icons8_office_35px.png"))); // NOI18N
                iconPob.setPreferredSize(new java.awt.Dimension(45, 35));
                placeOfBirthPanel.add(iconPob);

                jtPlaceOfBirth.setBorder(null);
                placeOfBirthPanel.add(jtPlaceOfBirth);

                jcRole.add(placeOfBirthPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 230, 40));

                emailPanel.setBackground(new java.awt.Color(255, 255, 255));
                emailPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                emailPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jLabel1.setBackground(new java.awt.Color(255, 255, 255));
                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/unindra/kkp_kelompok4/resource/image/Master/icons8_at_sign_35px.png"))); // NOI18N
                emailPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 3, -1, -1));

                jtEmail.setHorizontalAlignment(javax.swing.JTextField.LEFT);
                jtEmail.setBorder(null);
                emailPanel.add(jtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 1, 110, 37));

                jtGmail.setForeground(new java.awt.Color(102, 102, 102));
                jtGmail.setText("@gmail.com");
                jtGmail.setBorder(null);
                jtGmail.setPreferredSize(new java.awt.Dimension(2, 16));
                jtGmail.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jtGmailActionPerformed(evt);
                        }
                });
                emailPanel.add(jtGmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 1, 79, 37));

                jcRole.add(emailPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 230, 40));

                usernamePanel.setBackground(new java.awt.Color(255, 255, 255));
                usernamePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                usernamePanel.setLayout(new javax.swing.BoxLayout(usernamePanel, javax.swing.BoxLayout.LINE_AXIS));

                jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/unindra/kkp_kelompok4/resource/image/Master/icons8_male_user_35px.png"))); // NOI18N
                jLabel3.setToolTipText("");
                usernamePanel.add(jLabel3);

                jtUsername.setBorder(null);
                jtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyTyped(java.awt.event.KeyEvent evt) {
                                jtUsernameKeyTyped(evt);
                        }
                });
                usernamePanel.add(jtUsername);

                jcRole.add(usernamePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 230, 40));

                phoneNumberPanel.setBackground(new java.awt.Color(255, 255, 255));
                phoneNumberPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                phoneNumberPanel.setLayout(new javax.swing.BoxLayout(phoneNumberPanel, javax.swing.BoxLayout.LINE_AXIS));

                jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/unindra/kkp_kelompok4/resource/image/Master/icons8_phone_35px.png"))); // NOI18N
                phoneNumberPanel.add(jLabel4);

                jtPhoneNumber.setBorder(null);
                jtPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jtPhoneNumberActionPerformed(evt);
                        }
                });
                phoneNumberPanel.add(jtPhoneNumber);

                jcRole.add(phoneNumberPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, 230, 40));

                infoUsername.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
                infoUsername.setForeground(new java.awt.Color(255, 0, 102));
                infoUsername.setText("username sudah terdaftar");
                jcRole.add(infoUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 230, -1));

                checkUsernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                checkUsernameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/unindra/kkp_kelompok4/resource/image/Master/icons8_Checkmark_25px.png"))); // NOI18N
                checkUsernameLabel.setText("<html>Check <br>Username");
                checkUsernameLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                checkUsernameLabelMouseClicked(evt);
                        }
                });
                jcRole.add(checkUsernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, -1, 40));

                jScrollPane2.setViewportView(jcRole);

                infoActive.setForeground(new java.awt.Color(255, 51, 51));
                infoActive.setText("Check username terlebih dahulu untuk mengaktifkan tombol simpan");

                javax.swing.GroupLayout addPanelLayout = new javax.swing.GroupLayout(addPanel);
                addPanel.setLayout(addPanelLayout);
                addPanelLayout.setHorizontalGroup(
                        addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(addPanelLayout.createSequentialGroup()
                                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(titleLabel1)
                                        .addGroup(addPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
                                                        .addGroup(addPanelLayout.createSequentialGroup()
                                                                .addComponent(add_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap())
                        .addGroup(addPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(infoActive)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                addPanelLayout.setVerticalGroup(
                        addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(addPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titleLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(add_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addComponent(infoActive)
                                .addGap(1, 1, 1)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE))
                );

                mainPanel.add(addPanel, "card2");

                add(mainPanel, "card2");
        }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        mainPanel.removeAll();
	mainPanel.repaint();
	mainPanel.revalidate();
	
        mainPanel.add(addPanel);
	mainPanel.repaint();
	mainPanel.revalidate();
	
	add_Button.setText("Simpan");
	add_Button.setEnabled(false);
	infoActive.setVisible(true);
	jtIdEmployee.setText(service.number());
	
	    if (addButton.getText().equals("Ubah")) {
		    dataTable();
		    jtIdEmployee.setEnabled(false);
		    checkUsernameLabel.setVisible(false);
		    jtUsername.setEnabled(false);
		    infoActive.setVisible(false);
		    add_Button.setEnabled(true);
	    }
    }//GEN-LAST:event_addButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
	    panelDisplay();
	    loadData();
	    resetForm();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void add_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_ButtonActionPerformed
        if (add_Button.getText().equals("Tambah")) {
		    add_Button.setText("Simpan");
		    jtIdEmployee.setText(service.number());
	    }else if(add_Button.getText().equals("Simpan")){
		    saveData();
	    }else if(add_Button.getText().equals("Perbarui")){
		    renewData();
		    
		    
	    }
    }//GEN-LAST:event_add_ButtonActionPerformed

        private void cancelButtonMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonMainActionPerformed
               panelDisplay();
	       loadData();
	       resetForm();
        }//GEN-LAST:event_cancelButtonMainActionPerformed

        private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
               int index = employeeTable.getSelectedRow();
	       
	       if (index!=-1){
		       modelEmployee employee = tabelModel.getData(employeeTable.convertRowIndexToModel(index));
		       if (JOptionPane.showConfirmDialog(null, "Apakah ingin menghapus data ini ?","Konfirmasi hapus data",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION) {
			       service.deleteItem(employee);
			       tabelModel.deleteItem(index);
			       loadData();
			       resetForm();
		       }else{
			       JOptionPane.showMessageDialog(null, "data gagal dihapus");
		       }
	       }
        }//GEN-LAST:event_deleteButtonActionPerformed

        private void employeeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeTableMouseClicked
                if (addButton.getText().equals("Tambah")) {
			addButton.setText("Ubah");
		}
		deleteButton.setVisible(true);
		cancelButtonMain.setVisible(true);
        }//GEN-LAST:event_employeeTableMouseClicked

    private void jtPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtPhoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtPhoneNumberActionPerformed

        private void jtGmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtGmailActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_jtGmailActionPerformed

        private void employeeTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeTableMouseEntered
                // TODO add your handling code here:
        }//GEN-LAST:event_employeeTableMouseEntered

        private void checkUsernameLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkUsernameLabelMouseClicked
                checkUsername();
        }//GEN-LAST:event_checkUsernameLabelMouseClicked

        private void jtUsernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtUsernameKeyTyped
                infoUsername.setVisible(false);
		checkUsernameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/unindra/kkp_kelompok4/resource/image/Master/icons8_Checkmark_25px.png"))); // NOI18N
                checkUsernameLabel.setText("<html>Check <br>Username");
		add_Button.setEnabled(false);
		infoActive.setVisible(true);
        }//GEN-LAST:event_jtUsernameKeyTyped

private void panelDisplay(){
	mainPanel.removeAll();
	mainPanel.add(new employeeForm());
        mainPanel.repaint();
        mainPanel.revalidate();
}



        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JLabel Gender;
        private javax.swing.JButton addButton;
        private javax.swing.JPanel addPanel;
        private javax.swing.JButton add_Button;
        private javax.swing.JLabel address;
        private javax.swing.ButtonGroup bgGender;
        private javax.swing.JButton cancelButton;
        private javax.swing.JButton cancelButtonMain;
        private javax.swing.JComboBox<String> cbRole;
        private javax.swing.JLabel checkUsernameLabel;
        private javax.swing.JPanel dataPanel;
        private javax.swing.JLabel dateOfBirth;
        private com.toedter.calendar.JDateChooser dateOfBirthField;
        private javax.swing.JButton deleteButton;
        private javax.swing.JLabel email;
        private javax.swing.JPanel emailPanel;
        private javax.swing.JLabel employeeId;
        private javax.swing.JLabel employeeName2;
        private javax.swing.JPanel employeeNamePanel;
        private javax.swing.JTable employeeTable;
        private javax.swing.JRadioButton female;
        private javax.swing.JLabel iconName;
        private javax.swing.JLabel iconPob;
        private javax.swing.JLabel infoActive;
        private javax.swing.JLabel infoUsername;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JScrollPane jScrollPane4;
        private javax.swing.JPanel jcRole;
        private javax.swing.JTextField jtEmail;
        private javax.swing.JTextField jtGmail;
        private javax.swing.JTextField jtIdEmployee;
        private javax.swing.JTextField jtNameEmployee;
        private javax.swing.JTextField jtPhoneNumber;
        private javax.swing.JTextField jtPlaceOfBirth;
        private javax.swing.JTextField jtUsername;
        private javax.swing.JLabel lRole;
        private javax.swing.JPanel mainPanel;
        private javax.swing.JRadioButton male;
        private javax.swing.JLabel phoneNumber;
        private javax.swing.JPanel phoneNumberPanel;
        private javax.swing.JLabel placeOfBirth;
        private javax.swing.JPanel placeOfBirthPanel;
        private javax.swing.JTextArea tfAddress;
        private javax.swing.JLabel titleLabel;
        private javax.swing.JLabel titleLabel1;
        private javax.swing.JLabel username;
        private javax.swing.JPanel usernamePanel;
        // End of variables declaration//GEN-END:variables

	
	private void loadData(){
	deleteButton.setVisible(false);
	cancelButtonMain.setVisible(false);
	List<modelEmployee> list =service.getData();
	tabelModel.setData(list);
}
	
	private void saveData(){
		
		if (validasiInput()==true){
			String idEmployee = jtIdEmployee.getText();
			String nameEmployee = jtNameEmployee.getText();
			String gender = "";
                        if (male.isSelected()) {
                                gender = male.getText();
                            } else if (female.isSelected()) {
                                gender = female.getText();
                            }
			String placeOfBirth = jtPlaceOfBirth.getText();
                        java.util.Date dob = dateOfBirthField.getDate();
			java.sql.Date dateOfBirthConvert = new java.sql.Date(dob.getTime());
                        String address = tfAddress.getText();
                        String email = jtEmail.getText()+jtGmail.getText();
                        String username = jtUsername.getText();
                        String password =encryptLogin.getMD5("admin");
			String pin =encryptLogin.getMD5("12345");
                        String phoneNumber = jtPhoneNumber.getText();
                        String role = (String) cbRole.getSelectedItem();
                        
			modelEmployee employee = new modelEmployee();
			
			employee.setIdEmployee(idEmployee);
			employee.setEmployeeName(nameEmployee);
			employee.setGender(gender);
			employee.setPlaceOfBirth(placeOfBirth);
			employee.setDateOfBirth(dateOfBirthConvert);
			employee.setAddress(address);
			employee.setEmail(email);
			employee.setUsername(username);
                        employee.setPassword_Hash(password);
			employee.setPin(pin);
                        employee.setPhoneNumber(phoneNumber);
                        employee.setRole(role);
                        
			
			service.addItem(employee);
			tabelModel.addItem(employee);
			loadData();
			resetForm();
			panelDisplay();
			add_Button.setText("Tambah");
			
		
		}
	}
	
	private boolean validasiInput(){
		boolean input=false;
                String gender = "";
                        if (male.isSelected()) {
                                gender = male.getText();
                            } else if (female.isSelected()) {
                                gender = female.getText();
                            }
		if (jtNameEmployee.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nama Karyawan tidak boleh kosong");
		}else 
                    if (gender.equals("")){
			JOptionPane.showMessageDialog(null, "Pilih salah satu jenis kelamin");
		}else if (placeOfBirth.getText().trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "Tempat lahir tidak boleh kosong");
		}else if (dateOfBirthField.getDate() == null) {
			 JOptionPane.showMessageDialog(null, "Tanggal lahir tidak boleh kosong");
		}else if (tfAddress.getText().equals(null)){
			JOptionPane.showMessageDialog(null, "alamat tidak boleh kosong");
		}else if (jtEmail.getText().trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "email tidak boleh kosong");
		}else if (jtUsername.getText().trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "username tidak boleh kosong");
		}else if (jtPhoneNumber.getText().trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "no hp tidak boleh kosong");
		}else if (cbRole.getSelectedIndex() == 0){
			JOptionPane.showMessageDialog(null, "Pilih role terlebih dahulu");
		}else{
			input=true;
		}
		return input;
	}
	
	private void renewData(){
		int index = employeeTable.getSelectedRow();
		if (index!=-1){
			modelEmployee employee = tabelModel.getData(employeeTable.convertRowIndexToModel(index));
			
			if (validasiInput()==true){
				String idEmployee = jtIdEmployee.getText();
			String nameEmployee = jtNameEmployee.getText();
			String gender = "";
                        if (male.isSelected()) {
                                gender = male.getText();
                            } else if (female.isSelected()) {
                                gender = female.getText();
                            }
			String placeOfBirth = jtPlaceOfBirth.getText();
                        java.util.Date dob = dateOfBirthField.getDate();
			java.sql.Date dateOfBirthConvert = new java.sql.Date(dob.getTime());
                        String address = tfAddress.getText();
                        String email = jtEmail.getText()+jtGmail.getText();
                        String username = jtUsername.getText();
			String hashedPassword = encryptLogin.getMD5("admin");
			String pin = encryptLogin.getMD5("12345");
                        String phoneNumber = jtPhoneNumber.getText();
                        String role = (String) cbRole.getSelectedItem();
                        
			
			
			employee.setIdEmployee(idEmployee);
			employee.setEmployeeName(nameEmployee);
			employee.setGender(gender);
			employee.setPlaceOfBirth(placeOfBirth);
			employee.setDateOfBirth(dateOfBirthConvert);
			employee.setAddress(address);
			employee.setEmail(email);
			employee.setUsername(username);
			employee.setPin(pin);
                        employee.setPassword_Hash(hashedPassword);
                        employee.setPhoneNumber(phoneNumber);
                        employee.setRole(role);
			
                        
			
			service.renewItem(employee);
			tabelModel.renewItem(index,employee);
			loadData();
			resetForm();
			panelDisplay();

//			homeApp menu = new homeApp(idEmployee, nameEmployee, role, employee.getPictures());
//			menu.setVisible(true);

			    }
	}
	}
	
	private void resetForm(){
		addButton.requestFocus();
		addButton.setText("Tambah");
		jtNameEmployee.setText("");
		bgGender.clearSelection();
		jtPlaceOfBirth.setText("");
		dateOfBirthField.setDate(null);
		tfAddress.setText("");
		jtEmail.setText("");
		jtUsername.setText("");
		jtPhoneNumber.setText("");
		cbRole.setSelectedIndex(0);
	}

	private void dataTable(){
		dataPanel.setVisible(false);
		addPanel.setVisible(true);
		
		int row = employeeTable.getSelectedRow();
		titleLabel1.setText("Perbarui Data Karyawan");
		String idEmployee = (String) employeeTable.getValueAt(row, 1);
		
		modelEmployee employee = service.getById(idEmployee); 
		if (employee != null) {
		jtIdEmployee.setText(employee.getIdEmployee());
		jtNameEmployee.setText(employee.getEmployeeName());
		
		String gender = employee.getGender();
		if (gender.equals("Laki-Laki")) {
		    male.setSelected(true);
		} else if (gender.equals("Perempuan")) {
		    female.setSelected(true);
		}
		jtPlaceOfBirth.setText(employee.getPlaceOfBirth());
		dateOfBirthField.setDate(employee.getDateOfBirth());
		tfAddress.setText(employee.getAddress());
		String email = employee.getEmail();
		if (email.length() > 10) {
		    email = email.substring(0, email.length() - 10);
		}
		jtEmail.setText(email);

		jtUsername.setText(employee.getUsername());
		jtPhoneNumber.setText(employee.getPhoneNumber());
		cbRole.setSelectedItem(employee.getRole());
	    } else {
		JOptionPane.showMessageDialog(null, "Data Karyawan tidak ditemukan");
	    }
		
		add_Button.setText("Perbarui");
		cancelButtonMain.setVisible(true);
	}
	private void checkUsername() {
	modelEmployee employee = new modelEmployee();
	String username = jtUsername.getText();

	employee.setUsername(username);
	service.checkUsername(employee);

	if (employeeForm.checkUser) {
	    if (username.equals("")) {
			infoUsername.setText("Username tidak boleh kosong");
			 checkUsernameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/unindra/kkp_kelompok4/resource/image/Master/icons8_cancel_25px.png"))); // NOI18N
	    checkUsernameLabel.setText("<html>Username<br>tidak valid");
	    add_Button.setEnabled(false);
	    infoUsername.setVisible(true);
		}else{
		     checkUsernameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/unindra/kkp_kelompok4/resource/image/Master/icons8_Checkmark_25px_2.png"))); // NOI18N
	    checkUsernameLabel.setText("<html>Username<br>dapat digunakan");
	    add_Button.setEnabled(true);
	    infoActive.setVisible(false);
	    }
	   
	} else {
	    checkUsernameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/unindra/kkp_kelompok4/resource/image/Master/icons8_cancel_25px.png"))); // NOI18N
	    checkUsernameLabel.setText("<html>Username<br>sudah digunakan");
	    infoUsername.setText("Username sudah digunakan");
	    add_Button.setEnabled(false);
	    infoUsername.setVisible(true);
	}
	
}









}



