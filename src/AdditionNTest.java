public class AdditionNTest 
{
	
    public String matrix_1;
    public String matrix_2;
    public String result;
    
    public AdditionNTest(String matrix_1, String matrix_2, String result) 
    {
        this.matrix_1 = matrix_1;
        this.matrix_2 = matrix_2;
        this.result = result;
    }

    /**
     * GETTER & SETTER
     */
    
    public String getMatrix1() 
    {
        return matrix_1;
    }

    public void setMatrix1(String matrix_1) 
    {
        this.matrix_1 = matrix_1;
    }

    public String getMatrix2() 
    {
        return matrix_2;
    }

    public void setMatrix2(String matrix_2) 
    {
        this.matrix_2 = matrix_2;
    }

    public String getResult() 
    {
        return result;
    }

    public void setResult(String result) 
    {
        this.result = result;
    }
}
