package Logic;

import java.util.ArrayList;

import Staff.*;
import Office.*;

public class Logic {
    static ArrayList<Staff> staffs = new ArrayList<>();
    static ArrayList<Office> offices = new ArrayList<>();
    private static Staff newStaff;
     private static int ref;
     public Logic(){
         // Setting up dummy Staff
        staffs.add(new Educator("Ali","A12345",2));
        staffs.add(new Educator("Abu","A22345",2));
        staffs.add(new Educator("Akao","A32345",2));
        staffs.add(new Support("emily","A42345","Permanent"));
        staffs.add(new Admin("brace","A52345", 5));
        staffs.add(new Researcher("mia","A62345",5));

        //setting up offices, one for each cat
        offices.add(new LowOffice(20));
        offices.add(new MidOffice(10));
        offices.add(new HighOffice(5));

        // Putting staff into offices
        fillOfficeStaff(staffs);

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

         newStaff = staffs.get(staffs.size()-1);
         newOfficeStaff(newStaff);

     }

     public static boolean removestaff(Staff staff){
        int before = staffs.size(); 
        staffs.remove(staff);
        clearAllOffice();
        fillOfficeStaff(staffs);
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

    public static void newOfficeStaff(Staff staff){
        switch(staff.getOffice()){
            case "Low": offices.get(0).newStaff(staff); break;
            case "Mid": offices.get(1).newStaff(staff); break;
            case "High": offices.get(2).newStaff(staff); break;
        }
    }

    public static void fillOfficeStaff(ArrayList<Staff> staffs){
        for(Staff staffie: staffs){
            newOfficeStaff(staffie);
        }
    }

    public static Office fetchOffice(int ref){
        return offices.get(ref);
    }

    public static void clearAllOffice(){
        for(Office office: offices){
            office.clearOffice();
        }
    }
}
