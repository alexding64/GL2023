package model;

import java.util.Map;

/** Class that represent the Computer on which we will execute test plan
 * @author Célian Pithon
 * @version 1
 */
public class Computer 
{
	
    private Memory memory;
    private OutputController outputController;
    private Cpu cpu;
    private TestPlan testPlan;

    /**
     * Constructor of Computer class
     * @param memory of the computer
     * @param outputController of the computer
     * @param cpu of the computer
     * @param testPlan of the computer
     */
    public Computer(Memory memory, OutputController outputController, Cpu cpu, TestPlan testPlan)
    {
        this.memory = memory;
        this.outputController = outputController;
        this.cpu = cpu;
        this.testPlan = testPlan;
    }

    /**
     * Start the execution of the test plan
     */
    public void exec()
    {
    	initMemory(testPlan.getMatrices());
        int totalCost = 0;
        for (Test test : testPlan.getTests())
        {
            int cost = execTest(test);
            totalCost += cost;
            outputController.log("Coût du test : " + cost);
        }
        outputController.log("Coût total du plan de test : " + totalCost);
    }

    /*
     * GETTER & SETTER
     */

    /**
     * Setter of cpu
     * @param cpu of the computer
     */
    public void setCpu(Cpu cpu)
    {
    	this.cpu = cpu;
    }

    /**
     * Setter of memory
     * @param memory of the computer
     */
    public void setMemory(Memory memory)
    {
    	this.memory = memory;
    }

    /**
     * Setter of outputController
     * @param outputController of the computer
     */
    public void setOutputController(OutputController outputController)
    {
    	this.outputController = outputController;
    }

    /**
     * Setter of testPlan
     * @param testPlan chosen
     */
    public void setTestPlan(TestPlan testPlan)
    {
    	this.testPlan = testPlan;
    }

    /**
     * Load matrices in the memory
     * @param mat the matrices we want to use
     */
    private void initMemory(Map<String, Matrix> mat)
    {
        for (Map.Entry<String, Matrix> entry : mat.entrySet())
        {
            String address = entry.getKey();
            Matrix matrix = entry.getValue();
            memory.set(address, matrix);
        }
    }

    /**
     * Launch a test
     * @param test to launch
     * @return cost
     */
    private int execTest(Test test)
    {
        cpu.setTotalCost(0);
        switch (test.getOperationName())
        {
            case "Addition" :
                scalarAddition(((AdditionTest)test).getMatrix());
                break;
            case "AdditionN" :
                scalarNAddition(((AdditionNTest)test).getMatrix1(),
                                            ((AdditionNTest)test).getMatrix2(),
                                            ((AdditionNTest)test).getResult());
                break;
            case "Rotation" :
                rotation(((RotationTest)test).getMatrix(), ((RotationTest)test).getResult());
                break;
            default: // Mirror
                mirror(((MirrorTest)test).getMatrix(), ((MirrorTest)test).getResult());
                break;
        }
        return cpu.getTotalCost();
    }

    /**
     * Execute a scalar addition with the source matrix
     * @param src the address of the source matrix
     */
    private void scalarAddition(String src)
    {
        Matrix matrix = memory.get(src);
        cpu.resolution(matrix);
    }

    /**
     * Execute an addition of two matrices and put the result in the map at dest
     * @param mat1 the address of the first matrix
     * @param mat2 the address of the second matrix
     * @param dest the address of the result matrix
     */
    private void scalarNAddition(String mat1, String mat2, String dest)
    {
        Matrix matrix1 = memory.get(mat1);
        Matrix matrix2 = memory.get(mat2);
        memory.set(dest, cpu.addition(matrix1, matrix2));
    }

    /**
     * Execute a rotation and put the result in the map at dest
     * @param src the address of the source matrix
     * @param dest the address pf the destination matrix
     */
    private void rotation(String src, String dest)
    {
        Matrix matrix = memory.get(src);
        memory.set(dest, cpu.rotation(matrix));
    }

    /**
     * Execute a mirror and put the result int the map at dest
     * @param src the address of the source matrix
     * @param dest the address of the destination matrix
     */
    private void mirror(String src, String dest)
    {
        Matrix matrix = memory.get(src);
        memory.set(dest, cpu.permutation(matrix));
    }
}
