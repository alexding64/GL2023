public class RotationTest 
{
	
    private String matrix;
    private String result;
    
    public RotationTest(String matrix, String result) 
    {
        this.matrix = matrix;
        this.result = result;
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

    public String getResult() 
    {
        return result;
    }

    public void setResult(String result) 
    {
        this.result = result;
    }
}
