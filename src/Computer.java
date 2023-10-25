import java.util.Map;

public class Computer 
{
	
    private Memory memory;
    private OutputController outputController;
    private Cpu cpu;
    private TestPlan testPlan;

    public void exec()
    {
    	
    }

<<<<<<< HEAD
    /**
     * GETTER & SETTER
     */
    
    public void setCpu(Cpu cpu)
    {
    	this.cpu = cpu;
    }

    public void setMemory(Memory memory)
    {
    	this.memory = memory;
    }

    public void setOutputController(OutputController outputController)
    {
    	this.outputController = outputController;
    }

    public void setTestPlan(TestPlan testPlan)
    {
=======
    public void setCpu(Cpu cpu){
    	this.cpu = cpu;
    }

    public void setMemory(Memory memory){
    	this.memory = memory;
    }

    public void setOutputController(OutputController outputController){
    	this.outputController = outputController;
    }

    public void setTestPlan(TestPlan testPlan){
>>>>>>> 5ffa70956c5fa63be3941857ae331ff899682973
    	this.testPlan = testPlan;
    }

    private boolean init_memory(Map<String,Matrix> mat)
    {
        return false;
    }

    private int exec_test(Test test)
    {
        return 0;
    }

    private int scalar_addition(String src)
    {
        return 0;
    }

    private int scalar_n_addition(String mat1, String mat2, String dest)
    {
        return 0;
    }

    private int rotation(String src, String dest)
    {
        return 0;
    }

    private int mirror(String src, String dest)
    {
        return 0;
    }
}
