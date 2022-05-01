import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class HomePanel extends JPanel {
    JTextArea text1;
    JButton testButton;
    public HomePanel(){
        super();
        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        testButton =new JButton("Press me to test");
        add(testButton,BorderLayout.SOUTH);

        JPanel topPanel = new JPanel();
        BoxLayout topLayout = new BoxLayout(topPanel, BoxLayout.PAGE_AXIS);
        topPanel.setLayout(topLayout);
        try {
            BufferedImage officepic = ImageIO.read(new File("D:/My_Projects/OfficeApp/r/office.png"));
            JLabel piclabel = new JLabel(new ImageIcon(officepic.getScaledInstance(200, 200, Image.SCALE_FAST)));
            piclabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            topPanel.add(piclabel);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        JLabel text = new JLabel("OfficeApp by Team2");
        text.setAlignmentX(Component.CENTER_ALIGNMENT);
        topPanel.add(text);
        add(topPanel,BorderLayout.NORTH);
       

    }

    public JButton getTestButton(){
        return testButton;
    }
}
