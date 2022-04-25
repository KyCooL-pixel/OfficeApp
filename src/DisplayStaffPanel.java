import java.awt.Dimension;
import java.text.DecimalFormat;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

import Staff.*;

public class DisplayStaffPanel extends JPanel{
    String na = " ----- ";
    Font font = new Font("Arial", Font.CENTER_BASELINE, 20);
    Font font2 = new Font("Corona", Font.CENTER_BASELINE, 20);
    DecimalFormat df = new DecimalFormat("0.00");

    DisplayStaffPanel displayStaffPanel;
    JLabel name_label;
    JLabel title_label;
    JLabel salary_label;
    JLabel level_label;
    
    public DisplayStaffPanel(){
        BoxLayout infoBox = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        setLayout(infoBox);
        
        // components of infoBox
        name_label = new JLabel("Name : " + na);
        title_label = new JLabel("Title : " + na);
        salary_label = new JLabel("Total Salary : " + na);
        level_label = new JLabel("Level : " + na);
        add(Box.createRigidArea(new Dimension(0,20)));
        add(name_label);
        add(Box.createRigidArea(new Dimension(0,20)));
        add(title_label);
        add(Box.createRigidArea(new Dimension(0,20)));
        add(salary_label);
        add(Box.createRigidArea(new Dimension(0,20)));
        add(level_label);


    }
    // refresh the labels
    public void setInfo(Staff staff){
        name_label.setText("Name : " + staff.getName());
        if(staff instanceof Educator){
            Educator educator = (Educator) staff;
            title_label.setText("Title : " + educator.getTitle());
            salary_label.setText("Total Salary : " + df.format(educator.getSalary()));
            level_label.setText("Level : " + educator.getLevel());
        }

    }
    
}
