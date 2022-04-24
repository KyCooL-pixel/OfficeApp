package Staff;

public class Researcher extends Academic {
    private double allowance = 500;
    private static String title = "Researcher";
    public Researcher(String name,int level) {
        super(name, level);
    }

    public double getSalary(){
        return allowance + super.getSalary();
    }

    public String getTitle(){
        return title;
    }
    
}
