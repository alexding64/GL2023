package model;

public class AdditionTest extends Test
{
	
    private String matrix;

    /**
     * Constructor of AdditionTest class
     * @param matrix the address of the matrix
     */
    public AdditionTest(String matrix)
    {
    	super("Addition");
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
     * @param matrix the address of the matrix
     */
    public void setMatrix(String matrix) 
    {
        this.matrix = matrix;
    }
}
