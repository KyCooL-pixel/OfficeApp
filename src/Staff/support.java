package Staff;

public class Support extends NonAcademic{
    private String status;
    private static String title;
    public Support(String name,String status) {
        super(name);
        this.status = status;
        title ="Support";
    }
    public static String getTitle() {
        return title;
    }
    public void setStatus(String status) {
        this.status =status;   
    }

    public String getStatus(){
        return status;
    }
}
