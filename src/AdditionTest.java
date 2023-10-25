public class AdditionTest extends Test
{
	
    public String matrix;
    
    public AdditionTest(String name, String matrix) 
    {
    	super(name);
        this.matrix = matrix;
    }

    /**
     * GETTER & SETTER
     */
    
    public String getMatrix() 
    {
        return matrix;
    }

    public void setMatrix(String matrix) 
    {
        this.matrix = matrix;
    }
}
