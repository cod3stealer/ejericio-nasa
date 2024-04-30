package gui;

import fx.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class asigNave extends JDialog {
    private JComboBox<String> cmbMisiones;
    private JComboBox<String> cmbNaves;

    public asigNave(gestorMision gMision) {
        setTitle("Asignar Nave");
        setSize(400, 400);
        setLayout(new GridLayout(3, 2));
        setLocationRelativeTo(null);

        add(new JLabel("Misión:"));
        cmbMisiones = new JComboBox<>(gMision.getMision());
        add(cmbMisiones);

        add(new JLabel("Nave:"));
        cmbNaves = new JComboBox<>(gMision.getNombreNaves());
        add(cmbNaves);

        JButton btnAsignar = new JButton("Asignar nave:");
        btnAsignar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreMision = (String) cmbMisiones.getSelectedItem();
                String nombreNave = (String) cmbNaves.getSelectedItem();
                Nave nave = gMision.getNave(nombreNave);
                gMision.asignNaveMision(nombreMision, nave);
            }
        });
        add(btnAsignar);
        setVisible(true);
    }
}