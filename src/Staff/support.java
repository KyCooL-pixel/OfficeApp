package Staff;

public class support extends NonAcademic{
    private boolean isPermanent;
    public support(String name,boolean isPermanent) {
        super(name);
        this.setPermanent(isPermanent);
    }
    public boolean isPermanent() {
        return isPermanent;
    }
    public void setPermanent(boolean isPermanent) {
        this.isPermanent = isPermanent;
    }
  
}
