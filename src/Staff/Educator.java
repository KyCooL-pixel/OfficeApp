package Staff;


public class Educator extends Academic{
    private static double allowance = 250;
    private static String title = "Educator";
    public Educator(String name,int level) {
        super(name,level);
    }

    public double getSalary(){
        return allowance + super.getSalary() + super.getLevel()*500;
    }

    public String getTitle(){
        return title;
    }
    
}
