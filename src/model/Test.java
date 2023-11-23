package model;

/** Class used to represent an operation in a test plan
 * @author Alex Ding
 * @version 1
 */
public class Test
{

    private String operationName;

    /**
     * Constructor of Test class
     * @param operationName the name of the operation
     */
    public Test(String operationName)
    {
        this.operationName = operationName;
    }

    public Test()
    {

    }

    /*
     * GETTER & SETTER
     */

    /**
     * Getter of operationName
     * @return operationName the name of the operation
     */
    public String getOperationName() 
    {
        return operationName;
    }

    /**
     * Setter of operationName
     * @param operationName the name of the operation
     */
    public void setOperationName(String operationName)
    {
        this.operationName = operationName;
    }
}
