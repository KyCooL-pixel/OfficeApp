import java.awt.*;
import javax.swing.*;

import Staff.*;

import java.awt.event.*;

public class Gui {
    // Config fonts and styles
    Font font = new Font("Arial", Font.CENTER_BASELINE, 20);
    Font font2 = new Font("Corona", Font.CENTER_BASELINE, 20);

    // Initialize frame
    JFrame frame1;

    // Initialize panels
    JTabbedPane tabbedPane = new JTabbedPane();
    
    // declare homepanel (panel1) and its components
    HomePanel panel1 = new HomePanel();
    JTextArea text1;
    
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
        
        //adding listeners for staffpanel components
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
    // HomePanel class : P1
    public class HomePanel extends JPanel {
        public HomePanel(){
            super();
            BorderLayout layout = new BorderLayout();
            setLayout(layout);
            text1 = new JTextArea("Hello my friends");
            text1.setFont(font);
            add(text1,BorderLayout.NORTH);
    
        }
    }

    // StaffPanel class : P2
    public class StaffPanel extends JPanel {
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
    }
    
    // Subpanel (display panel ) of StaffPanel -> display selectedStaff info : Box ?
    public class DisplayStaffPanel extends JPanel{
        String na = " ----- ";
        public DisplayStaffPanel(){
            BoxLayout infoBox = new BoxLayout(this, BoxLayout.PAGE_AXIS);
            setLayout(infoBox);
            
            // components of infoBox
            name_label = new JLabel("Name : " + na);
            title_label = new JLabel("Title : " + na);
            add(name_label);
            add(Box.createRigidArea(new Dimension(0,10)));
            add(title_label);
        }
        // refresh the labels
        public void setInfo(Staff staff){
            name_label.setText("Name : " + staff.getName());
            if(staff instanceof Educator){
                Educator educator = (Educator) staff;
                title_label.setText("Title : " + educator.getTitle());
            }

        }
        
    }
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
                Logic.addstaff(tempholder,2);
                System.out.println("Is added!! do testing now!!");
            }
            else{
                System.out.println("Already in the system !");
            }
        }

    }
}
