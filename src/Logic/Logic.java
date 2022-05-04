package Logic;

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

     // take buildinfo arraylist, build and add
     public static void addstaff(ArrayList<String> buildInfo){
         switch(buildInfo.get(2)){
             case "Educator":
                staffs.add(new Educator(buildInfo.get(0),buildInfo.get(1),Integer.valueOf(buildInfo.get(3))));
                break;
            case "Researcher":
                staffs.add(new Researcher(buildInfo.get(0),buildInfo.get(1),Integer.valueOf(buildInfo.get(3))));
                break;
            case "Admin":
                staffs.add(new Admin(buildInfo.get(0),buildInfo.get(1),Integer.valueOf(buildInfo.get(3))));
                break;
            case "Support":
                staffs.add(new Support(buildInfo.get(0),buildInfo.get(1),buildInfo.get(3)));
                break;
            
            default:
                System.out.println("An error occured....");
         }
     }

     public static boolean removestaff(Staff staff){
        int before = staffs.size(); 
        staffs.remove(staff);
        if(before==staffs.size())
            return false;
        return true;
         
     }
    
     public static boolean checkStaffExist(String name){
        for(Staff staff: staffs){
            if(staff.getName().equals(name) || staff.getMatric().equals(name)){
                ref = staffs.indexOf(staff);
                return true;
            }
        }
        return false;
     }

    public static Staff fetchStaff(){
        return staffs.get(ref);
    }

    public static int getTotal() {
        return staffs.size();
    }
}
