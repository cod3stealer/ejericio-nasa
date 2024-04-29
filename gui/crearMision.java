package gui;

import fx.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class crearMision extends JFrame {
    private JTextField txtNombre;
    private JTextField txtFechaLanzamiento;
    private JTextField txtObjetivos;
    public crearMision(gestorMision gestorMisiones) {
        setTitle("Crear Misión");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));
        setLocationRelativeTo(null);

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Fecha de Lanzamiento:"));
        txtFechaLanzamiento = new JTextField();
        add(txtFechaLanzamiento);

        add(new JLabel("Objetivos:"));
        txtObjetivos = new JTextField();
        add(txtObjetivos);

        JButton btnCrear = new JButton("Crear");
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mision mision = new Mision();
                mision.setNombre(txtNombre.getText());
                mision.setFecha(txtFechaLanzamiento.getText());
                mision.setObj(txtObjetivos.getText());
                gestorMisiones.crearMision(mision.getNombre(), mision.getFecha(), mision.getObj(), mision.getNave(), mision.getTripulantes());
                dispose();
            }
        });
        add(btnCrear);
        setVisible(true);
    }
}
