package model;

public class MirrorTest extends Test
{
	
    private String matrix;
    private String result;


	/**
	 * Constructor of MirrorTest class
	 * @param matrix the address of the matrix
	 * @param result the address of the result matrix
	 */
	public MirrorTest(String matrix, String result)
    {
		super("Mirror");
    	this.matrix = matrix;
    	this.result = result;
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
