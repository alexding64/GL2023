public class Component 
{
	
    private String name;
    private int total_usage;

    public Component(String name) 
    {
        this.name = name;
        this.total_usage = 0;
    }
    

    
<<<<<<< HEAD
    public void reset_total_usage()
    {
        this.total_usage = 0;
    }
    
    /**
     * GETTER & SETTER
     */
    
    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getTotalUsage() 
    {
        return total_usage;
    }

    public void setTotalUsage(int total_usage) 
    {
=======
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
>>>>>>> 5ffa70956c5fa63be3941857ae331ff899682973
        this.total_usage = total_usage;
    }
}
