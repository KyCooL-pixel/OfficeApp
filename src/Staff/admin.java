package Staff;

public class Admin extends NonAcademic {
    private static double stocks = 1000;
    private static String title = "Admin";
    private int level;
    public Admin(String name,String matric,int level) {
        super(name,matric);
        this.setLevel(level);
        checkOffice(level);
    }


    public int getLevel() {
        return level;
    }


    public void setLevel(int level) {
        this.level = level;
    }


    public static String getTitle() {
        return title;
    }

    public double getSalary() {
        return super.getSalary() + stocks + 1000*level;
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
