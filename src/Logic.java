import java.util.ArrayList;

import Staff.*;

public class Logic {
     static ArrayList<Staff> staffs = new ArrayList<>();
     public Logic(){
         // TODO remove these dummy objects later on
        staffs.add(new Educator("Ali",2));
        staffs.add(new Educator("Abu",2));
        staffs.add(new Educator("Akao",2));
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
    
}
