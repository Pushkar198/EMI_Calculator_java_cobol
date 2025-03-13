import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UIManager uiManager = new UIManager();
            uiManager.showWelcomePage();
        });
    }
}
