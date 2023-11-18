package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FileReader
{
    /**
     * Give the list of item (CPU, memory, controller output or test plan) available in the directoryPath
     * @param directoryPath the directory path
     * @return the item list in table of String
     */
    public String[] getItemList(String directoryPath) throws FileNotFoundException
    {
        File folder = new File(directoryPath);
        File[] files = folder.listFiles();
        List<String> itemNames = new ArrayList<>();

        if (files != null)
        {
            for (File file : files)
            {
                if (file.isFile() && file.getName().endsWith(".txt"))
                {
                    itemNames.add(file.getName().replace(".txt", ""));
                }
            }
        } else
        {
            throw new FileNotFoundException("Le fichier n'a pas été trouvé");
        }

        return itemNames.toArray(new String[0]);
    }

    /**
     * Create a CPU with values in the file path
     * @param path of the file chosen
     * @return the cpu created
     */
    public Cpu getCpu(String path)
    {
        File item = new File(path);
        List<String> parametersList = getValuesFromFile(item);
        String[] fileName = path.split("/");
        return new Cpu(fileName[fileName.length-1], Integer.parseInt(parametersList.get(0)),
                Integer.parseInt(parametersList.get(1)), Integer.parseInt(parametersList.get(2)),
                Integer.parseInt(parametersList.get(3)));
    }

    /**
     * Create a Memory with values in the file path
     * @param path of the file chosen
     * @return the memory created
     */
    public Memory getMemory(String path)
    {
        File item = new File(path);
        List<String> parametersList = getValuesFromFile(item);
        String[] fileName = path.split("/");
        return new Memory(fileName[fileName.length-1], Integer.parseInt(parametersList.get(0)),
                Integer.parseInt(parametersList.get(1)), new HashMap<>());
    }

    /**
     * Create an output with values in the file path
     * @param path of the file chosen
     * @return the output created
     */
    public OutputController getOutputController(String path)
    {
        File item = new File(path);
        List<String> parametersList = getValuesFromFile(item);
        String[] fileName = path.split("/");
        return new OutputController(fileName[fileName.length-1],
                Integer.parseInt(parametersList.get(0)));
    }

    /**
     * Create an output with values in the file path
     * @param path of the file chosen
     * @return the output created
     */
    public TestPlan getTestPlan(String path)
    {
        return TestPlan.fromFile(path);
    }

    /**
     * Method to extract values in a text file
     * @param file the file with values to extract
     * @return values extracted in a table of String
     */
    private static List<String> getValuesFromFile(File file)
    {
        List<String> values = new ArrayList<>();
        Scanner myReader;
        try
        {
            myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String[] line = myReader.nextLine().split("=");
                if (line.length == 2)
                {
                    String value = line[1];
                    values.add(value);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        return values;
    }

    /**
     * Get lines from a file
     * @param file
     * @return a list of lines
     */
    public static List<String> getLinesFromFile(File file)
    {
        List<String> values = new ArrayList<>();
        Scanner myReader;
        try
        {
            myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                values.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        return values;
    }
}
