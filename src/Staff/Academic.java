package Staff;

public class Academic extends Staff implements Salary{
    private static double basic = 2000;
    private double increment;
    private int level;
    private String title;
    public Academic(String name, int level){
        super(name);
        this.level = level;
        increment = 0;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public double getSalary() {
        return basic + increment;
    }

    public void Increase(double amount){
        increment += amount;
    }

    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }


}
