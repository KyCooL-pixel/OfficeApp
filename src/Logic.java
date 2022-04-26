import java.util.ArrayList;

import Staff.*;

public class Logic {
     static ArrayList<Staff> staffs = new ArrayList<>();
     private static int ref;
     public Logic(){
         // TODO remove these dummy objects later on, this is just doing the job of deserialisation
        staffs.add(new Educator("Ali","A12345",2));
        staffs.add(new Educator("Abu","A22345",2));
        staffs.add(new Educator("Akao","A32345",2));
        staffs.add(new Support("emily","A42345","Permanent"));
        staffs.add(new Admin("brace","A52345", 5));
        staffs.add(new Researcher("mia","A62345",5));
     }

     public static ArrayList<Staff> getstaffs(){
         return staffs;
     }

     public static void addstaff(String name,int level){
     }

     public static void removestaff(Staff staff){
         staffs.remove(staff);
     }
    
     public static boolean checkStaffExist(String name){
        for(Staff staff: staffs){
            if(staff.getName().equals(name)){
                ref = staffs.indexOf(staff);
                return true;
            }
        }
        return false;
     }

    public static Staff fetchStaff(){
        return staffs.get(ref);
    }
}
