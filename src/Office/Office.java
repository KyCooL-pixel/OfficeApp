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
}
