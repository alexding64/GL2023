public class FileReader 
{
    public String[] getTestPlanList()
    {
        return new String['0'];
    }

    public String[] getCpuList()
    {
        return new String['0'];
    }

    public String[] getMemoryList()
    {
        return new String['0'];
    }

    public String[] getOutputCtrlList()
    {
        return new String['0'];
    }

    public Cpu getCpu(Cpu path)
    {
        return null;
    }

    public Memory getMemory(String path)
    {
        return null;
    }

    public OutputController getOutputController(String path)
    {
        return new OutputController("", 0);
    }
}
