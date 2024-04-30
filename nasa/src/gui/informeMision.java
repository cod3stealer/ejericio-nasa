package gui;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class informeMision extends JFrame {
    public informeMision(String nMision) {
        setTitle("Informe: " + nMision);
        setSize(450, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea txtArea = new JTextArea();
        JScrollPane scroll = new JScrollPane(txtArea);
        add(scroll);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(".missions/"+nMision + ".txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                txtArea.append(line+"\n");
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        setVisible(true);
    }
}