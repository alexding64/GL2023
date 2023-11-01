import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FileReader
{
    public String[] getTestPlanList()
    {
        return new String['0'];
    }

    public String[] getCpuList(String directoryPath)
    {
        File folder = new File(directoryPath);
        File[] files = folder.listFiles();
        List<String> cpuNames = new ArrayList<>();

        if (files != null)
        {
            for (File file : files)
            {
                if (file.isFile() && file.getName().endsWith(".txt"))
                {
                    cpuNames.add(file.getName().replace(".txt", ""));
                }
            }
        }

        return cpuNames.toArray(new String[0]);
    }

    public String[] getMemoryList(String directoryPath)
    {
        File folder = new File(directoryPath);
        File[] files = folder.listFiles();
        List<String> memoryNames = new ArrayList<>();

        if (files != null)
        {
            for (File file : files)
            {
                if (file.isFile() && file.getName().endsWith(".txt"))
                {
                	memoryNames.add(file.getName().replace(".txt", ""));
                }
            }
        }

        return memoryNames.toArray(new String[0]);
    }

    public String[] getOutputCtrlList(String directoryPath)
    {
        File folder = new File(directoryPath);
        File[] files = folder.listFiles();
        List<String> outputNames = new ArrayList<>();

        if (files != null)
        {
            for (File file : files)
            {
                if (file.isFile() && file.getName().endsWith(".txt"))
                {
                	outputNames.add(file.getName().replace(".txt", ""));
                }
            }
        }

        return outputNames.toArray(new String[0]);
    }

    public Cpu getCpu(String path)
    {
        File item = new File(path);
        List<String> parametersList = getValuesFromFile(item);
        String[] fileName = path.split("/");
        return new Cpu(fileName[fileName.length-1], Integer.parseInt(parametersList.get(0)),
                Integer.parseInt(parametersList.get(1)), Integer.parseInt(parametersList.get(2)));
    }

    public Memory getMemory(String path)
    {
        File item = new File(path);
        List<String> parametersList = getValuesFromFile(item);
        String[] fileName = path.split("/");
        return new Memory(fileName[fileName.length-1], Integer.parseInt(parametersList.get(0)),
                Integer.parseInt(parametersList.get(1)), new HashMap<String, Matrix>());
    }

    public OutputController getOutputController(String path)
    {
        File item = new File(path);
        List<String> parametersList = getValuesFromFile(item);
        String[] fileName = path.split("/");
        return new OutputController(fileName[fileName.length-1], Integer.parseInt(parametersList.get(0)));
    }

    private static List<String> getValuesFromFile(File file) {
        List<String> values = new ArrayList<>();
        Scanner myReader = null;
        try {
            myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String[] line = myReader.nextLine().split("=");
                if (line.length == 2) {
                    String value = line[1];
                    values.add(value);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return values;
    }
}
