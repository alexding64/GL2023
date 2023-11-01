public class AdditionTest extends Test
{
	
    private String matrix;
    
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
