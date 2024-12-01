import javax.swing.*;
import controller.MainController;
import view.MainView;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainView mainView = new MainView();
            new MainController(mainView);
        });
    }
}
