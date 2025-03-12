import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class EmiCalculator extends JFrame implements ActionListener {
    private JRadioButton rb1, rb2, rb3;
    private JButton calculateButton;
    private JTextField ptext, rtext, ttext, anstext, tptext, intetext;
    private JLabel movingTitle;
    private Timer timer;
    private int titleX = 10, direction = 1;

    EmiCalculator() {
        setTitle("EMI Calculator");
        setSize(800, 600);
        setMinimumSize(new Dimension(600, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Animated Title Label
        movingTitle = new JLabel(" EMI Calculator ", JLabel.CENTER);
        movingTitle.setFont(new Font("Serif", Font.BOLD, 30));
        movingTitle.setForeground(Color.RED);
        add(movingTitle, BorderLayout.NORTH);
        startTitleAnimation();

        // Main Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Loan Type Selection
        JLabel subtitle = new JLabel("Select Loan Type:");
        subtitle.setFont(new Font("Serif", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(subtitle, gbc);

        rb1 = new JRadioButton("Personal Loan");
        rb2 = new JRadioButton("Home Loan");
        rb3 = new JRadioButton("Car Loan");

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);

        JPanel radioPanel = new JPanel();
        radioPanel.add(rb1);
        radioPanel.add(rb2);
        radioPanel.add(rb3);
        gbc.gridx = 1;
        panel.add(radioPanel, gbc);

        // Loan Details
        addLabeledField(panel, gbc, "Loan Amount (₹):", 1, ptext = new JTextField(15));
        addLabeledField(panel, gbc, "Rate of Interest (% per year):", 2, rtext = new JTextField(15));
        addLabeledField(panel, gbc, "Loan Term (months):", 3, ttext = new JTextField(15));

        // Calculate Button
        calculateButton = new JButton("Calculate EMI");
        calculateButton.setFont(new Font("Arial", Font.BOLD, 16));
        calculateButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(calculateButton, gbc);

        // Results
        gbc.gridwidth = 1;
        addLabeledField(panel, gbc, "Loan EMI (₹):", 5, anstext = new JTextField(15));
        anstext.setEditable(false);
        addLabeledField(panel, gbc, "Total Interest (₹):", 6, intetext = new JTextField(15));
        intetext.setEditable(false);
        addLabeledField(panel, gbc, "Total Payment (₹):", 7, tptext = new JTextField(15));
        tptext.setEditable(false);

        add(panel, BorderLayout.CENTER);

        // Make UI Responsive
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                adjustFontSize(getWidth(), getHeight());
            }
        });

        setVisible(true);
    }

    private void addLabeledField(JPanel panel, GridBagConstraints gbc, String label, int row, JTextField field) {
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel jLabel = new JLabel(label);
        jLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(jLabel, gbc);

        gbc.gridx = 1;
        field.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(field, gbc);
    }

    private void startTitleAnimation() {
        timer = new Timer(50, e -> {
            titleX += direction * 5;
            if (titleX > getWidth() - 200 || titleX < 10) {
                direction *= -1;
            }
            movingTitle.setLocation(titleX, 10);
        });
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double loanAmount = Double.parseDouble(ptext.getText());
            double annualRate = Double.parseDouble(rtext.getText());
            double months = Double.parseDouble(ttext.getText());

            // Validation Checks
            if (loanAmount <= 0 || annualRate <= 0 || months <= 0) {
                JOptionPane.showMessageDialog(this, "Please enter positive values.");
                return;
            }

            // New Loan Amount Limits
            if (rb1.isSelected() && loanAmount > 5000000) {
                JOptionPane.showMessageDialog(this, "Personal Loan max: ₹50,00,000");
                return;
            }
            if (rb2.isSelected() && loanAmount > 50000000) {
                JOptionPane.showMessageDialog(this, "Home Loan max: ₹5 Crore");
                return;
            }
            if (rb3.isSelected() && loanAmount > 10000000) {
                JOptionPane.showMessageDialog(this, "Car Loan max: ₹1 Crore");
                return;
            }

            double monthlyRate = (annualRate / 12) / 100;
            double emi = (loanAmount * monthlyRate * Math.pow(1 + monthlyRate, months)) /
                    (Math.pow(1 + monthlyRate, months) - 1);
            double totalPayment = emi * months;
            double totalInterest = totalPayment - loanAmount;

            anstext.setText(String.format("₹%.2f", emi));
            intetext.setText(String.format("₹%.2f", totalInterest));
            tptext.setText(String.format("₹%.2f", totalPayment));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input! Enter only numbers.");
        }
    }

    private void adjustFontSize(int width, int height) {
        int baseSize = Math.min(width / 40, height / 40);
        movingTitle.setFont(new Font("Serif", Font.BOLD, baseSize + 10));
        ptext.setFont(new Font("Arial", Font.PLAIN, baseSize));
        rtext.setFont(new Font("Arial", Font.PLAIN, baseSize));
        ttext.setFont(new Font("Arial", Font.PLAIN, baseSize));
        anstext.setFont(new Font("Arial", Font.PLAIN, baseSize));
        intetext.setFont(new Font("Arial", Font.PLAIN, baseSize));
        tptext.setFont(new Font("Arial", Font.PLAIN, baseSize));
        calculateButton.setFont(new Font("Arial", Font.BOLD, baseSize + 4));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EmiCalculator::new);
    }
}
