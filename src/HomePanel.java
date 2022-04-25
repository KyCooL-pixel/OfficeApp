import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;

public class HomePanel extends JPanel {
    JTextArea text1;
    JButton testButton;
    public HomePanel(){
        super();
        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        testButton =new JButton("Press me to test");
        text1 = new JTextArea("Hello my friends");
        add(text1,BorderLayout.NORTH);
        add(testButton);

    }

    public JButton getTestButton(){
        return testButton;
    }
}
