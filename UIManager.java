import javax.swing.*;
import java.awt.*;

public class UIManager {
    private JFrame frame;
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public UIManager() {
        frame = new JFrame("Intelligent Loan Decision System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Add pages
        cardPanel.add(new WelcomePage(this), "Welcome");
        cardPanel.add(new LoanSelectionPage(this), "LoanSelection");
        cardPanel.add(new LoanCalculatorPage(this), "LoanCalculator");

        frame.add(cardPanel);
        frame.setVisible(true);
    }

    public void showWelcomePage() {
        cardLayout.show(cardPanel, "Welcome");
    }

    public void showLoanSelectionPage() {
        cardLayout.show(cardPanel, "LoanSelection");
    }

    public void showLoanCalculatorPage() {
        cardLayout.show(cardPanel, "LoanCalculator");
    }
}
