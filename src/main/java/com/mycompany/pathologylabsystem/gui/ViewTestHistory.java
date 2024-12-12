/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.pathologylabsystem.gui;

import com.mycompany.pathologylabsystem.FileManager;
import com.mycompany.pathologylabsystem.Patient;
import com.mycompany.pathologylabsystem.TestResult;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author XPRISTO
 */
public class ViewTestHistory extends javax.swing.JFrame {

    private List<Patient> patients;
    private FileManager fileManager = new FileManager();
    List<TestResult> testHistory;
    Patient k;

    /**
     * Creates new form ViewTestHistory
     */
    public ViewTestHistory() {
        initComponents();
        setLocationRelativeTo(null); // Centers the JFrame
        setResizable(false);
    }

    ViewTestHistory(Patient e) {
        initComponents();
        setLocationRelativeTo(null); // Centers the JFrame
        setResizable(false);
        testHistory = fileManager.loadPatientHistory(e.getId());
        k = e;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TestHistoryT = new javax.swing.JTable();
        Back = new javax.swing.JButton();
        FilterByDate = new javax.swing.JButton();
        GeneratHelthReport = new javax.swing.JButton();
        GenerateTestReport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(241, 246, 249));

        TestHistoryT.setBackground(new java.awt.Color(155, 164, 181));
        TestHistoryT.setForeground(new java.awt.Color(33, 42, 62));
        TestHistoryT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Test Name", "Result", "Main", "Max", "Status", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TestHistoryT.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TestHistoryT);

        Back.setBackground(new java.awt.Color(57, 72, 103));
        Back.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Back.setForeground(new java.awt.Color(241, 246, 249));
        Back.setText("Back");
        Back.setFocusable(false);
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        FilterByDate.setBackground(new java.awt.Color(33, 42, 62));
        FilterByDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        FilterByDate.setForeground(new java.awt.Color(241, 246, 249));
        FilterByDate.setText("Filter by Date");
        FilterByDate.setFocusable(false);
        FilterByDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterByDateActionPerformed(evt);
            }
        });

        GeneratHelthReport.setBackground(new java.awt.Color(33, 42, 62));
        GeneratHelthReport.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GeneratHelthReport.setForeground(new java.awt.Color(241, 246, 249));
        GeneratHelthReport.setText("Generate Health Report");
        GeneratHelthReport.setFocusable(false);
        GeneratHelthReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GeneratHelthReportActionPerformed(evt);
            }
        });

        GenerateTestReport.setBackground(new java.awt.Color(33, 42, 62));
        GenerateTestReport.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GenerateTestReport.setForeground(new java.awt.Color(241, 246, 249));
        GenerateTestReport.setText("Generate Test Report");
        GenerateTestReport.setFocusable(false);
        GenerateTestReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateTestReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GeneratHelthReport)
                    .addComponent(FilterByDate, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GenerateTestReport))
                .addGap(94, 94, 94))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Back, FilterByDate, GeneratHelthReport, GenerateTestReport});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(GenerateTestReport)
                    .addComponent(FilterByDate, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GeneratHelthReport)
                    .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Back, FilterByDate, GeneratHelthReport, GenerateTestReport});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GeneratHelthReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GeneratHelthReportActionPerformed
        if(testHistory.isEmpty()){
            JOptionPane.showMessageDialog(this, "No test history available to generate a report.", "try again", JOptionPane.ERROR_MESSAGE);
        }else{
            this.setVisible(false);
            new GeneratHelthReport(testHistory, k).setVisible(true);
        }
    }//GEN-LAST:event_GeneratHelthReportActionPerformed

    private void FilterByDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilterByDateActionPerformed
//        this.setVisible(false);
        new FilterByDate(testHistory).setVisible(true);
    }//GEN-LAST:event_FilterByDateActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        this.setVisible(false);
//        new DisplayPatientProfile(k, "").setVisible(true);
    }//GEN-LAST:event_BackActionPerformed

    private void GenerateTestReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateTestReportActionPerformed
        int row = TestHistoryT.getSelectedRow();
        if (row==-1) {
             JOptionPane.showMessageDialog(this, "No row selected.", "try again", JOptionPane.ERROR_MESSAGE);
        }else{
            DefaultTableModel model = (DefaultTableModel) TestHistoryT.getModel();
            String Testname = model.getValueAt(row, 0).toString();
            String TestResult = model.getValueAt(row, 1).toString();
            String TestMin = model.getValueAt(row, 2).toString();
            String TestMax = model.getValueAt(row, 3).toString();
            String TestStatus = model.getValueAt(row, 4).toString();
            String TestDeat = model.getValueAt(row, 5).toString();
            this.setVisible(false);
            new GenerateTestReport(Testname, TestResult, TestMin, TestMax, TestStatus, TestDeat, k).setVisible(true);
        }
    }//GEN-LAST:event_GenerateTestReportActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        DefaultTableModel model = (DefaultTableModel) TestHistoryT.getModel();
        for (int i = 0; i < testHistory.size(); i++) {
            TestResult test = testHistory.get(i);
            model.addRow(new Object[]{test.getTestName(), test.getResult(), test.getMin(), test.getMax(), test.getStatus(), test.getDate()});
        }

    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(ViewTestHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewTestHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewTestHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewTestHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewTestHistory().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton FilterByDate;
    private javax.swing.JButton GeneratHelthReport;
    private javax.swing.JButton GenerateTestReport;
    private javax.swing.JTable TestHistoryT;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
