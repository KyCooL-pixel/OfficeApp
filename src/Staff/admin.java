package Staff;

public class admin extends NonAcademic {
    private static double stocks = 1000;
    private String type;
    public admin(String name,String type) {
        super(name);
        this.setType(type);
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public double getSalary() {
        return super.getSalary() + stocks;
    }
    
}
