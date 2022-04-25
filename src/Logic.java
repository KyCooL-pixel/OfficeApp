import java.util.ArrayList;

import Staff.*;

public class Logic {
     static ArrayList<Staff> staffs = new ArrayList<>();
     private static int ref;
     public Logic(){
         // TODO remove these dummy objects later on, this is just doing the job of deserialisation
        staffs.add(new Educator("Ali",2));
        staffs.add(new Educator("Abu",2));
        staffs.add(new Educator("Akao",2));
        staffs.add(new Support("emily","Permanent"));
        staffs.add(new Admin("brace"));
        staffs.add(new Researcher("mia",5));
     }

     public static ArrayList<Staff> getstaffs(){
         return staffs;
     }

     public static void addstaff(String name,int level){
         staffs.add(new Educator(name,level));
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