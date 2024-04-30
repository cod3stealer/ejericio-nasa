package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Timer;
import java.util.TimerTask;

public class simuladorMision extends JPanel {

    private static final int ANIMATION_DELAY = 10; // milliseconds between animation steps
    private static final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width; // Get screen width
    private static final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height; // Get screen height

    private int x = 0; // current X-coordinate of the line endpoint
    private int y = SCREEN_HEIGHT; // current Y-coordinate of the line endpoint

    public simuladorMision() {
        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Draw the line
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(0, SCREEN_HEIGHT, x, y);

        // Schedule the next animation step
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateLinePosition();
                repaint(); // Trigger repainting to draw the updated line
            }
        }, 0, ANIMATION_DELAY);
    }

    private void updateLinePosition() {
        // Calculate the new X-coordinate based on a sine curve
        x = (int) (SCREEN_WIDTH * (0.5 + 0.5 * Math.sin(Math.PI * (double) x / 50)));

        // Calculate the new Y-coordinate based on the X-coordinate
        y = SCREEN_HEIGHT - (int) ((double) x / SCREEN_WIDTH * SCREEN_HEIGHT);

        // Prevent going out of bounds
        if (x > SCREEN_WIDTH) {
            x = SCREEN_WIDTH;
        }
        if (y < 0) {
            y = 0;
        }
    }
}



