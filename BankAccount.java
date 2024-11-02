import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankAccount{
    public static void main(String[] args) {
        // Initial balance
        final double[] balance = {500.00};

        // Set up the main frame
        JFrame frame = new JFrame("ATM Interface");
        frame.setSize(600, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Display for balance
        JLabel balanceLabel = new JLabel("Current Balance: $" + balance[0]);
        balanceLabel.setBounds(20, 20, 200, 30);
        frame.add(balanceLabel);

        // Deposit button
        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(20, 70, 150, 30);
        frame.add(depositButton);

        // Withdraw button
        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(200, 70, 150, 30);
        frame.add(withdrawButton);

        // Check Balance button
        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.setBounds(20, 120, 150, 30);
        frame.add(checkBalanceButton);

        // Exit button
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(200, 120, 150, 30);
        frame.add(exitButton);

        // Action listeners for buttons
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(frame, "Enter deposit amount:");
                if (input != null) {
                    try {
                        double amount = Double.parseDouble(input);
                        if (amount > 0) {
                            balance[0] += amount;
                            balanceLabel.setText("Current Balance: $" + balance[0]);
                            JOptionPane.showMessageDialog(frame, "Deposited: $" + amount);
                        } else {
                            JOptionPane.showMessageDialog(frame, "Invalid amount. Please enter a positive number.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid number.");
                    }
                }
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(frame, "Enter withdrawal amount:");
                if (input != null) {
                    try {
                        double amount = Double.parseDouble(input);
                        if (amount > 0 && amount <= balance[0]) {
                            balance[0] -= amount;
                            balanceLabel.setText("Current Balance: $" + balance[0]);
                            JOptionPane.showMessageDialog(frame, "Withdrew: $" + amount);
                        } else if (amount > balance[0]) {
                            JOptionPane.showMessageDialog(frame, "Insufficient balance.");
                        } else {
                            JOptionPane.showMessageDialog(frame, "Invalid amount. Please enter a positive number.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid number.");
                    }
                }
            }
        });

        checkBalanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Current Balance: $" + balance[0]);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Thank you for using the ATM!");
                System.exit(0);
            }
        });

        // Show the frame
        frame.setVisible(true);
    }
}
