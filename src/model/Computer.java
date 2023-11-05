package model;

import model.AdditionNTest;
import model.AdditionTest;

import java.util.Map;

public class Computer 
{
	
    private Memory memory;
    private OutputController outputController;
    private Cpu cpu;
    private TestPlan testPlan;

    /**
     * Constructor of Computer class
     * @param memory
     * @param outputController
     * @param cpu
     * @param testPlan
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
        for (Test test : testPlan.getTests()) {
            int cost = execTest(test);
            outputController.log("Coût du test : " + cost);
        }
    }

    /**
     * GETTER & SETTER
     */

    /**
     * Setter of cpu
     * @param cpu
     */
    public void setCpu(Cpu cpu)
    {
    	this.cpu = cpu;
    }

    /**
     * Setter of memory
     * @param memory
     */
    public void setMemory(Memory memory)
    {
    	this.memory = memory;
    }

    /**
     * Setter of outputController
     * @param outputController
     */
    public void setOutputController(OutputController outputController)
    {
    	this.outputController = outputController;
    }

    /**
     * Setter of testPlan
     * @param testPlan
     */
    public void setTestPlan(TestPlan testPlan)
    {
    	this.testPlan = testPlan;
    }

    /**
     * Load matrices in the memory
     * @param mat
     * @return true if the memory is initialized
     */
    private boolean initMemory(Map<String, Matrix> mat)
    {
        for (Map.Entry<String, Matrix> entry : mat.entrySet()) {
            String address = entry.getKey();
            Matrix matrix = entry.getValue();
            memory.set(address, matrix);
        }
        return true;
    }

    /**
     * Launch a test
     * @param test
     * @return cost
     */
    private int execTest(Test test)
    {
        int cost = 0;
        switch (test.getOperationName()) {
            case "Addition" :
                cost = scalarAddition(((AdditionTest)test).getMatrix());
                break;
            case "AdditionN" :
                cost = scalarNAddition(((AdditionNTest)test).getMatrix1(),
                                            ((AdditionNTest)test).getMatrix2(),
                                            ((AdditionNTest)test).getResult());
                break;
            case "Rotation" :
                cost = rotation(((RotationTest)test).getMatrix(), ((RotationTest)test).getResult());
                break;
            default: // Mirror
                cost = mirror(((MirrorTest)test).getMatrix(), ((MirrorTest)test).getResult());
                break;
        }
        return 0;
    }

    /**
     * Execute a scalar addition with the source matrix
     * @param src
     * @return cost
     */
    private int scalarAddition(String src)
    {
        Matrix matrix = memory.get(src);
        if (matrix.getSize() == 2) {
            return cpu.resolution(matrix);
        }
        //TODO
        return 0;
    }

    /**
     * Execute an addition of two matrices and put the result in the map at dest
     * @param mat1
     * @param mat2
     * @param dest
     * @return cost
     */
    private int scalarNAddition(String mat1, String mat2, String dest)
    {
        return 0;
    }

    /**
     * Execute a rotation and put the result in the map at dest
     * @param src
     * @param dest
     * @return
     */
    private int rotation(String src, String dest)
    {
        Matrix matrix = memory.get(src);
        if (matrix.getSize() == 2) {
            memory.set(dest, cpu.rotation(matrix));
        }
        //TODO
        return 0;
    }

    /**
     * Execute a mirror and put the result int the map at dest
     * @param src
     * @param dest
     * @return
     */
    private int mirror(String src, String dest)
    {
        Matrix matrix = memory.get(src);
        if (matrix.getSize() == 2) {
            memory.set(dest, cpu.permutation(matrix));
        }
        //TODO
        return 0;
    }
}
