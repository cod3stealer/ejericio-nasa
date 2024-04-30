import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class gui extends JFrame {

    private final api cryptoAPI;
    private final JTextField amountField;

    public gui(api api) {
        super("Criptomonedas"); // Set title in constructor

        this.cryptoAPI = api; // Store CryptoAPI instance
        this.amountField = new JTextField("1"); // Initialize amount field in constructor

        initializeComponents();
    }

    private void initializeComponents() {
        private void setupFrame() {
            // Set frame properties
            setTitle("Intercambio de Criptomonedas");
            setSize(400, 200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            // Create and configure panel
            JPanel panel = new JPanel(new GridLayout(4, 2));
            JButton exchangeButton = new JButton("Balance");
            // Add labels and other components to the panel
            panel.add(new JLabel("Bitcoin"));
            panel.add(new JLabel()); // Spacer label
            panel.add(new JLabel("Ethereum"));
            panel.add(new JLabel()); // Spacer label
            panel.add(new JLabel("Cantidad:"));
            panel.add(amountField);
            panel.add(exchangeButton);
            exchangeButton.addActionListener(this::handleExchange);

            // Add panel to the frame
            add(panel);
        }
    }

    private void handleExchange(ActionEvent e) {
        try {
            double amount = Double.parseDouble(amountField.getText());
            double result = cryptoAPI.exchange("bitcoin", "ethereum", amount);
            JOptionPane.showMessageDialog(null, "El resultado del intercambio es: " + result);
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}
