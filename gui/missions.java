package gui;

import javax.swing.*;
import fx.*;

import java.awt.*;
import java.awt.event.ActionListener;

public class missions extends JFrame {
    private gestorMision gMision;
    private JComboBox<String> desplegable;

    public missions(){
        // Se crea una nueva instancia de la clase `gestorMision` y se almacena en la variable `gMision`.
        // Esta clase se encarga de gestionar las misiones espaciales (crearlas, asignar naves y tripulación, etc.).
        gMision = new gestorMision();

        // Se crea una nueva instancia del componente `JComboBox` y se almacena en la variable `desplegable`.
        // Un `JComboBox` es un componente Swing utilizado para crear un menú desplegable que permite al usuario seleccionar una opción de una lista.
        desplegable = new JComboBox<>();

        // Configuración inicial del JFrame (la ventana principal de la aplicación):
        // Se establece el título de la ventana como "Menú principal".
        setTitle("Menu principal");

        // Se define el tamaño de la ventana a 500 píxeles de ancho y 500 píxeles de alto.
        setSize(500,500);

        // Se indica que la aplicación se cierre al pulsar la "X" de la ventana.
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Se centra la ventana en la pantalla.
        setLocationRelativeTo(null);

        // Se crea un nuevo panel llamado `button` para agrupar los botones.
        JPanel button = new JPanel();

        // Se establece el layout del JFrame como un `GridLayout` con 5 filas y 1 columna.
        // Esto organiza los elementos en una cuadrícula de 5 botones (uno encima del otro).
        setLayout(new GridLayout(5,1));

        // Se crean objetos de la clase `JButton` para cada botón del menú:
        JButton bCrearMision = new JButton("Crear misión");
        JButton bAsignNave = new JButton("Asignar nave(s)");
        JButton bAsignTrip = new JButton("Asignar tripulación");
        JButton bEstado = new JButton("Ver estado de la misión");
        JButton bTrayect = new JButton("Ver trayectoria de la misión");

        // Se agregan los botones creados al panel `button`.
        button.add(bCrearMision);
        button.add(bAsignNave);
        button.add(bAsignTrip);
        button.add(bEstado);
        button.add(bTrayect);

        // Se agrega el panel `button` que contiene los botones al JFrame principal.
        add(button);

        // Se crea un objeto `ActionListener` utilizando una expresión lambda.
        // Un `ActionListener` es una interfaz que define un método `actionPerformed` que se invoca cuando se produce un evento de acción en un componente.
        ActionListener actionListener = (e) -> {

            // Se obtiene el botón que generó el evento (el botón presionado)
            JButton source = (JButton) e.getSource();

            // Se utiliza un switch para determinar la acción a realizar en base al texto del botón presionado
            switch (source.getText()) {
                case "Crear misión":
                    // Se crea una nueva instancia de la clase `crearMision` y se le pasa la referencia al gestor de misiones (`gMision`)
                    new crearMision(gMision);
                    break;
                case "Asignar nave":
                    // Se crea una nueva instancia de la clase `asigNave` y se le pasa la referencia al gestor de misiones (`gMision`)
                    new asigNave(gMision);
                    break;
                case "Asignar tripulación":
                    // Se crea una nueva instancia de la clase `asignTrip` y se le pasa la referencia al gestor de misiones (`gMision`)
                    if (gMision.getMisionRegistrada() == null){
                        JOptionPane.showMessageDialog(null,"Crea una mision primero","error",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    new asignTrip(gMision);
                    break;

                case "Ver estado de la misión":
                    // Se intenta obtener el nombre de la misión registrada utilizando el gestor de misiones (`gMision`)
                    try {
                        String mision = gMision.getMisionRegistrada();
                        if (mision != null) {
                            // Si hay una misión registrada, se crea una nueva instancia de la clase `informeMision` y se le pasa el nombre de la misión
                            new informeMision(mision);
                        } else {
                            // Si no hay una misión registrada, se muestra un mensaje informativo utilizando `JOptionPane`
                            JOptionPane.showMessageDialog(null, "No hay ninguna misión reciente de la que mostrar su informe.");
                        }
                    } catch (NullPointerException ex) {
                        // Se maneja la excepción `NullPointerException` en caso de que el gestor de misiones devuelva null
                        misionUtils.mostrarError("Error al obtener el nombre de la misión reciente", ex);
                    }
                    break;
                case "Ver trayectoria de la misión":
                    // Se intenta mostrar la trayectoria de la misión utilizando la utilidad `misionUtils`
                    try {
                        misionUtils.mostrarTrayectoriaMision();
                    } catch (Exception ex) {
                        // Se maneja cualquier excepción que pueda ocurrir al mostrar la trayectoria
                        misionUtils.mostrarError("Error al mostrar la trayectoria de la misión", ex);
                    }
                    break;
            }
        };

        // Asignar el ActionListener a los botones
        bCrearMision.addActionListener(actionListener);
        bAsignNave.addActionListener(actionListener);
        bAsignTrip.addActionListener(actionListener);
        bEstado.addActionListener(actionListener);
        bTrayect.addActionListener(actionListener);

        setVisible(true);
    }
}
