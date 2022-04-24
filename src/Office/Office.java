package Office;

import java.util.ArrayList;
import Staff.*;

public class Office {
    ArrayList<Staff> staffs = new ArrayList<Staff>();
    public Office(){
        staffs = null;
    }

    public ArrayList<Staff> getStaffs(){
        return staffs;
    }

    public void addStaff(Staff staff){
        staffs.add(staff);
    }
    
}
