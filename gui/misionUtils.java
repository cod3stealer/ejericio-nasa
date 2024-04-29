package gui;

import javax.swing.*;
import fx.*;

public class misionUtils extends JFrame {

    public static void mostrarError(String mensaje, Exception ex) {
        JOptionPane.showMessageDialog(null, mensaje + ": " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void mostrarTrayectoriaMision() {
        try {
            simuladorMision simuladorMisiones = new simuladorMision();
            JFrame frame = new JFrame("Trayectoria de la misión");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(simuladorMisiones);
            frame.setSize(400, 400);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } catch (Exception e) {
            mostrarError("Error al mostrar la trayectoria de la misión", e);
        }
    }
}
