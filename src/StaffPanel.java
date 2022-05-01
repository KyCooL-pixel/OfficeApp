import javax.imageio.ImageIO;
import javax.swing.*;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

public class StaffPanel extends JPanel {
    Font font = new Font("Arial", Font.CENTER_BASELINE, 20);
    Font font2 = new Font("Corona", Font.CENTER_BASELINE, 15);
    DecimalFormat df = new DecimalFormat("0.00");
    
    private JPanel topsearchbox;
    private JPanel bottomControlBox;
    private JTextField searchField;
    private JButton searchButton;
    private JButton addButton;
    private JButton deleteButton;
    private JButton editButton;

    private DisplayStaffPanel displayStaffPanel = new DisplayStaffPanel();
    
    
    public StaffPanel(){
    
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        // setup topbox
        topsearchbox = new JPanel();
        topsearchbox.setBackground(Color.LIGHT_GRAY);
        
        //set up components of topbox
        searchField = new JTextField("Search by Name/Matric ",20);
        searchField.setFont(font2);
        searchButton = new JButton("Search");
        addButton = new JButton("Add");

        // init bottomcontrolbox
        bottomControlBox = new JPanel(new FlowLayout(FlowLayout.TRAILING));

        //init components of bottomcontrolbox
        deleteButton = new JButton("Delete");
        deleteButton.setBackground(Color.RED);
        editButton = new JButton("Edit");

        // add to bottomcontrolbox
        bottomControlBox.add(editButton);
        bottomControlBox.add(deleteButton);
        
        
        //add components to topbox
        topsearchbox.add(searchField);
        topsearchbox.add(searchButton);
        topsearchbox.add(addButton);
        
        // setup displaypanel
        displayStaffPanel = new DisplayStaffPanel();
        JPanel panel = new JPanel();
        panel.add(Box.createRigidArea(new Dimension(20,0)));
        panel.setBackground(Color.WHITE);

        // Adding pic
        try {
            BufferedImage officepic = ImageIO.read(new File("D:/My_Projects/OfficeApp/r/staff.png"));
            JLabel piclabel = new JLabel(new ImageIcon(officepic.getScaledInstance(200, 200, Image.SCALE_FAST)));

            add(piclabel,BorderLayout.EAST);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //add components to panel
        add(topsearchbox,BorderLayout.NORTH);
        add(displayStaffPanel,BorderLayout.CENTER);
        add(panel,BorderLayout.WEST);
        add(bottomControlBox, BorderLayout.SOUTH);
        this.setBackground(Color.WHITE);

    }

    public JPanel getTopSearchBox(){
        return topsearchbox;
    }

    public  JTextField getSearchField(){
        return searchField;
    }

    public JButton getSearchButton(){
        return searchButton;
    }

    public JButton getAddButton(){
        return addButton;
    }

    public JButton getDeleteButton(){
        return deleteButton;
    }

    public JButton getEditButton(){
        return editButton;
    }

    public DisplayStaffPanel getDisplayStaffPanel(){
        return displayStaffPanel;
    }
}
