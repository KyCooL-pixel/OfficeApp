package Staff;

public class NonAcademic extends Staff implements Salary{
    private static double basic = 1500;
    private double increment;
    public NonAcademic(String name){
        super(name);
        increment =0;
    }
    @Override
    public double getSalary() {
        return basic + increment;
    }

}
