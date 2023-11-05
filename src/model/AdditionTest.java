package model;

public class AdditionTest extends Test
{
	
    private String matrix;

    /**
     * Constructor of AdditionTest class
     * @param name
     * @param matrix
     */
    public AdditionTest(String name, String matrix) 
    {
    	super(name);
        this.matrix = matrix;
    }

    /**
     * GETTER & SETTER
     */

    /**
     * Getter of matrix
     * @return matrix
     */
    public String getMatrix() 
    {
        return matrix;
    }

    /**
     * Setter of matrix
     * @param matrix
     */
    public void setMatrix(String matrix) 
    {
        this.matrix = matrix;
    }
}