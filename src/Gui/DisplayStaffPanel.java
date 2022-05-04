package Gui;
import java.text.DecimalFormat;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

import Staff.*;

public class DisplayStaffPanel extends JPanel{
    String na = " ------------ ";
    Font font = new Font("Arial", Font.CENTER_BASELINE, 14);
    Font font2 = new Font("Serif", Font.CENTER_BASELINE, 20);
    DecimalFormat df = new DecimalFormat("0.00");

    DisplayStaffPanel displayStaffPanel;
    JLabel name_label;
    JLabel matric_label;
    JLabel title_label;
    JLabel salary_label;
    JLabel level_label;
    JLabel status_label;
    JLabel name;
    JLabel matric;
    JLabel title;
    JLabel salary;
    JLabel level;
    JLabel status;


    
    
    public DisplayStaffPanel(){
        BoxLayout infoBox = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        setLayout(infoBox);
        
        // components of infoBox
        name_label = new JLabel(na);
        matric_label = new JLabel(na);
        title_label = new JLabel(na);
        salary_label = new JLabel(na);
        level_label = new JLabel(na);
        status_label =  new JLabel(na);

        name = new JLabel("Name: ");
        matric = new JLabel("Matric No: ");
        title = new JLabel("Title: ");
        salary = new JLabel("Salary: ");
        level = new JLabel("Level: ");
        status = new JLabel("Status: ");
        
        JComponent[] dynamicComponents = {name_label,matric_label,title_label,salary_label,level_label,status_label};
        JComponent[] staticComponents = {name,matric,title,salary,level,status};
        
        for(JComponent staticComp: staticComponents){
            staticComp.setFont(font);
            staticComp.setForeground(Color.RED);
        }

    
        for(JComponent dynamicComponent: dynamicComponents){
            dynamicComponent.setFont(font2);
            dynamicComponent.setForeground(Color.darkGray);
        }

        // Grouping them together
        JComponent[] components = {
            name,
            name_label,
            matric,
            matric_label,
            title,
            title_label,
            salary,
            salary_label,
            level,
            level_label,
            status,
            status_label
        };

        // Styling components
        add(Box.createRigidArea(new Dimension(0,20)));
        for(JComponent component :components){
            component.setAlignmentX(Component.LEFT_ALIGNMENT);
            component.setMinimumSize(new Dimension(3000,30));
            component.setPreferredSize(new Dimension(5000,30));
            add(component);
            add(Box.createRigidArea(new Dimension(0,5)));
        }

        setBackground(Color.WHITE);
    }
    // refresh the labels
    public void setInfo(Staff staff){
        name_label.setText(staff.getName());
        matric_label.setText(staff.getMatric());
        if(staff instanceof Educator){
            Educator educator = (Educator) staff;
            title_label.setText(educator.getTitle());
            salary_label.setText(df.format(educator.getSalary()));
            level_label.setText(""+educator.getLevel());
            status_label.setText( "N/A");
        }
        else if(staff instanceof Support){
            Support support = (Support) staff;
            title_label.setText(Support.getTitle());
            salary_label.setText(df.format(support.getSalary()));
            level_label.setText("N/A");
            status_label.setText(support.getStatus());
        }

        else if(staff instanceof Admin){
            Admin admin = (Admin) staff;
            title_label.setText( Admin.getTitle());
            salary_label.setText(df.format(admin.getSalary()));
            level_label.setText( "N/A");
            status_label.setText( "N/A");
        }

        else if(staff instanceof Researcher){
            Researcher researcher = (Researcher) staff;
            title_label.setText(researcher.getTitle());
            salary_label.setText( df.format(researcher.getSalary()));
            level_label.setText(""+ researcher.getLevel());
            status_label.setText( "N/A");
        }
    }

    public void setNull(){
        JComponent[] dynamicComponents = {name_label,matric_label,title_label,salary_label,level_label,status_label};
        for(JComponent dynamicComponent: dynamicComponents){
            ((JLabel) dynamicComponent).setText(na);

        }

    }
    
}
