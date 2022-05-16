import Gui.Gui;
import Logic.Logic;

public class App {
    public static void main(String[] args) throws Exception {
        // launch Logic and Gui
        new Logic();
        new Gui().buildGUI();
    }
}


