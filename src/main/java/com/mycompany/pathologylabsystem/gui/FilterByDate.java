/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.pathologylabsystem.gui;

import com.mycompany.pathologylabsystem.TestResult;
import java.util.List;
import com.mycompany.pathologylabsystem.FileManager;
import com.mycompany.pathologylabsystem.Patient;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.util.*; 
/**
 *
 * @author XPRISTO
 */
public class FilterByDate extends javax.swing.JFrame {

    private FileManager fileManager = new FileManager();

    /**
     * Creates new form FilterByDate
     */
    public FilterByDate() {
        initComponents();
        setLocationRelativeTo(null); // Centers the JFrame
    }
    List<TestResult> Result;
    public FilterByDate(List<TestResult> testHistory) {
        Result=testHistory;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        TestHistoryT = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Show = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        StartDate = new com.toedter.calendar.JDateChooser();
        EndDate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
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

        jLabel1.setText("Enter Start Date");

        jLabel2.setText("Enter End Date");

        Show.setText("Show");
        Show.setActionCommand("");
        Show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowActionPerformed(evt);
            }
        });

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(StartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(Show)
                        .addGap(18, 18, 18)
                        .addComponent(Back)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Show)
                    .addComponent(Back))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        this.setVisible(false);
        new ViewTestHistory().setVisible(true);
    }//GEN-LAST:event_BackActionPerformed

    private void ShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowActionPerformed
        String startDate=StartDate.getDateFormatString();
        String endDate=EndDate.getDateFormatString();
        Date s=StartDate.getDate();
        Date e=EndDate.getDate();
        if(e.before(s)){
         JOptionPane.showMessageDialog(this,"enter valid Date","try again", JOptionPane.ERROR_MESSAGE);
        }else{
            List<TestResult> finalresult=retrieveTestResultsByDate(Result,startDate,endDate);
            if(finalresult.isEmpty()){
                JOptionPane.showMessageDialog(this,"No test results found for the specified date range","try again", JOptionPane.ERROR_MESSAGE);
                return;
            }else{
                DefaultTableModel model=(DefaultTableModel)TestHistoryT.getModel();
                while(model.getRowCount()>0){model.removeRow(0);}

                for (int i = 0; i < finalresult.size(); i++) {
                    TestResult test = finalresult.get(i);
                   model.addRow(new Object[]{test.getTestName(), test.getResult(),test.getMin(), test.getMax(),test.getStatus(),test.getDate()});
                }

            }
        }
    }//GEN-LAST:event_ShowActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
         
            DefaultTableModel model=(DefaultTableModel)TestHistoryT.getModel();
            for (int i = 0; i <Result.size(); i++) {
            TestResult test = Result.get(i);
            model.addRow(new Object[]{test.getTestName(), test.getResult(),test.getMin(), test.getMax(),test.getStatus(),test.getDate()});
        }
    }//GEN-LAST:event_formWindowOpened

    private List<TestResult> retrieveTestResultsByDate(List<TestResult> testHistory, String startDate, String endDate) {
        List<TestResult> filteredResults = new ArrayList<>();

        for (TestResult result : testHistory) {
//            if (result.getDate().compareTo(startDate) >= 0 && result.getDate().compareTo(endDate) <= 0) {
//                filteredResults.add(result);
//            }
            if (fileManager.isDateInRange(result.getDate(), startDate, endDate)) {
                filteredResults.add(result);
            }
        }
        return filteredResults;
    }
    
    public boolean isDateInRange(String date, String startDate, String endDate) {
        return (date.compareTo(startDate) >= 0 && date.compareTo(endDate) <= 0);
    }
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
            java.util.logging.Logger.getLogger(FilterByDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FilterByDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FilterByDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FilterByDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FilterByDate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private com.toedter.calendar.JDateChooser EndDate;
    private javax.swing.JButton Show;
    private com.toedter.calendar.JDateChooser StartDate;
    private javax.swing.JTable TestHistoryT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
