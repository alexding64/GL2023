import java.util.Scanner;
import java.io.File;


public class InputController 
{
	
    private static String selectedCPU = "Aucun";
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
    private static String testplanPath = "./configFiles/testplanPath";

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
	    if ("Aucun".equals(selectedCPU)) {
	        // Afficher en rouge
	        System.out.print("\u001B[31m" + selectedCPU + "\u001B[0m"); // Code ANSI pour rouge
	    } else {
	        // Afficher en vert
	        System.out.print("\u001B[32m" + selectedCPU + "\u001B[0m"); // Code ANSI pour vert
	    }
	    System.out.println("");
	    
	    System.out.print("Memory : ");
	    if ("Aucun".equals(selectedMemory)) {
	        // Afficher en rouge
	        System.out.print("\u001B[31m" + selectedMemory + "\u001B[0m"); // Code ANSI pour rouge
	    } else {
	        // Afficher en vert
	        System.out.print("\u001B[32m" + selectedMemory + "\u001B[0m"); // Code ANSI pour vert
	    }
	    System.out.println("");
	    
	    System.out.print("Contrôleur de sortie : ");
	    if ("Aucun".equals(selectedController)) {
	        // Afficher en rouge
	        System.out.print("\u001B[31m" + selectedController + "\u001B[0m"); // Code ANSI pour rouge
	    } else {
	        // Afficher en vert
	        System.out.print("\u001B[32m" + selectedController + "\u001B[0m"); // Code ANSI pour vert
	    }
	    System.out.println("");
	    
	    System.out.print("Plan de test : ");
	    if ("Aucun".equals(selectedTestPlan)) {
	        // Afficher en rouge
	        System.out.print("\u001B[31m" + selectedTestPlan + "\u001B[0m"); // Code ANSI pour rouge
	    } else {
	        // Afficher en vert
	        System.out.print("\u001B[32m" + selectedTestPlan + "\u001B[0m"); // Code ANSI pour vert
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

    public static void displayTestPlanList()
    {
        File folder = new File(testplanPath);
        File[] files = folder.listFiles();
        int choice = 1;

        if (files != null)
        {
            for (File file : files)
            {
                if (file.isFile() && file.getName().endsWith(".txt"))
                {
                    System.out.println(choice + ". " + file.getName().replace(".txt", ""));
                    choice++;
                }
            }
        }

        System.out.println("0. Quitter");
        System.out.println("");
        System.out.println("-----------------------------------");

        int userChoice = getTestPlanChoice(choice); // Obtenez le choix de l'utilisateur

        if (userChoice >= 1 && userChoice < choice)
        {
            selectedTestPlan = files[userChoice - 1].getName().replace(".txt", "");
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
        String[] cpuList = fileReader.getCpuList(cpuPath);

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
                selectedCPU = cpuList[userChoice - 1];
                break; 
            } else if (userChoice == 0)
            {
                break; 
            }
        }
    }

    
    /*
     * Memory Composants list display 
     * The user will choose his controller that he wants
     * @author Aurélien Paquet
     * @version 1.0
     */
    
    public static void displayMemoryList()
    {
        FileReader fileReader = new FileReader();
        String[] memoryList = fileReader.getMemoryList(memoryPath);

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
            System.out.println("");
            System.out.println("-----------------------------------");

            int userChoice = getMemoryChoice(memoryList.length); 

            if (userChoice >= 1 && userChoice <= memoryList.length)
            {
                selectedMemory = memoryList[userChoice - 1];
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
        String[] outputCtrlList = fileReader.getOutputCtrlList(outputPath);

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
            System.out.println("");
            System.out.println("-----------------------------------");

            int userChoice = getOutputCtrlChoice(outputCtrlList.length); 

            if (userChoice >= 1 && userChoice <= outputCtrlList.length)
            {
                selectedController = outputCtrlList[userChoice - 1];

                break; 
            } else if (userChoice == 0)
            {
                break; 
            }
        }
    }

    public static int getMainMenuChoice() 
    {
        Scanner scanner = new Scanner(System.in);
        int choix = 0;

        System.out.print("Votre choix : ");
        choix = scanner.nextInt();

        return choix;
    }

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
                    break; // Sort de la boucle si le choix est valide
                } else {
                    System.out.println("Choix invalide. Veuillez sélectionner une option valide.");
                }
            } else {
                scanner.next(); // Pour consommer l'entrée invalide
                System.out.println("Choix invalide. Veuillez sélectionner une option valide.");
            }
        }
        return choice;
    }
    
    public static int getTestPlanChoice(int maxChoice) 
    {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (true) {
            System.out.print("Votre choix : ");
            if (scanner.hasNextInt())
            {
                choice = scanner.nextInt();
                if (choice >= 0 && choice <= maxChoice)
                {
                    break; // Sort de la boucle si le choix est valide
                } else {
                    System.out.println("Choix invalide. Veuillez sélectionner une option valide.");
                }
            } else {
                scanner.next(); // Pour consommer l'entrée invalide
                System.out.println("Choix invalide. Veuillez sélectionner une option valide.");
            }
        }

        return choice;
    }

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
                    break; // Sort de la boucle si le choix est valide
                } else {
                    System.out.println("Choix invalide. Veuillez sélectionner une option valide.");
                }
            } else {
                scanner.next(); // Pour consommer l'entrée invalide
                System.out.println("Choix invalide. Veuillez sélectionner une option valide.");
            }
        }

        return choice;
    }

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
                    break; // Sort de la boucle si le choix est valide
                } else {
                    System.out.println("Choix invalide. Veuillez sélectionner une option valide.");
                }
            } else {
                scanner.next(); // Pour consommer l'entrée invalide
                System.out.println("Choix invalide. Veuillez sélectionner une option valide.");
            }
        }

        return choice;
    }

    /**
     * Cpu getter
     * @return cpu
     */
    public static Cpu getCpu()
    {
        return cpu;
    }

    /**
     * Memory getter
     * @return memory
     */
    public static Memory getMemory()
    {
        return memory;
    }

    /**
     * Output getter
     * @return outputController
     */
    public static OutputController getOutputController()
    {
        return outputController;
    }

    /**
     * TestPlan Getter
     * @return testPlan
     */
    public static TestPlan getTestPlan()
    {
        return testPlan;
    }
}
