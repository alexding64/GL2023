package model;

import java.io.File;
import java.util.HashMap;
import java.util.List;
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
        File file = new File(filename);
        List<String> lines = FileReader.getLinesFromFile(file);
        TestPlan testPlan = new TestPlan();
        testPlan.matrices = new HashMap<>();

        int i = 0;
        int n; // the number of matrices
        do {
            n = Integer.parseInt(lines.get(i).replace(" ", "").replace("matrices:", ""));
            i++;
        } while (n == 0);

        for (int j = 0; j < n; j++) {
            while (lines.get(i).isEmpty()) {
                i++;
            }
            String[] line = lines.get(i).replace(" ", "").split(":");
            String name = line[0];
            int separator = line[1].indexOf(","); // finds the separator between the size and the data
            int size = Integer.parseInt(line[1].substring(0, separator));
            int[][] data = parseMatrix(line[1].substring(separator+1));
            Matrix matrix = new Matrix(size, data);
            testPlan.matrices.put(name, matrix);
            i++;
        }

        int m = 0; // the number of tests
        do {
            try {
                m = Integer.parseInt(lines.get(i).replace(" ", "").replace("tests:", ""));
            } catch (Exception ignored) {

            }
            i++;
        } while (m == 0);

        testPlan.tests = new Test[m];

        for (int j = 0; j < m; j++) {
            while (lines.get(i).isEmpty()) {
                i++;
            }
            String line = lines.get(i).replace(" ", "");

            if (line.toLowerCase().contains("addition")) {
                if (line.toLowerCase().contains("additionn")) {
                    int separator = line.indexOf("=");
                    String result = line.substring(0, separator);
                    String[] matricesCalculate = line.substring(separator+1)
                            .replaceAll("(?i)additionn\\(", "").replace(")", "")
                            .split(",");
                    testPlan.tests[j] = new AdditionNTest(matricesCalculate[0], matricesCalculate[1], result);
                }
                else {
                    String matrixCalculate = line.replaceAll("(?i)addition\\(", "")
                            .replace(")", "");
                    testPlan.tests[j] = new AdditionTest(matrixCalculate);
                }
            }
            else if (line.toLowerCase().contains("rotation")) {
                int separator = line.indexOf("=");
                String result = line.substring(0, separator);
                String matrixCalculate = line.substring(separator+1)
                        .replaceAll("(?i)rotation\\(", "").replace(")", "");
                testPlan.tests[j] = new RotationTest(matrixCalculate, result);
            }
            else if (line.toLowerCase().contains("mirror")) {
                int separator = line.indexOf("=");
                String result = line.substring(0, separator);
                String matrixCalculate = line.substring(separator+1)
                        .replaceAll("(?i)mirror\\(", "").replace(")", "");
                testPlan.tests[j] = new MirrorTest(matrixCalculate, result);
            }
            i++;
        }

        return testPlan;
    }

    private static int[][] parseMatrix(String matrixString) {
        // Remove brackets and split into rows
        String[] rows = matrixString.replaceAll("\\[\\[", "")
                .replaceAll("]]", "")
                .split("],\\[");

        int numRows = rows.length;
        int numCols = rows[0].split(",").length;

        int[][] matrix = new int[numRows][numCols];

        // Parse each element and populate the matrix
        for (int i = 0; i < numRows; i++) {
            String[] elements = rows[i].split(",");
            for (int j = 0; j < numCols; j++) {
                matrix[i][j] = Integer.parseInt(elements[j]);
            }
        }

        return matrix;
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

