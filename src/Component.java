public class Component 
{
	
    private String name;
    private int totalUsage;

    public Component(String name) 
    {
        this.name = name;
        this.totalUsage = 0;
    }

    public void resetTotalUsage()
    {
        this.totalUsage = 0;
    }
    
    /*
    * 
    * Class Getter and Setter
    * 
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
        return totalUsage;
    }

    public void setTotalUsage(int totalUsage)
    {
        this.totalUsage = totalUsage;
    }
}
