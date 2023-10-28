public class AdditionNTest 
{
	
    public String matrix1;
    public String matrix2;
    public String result;
    

    public AdditionNTest(String matrix1, String matrix2, String result)
    {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = result;
    }

    /**
     * GETTER & SETTER
     */
    
    public String getMatrix1() {
        return matrix1;
    }

    public void setMatrix1(String matrix1) {
        this.matrix1 = matrix1;
    }

    public String getMatrix2() {
        return matrix2;
    }

    public void setMatrix2(String matrix2) {
        this.matrix2 = matrix2;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
}
