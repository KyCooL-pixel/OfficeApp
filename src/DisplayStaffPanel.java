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
    Font font = new Font("Arial", Font.CENTER_BASELINE, 16);
    Font font2 = new Font("Corona", Font.CENTER_BASELINE, 20);
    DecimalFormat df = new DecimalFormat("0.00");

    DisplayStaffPanel displayStaffPanel;
    JLabel name_label;
    JLabel title_label;
    JLabel salary_label;
    JLabel level_label;
    JLabel status_label;
    
    
    public DisplayStaffPanel(){
        BoxLayout infoBox = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        setLayout(infoBox);
        
        // components of infoBox
        name_label = new JLabel("   Name :    " + na);
        title_label = new JLabel("   Title :    " + na);
        salary_label = new JLabel("   Total Salary :    " + na);
        level_label = new JLabel("   Level :    " + na);
        status_label =  new JLabel("   Status :    " + na);

        // Grouping them together
        JComponent[] components = {name_label,title_label,salary_label,level_label,status_label};

        // Styling components
        // TODO should separate static label and actual attributes of staff
        for(JComponent component :components){
            component.setAlignmentX(Component.LEFT_ALIGNMENT);
            component.setMinimumSize(new Dimension(3000,30));
            component.setPreferredSize(new Dimension(5000,30));
            component.setFont(font);
            component.setForeground(Color.BLUE);
            add(Box.createRigidArea(new Dimension(0,30)));
            add(component);
        }
    }
    // refresh the labels
    public void setInfo(Staff staff){
        name_label.setText("    Name :    " + staff.getName());
        if(staff instanceof Educator){
            Educator educator = (Educator) staff;
            title_label.setText("   Title :    " + educator.getTitle());
            salary_label.setText("  Total Salary :    " + df.format(educator.getSalary()));
            level_label.setText("   Level :    " + educator.getLevel());
            status_label.setText("   Status :    " + "N/A");
        }
        else if(staff instanceof Support){
            Support support = (Support) staff;
            title_label.setText("   Title :    " + Support.getTitle());
            salary_label.setText("   Total Salary :    " + df.format(support.getSalary()));
            level_label.setText("   Level :    " + "N/A");
            status_label.setText("   Status :    " + support.getStatus());
        }

        else if(staff instanceof Admin){
            Admin admin = (Admin) staff;
            title_label.setText("   Title :    " + Admin.getTitle());
            salary_label.setText("   Total Salary :    " + df.format(admin.getSalary()));
            level_label.setText("   Level :    " + "N/A");
            status_label.setText("   Status :    " + "N/A");
        }

        else if(staff instanceof Researcher){
            Researcher researcher = (Researcher) staff;
            title_label.setText("   Title :    " + researcher.getTitle());
            salary_label.setText("  Total Salary :    " + df.format(researcher.getSalary()));
            level_label.setText("   Level :    " + researcher.getLevel());
            status_label.setText("   Status :    " + "N/A");

        }

    }

    public void setNull(){
        name_label.setText("   Name :    " + na);
        title_label.setText("   Title :    " + na);
        salary_label.setText("   Total Salary :    " + na);
        level_label.setText("   Level :    " + na);
        status_label.setText("   Status :    " + na);

    }
    
}
