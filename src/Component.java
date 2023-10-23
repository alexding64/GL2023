public class Component {
    private String name;
    private int total_usage;

    public Component(String name) 
    {
        this.name = name;
        this.total_usage = 0;
    }
    

    
    public void reset_total_usage(){
        this.total_usage = 0;
    }
    
    /*
    * 
    * Class Getter and Setter
    * 
    */
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalUsage() {
        return total_usage;
    }

    public void setTotalUsage(int total_usage) {
        this.total_usage = total_usage;
    }
}
