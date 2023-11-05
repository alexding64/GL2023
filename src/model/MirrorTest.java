package model;

public class MirrorTest extends Test
{
	
    private String matrix;
    private String result;


	/**
	 * Constructor of MirrorTest class
	 * @param matrix
	 * @param result
	 */
	public MirrorTest(String matrix, String result)
    {
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
	 * @return result
	 */
	public String getResult() 
	{
		return result;
	}

	/**
	 * Setter of result
	 * @param result
	 */
	public void setResult(String result) 
	{
		this.result = result;
	} 
}
