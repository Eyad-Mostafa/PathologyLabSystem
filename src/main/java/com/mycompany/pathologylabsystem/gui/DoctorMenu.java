/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.pathologylabsystem.gui;

import com.mycompany.pathologylabsystem.FileManager;
import com.mycompany.pathologylabsystem.Patient;
import com.mycompany.pathologylabsystem.Test;
import com.mycompany.pathologylabsystem.TestResult;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author XEON
 */
public class DoctorMenu extends javax.swing.JFrame {

    /**
     * Creates new form DoctorMenu
     */
    String name;
    private FileManager fileManager = new FileManager();
    private List<Patient> patients;
    List<String> pendingTests = fileManager.loadPendingTests();

    public DoctorMenu(String name) {
        initComponents();
        setLocationRelativeTo(null); // Centers the JFrame
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.name = name;
    }

    private DoctorMenu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void fillTable() {
        DefaultTableModel model = (DefaultTableModel) pendingTestTable.getModel();
        List<String> pendingTests = fileManager.loadPendingTests();
        model.setRowCount(0);
        for (int i = 0; i < pendingTests.size(); i++) {
            String row = pendingTests.get(i);
            String[] arr = row.split(",");
            model.addRow(new Object[]{arr[0], arr[1], arr[4]});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addPatient = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pendingTestTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAddTestResult = new javax.swing.JButton();
        btnAddNewTest = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        drName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        addPatient.setText("Add Patient");
        addPatient.setBorderPainted(false);
        addPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPatientActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Doctor Menu");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(241, 246, 249));

        pendingTestTable.setBackground(new java.awt.Color(57, 72, 103));
        pendingTestTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pendingTestTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pendingTestTable.setForeground(new java.awt.Color(241, 246, 249));
        pendingTestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient ID", "Test Name", "Date"
            }
        ));
        pendingTestTable.setRowHeight(30);
        pendingTestTable.setRowMargin(2);
        pendingTestTable.setShowGrid(true);
        jScrollPane1.setViewportView(pendingTestTable);
        pendingTestTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Pending Test");

        jPanel2.setBackground(new java.awt.Color(33, 42, 62));

        btnAddTestResult.setBackground(new java.awt.Color(241, 246, 249));
        btnAddTestResult.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddTestResult.setForeground(new java.awt.Color(51, 51, 51));
        btnAddTestResult.setIcon(new javax.swing.ImageIcon("D:\\abo baker\\collage\\third_year\\first_sem\\java\\project\\newDesign\\PathologyLabSystem\\src\\main\\java\\com\\mycompany\\pathologylabsystem\\image\\signature.png")); // NOI18N
        btnAddTestResult.setText("Add Test Result");
        btnAddTestResult.setBorderPainted(false);
        btnAddTestResult.setFocusable(false);
        btnAddTestResult.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnAddTestResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTestResultActionPerformed(evt);
            }
        });

        btnAddNewTest.setBackground(new java.awt.Color(241, 246, 249));
        btnAddNewTest.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddNewTest.setForeground(new java.awt.Color(51, 51, 51));
        btnAddNewTest.setIcon(new javax.swing.ImageIcon("D:\\abo baker\\collage\\third_year\\first_sem\\java\\project\\newDesign\\PathologyLabSystem\\src\\main\\java\\com\\mycompany\\pathologylabsystem\\image\\add.png")); // NOI18N
        btnAddNewTest.setText("Add New Test");
        btnAddNewTest.setBorderPainted(false);
        btnAddNewTest.setFocusable(false);
        btnAddNewTest.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnAddNewTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewTestActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(241, 246, 249));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(51, 51, 51));
        btnSearch.setIcon(new javax.swing.ImageIcon("D:\\abo baker\\collage\\third_year\\first_sem\\java\\project\\newDesign\\PathologyLabSystem\\src\\main\\java\\com\\mycompany\\pathologylabsystem\\image\\magnifying-glass.png")); // NOI18N
        btnSearch.setText("Search For Patient");
        btnSearch.setBorderPainted(false);
        btnSearch.setFocusable(false);
        btnSearch.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(155, 164, 181));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClear.setForeground(new java.awt.Color(0, 0, 0));
        btnClear.setIcon(new javax.swing.ImageIcon("D:\\abo baker\\collage\\third_year\\first_sem\\java\\project\\newDesign\\PathologyLabSystem\\src\\main\\java\\com\\mycompany\\pathologylabsystem\\image\\trash.png")); // NOI18N
        btnClear.setText("Clear Pending Tests");
        btnClear.setBorderPainted(false);
        btnClear.setFocusable(false);
        btnClear.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(155, 164, 181));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon("D:\\abo baker\\collage\\third_year\\first_sem\\java\\project\\newDesign\\PathologyLabSystem\\src\\main\\java\\com\\mycompany\\pathologylabsystem\\image\\logout.png")); // NOI18N
        jButton1.setText("Log out");
        jButton1.setBorderPainted(false);
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        drName.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        drName.setForeground(new java.awt.Color(241, 246, 249));
        drName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        drName.setToolTipText("");

        jLabel3.setIcon(new javax.swing.ImageIcon("D:\\abo baker\\collage\\third_year\\first_sem\\java\\project\\newDesign\\PathologyLabSystem\\src\\main\\java\\com\\mycompany\\pathologylabsystem\\image\\biologist (2).png")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(drName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel2Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel3)
                            .addComponent(jButton1)))
                    .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddNewTest, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddTestResult, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddNewTest, btnAddTestResult, btnClear, btnSearch, jButton1});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(drName, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnAddTestResult, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddNewTest, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(46, 46, 46)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddNewTest, btnAddTestResult, btnClear, btnSearch, jButton1});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPatientActionPerformed


    }//GEN-LAST:event_addPatientActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        fillTable();
        drName.setText("Welcome Dr."+name);
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        Login t = new Login();
        t.setVisible(true);
        t.pack();
        t.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        int result = JOptionPane.showConfirmDialog(this,
            "Are You Sure, You Want Delete All Pending Tests",
            "Confirm",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            fileManager.clearPendingTests();
            DefaultTableModel model = (DefaultTableModel) pendingTestTable.getModel();
            model.setRowCount(0);
        } else
        return;
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        this.setVisible(false);
        SearchInterface t = new SearchInterface(this, true);
        t.setVisible(true);
        t.pack();
        t.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAddNewTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewTestActionPerformed
        this.setVisible(false);
        AddNewTest t = new AddNewTest(name);
        t.setVisible(true);
        t.pack();
        t.setLocationRelativeTo(null);
        t.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.dispose();
    }//GEN-LAST:event_btnAddNewTestActionPerformed

    private void btnAddTestResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTestResultActionPerformed
        int row = pendingTestTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "please select test", "try again", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            DefaultTableModel model = (DefaultTableModel) pendingTestTable.getModel();
            Object valueP = model.getValueAt(row, 0);
            Object valueT = model.getValueAt(row, 1);
            Object valueD = model.getValueAt(row, 2);
            String patientId = (String) valueP;
            Test selectedTest = fileManager.getTestByName((String) valueT);
            int min = (int) selectedTest.getMin();
            int max = (int) selectedTest.getMax();
            String selectedTestName = (String) valueT + "," + Integer.toString(min) + "," + Integer.toString(max);
            String selectedTestInfo = patientId + "," + selectedTestName + "," + (String) valueD;
            System.out.println(selectedTestName);
            System.out.println(selectedTestInfo);
            String currentDate = java.time.LocalDate.now().toString();
            if (selectedTest == null) {
                JOptionPane.showMessageDialog(this, "No Test", "try again", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String result = JOptionPane.showInputDialog(this, "input result for " + valueT);
            String status;
            Long testResult;
            try {
                testResult = Long.parseLong(result);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Enter Avalid Value", "try again", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (testResult < selectedTest.getMin()) {
                status = "Low";
            } else if (testResult > selectedTest.getMax()) {
                status = "High";
            } else {
                status = "Normal";
            }
            TestResult newTestResult = new TestResult(selectedTest, testResult, status, currentDate);
            fileManager.addTestResultToPatientHistory(patientId, newTestResult);
            fileManager.removeTestFromPending(selectedTestInfo);
            fillTable();
            //            System.out.println("Test result added successfully for test: " + selectedTest.getName());

        }
    }//GEN-LAST:event_btnAddTestResultActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DoctorMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctorMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPatient;
    private javax.swing.JButton btnAddNewTest;
    private javax.swing.JButton btnAddTestResult;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel drName;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable pendingTestTable;
    // End of variables declaration//GEN-END:variables

}
