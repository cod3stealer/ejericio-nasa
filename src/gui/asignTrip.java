package gui;

import fx.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class asignTrip extends JDialog {
    private JComboBox<String> cmbMisiones;
    private JComboBox<String> cmbTripulantes;
    public asignTrip(gestorMision gMision) {
        setTitle("Asignar tripulación");
        setSize(500, 300);
        setLayout(new GridLayout(3, 2));
        setLocationRelativeTo(null);
        add(new JLabel("Misión:"));
        cmbMisiones = new JComboBox<>(gMision.getMision());
        add(cmbMisiones);
        add(new JLabel("Tripulante:"));
        cmbTripulantes = new JComboBox<>(gMision.getNombresTripulantes());
        add(cmbTripulantes);
        JButton bAsignar = new JButton("Asignar tripulante");
        bAsignar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mision = (String) cmbMisiones.getSelectedItem();
                String nombreTripulante = (String) cmbTripulantes.getSelectedItem();
                Tripulante tripulante = gMision.getTripulantePorNombre(nombreTripulante);
                gMision.asignTripAMision(mision, tripulante);
            }
        });
        add(bAsignar);
        setVisible(true);
    }
}