package model;

/** Class used to represent the mirroring operation in a test plan
 * @author Aurélien Paquet
 * @version 1
 */
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

    /*
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
	 * @param matrix the new matrix
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
