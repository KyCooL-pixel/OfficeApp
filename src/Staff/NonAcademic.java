package Staff;

public class NonAcademic extends Staff implements Salary{
    private static double basic = 1500;
    private double increment;
    private int level;
    public NonAcademic(String name,String matric){
        super(name,matric);
        increment =0;
    }
    @Override
    public double getSalary() {
        return basic + increment;
    }

}
