package Gui;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Logic.Logic;

public class Addframe extends JFrame {
    private static JDialog addDialog;
    private JButton saveButton;
    private JLabel nameJLabel;
    private JLabel matricJLabel;
    private JTextField matricTextField;
    private JTextField nameTextField;
    private JLabel titJLabel;
    private JComboBox<String> tComboBox;
    private JLabel levelJLabel;
    private JComboBox<Integer> levelComboBox;
    private JLabel statusJLabel;
    private JComboBox<String> statusComboBox;

    

    private ArrayList<String> buildInfo = new ArrayList<String>();


    private JPanel fillInPane;
    String[] titles = {null,"Educator","Researcher","Admin","Support"};
    Integer[] level = {1,2,3,4,5};
    String[] status = {"Permanent","Contract"};

    public Addframe(){
        //setting up dialog
        JFrame f = new JFrame();
        addDialog = new JDialog(f,"Add a new staff ",true);
        addDialog.setLayout(new FlowLayout());
        
        // setting up box panel
        fillInPane = new JPanel();
        fillInPane.setLayout(new BoxLayout(fillInPane, BoxLayout.PAGE_AXIS));

        //setting up components
        saveButton = new JButton("SAVE");

        nameJLabel = new JLabel("Name: ");
        nameTextField = new JTextField(null,15);

        matricJLabel = new JLabel("Matric No: ");
        matricTextField = new JTextField(null,15);

        titJLabel = new JLabel("Title: ");
        tComboBox = new JComboBox<String>(titles);

        levelJLabel = new JLabel("Level: ");
        levelComboBox = new JComboBox<Integer>(level);
        
        statusJLabel = new JLabel("Status: ");
        statusComboBox = new JComboBox<String>(status);

        // adding listeners for components
        saveButton.addActionListener(new saveListener());
        tComboBox.addItemListener(new tComboBoxItemListener());

        // Styling and modifying components
        fillInPane.add(Box.createRigidArea(new Dimension(0,15)));
        

        //adding components to box panel
        JComponent[] components = {
            nameJLabel,
            nameTextField,
            matricJLabel,
            matricTextField,
            titJLabel,
            tComboBox,
            levelJLabel,
            levelComboBox,
            statusJLabel,
            statusComboBox,
            saveButton
        };

        for(JComponent component: components){
            component.setAlignmentX(CENTER_ALIGNMENT);
            fillInPane.add(component);
            fillInPane.add(Box.createRigidArea(new Dimension(0,10)));
        }

        //Hide component until called
        levelComboBox.setEnabled(false);
        statusComboBox.setEnabled(false);


        // adding pane to dialog
        addDialog.add(fillInPane);
        addDialog.setLocation(600, 200);
        addDialog.setSize(350,400);
        addDialog.setVisible(true);   
    }
    
    public class saveListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Extract info from the fields and pass to logic to add
            if(checkInfo()){
                Logic.addstaff(fetchInfo());
                addDialog.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Please enter info correctly!!",
                     "Wrong or Incomplete Info", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public class tComboBoxItemListener implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if(tComboBox.getSelectedItem() == "Support"){
                    statusComboBox.setEnabled(true);
                    levelComboBox.setSelectedItem(level[0]);
                    levelComboBox.setEnabled(false);
                }
                else if(tComboBox.getSelectedItem() == "Select a title"){
                    levelComboBox.setEnabled(false);
                    statusComboBox.setEnabled(false);
                    levelComboBox.setSelectedItem(level[0]);                    
                    statusComboBox.setSelectedItem(status[0]);
                }
                else{
                    statusComboBox.setEnabled(false);
                    statusComboBox.setSelectedItem(status[0]);
                    levelComboBox.setEnabled(true);
                }
            } 
        }
    }

    public ArrayList<String> fetchInfo(){
        // TODO fetch the info from field and return to logic class for adding
        buildInfo.add(nameTextField.getText());
        buildInfo.add(matricTextField.getText());
        buildInfo.add(tComboBox.getSelectedItem().toString());
        if(tComboBox.getSelectedItem() == "Support")
            buildInfo.add(statusComboBox.getSelectedItem().toString());
        else
            buildInfo.add(levelComboBox.getSelectedItem().toString());
        
        return buildInfo;
    }


    // Check whether user input is correct
    public boolean checkInfo(){
        JComponent[] components = {
            nameTextField,
            matricTextField,
            tComboBox,
        };
        if(!(statusComboBox.isEnabled()|| levelComboBox.isEnabled()))
            return false;
        for(JComponent component: components){
            if(component instanceof JTextField){
                JTextField text = (JTextField) component;
                if(text.getText().length() <1)
                    return false; 
            }
            else{
                if(((JComboBox<String>)component).getSelectedItem()==null)
                    return false;
            }
        }
        return true;
    }
}
