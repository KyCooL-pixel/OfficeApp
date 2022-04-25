import javax.swing.*;


import java.awt.*;
import java.text.DecimalFormat;

public class StaffPanel extends JPanel {
    Font font = new Font("Arial", Font.CENTER_BASELINE, 20);
    Font font2 = new Font("Corona", Font.CENTER_BASELINE, 20);
    DecimalFormat df = new DecimalFormat("0.00");
    
    JPanel topsearchbox;
    JTextField searchField;
    JButton searchButton;
    JButton addButton;

    DisplayStaffPanel displayStaffPanel = new DisplayStaffPanel();
    
    public StaffPanel(){
        super();
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        // setup topbox
        topsearchbox = new JPanel();
        topsearchbox.setBackground(Color.LIGHT_GRAY);
        
        //set up components of topbox
        searchField = new JTextField("Enter staff name here ( case sensitive ) ",25);
        searchField.setFont(font2);
        searchButton = new JButton("Search");
        addButton = new JButton("Add");

    
        //add components to topbox
        topsearchbox.add(searchField);
        topsearchbox.add(searchButton);
        topsearchbox.add(addButton);
        
        // setup displaypanel
        displayStaffPanel = new DisplayStaffPanel();
        //add topbox to panel
        add(topsearchbox,BorderLayout.NORTH);
        add(displayStaffPanel,BorderLayout.CENTER);
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

    public DisplayStaffPanel getDisplayStaffPanel(){
        return displayStaffPanel;
    }
}
