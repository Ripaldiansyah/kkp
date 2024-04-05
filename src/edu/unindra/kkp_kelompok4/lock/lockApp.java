package edu.unindra.kkp_kelompok4.lock;

import edu.unindra.kkp_kelompok4.Services.serviceEmployee;
import edu.unindra.kkp_kelompok4.dao.DAO_Employee;
import edu.unindra.kkp_kelompok4.login.encryptLogin;
import edu.unindra.kkp_kelompok4.model.modelEmployee;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import edu.unindra.kkp_kelompok4.home.homeApp;

public class lockApp extends javax.swing.JDialog {

    private modelEmployee lockApp = new modelEmployee();
    private serviceEmployee pinLockApp = new DAO_Employee();
    
    public lockApp(java.awt.Frame parent, boolean modal,String idEmployee) {
        super(parent, modal); 
	lockApp.setIdEmployee(idEmployee);
        initComponents();
	((AbstractDocument) pinLock.getDocument()).setDocumentFilter(new NumberOnlyFilter());
	btEnter.requestFocus();
	hidePassword.setVisible(false);
	showPassword.setVisible(false);
	pinLock.setEchoChar((char)0);
	((AbstractDocument) pinLock.getDocument()).setDocumentFilter(null);
	
    }
    @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                lockPanel = new javax.swing.JPanel();
                inputPasswordLabel = new javax.swing.JLabel();
                labelMinimarket = new javax.swing.JLabel();
                labelIcon = new javax.swing.JLabel();
                btEnter = new javax.swing.JButton();
                picPanel = new javax.swing.JPanel();
                showPassword = new javax.swing.JLabel();
                hidePassword = new javax.swing.JLabel();
                pinLock = new javax.swing.JPasswordField();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setUndecorated(true);

                lockPanel.setBackground(new java.awt.Color(0, 0, 255));
                lockPanel.setPreferredSize(new java.awt.Dimension(1000, 534));
                lockPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                inputPasswordLabel.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
                inputPasswordLabel.setForeground(new java.awt.Color(255, 255, 255));
                inputPasswordLabel.setText("Masukan PIN");
                lockPanel.add(inputPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, -1, -1));

                labelMinimarket.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
                labelMinimarket.setForeground(new java.awt.Color(255, 255, 255));
                labelMinimarket.setText("MINIMARKET XYZ");
                lockPanel.add(labelMinimarket, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 406, -1));

                labelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/unindra/kkp_kelompok4/resource/image/HomeApp/Shopping.png"))); // NOI18N
                lockPanel.add(labelIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 92, -1));

                btEnter.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
                btEnter.setForeground(new java.awt.Color(0, 0, 255));
                btEnter.setText("Masuk");
                btEnter.setActionCommand("");
                btEnter.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btEnterActionPerformed(evt);
                        }
                });
                lockPanel.add(btEnter, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, -1, 43));

                picPanel.setBackground(new java.awt.Color(0, 0, 255));
                picPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
                picPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                showPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/unindra/kkp_kelompok4/resource/image/Login/showPassword.png"))); // NOI18N
                showPassword.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                showPasswordMouseClicked(evt);
                        }
                });
                picPanel.add(showPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 30, 50));

                hidePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/unindra/kkp_kelompok4/resource/image/Login/hidePassword.png"))); // NOI18N
                hidePassword.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                hidePasswordMouseClicked(evt);
                        }
                });
                picPanel.add(hidePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 30, 50));

                pinLock.setBackground(new java.awt.Color(0, 0, 255));
                pinLock.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
                pinLock.setForeground(java.awt.Color.gray);
                pinLock.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                pinLock.setText("Plase input number only !");
                pinLock.setToolTipText("");
                pinLock.setBorder(null);
                pinLock.setPreferredSize(new java.awt.Dimension(129, 16));
                pinLock.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusGained(java.awt.event.FocusEvent evt) {
                                pinLockFocusGained(evt);
                        }
                        public void focusLost(java.awt.event.FocusEvent evt) {
                                pinLockFocusLost(evt);
                        }
                });
                pinLock.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                pinLockMouseClicked(evt);
                        }
                });
                pinLock.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyTyped(java.awt.event.KeyEvent evt) {
                                pinLockKeyTyped(evt);
                        }
                });
                picPanel.add(pinLock, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1, 260, 47));

                lockPanel.add(picPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, 300, 50));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lockPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lockPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                );

                pack();
                setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

    private void btEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnterActionPerformed
       getPin();
    }//GEN-LAST:event_btEnterActionPerformed

        private void pinLockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pinLockMouseClicked
		
        }//GEN-LAST:event_pinLockMouseClicked

        private void showPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showPasswordMouseClicked
                showPassword.setVisible(false);
                hidePassword.setVisible(true);
                pinLock.setEchoChar('*');
        }//GEN-LAST:event_showPasswordMouseClicked

        private void hidePasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hidePasswordMouseClicked
                hidePassword.setVisible(false);
                showPassword.setVisible(true);
                pinLock.setEchoChar((char)0);
        }//GEN-LAST:event_hidePasswordMouseClicked

        private void pinLockFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pinLockFocusGained
		String pin = pinLock.getText();
		if (pin.equals("Plase input number only !")){
			pinLock.setText("");
			pinLock.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
                        pinLock.setForeground(java.awt.Color.white);
			 ((AbstractDocument) pinLock.getDocument()).setDocumentFilter(new NumberOnlyFilter());
		}
        }//GEN-LAST:event_pinLockFocusGained

        private void pinLockFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pinLockFocusLost
		((AbstractDocument) pinLock.getDocument()).setDocumentFilter(null);
		String pin = pinLock.getText();
		if (pin.equals("")){
			pinLock.setText("Plase input number only !");
			pinLock.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
                        pinLock.setForeground(java.awt.Color.gray);
			pinLock.setEchoChar((char)0);
			hidePassword.setVisible(false);
			showPassword.setVisible(false);
		}
	 
        }//GEN-LAST:event_pinLockFocusLost

        private void pinLockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pinLockKeyTyped
	       hidePassword.setVisible(true);
	       pinLock.setEchoChar('*');
	       
	       if (showPassword.isVisible()) {
			pinLock.setEchoChar((char)0);
			hidePassword.setVisible(false);
			pinLock.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                        pinLock.setForeground(java.awt.Color.white);
		}else{
		      pinLock.setEchoChar('*'); 
		      pinLock.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                      pinLock.setForeground(java.awt.Color.white);
	       }
        }//GEN-LAST:event_pinLockKeyTyped

 

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btEnter;
        private javax.swing.JLabel hidePassword;
        private javax.swing.JLabel inputPasswordLabel;
        private javax.swing.JLabel labelIcon;
        private javax.swing.JLabel labelMinimarket;
        private javax.swing.JPanel lockPanel;
        private javax.swing.JPanel picPanel;
        private javax.swing.JPasswordField pinLock;
        private javax.swing.JLabel showPassword;
        // End of variables declaration//GEN-END:variables



	private void getPin(){
		
		String idEmployee = lockApp.getIdEmployee();
		
		modelEmployee retrievedEmployee = pinLockApp.pinSetting(idEmployee);
		String pin = retrievedEmployee.getPin();
		
		String pinInput = encryptLogin.getMD5 ( pinLock.getText());
		
		if (pin.equals(pinInput)) {
			JOptionPane.showMessageDialog(null, "SELAMAT BEKERJA KEMBALI");
			dispose();
		}else{
			JOptionPane.showMessageDialog(null, "PIN SALAH");
		}
	}

}
