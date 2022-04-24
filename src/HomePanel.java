import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;

public class HomePanel extends JPanel {
    JTextArea text1;
    public HomePanel(){
        super();
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        text1 = new JTextArea("Hello my friends");
        add(text1,BorderLayout.NORTH);

    }
}
