package Gui;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import Logic.Logic;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class HomePanel extends JPanel {
    JTextArea text1;
    static JButton testButton;
    JLabel totalstaffLabel;
    static JPanel topPanel;
    static JLabel totalstaff;
    static JLabel moonlabel;
    static JLabel sunlabel;
    Font font = new Font("Serif", Font.CENTER_BASELINE, 30);
    Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);

    static boolean DarkOn = false;

    public HomePanel(){
        super();
        //set homepanel layout
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
       
        //declare panel
        topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.setBackground(Color.WHITE);

        // init and add pic
        try {

            // load pic
            BufferedImage moonpic = ImageIO.read(new File("r/moon.png"));
            moonlabel = new JLabel(new ImageIcon(moonpic.getScaledInstance(50, 50, Image.SCALE_FAST)));
            BufferedImage officepic = ImageIO.read(new File("r/office.png"));
            JLabel piclabel = new JLabel(new ImageIcon(officepic.getScaledInstance(300, 300, Image.SCALE_FAST)));
            BufferedImage sunpic = ImageIO.read(new File("r/sun.png"));
            sunlabel = new JLabel(new ImageIcon(sunpic.getScaledInstance(50, 50, Image.SCALE_FAST)));
            
            // Alignment
            piclabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            sunlabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
            moonlabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            sunlabel.setAlignmentY(Component.TOP_ALIGNMENT);
            moonlabel.setAlignmentY(Component.TOP_ALIGNMENT);
            moonlabel.setVisible(DarkOn);
            sunlabel.setVisible(!DarkOn);

            // add pic to topPanel
            topPanel.add(moonlabel);
            topPanel.add(piclabel);
            topPanel.add(sunlabel);

        } catch (IOException e) {
            e.printStackTrace();
        }

        add(topPanel,BorderLayout.NORTH);
       

        // Mid Panel
        JPanel midpanel = new JPanel();
        BoxLayout midLayout = new BoxLayout(midpanel, BoxLayout.PAGE_AXIS);
        midpanel.setLayout(midLayout);

        JLabel text = new JLabel("OfficeApp by Team2");
        text.setFont(font);
        text.setAlignmentX(Component.CENTER_ALIGNMENT);
        midpanel.add(Box.createRigidArea(new Dimension(0,20)));
        midpanel.add(text);
        totalstaffLabel = new JLabel("Total staff");
        
        totalstaff = new JLabel(" "+(Logic.getTotal())+" ");
        totalstaff.setFont(font);
        totalstaff.setBorder(border);

        totalstaffLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        totalstaff.setAlignmentX(Component.CENTER_ALIGNMENT);
        midpanel.add(Box.createRigidArea(new Dimension(0,20)));
        midpanel.add(totalstaffLabel);
        midpanel.add(Box.createRigidArea(new Dimension(0,5)));
        midpanel.add(totalstaff);
        

        // Botpanel for darkmode button (named as test button in gui, as im lazy to change)
        JPanel botpanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));

        try {
            BufferedImage refreshpic = ImageIO.read(new File("r/dark.png"));
            testButton= new JButton(new ImageIcon(refreshpic.getScaledInstance(35, 35, Image.SCALE_FAST)));
            testButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            testButton.setBackground(Color.WHITE);

            botpanel.add(testButton);
        } catch (IOException e) {
            e.printStackTrace();
        }

        botpanel.add(testButton,BorderLayout.SOUTH);

        add(midpanel,BorderLayout.CENTER);
        add(botpanel,BorderLayout.SOUTH);
    }

    public JButton getTestButton(){
        return testButton;
    }

    // Called every time when add/delete action success
    public static void refresh(){
        totalstaff.setText(" "+Logic.getTotal()+" ");
    }


    // DarkMode On/off
    public static void OnOffTheme(){
        if(DarkOn){
            testButton.setBackground(Color.GRAY);
            topPanel.setBackground(Color.GRAY);
        }
        else{
            testButton.setBackground(Color.WHITE);
            topPanel.setBackground(Color.WHITE);
        }
        moonlabel.setVisible(DarkOn);
        sunlabel.setVisible(!DarkOn);
    }

    // Flip boolean for DarkOn
    public static void flip() {
        DarkOn = !DarkOn;
    }
}
