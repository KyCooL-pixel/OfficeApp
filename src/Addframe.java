import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Addframe extends JFrame {
    private static JDialog addDialog;
    private JButton check;
    private JLabel nameJLabel;
    private JTextField nameTextField;
    private JComboBox tComboBox;
    private JPanel fillInPane;
    String[] titles = {"Educator","Researcher","Admin","Support"};

    public Addframe(){
        //setting up dialog
        JFrame f = new JFrame();
        addDialog = new JDialog(f,"Add a new staff ",true);
        addDialog.setLayout(new FlowLayout());
        
        // setting up box panel
        fillInPane = new JPanel();
        fillInPane.setLayout(new BoxLayout(fillInPane, BoxLayout.PAGE_AXIS));
        //setting up components
        check = new JButton("check");
        nameJLabel = new JLabel("Name: ");
        nameTextField = new JTextField(15);
        tComboBox = new JComboBox<String>(titles);

        // adding listeners for components
        check.addActionListener(new checkListener());
        tComboBox.addItemListener(new tComboBoxItemListener());
        //adding components to box panel
        fillInPane.add(nameJLabel);
        fillInPane.add(Box.createRigidArea(new Dimension(0,10)));
        fillInPane.add(nameTextField);
        fillInPane.add(Box.createRigidArea(new Dimension(0,30)));
        fillInPane.add(tComboBox);
        fillInPane.add(Box.createRigidArea(new Dimension(0,30)));
        fillInPane.add(check);

        // adding pane to dialog
        addDialog.add(fillInPane);
        addDialog.setLocation(600, 200);
        addDialog.setSize(400,400);
        addDialog.setVisible(true);
    }


    public class checkListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            System.out.println("Test pressed!!");
            addDialog.setVisible(false);
        }
    }

    public class tComboBoxItemListener implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
            // TODO Auto-generated method stub
            if (e.getStateChange() == ItemEvent.SELECTED) {
                 System.out.println(tComboBox.getSelectedItem());
            }   
        }
    }
    
}
