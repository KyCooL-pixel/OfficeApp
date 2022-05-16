package Office;

import Staff.*;

public class Office {
    private int capacity;
    private int occupied = 0; 
    private Staff[] officestaffs;

    public Office(int capacity){
        this.capacity = capacity;
        officestaffs = new Staff[capacity];
    }

    public void newStaff(Staff staff){
        if(occupied<capacity-1)
            officestaffs[occupied++] = staff;
    }

    public Office newOffice(){
        return new Office(capacity);
    }

    public int getOccupied(){
        return occupied;
    }

    public int getCapacity(){
        return capacity;
    }

    public Staff[] getStaffs(){
        return officestaffs;
    }

    public void clearOffice(){
        for(int i =0;i< capacity;i++){
            officestaffs[i] = null;
        }
        occupied =0;
    }
}
