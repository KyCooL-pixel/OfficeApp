package Staff;

public class Staff {
    private String name;
    private String matric;
    private String office;
    
    public Staff(String name,String matric){
        this.name = name;
        this.setMatric(matric);
    }

    public String getMatric() {
        return matric;
    }

    public void setMatric(String matric) {
        this.matric = matric;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setOffice(String office){
        this.office = office;
    }

    public void checkOffice(){
    }

    public String getOffice(){
        return office;
    }
    
    
}
