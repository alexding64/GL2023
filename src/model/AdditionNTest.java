package model;

/** Class used to represent the addition operation in a test plan
 * @author Aurélien Paquet
 * @version 1
 */
public class AdditionNTest extends Test
{
	
    private String matrix1;
    private String matrix2;
    private String result;


    /**
     * Constructor of AdditionNTest class
     * @param matrix1 the address of the first matrix
     * @param matrix2 the address of the second matrix
     * @param result the address of the result matrix
     */
    public AdditionNTest(String matrix1, String matrix2, String result)
    {
        super("AdditionN");
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = result;
    }

    /*
     * GETTER & SETTER
     */

    /**
     * Getter of matrix1
     * @return matrix1 the first matrix
     */
    public String getMatrix1()
    {
        return matrix1;
    }

    /**
     * Setter of matrix1
     * @param matrix1 the first matrix
     */
    public void setMatrix1(String matrix1)
    {
        this.matrix1 = matrix1;
    }

    /**
     * Getter of matrix2
     * @return matrix2 the second matrix
     */
    public String getMatrix2()
    {
        return matrix2;
    }

    /**
     * Setter of matrix2
     * @param matrix2 the second matrix
     */
    public void setMatrix2(String matrix2)
    {
        this.matrix2 = matrix2;
    }

    /**
     * Getter of Result
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
