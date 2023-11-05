package model;

public class AdditionNTest extends Test
{
	
    private String matrix1;
    private String matrix2;
    private String result;


    /**
     * Constructor of AdditionNTest class
     * @param matrix1
     * @param matrix2
     * @param result
     */
    public AdditionNTest(String matrix1, String matrix2, String result)
    {
        super();
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = result;
    }

    /**
     * GETTER & SETTER
     */

    /**
     * Getter of matrix1
     * @return matrix1
     */
    public String getMatrix1()
    {
        return matrix1;
    }

    /**
     * Setter of matrix1
     * @param matrix1
     */
    public void setMatrix1(String matrix1)
    {
        this.matrix1 = matrix1;
    }

    /**
     * Getter of matrix2
     * @return matrix2
     */
    public String getMatrix2()
    {
        return matrix2;
    }

    /**
     * Setter of matrix2
     * @param matrix2
     */
    public void setMatrix2(String matrix2)
    {
        this.matrix2 = matrix2;
    }

    /**
     * Getter of Result
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
