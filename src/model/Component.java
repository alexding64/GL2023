package model;

public class Component
{
	
    private String name;
    private int totalUsage;

    /**
     * Constructor of Component class
     * @param name
     */
    public Component(String name) 
    {
        this.name = name;
        this.totalUsage = 0;
    }

    /**
     * Reset the component's total usage
     */
    public void resetTotalUsage()
    {
        this.totalUsage = 0;
    }
    
    /*
    * 
    * Class Getter and Setter
    * 
    */

    /**
     * Getter of name
     * @return name
     */
    public String getName() 
    {
        return name;
    }

    /**
     * Setter of name
     * @param name
     */
    public void setName(String name) 
    {
        this.name = name;
    }

    /**
     * Getter of totalUsage
     * @return totalUsage
     */
    public int getTotalUsage() 
    {
        return totalUsage;
    }

    /**
     * Setter of totalUsage
     * @param totalUsage
     */
    public void setTotalUsage(int totalUsage)
    {
        this.totalUsage = totalUsage;
    }
}
