/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.pathologylabsystem.gui;

import com.mycompany.pathologylabsystem.FileManager;
import com.mycompany.pathologylabsystem.Patient;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author XEON
 */
public class ReceptionistMenu extends javax.swing.JFrame {

    /**
     * Creates new form ReceptionistMenu
     */
    String name;
    private FileManager fileManager = new FileManager();
    private List<Patient> patients; // List of patients

    public ReceptionistMenu() {
        initComponents();
        setLocationRelativeTo(null); // Centers the JFrame
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        patients = fileManager.loadPatients();
        populatePatientsTable();
    }

    public ReceptionistMenu(String n) {
        initComponents();
        setLocationRelativeTo(null); // Centers the JFrame
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.name = n;
        patients = fileManager.loadPatients();
        jLabel1.setText("Welcome " + name);
        populatePatientsTable();
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
        jPanel2 = new javax.swing.JPanel();
        javax.swing.ButtonGroup buttonGroup = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        patiantsDataa = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        addPatientPanal = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        patientName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        phone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ID = new javax.swing.JSpinner();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        weight = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        height = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        age = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        addPatient = new javax.swing.JButton();
        searchPatient = new javax.swing.JButton();
        searchPatient1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(165, 157, 132));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        patiantsDataa.setBackground(new java.awt.Color(57, 72, 103));
        patiantsDataa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        patiantsDataa.setForeground(new java.awt.Color(255, 255, 255));
        patiantsDataa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        patiantsDataa.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(patiantsDataa);
        patiantsDataa.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText(this.name);
        jLabel1.setToolTipText("");

        addPatientPanal.setBackground(new java.awt.Color(33, 42, 62));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Patient Name");

        patientName.setBackground(new java.awt.Color(255, 255, 255));
        patientName.setForeground(new java.awt.Color(51, 51, 51));
        patientName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientNameActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Phone Number");

        phone.setBackground(new java.awt.Color(255, 255, 255));
        phone.setForeground(new java.awt.Color(51, 51, 51));
        phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ID");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Weight");

        weight.setModel(new javax.swing.SpinnerNumberModel(1, 1, 200, 1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Height");

        height.setModel(new javax.swing.SpinnerNumberModel(50, 50, 210, 1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Age");

        age.setModel(new javax.swing.SpinnerNumberModel(1, 1, 120, 1));
        age.setToolTipText("");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Add New Patient");

        male.setBackground(new java.awt.Color(33, 42, 62));
        male.setForeground(new java.awt.Color(255, 255, 255));
        male.setText("Male");
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });

        female.setBackground(new java.awt.Color(33, 42, 62));
        female.setForeground(new java.awt.Color(255, 255, 255));
        female.setText("Female");
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });

        addPatient.setBackground(new java.awt.Color(255, 255, 255));
        addPatient.setForeground(new java.awt.Color(51, 51, 51));
        addPatient.setText("Add Patient");
        addPatient.setBorderPainted(false);
        addPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPatientActionPerformed(evt);
            }
        });

        searchPatient.setBackground(new java.awt.Color(255, 255, 255));
        searchPatient.setForeground(new java.awt.Color(51, 51, 51));
        searchPatient.setText("Search for Patient");
        searchPatient.setBorderPainted(false);
        searchPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPatientActionPerformed(evt);
            }
        });

        searchPatient1.setBackground(new java.awt.Color(255, 255, 255));
        searchPatient1.setForeground(new java.awt.Color(153, 0, 0));
        searchPatient1.setText("Log out");
        searchPatient1.setBorderPainted(false);
        searchPatient1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPatient1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addPatientPanalLayout = new javax.swing.GroupLayout(addPatientPanal);
        addPatientPanal.setLayout(addPatientPanalLayout);
        addPatientPanalLayout.setHorizontalGroup(
            addPatientPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPatientPanalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addPatientPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addPatientPanalLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(addPatientPanalLayout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                        .addGap(23, 23, 23)
                        .addGroup(addPatientPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addPatientPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(addPatientPanalLayout.createSequentialGroup()
                                    .addGroup(addPatientPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(addPatientPanalLayout.createSequentialGroup()
                                            .addComponent(male, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(female))
                                        .addGroup(addPatientPanalLayout.createSequentialGroup()
                                            .addGroup(addPatientPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel3))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(addPatientPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(weight)
                                                .addComponent(age))))
                                    .addGap(18, 18, 18)
                                    .addGroup(addPatientPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel7))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(addPatientPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(height, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(addPatientPanalLayout.createSequentialGroup()
                                    .addGroup(addPatientPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(patientName, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchPatient1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(34, Short.MAX_VALUE))))
        );

        addPatientPanalLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {patientName, phone, searchPatient1});

        addPatientPanalLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ID, age, height, weight});

        addPatientPanalLayout.setVerticalGroup(
            addPatientPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPatientPanalLayout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(addPatientPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addPatientPanalLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addPatientPanalLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(patientName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(addPatientPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(male)
                            .addComponent(female)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(addPatientPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel4)
                            .addComponent(weight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(height, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(addPatientPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(32, 32, 32)
                .addComponent(searchPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(addPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(searchPatient1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Patients");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(addPatientPanal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 43, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(addPatientPanal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void populatePatientsTable() {
        // Create a DefaultTableModel with column names
        DefaultTableModel model = new DefaultTableModel(new String[]{"Name", "ID", "Age", "Gender", "Height", "Weight", "Phone"}, 0);
        
        // Load patients from the file manager
        patients = fileManager.loadPatients();
        // Iterate through the patients list and add rows to the model
        for (Patient patient : patients) {
            Object[] rowData = {
                patient.getName(),
                patient.getId(),
                patient.getAge(),
                patient.getGender(),
                patient.getHeight(),
                patient.getWeight(),
                patient.getContactInfo()
            };
            model.addRow(rowData);
        }

        // Set the model to the JTable
        patiantsDataa.setModel(model);
    }

    private void searchPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPatientActionPerformed
        SearchInterface si = new SearchInterface(this, false);
        si.setVisible(true);
        si.pack();
        si.setLocationRelativeTo(null);
        this.dispose();

    }//GEN-LAST:event_searchPatientActionPerformed

    private void addPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPatientActionPerformed
        String id = ID.getValue().toString(); // Get ID from JSpinner
        String name1 = patientName.getText().trim(); // Get name from JTextField
        int age1 = (int) age.getValue(); // Get age from JSpinner
        String gender = male.isSelected() ? "Male" : (female.isSelected() ? "Female" : ""); // Get gender from JCheckBoxes
        int weight1 = (int) weight.getValue(); // Get weight from JSpinner
        int height1 = (int) height.getValue(); // Get height from JSpinner
        String contactInfo = phone.getText().trim(); // Get phone number from JTextField
                                           
       
        
        String rgx = "^0(10|11|12|15)\\d{8}$";

        if (!contactInfo.matches(rgx)) {
            JOptionPane.showMessageDialog(this, "Invalid phone number. Ensure it starts with 0 and is followed by 10, 11, 12, or 15, and is exactly 11 digits long.", 
                                          "Incorrect Phone Number", JOptionPane.ERROR_MESSAGE);
            return;
        } 
        
        // Validate inputs
        if (id.isEmpty() || name1.isEmpty() || gender.isEmpty() || contactInfo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Long.parseLong(id); // Attempt to parse the string as a number
            // Check if a patient with the same ID already exists
            boolean patientExists = false;
            for (Patient patient : patients) {
                if (patient.getId().equals(id)) {
                    patientExists = true;
                    break; // Stop checking further once a match is found
                }
            }

            if (patientExists) {
                JOptionPane.showMessageDialog(this, "Patient with this ID already exists. Please use a different ID..", "Duplicate ID", JOptionPane.ERROR_MESSAGE);
                return; // Exit the method without adding the user
            }
        } catch (NumberFormatException e) {
            System.out.println("ID must be number.");
            return;
        }
        // Validate age, weight, and height
        if (age1 < 1 || age1 > 120) {
            JOptionPane.showMessageDialog(this, "Age must be between 1 and 120.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (weight1 < 1 || weight1 > 500) {
            JOptionPane.showMessageDialog(this, "Weight must be between 1 and 500.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (height1 < 30 || height1 > 220) {
            JOptionPane.showMessageDialog(this, "Height must be between 30 and 220 cm.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create new Patient object
        Patient newPatient = new Patient(id, name1, age1, gender, weight1, height1, contactInfo);

        // Add patient using FileManager
        fileManager.addPatient(newPatient);
        patients.add(newPatient); // Add to the in-memory list

        // Refresh the patient table
        populatePatientsTable();

        // Clear input fields after adding
        patientName.setText("");
        phone.setText("");
        ID.setValue(0);
        age.setValue(1);
        weight.setValue(1);
        height.setValue(50);
        male.setSelected(false);
        female.setSelected(false);

        JOptionPane.showMessageDialog(this, "Patient added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);


    }//GEN-LAST:event_addPatientActionPerformed

    private void searchPatient1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPatient1ActionPerformed
        this.setVisible(false);
        Login t = new Login();
        t.setVisible(true);
        t.pack();
        t.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_searchPatient1ActionPerformed

    private void phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneActionPerformed
        String phoneNumber = phone.getText().trim();
        
        String regex = "^0(10|11|12|15)\\d{8}$";

        if (!phoneNumber.matches(regex)) {
            JOptionPane.showMessageDialog(this, "Invalid phone number. Ensure it starts with 0 and is followed by 10, 11, 12, or 15, and is exactly 11 digits long.", 
                                          "Validation Error", JOptionPane.ERROR_MESSAGE);
        } 
//        else {
//            JOptionPane.showMessageDialog(this, "Invalid phone number. Ensure it starts with 0 and is followed by 10, 11, 12, or 15, and is exactly 11 digits long.", 
//                                          "Validation Error", JOptionPane.ERROR_MESSAGE);
//        }
    }//GEN-LAST:event_phoneActionPerformed

    private void patientNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientNameActionPerformed

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
        if(female.isSelected())
        {
            male.setSelected(false);
        }
    }//GEN-LAST:event_femaleActionPerformed

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
        if(male.isSelected())
        {
            female.setSelected(false);
        }

    }//GEN-LAST:event_maleActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReceptionistMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner ID;
    private javax.swing.JButton addPatient;
    private javax.swing.JPanel addPatientPanal;
    private javax.swing.JSpinner age;
    private javax.swing.JRadioButton female;
    private javax.swing.JSpinner height;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JRadioButton male;
    private javax.swing.JTable patiantsDataa;
    private javax.swing.JTextField patientName;
    private javax.swing.JTextField phone;
    private javax.swing.JButton searchPatient;
    private javax.swing.JButton searchPatient1;
    private javax.swing.JSpinner weight;
    // End of variables declaration//GEN-END:variables
}
