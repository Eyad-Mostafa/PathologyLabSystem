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
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
     
    ViewTestHistory(Patient e){
        initComponents();
        setLocationRelativeTo(null); // Centers the JFrame
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        testHistory = fileManager.loadPatientHistory(e.getId());
        k=e;
     }
     /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GeneratHelthReport = new javax.swing.JButton();
        GenerateTestReport = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        FilterByDate = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TestHistoryT = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        GeneratHelthReport.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GeneratHelthReport.setText("Generate Health Report");
        GeneratHelthReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GeneratHelthReportActionPerformed(evt);
            }
        });

        GenerateTestReport.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GenerateTestReport.setText("Generate Test Report");
        GenerateTestReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateTestReportActionPerformed(evt);
            }
        });

        Back.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        FilterByDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        FilterByDate.setText("Filter by Date");
        FilterByDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterByDateActionPerformed(evt);
            }
        });

        TestHistoryT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Test Name", "Result", "Main", "Max", "Status", "Date"
            }
        ));
        jScrollPane2.setViewportView(TestHistoryT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GeneratHelthReport))
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FilterByDate, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GenerateTestReport))
                .addContainerGap(110, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FilterByDate)
                    .addComponent(Back))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GenerateTestReport)
                    .addComponent(GeneratHelthReport))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GeneratHelthReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GeneratHelthReportActionPerformed
            this.setVisible(false);
            new GeneratHelthReport( testHistory).setVisible(true);
    }//GEN-LAST:event_GeneratHelthReportActionPerformed

    private void FilterByDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilterByDateActionPerformed
                  this.setVisible(false);
            new FilterByDate(testHistory).setVisible(true);
    }//GEN-LAST:event_FilterByDateActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
       this.setVisible(false);
       new DisplayPatientProfile(k).setVisible(true);
    }//GEN-LAST:event_BackActionPerformed

    private void GenerateTestReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateTestReportActionPerformed
        int row=TestHistoryT.getSelectedRow();
        DefaultTableModel model=(DefaultTableModel)TestHistoryT.getModel();
         String Testname=model.getValueAt(row, 0).toString();
         String TestResult=model.getValueAt(row, 1).toString();
         String TestMin=model.getValueAt(row, 2).toString();
         String TestMax=model.getValueAt(row, 2).toString();
         String TestStatus=model.getValueAt(row, 4).toString();
         String TestDeat=model.getValueAt(row, 5).toString();
         this.setVisible(false);
       new GenerateTestReport(Testname,TestResult,TestMin,TestMax,TestStatus,TestDeat).setVisible(true);
    }//GEN-LAST:event_GenerateTestReportActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
            DefaultTableModel model=(DefaultTableModel)TestHistoryT.getModel();
            for (int i = 0; i <testHistory.size(); i++) {
            TestResult test = testHistory.get(i);
            model.addRow(new Object[]{test.getTestName(), test.getResult(),test.getMin(), test.getMax(),test.getStatus(),test.getDate()});
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
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
