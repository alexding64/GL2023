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
