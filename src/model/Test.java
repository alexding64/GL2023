package model;

public class Test
{

    private String operationName;

    /**
     * Constructor of Test class
     * @param operationName
     */
    public Test(String operationName)
    {
        this.operationName = operationName;
    }

    public Test() {

    }

    /**
     * GETTER & SETTER
     */

    /**
     * Getter of operationName
     * @return operationName
     */
    public String getOperationName() 
    {
        return operationName;
    }

    /**
     * Setter of operationName
     * @param operationName
     */
    public void setOperationName(String operationName)
    {
        this.operationName = operationName;
    }
}
