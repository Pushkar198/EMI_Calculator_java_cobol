//import javax.swing.*;
//import java.awt.*;
//
//public class LoanCalculatorPage extends JPanel {
//    public LoanCalculatorPage(UIManager uiManager) {
//        setLayout(new BorderLayout(10, 10));
//        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding
//
//        JLabel titleLabel = new JLabel("<html><h2 style='color: #2C3E50;'>Loan Calculator</h2><p style='color: #7F8C8D;'>Enter loan details to calculate EMI.</p></html>", SwingConstants.CENTER);
//        add(titleLabel, BorderLayout.NORTH);
//
//        JPanel formPanel = new JPanel(new GridBagLayout());
//        formPanel.setBorder(BorderFactory.createTitledBorder("Enter Loan Details"));
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.insets = new Insets(5, 5, 5, 5);
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//
//        JLabel amountLabel = new JLabel("Loan Amount: *");
//        JTextField amountField = new JTextField();
//        JLabel amountHint = new JLabel("<html><i style='color: #7F8C8D;'>Enter a valid loan amount (e.g., 500000)</i></html>");
//        JLabel amountError = new JLabel("", SwingConstants.RIGHT);
//        amountError.setForeground(Color.RED);
//
//        JLabel interestLabel = new JLabel("Interest Rate (%): *");
//        JTextField interestField = new JTextField();
//        JLabel interestHint = new JLabel("<html><i style='color: #7F8C8D;'>Enter a valid interest rate (e.g., 7.5)</i></html>");
//        JLabel interestError = new JLabel("", SwingConstants.RIGHT);
//        interestError.setForeground(Color.RED);
//
//        JLabel tenureLabel = new JLabel("Loan Tenure (years): *");
//        JTextField tenureField = new JTextField();
//        JLabel tenureHint = new JLabel("<html><i style='color: #7F8C8D;'>Enter tenure in years (e.g., 15)</i></html>");
//        JLabel tenureError = new JLabel("", SwingConstants.RIGHT);
//        tenureError.setForeground(Color.RED);
//
//        JButton calculateButton = new JButton("Calculate EMI");
//        JLabel resultLabel = new JLabel("<html><b>EMI: -</b></html>");
//        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        resultLabel.setForeground(new Color(39, 174, 96));
//
//        // Validation and Calculation Logic
//        calculateButton.addActionListener(e -> {
//            boolean isValid = true;
//            amountError.setText("");
//            interestError.setText("");
//            tenureError.setText("");
//
//            try {
//                double amount = Double.parseDouble(amountField.getText().trim());
//                if (amount <= 0) {
//                    amountError.setText("Amount must be greater than 0");
//                    isValid = false;
//                }
//            } catch (NumberFormatException ex) {
//                amountError.setText("Invalid amount! Enter numbers only.");
//                isValid = false;
//            }
//
//            double rate = 0;
//            try {
//                rate = Double.parseDouble(interestField.getText().trim()) / 100 / 12;
//                if (rate <= 0) {
//                    interestError.setText("Rate must be positive.");
//                    isValid = false;
//                }
//            } catch (NumberFormatException ex) {
//                interestError.setText("Invalid rate! Enter a valid percentage.");
//                isValid = false;
//            }
//
//            int tenure = 0;
//            try {
//                tenure = Integer.parseInt(tenureField.getText().trim()) * 12;
//                if (tenure <= 0) {
//                    tenureError.setText("Tenure must be at least 1 year.");
//                    isValid = false;
//                }
//            } catch (NumberFormatException ex) {
//                tenureError.setText("Invalid tenure! Enter whole numbers.");
//                isValid = false;
//            }
//
//            if (isValid) {
//                double emi = (Double.parseDouble(amountField.getText()) * rate * Math.pow(1 + rate, tenure)) / (Math.pow(1 + rate, tenure) - 1);
//                resultLabel.setText(String.format("<html><b>EMI: ₹ %.2f</b></html>", emi));
//            } else {
//                resultLabel.setText("<html><b style='color: red;'>Fix the errors above</b></html>");
//            }
//        });
//
//        // Adding components in the form
//        addComponent(formPanel, gbc, amountLabel, 0, 0);
//        addComponent(formPanel, gbc, amountField, 1, 0);
//        addComponent(formPanel, gbc, amountHint, 1, 1);
//        addComponent(formPanel, gbc, amountError, 1, 2);
//
//        addComponent(formPanel, gbc, interestLabel, 0, 3);
//        addComponent(formPanel, gbc, interestField, 1, 3);
//        addComponent(formPanel, gbc, interestHint, 1, 4);
//        addComponent(formPanel, gbc, interestError, 1, 5);
//
//        addComponent(formPanel, gbc, tenureLabel, 0, 6);
//        addComponent(formPanel, gbc, tenureField, 1, 6);
//        addComponent(formPanel, gbc, tenureHint, 1, 7);
//        addComponent(formPanel, gbc, tenureError, 1, 8);
//
//        gbc.gridwidth = 2;
//        gbc.gridx = 0;
//        gbc.gridy = 9;
//        formPanel.add(calculateButton, gbc);
//
//        gbc.gridy = 10;
//        formPanel.add(resultLabel, gbc);
//
//        add(formPanel, BorderLayout.CENTER);
//    }
//
//    private void addComponent(JPanel panel, GridBagConstraints gbc, JComponent comp, int x, int y) {
//        gbc.gridx = x;
//        gbc.gridy = y;
//        gbc.gridwidth = (comp instanceof JLabel && x == 1) ? 2 : 1;
//        panel.add(comp, gbc);
//    }
//}
//
//


import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class LoanCalculatorPage extends JPanel {
    public LoanCalculatorPage(UIManager uiManager) {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding

        // Title Label
        JLabel titleLabel = new JLabel("<html><h2 style='color: #2C3E50;'>Loan Calculator</h2><p style='color: #7F8C8D;'>Enter loan details to calculate EMI.</p></html>", SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        // Form Panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Enter Loan Details"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); // Padding between components
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Loan Amount Field
        JLabel amountLabel = new JLabel("Loan Amount: *");
        JTextField amountField = new JTextField(15);
        JLabel amountHint = new JLabel("<html><i style='color: #7F8C8D;'>Enter a valid loan amount (e.g., 500000)</i></html>");
        JLabel amountError = new JLabel("", SwingConstants.RIGHT);
        amountError.setForeground(Color.RED);

        // Interest Rate Field
        JLabel interestLabel = new JLabel("Interest Rate (%): *");
        JTextField interestField = new JTextField(15);
        JLabel interestHint = new JLabel("<html><i style='color: #7F8C8D;'>Enter a valid interest rate (e.g., 7.5)</i></html>");
        JLabel interestError = new JLabel("", SwingConstants.RIGHT);
        interestError.setForeground(Color.RED);

        // Loan Tenure Field
        JLabel tenureLabel = new JLabel("Loan Tenure (years): *");
        JTextField tenureField = new JTextField(15);
        JLabel tenureHint = new JLabel("<html><i style='color: #7F8C8D;'>Enter tenure in years (e.g., 15)</i></html>");
        JLabel tenureError = new JLabel("", SwingConstants.RIGHT);
        tenureError.setForeground(Color.RED);

        // Calculate Button
        JButton calculateButton = new JButton("Calculate EMI"); // Button text is set here
        calculateButton.setBackground(new Color(39, 174, 96)); // Green color
        calculateButton.setForeground(Color.BLACK);
        calculateButton.setFocusPainted(false);

        // Result Label
        JLabel resultLabel = new JLabel("<html><b>EMI: -</b></html>");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setForeground(new Color(39, 174, 96)); // Green color

        // Add components to the form
        addComponent(formPanel, gbc, amountLabel, 0, 0);
        addComponent(formPanel, gbc, amountField, 1, 0);
        addComponent(formPanel, gbc, amountHint, 1, 1);
        addComponent(formPanel, gbc, amountError, 1, 2);

        addComponent(formPanel, gbc, interestLabel, 0, 3);
        addComponent(formPanel, gbc, interestField, 1, 3);
        addComponent(formPanel, gbc, interestHint, 1, 4);
        addComponent(formPanel, gbc, interestError, 1, 5);

        addComponent(formPanel, gbc, tenureLabel, 0, 6);
        addComponent(formPanel, gbc, tenureField, 1, 6);
        addComponent(formPanel, gbc, tenureHint, 1, 7);
        addComponent(formPanel, gbc, tenureError, 1, 8);

        // Calculate Button and Result Label
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 9;
        formPanel.add(calculateButton, gbc);

        gbc.gridy = 10;
        formPanel.add(resultLabel, gbc);

        // Add form panel to the main panel
        add(formPanel, BorderLayout.CENTER);

        // Validation and Calculation Logic
        calculateButton.addActionListener(e -> {
            boolean isValid = true;
            amountError.setText("");
            interestError.setText("");
            tenureError.setText("");

            // Validate Loan Amount
            double amount = 0;
            try {
                amount = Double.parseDouble(amountField.getText().trim());
                if (amount <= 0) {
                    amountError.setText("Amount must be greater than 0");
                    isValid = false;
                }
            } catch (NumberFormatException ex) {
                amountError.setText("Invalid amount! Enter numbers only.");
                isValid = false;
            }

            // Validate Interest Rate
            double rate = 0;
            try {
                rate = Double.parseDouble(interestField.getText().trim()) / 100 / 12;
                if (rate <= 0) {
                    interestError.setText("Rate must be positive.");
                    isValid = false;
                }
            } catch (NumberFormatException ex) {
                interestError.setText("Invalid rate! Enter a valid percentage.");
                isValid = false;
            }

            // Validate Loan Tenure
            int tenure = 0;
            try {
                tenure = Integer.parseInt(tenureField.getText().trim()) * 12;
                if (tenure <= 0) {
                    tenureError.setText("Tenure must be at least 1 year.");
                    isValid = false;
                }
            } catch (NumberFormatException ex) {
                tenureError.setText("Invalid tenure! Enter whole numbers.");
                isValid = false;
            }

            // Calculate EMI if all inputs are valid
            if (isValid) {
                double emi = (amount * rate * Math.pow(1 + rate, tenure)) / (Math.pow(1 + rate, tenure) - 1);
                DecimalFormat df = new DecimalFormat("#,##0.00");
                resultLabel.setText(String.format("<html><b>EMI: ₹ %s</b></html>", df.format(emi)));
            } else {
                resultLabel.setText("<html><b style='color: red;'>Fix the errors above</b></html>");
            }
        });
    }

    // Helper method to add components to the form
    private void addComponent(JPanel panel, GridBagConstraints gbc, JComponent comp, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = (comp instanceof JLabel && x == 1) ? 2 : 1;
        panel.add(comp, gbc);
    }
}