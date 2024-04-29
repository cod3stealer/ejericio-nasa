package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class simuladorMision extends JPanel {

    private static final int NUM_PUNTOS_CONTROL = 5; // Número de puntos de control
    private static final int ANCHO_PANEL = 400;
    private static final int ALTO_PANEL = 400;
    private List<Point2D.Double> puntosControl;

    public simuladorMision() {
        puntosControl = generarPuntosControlAleatorios();
    }

    private List<Point2D.Double> generarPuntosControlAleatorios() {
        List<Point2D.Double> puntos = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < NUM_PUNTOS_CONTROL; i++) {
            double x = random.nextDouble() * ANCHO_PANEL;
            double y = random.nextDouble() * ALTO_PANEL;
            puntos.add(new Point2D.Double(x, y));
        }
        return puntos;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);

        // Generar la curva de Bézier
        GeneralPath curva = new GeneralPath();
        curva.moveTo(puntosControl.get(0).getX(), puntosControl.get(0).getY());
        for (int i = 1; i < puntosControl.size() - 1; i++) {
            curva.curveTo(puntosControl.get(i).getX(), puntosControl.get(i).getY(),
                    puntosControl.get(i + 1).getX(), puntosControl.get(i + 1).getY(),
                    puntosControl.get(i + 2).getX(), puntosControl.get(i + 2).getY());
        }
        curva.closePath();

        // Dibujar la curva
        g2d.draw(curva);
    }
}

