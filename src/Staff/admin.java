package Staff;

public class Admin extends NonAcademic {
    private static double stocks = 1000;
    private static String title = "Admin";
    public Admin(String name) {
        super(name);
    }


    public static String getTitle() {
        return title;
    }

    public double getSalary() {
        return super.getSalary() + stocks;
    }
}
