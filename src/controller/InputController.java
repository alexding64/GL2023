package controller;

import model.*;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;


public class InputController 
{
	
    private static String selectedCpu = "Aucun";
    private static String selectedMemory = "Aucun";
    private static String selectedController = "Aucun";
    private static String selectedTestPlan = "Aucun";

    private static Cpu cpu;
    private static Memory memory;
    private static OutputController outputController;
    private static TestPlan testPlan;

    private static String cpuPath = "./configFiles/cpuList";
    private static String memoryPath = "./configFiles/memoryList";
    private static String outputPath = "./configFiles/outputList";
    private static String testplanPath = "./configFiles/testPlanList";

    /*
     * Main menu display with component list display
     * @author Aurélien Paquet
     * @version 1.0
     */
    public static void displayMainMenu()
    {
	    System.out.println("======== MAIN_MENU ========");
	    System.out.println("");
	    System.out.print("CPU : ");
	    if ("Aucun".equals(selectedCpu))
        {
	        /* Print in red */
	        System.out.print("\u001B[31m" + selectedCpu + "\u001B[0m"); // ANSI red
	    } else
        {
            /* Print in green */
	        System.out.print("\u001B[32m" + selectedCpu + "\u001B[0m"); // ANSI green
	    }
	    System.out.println("");
	    
	    System.out.print("Mémoire : ");
	    if ("Aucun".equals(selectedMemory))
        {
            /* Print in red */
	        System.out.print("\u001B[31m" + selectedMemory + "\u001B[0m"); // ANSI red
	    } else
        {
            /* Print in green */
	        System.out.print("\u001B[32m" + selectedMemory + "\u001B[0m"); // ANSI green
	    }
	    System.out.println("");
	    
	    System.out.print("Contrôleur de sortie : ");
	    if ("Aucun".equals(selectedController))
        {
            /* Print in red */
	        System.out.print("\u001B[31m" + selectedController + "\u001B[0m"); // ANSI red
	    } else
        {
            /* Print in green */
	        System.out.print("\u001B[32m" + selectedController + "\u001B[0m"); // ANSI green
	    }
	    System.out.println("");
	    
	    System.out.print("Plan de test : ");
	    if ("Aucun".equals(selectedTestPlan))
        {
            /* Print in red */
	        System.out.print("\u001B[31m" + selectedTestPlan + "\u001B[0m"); // ANSI red
	    } else
        {
            /* Print in green */
	        System.out.print("\u001B[32m" + selectedTestPlan + "\u001B[0m"); // ANSI green
	    }
	    System.out.println("");
	    
	    System.out.println("");
	    System.out.println("-----------------------------------");
	    System.out.println("");
	    System.out.println("1. Choisir un CPU");
	    System.out.println("2. Choisir une mémoire");
	    System.out.println("3. Choisir un contrôleur de sortie");
	    System.out.println("4. Choisir un plan de test");
	    System.out.println("5. Exécution");
	    System.out.println("6. Quitter");
	    System.out.println("");
	    System.out.println("-----------------------------------");
    }

    /**
     * Display the testPlan list
     */
    public static void displayTestPlanList()
    {
        FileReader fileReader = new FileReader();
        String[] testPlanList;
        try
        {
            testPlanList = fileReader.getTestPlanList(testplanPath);
        } catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }

        if (testPlanList.length == 0)
        {
            System.out.println("Aucun plan de test disponible.");
            return;
        }

        int choice = 1;

        while (true)
        {
            System.out.println("======== CHOIX DU PLAN DE TEST ========\n");
            System.out.println("Plans de test disponibles : ");

            for (String testPlanName : testPlanList)
            {
                System.out.println(choice + ". " + testPlanName);
                choice++;
            }

            System.out.println("0. Quitter");
            System.out.println("");
            System.out.println("-----------------------------------");

            int userChoice = getTestPlanChoice(testPlanList.length);

            if (userChoice >= 1 && userChoice <= testPlanList.length)
            {
                selectedTestPlan = testPlanList[userChoice - 1];
                testPlan = fileReader.getTestPlan(testplanPath + "/" + testPlanList[userChoice - 1] + ".txt");
                break;
            } else if (userChoice == 0)
            {
                break;
            }
        }
    }

    /*
     * CPU list display 
     * The user will choose his controller that he wants
     * @author Aurélien Paquet
     * @version 1.0
     */
    public static void displayCpuList()
    {
        FileReader fileReader = new FileReader();
        String[] cpuList = new String[0];
        try
        {
            cpuList = fileReader.getCpuList(cpuPath);
        } catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }

        if (cpuList.length == 0)
        {
            System.out.println("Aucun CPU disponible.");
            return;
        }

        int choice = 1;

        while (true)
        {
            System.out.println("======== CPU_CHOICE ========\n");
            System.out.println("CPU disponibles : ");

            for (String cpuName : cpuList)
            {
                System.out.println(choice + ". " + cpuName);
                choice++;
            }

            System.out.println("0. Quitter");
            System.out.println("");
            System.out.println("-----------------------------------");

            int userChoice = getCpuChoice(cpuList.length); 

            if (userChoice >= 1 && userChoice <= cpuList.length)
            {
                selectedCpu = cpuList[userChoice - 1];
                cpu = fileReader.getCpu(cpuPath + "/" + cpuList[userChoice - 1] + ".txt");
                break; 
            } else if (userChoice == 0)
            {
                break; 
            }
        }
    }

    
    /*
     * model.Memory Composants list display
     * The user will choose his controller that he wants
     * @author Aurélien Paquet
     * @version 1.0
     */
    public static void displayMemoryList()
    {
        FileReader fileReader = new FileReader();
        String[] memoryList = new String[0];
        try
        {
            memoryList = fileReader.getMemoryList(memoryPath);
        } catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }

        if (memoryList.length == 0)
        {
            System.out.println("Aucune mémoire disponible.");
            return;
        }

        int choice = 1;

        while (true)
        {
            System.out.println("======== MEMORY_CHOICE ========\n");
            System.out.println("Mémoires disponibles : ");

            for (String memoryName : memoryList)
            {
                System.out.println(choice + ". " + memoryName);
                choice++;
            }

            System.out.println("0. Quitter");
            System.out.println();
            System.out.println("-----------------------------------");

            int userChoice = getMemoryChoice(memoryList.length); 

            if (userChoice >= 1 && userChoice <= memoryList.length)
            {
                selectedMemory = memoryList[userChoice - 1];
                memory = fileReader.getMemory(memoryPath + "/" + memoryList[userChoice - 1] + ".txt");
                break;
            } else if (userChoice == 0)
            {
                break; 
            }
        }
    }

    
    /*
     * Output conroller list display 
     * The user will choose his controller that he wants
     * @author Aurélien Paquet
     * @version 1.0
     */
    public static void displayOutputCtrlList()
    {
        FileReader fileReader = new FileReader();
        String[] outputCtrlList = new String[0];
        try
        {
            outputCtrlList = fileReader.getOutputCtrlList(outputPath);
        } catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }

        if (outputCtrlList.length == 0)
        {
            System.out.println("Aucun contrôleur de sortie disponible.");
            return;
        }

        int choice = 1;

        while (true)
        {
            System.out.println("======== OUTPUT_CTRL_CHOICE ========\n");
            System.out.println("Contrôleurs de sortie disponibles : ");

            for (String outputCtrlName : outputCtrlList)
            {
                System.out.println(choice + ". " + outputCtrlName);
                choice++;
            }

            System.out.println("0. Quitter");
            System.out.println();
            System.out.println("-----------------------------------");

            int userChoice = getOutputCtrlChoice(outputCtrlList.length); 

            if (userChoice >= 1 && userChoice <= outputCtrlList.length)
            {
                selectedController = outputCtrlList[userChoice - 1];
                outputController = fileReader.getOutputController(outputPath + "/" + outputCtrlList[userChoice - 1] + ".txt");
                break; 
            } else if (userChoice == 0)
            {
                break; 
            }
        }
    }

    /**
     * Get the choice in the main menu
     * @return choice made
     */
    public static int getMainMenuChoice() 
    {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        System.out.print("Votre choix : ");
        choice = scanner.nextInt();

        return choice;
    }

    /**
     * Get the cpu chosen
     * @param maxChoice the maximum
     * @return choice made
     */
    public static int getCpuChoice(int maxChoice) 
    {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (true)
        {
            System.out.print("Votre choix : ");
            if (scanner.hasNextInt())
            {
                choice = scanner.nextInt();
                if (choice >= 0 && choice <= maxChoice)
                {
                    break; // Exit
                } else
                {
                    System.out.println("Choix invalide. Veuillez sélectionner une option valide.");
                }
            } else
            {
                scanner.next();
                System.out.println("Choix invalide. Veuillez sélectionner une option valide.");
            }
        }
        return choice;
    }

    /**
     * Get the testPlan chosen
     * @param maxChoice the maximum
     * @return choice made
     */
    public static int getTestPlanChoice(int maxChoice) 
    {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (true)
        {
            System.out.print("Votre choix : ");
            if (scanner.hasNextInt())
            {
                choice = scanner.nextInt();
                if (choice >= 0 && choice <= maxChoice)
                {
                    break; // Exit
                } else
                {
                    System.out.println("Choix invalide. Veuillez sélectionner une option valide.");
                }
            } else
            {
                scanner.next();
                System.out.println("Choix invalide. Veuillez sélectionner une option valide.");
            }
        }

        return choice;
    }

    /**
     * Get the memory chosen
     * @param maxChoice the maximum
     * @return choice made
     */
    public static int getMemoryChoice(int maxChoice) 
    {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (true)
        {
            System.out.print("Votre choix : ");
            if (scanner.hasNextInt())
            {
                choice = scanner.nextInt();
                if (choice >= 0 && choice <= maxChoice)
                {
                    break; // Exit
                } else
                {
                    System.out.println("Choix invalide. Veuillez sélectionner une option valide.");
                }
            } else
            {
                scanner.next();
                System.out.println("Choix invalide. Veuillez sélectionner une option valide.");
            }
        }

        return choice;
    }

    /**
     * Get the outputController chosen
     * @param maxChoice tje maximum
     * @return choice made
     */
    public static int getOutputCtrlChoice(int maxChoice) 
    {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (true)
        {
            System.out.print("Votre choix : ");
            if (scanner.hasNextInt())
            {
                choice = scanner.nextInt();
                if (choice >= 0 && choice <= maxChoice)
                {
                    break; // Exit
                } else
                {
                    System.out.println("Choix invalide. Veuillez sélectionner une option valide.");
                }
            } else
            {
                scanner.next();
                System.out.println("Choix invalide. Veuillez sélectionner une option valide.");
            }
        }

        return choice;
    }

    /**
     * Getter of cpu
     * @return cpu
     */
    public static Cpu getCpu()
    {
        return cpu;
    }

    /**
     * Getter of memory
     * @return memory
     */
    public static Memory getMemory()
    {
        return memory;
    }

    /**
     * Getter of outputController
     * @return outputController
     */
    public static OutputController getOutputController()
    {
        return outputController;
    }

    /**
     * Getter of testPlan
     * @return testPlan
     */
    public static TestPlan getTestPlan()
    {
        return testPlan;
    }
}
