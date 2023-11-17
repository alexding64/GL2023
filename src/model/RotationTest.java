package model;

public class RotationTest extends Test
{
	
    private String matrix;
    private String result;

    /**
     * Constructor of RotationTest class
     * @param matrix the address of the matrix
     * @param result the address of the result matrix
     */
    public RotationTest(String matrix, String result) 
    {
        super("Rotation");
        this.matrix = matrix;
        this.result = result;
    }

    /**
     * GETTER & SETTER
     */

    /**
     * Getter of matrix
     * @return matrix the address of the matrix
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

    /**
     * Getter of result
     * @return result the address of the result matrix
     */
    public String getResult() 
    {
        return result;
    }

    /**
     * Setter of result
     * @param result the address of the result matrix
     */
    public void setResult(String result) 
    {
        this.result = result;
    }
}
