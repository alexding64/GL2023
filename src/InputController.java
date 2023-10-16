public class InputController {
    private FileReader fileReader;

    public void displayMainMenu(){
    }

    public void displayTestPlanList(){
    }

    public void displayCpuList(){
    }

    public void displayMemoryList(){
    }

    public void displayOutputCtrlList(){
    }

    public int getMainMenuChoice(){
        return 0;
    }

    public TestPlan getTestPlanChoice(){
        return new TestPlan();
    }

    public Cpu getCpuChoice(){
        return new Cpu();
    }

    public Memory getMemoryChoice(){
        return new Memory();
    }

    public OutputController getOutputCtrlChoice(){
        return new OutputController();
    }
}
