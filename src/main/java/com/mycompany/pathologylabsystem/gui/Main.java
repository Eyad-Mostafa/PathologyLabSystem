package com.mycompany.pathologylabsystem.gui;

/**
 *
 * @author Eyad Mostafa
 */
public class Main {

    public static void startGUI() {
        javax.swing.SwingUtilities.invokeLater(() -> {
            // Create and show the GUI
            new Login().setVisible(true);
        });
    }
}
