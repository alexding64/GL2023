package model;

import java.util.Map;

public class TestPlan 
{

    private Map<String,Matrix> matrices;
    private Test[] tests;

    /**
     * Create a test plan from a file at filename
     * @param filename the file name
     * @return testPlan created
     */
    public static TestPlan fromFile(String filename)
    {
        return new TestPlan();
    }

    /**
     * Get all the matrices
     * @return all the matrices
     */
    public Map<String, Matrix> getMatrices()
    {
        return matrices;
    }

    /**
     * Get all the tests of the test plan
     * @return all the tests
     */
    public Test[] getTests()
    {
        return tests;
    }
}

