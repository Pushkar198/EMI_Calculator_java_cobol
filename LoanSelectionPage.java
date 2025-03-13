import javax.swing.*;
import java.awt.*;

public class LoanSelectionPage extends JPanel {
    public LoanSelectionPage(UIManager uiManager) {
        // Set layout to BoxLayout for vertical alignment
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding around the panel

        // Title label
        JLabel titleLabel = new JLabel("Loan Type Selection", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24)); // Set font size and style
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the title horizontally
        add(titleLabel);

        // Add some vertical space between the title and buttons
        add(Box.createRigidArea(new Dimension(0, 20))); // 20 pixels of vertical space

        // Create buttons and align them vertically
        JButton homeLoanButton = createStyledButton("Home Loan");
        JButton carLoanButton = createStyledButton("Car Loan");
        JButton personalLoanButton = createStyledButton("Personal Loan");
        JButton educationLoanButton = createStyledButton("Education Loan");

        // Add action listeners
        homeLoanButton.addActionListener(e -> uiManager.showLoanCalculatorPage());
        carLoanButton.addActionListener(e -> uiManager.showLoanCalculatorPage());
        personalLoanButton.addActionListener(e -> uiManager.showLoanCalculatorPage());
        educationLoanButton.addActionListener(e -> uiManager.showLoanCalculatorPage());

        // Add buttons to the panel
        add(homeLoanButton);
        add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing between buttons
        add(carLoanButton);
        add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing between buttons
        add(personalLoanButton);
        add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing between buttons
        add(educationLoanButton);
    }

    // Helper method to create styled buttons
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font size
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the button horizontally
        button.setMaximumSize(new Dimension(200, 40)); // Set maximum size for buttons
        button.setBackground(new Color(240, 240, 240)); // Light gray background
        button.setFocusPainted(false); // Remove focus border
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLUE, 1),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)
        )); // Add padding and border
        return button;
    }
}