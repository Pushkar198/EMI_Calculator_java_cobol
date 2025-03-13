import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JPanel {
    public WelcomePage(UIManager uiManager) {
        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("<html><h2>Welcome to the Smart Loan Decision System!</h2><p>Your one-stop solution for making intelligent loan choices.</p></html>", SwingConstants.CENTER);
        add(welcomeLabel, BorderLayout.CENTER);

        JButton nextButton = new JButton("Next →");
        nextButton.addActionListener(e -> uiManager.showLoanSelectionPage());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(nextButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
