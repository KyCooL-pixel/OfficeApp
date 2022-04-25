import java.awt.*;
import javax.swing.*;
import java.text.DecimalFormat;

import Staff.*;

import java.awt.event.*;

public class Gui {
    // Config fonts and styles
    Font font = new Font("Arial", Font.CENTER_BASELINE, 20);
    Font font2 = new Font("Corona", Font.CENTER_BASELINE, 20);
    DecimalFormat df = new DecimalFormat("0.00");

    // Initialize frame
    JFrame frame1;

    // Initialize panels
    JTabbedPane tabbedPane = new JTabbedPane();
    
    // declare homepanel (panel1) and its components
    HomePanel panel1 = new HomePanel();
    JTextArea text1;
    JButton button;
    
    //declare staffpanel (panel2) and its components
    StaffPanel panel2 = new StaffPanel();
    // searchbox : border
    JPanel topsearchbox;
    JTextField searchField;
    JButton searchButton;
    JButton addButton;
    //displayzonepanel :
    DisplayStaffPanel displayStaffPanel;
    JLabel name_label;
    JLabel title_label;
    JLabel salary_label;
    JLabel level_label;


    Staff currentStaff;

    public static void main(String[] args){
        new Gui().buildGUI();
    }
    public void buildGUI(){
        //setting up frame
        frame1 = new JFrame("Test");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //setting up background and its layout : borderlayout here
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(0, 2, 5, 2));
        background.setBounds(500, 100, 600, 600);
        Color bgColor = new Color(173,216,230);
        background.setBackground(bgColor);
        
        //Pointing objects
        button = panel1.getTestButton();
        searchField = panel2.getSearchField();
        searchButton = panel2.getSearchButton();
        addButton = panel2.getAddButton();
        displayStaffPanel = panel2.getDisplayStaffPanel();

        //adding listeners for staffpanel components
        button.addActionListener(new testListener());
        searchField.addActionListener(new searchFieldListener());
        searchField.addFocusListener(new searchFieldFocusListener());
        searchButton.addActionListener(new searchButtonListener());
        addButton.addActionListener(new addButtonListener());


        // adding panels to tab pane
        tabbedPane.add("    Home    ",panel1);
        tabbedPane.add("    Staff   ", panel2);

        // Configure tabbedPane
        tabbedPane.setBackgroundAt(0,Color.WHITE);
        tabbedPane.setBackground(new Color(0,0,0,0));
        tabbedPane.setForeground(Color.GRAY);
        tabbedPane.setFont(font);

        // adding tabbedpane to background
        background.add(tabbedPane);


        // adding background to frame
        frame1.getContentPane().add(background);

        //set bounds for frame
        frame1.setBounds(500,100,700 ,700);
        
        //pack
        //frame1.pack();
        
        //show frame
        frame1.setVisible(true);
    }

    // StaffPanel class : P2
    
    public class searchFieldListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            searchButton.doClick();
            
        }
            
    }

    public class searchFieldFocusListener implements FocusListener{
        @Override
        public void focusGained(FocusEvent e) {
            searchField.requestFocusInWindow();
            searchField.selectAll();
        }
        @Override
        public void focusLost(FocusEvent e) {}
    }

    public class searchButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String tempholder = searchField.getText();
            boolean isExist = Logic.checkStaffExist(tempholder);
            if(isExist){
                currentStaff = Logic.fetchStaff();
                System.out.println(currentStaff);
                System.out.println("FOUND !!");
                // Refresh the staff info page
                displayStaffPanel.setInfo(currentStaff);
            }
            else{
                System.out.println("NOT IN THE SYSTEM ,PLS ADD IT NOW !");
            }
        }
    }

    public class addButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String tempholder = searchField.getText();
            boolean isExist = Logic.checkStaffExist(tempholder);
            if(!isExist){
                // TODO do some actual adding here with JDialog requesting info
                Logic.addstaff(tempholder,2);
                System.out.println("Is added!! do testing now!!");
            }
            else{
                System.out.println("Already in the system !");
            }
        }

    }

    public class testListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Im called !!  time to refactor !!");
        }

    }
}
