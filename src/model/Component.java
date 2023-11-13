package model;

public class Component
{
	
    private String name;
    private int totalUsage;

    /**
     * Constructor of Component class
     * @param name the component name
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
     * @return name of the component
     */
    public String getName() 
    {
        return name;
    }

    /**
     * Setter of name
     * @param name of the component
     */
    public void setName(String name) 
    {
        this.name = name;
    }

    /**
     * Getter of totalUsage
     * @return totalUsage the usage of the component
     */
    public int getTotalUsage() 
    {
        return totalUsage;
    }

    /**
     * Setter of totalUsage
     * @param totalUsage the usage of the component
     */
    public void setTotalUsage(int totalUsage)
    {
        this.totalUsage = totalUsage;
    }
}
