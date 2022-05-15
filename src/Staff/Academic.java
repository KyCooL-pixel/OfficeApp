package Staff;


public class Academic extends Staff implements Salary{
    private static double basic = 2000;
    private double increment;
    private int level;
    private String title;
    public Academic(String name, String matric,int level){
        super(name,matric);
        this.level = level;
        increment = 0;
        checkOffice(level);
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

    public void checkOffice(int level){
        if(level > 3)
            setOffice("High");
        else if(level > 1)
            setOffice("Mid");
        else
            setOffice("Low");
    }


}
