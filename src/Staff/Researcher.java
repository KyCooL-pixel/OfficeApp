package Staff;

public class Researcher extends Academic {
    private double allowance = 500;
    private static String title = "Researcher";
    public Researcher(String name,String matric,int level) {
        super(name,matric, level);
    }

    public double getSalary(){
        return allowance + super.getSalary() + super.getLevel()*1000;
    }

    public String getTitle(){
        return title;
    }
    
}
