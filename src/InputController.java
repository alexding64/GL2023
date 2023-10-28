import java.util.Scanner;
import java.io.File;


public class InputController 
{
	
    private FileReader fileReader;
    private static String selectedCPU = "Aucun";
    private static Cpu cpu;
    private static String selectedMemory = "Aucun";
    private static Memory memory;
    private static String selectedController = "Aucun";
    private static OutputController outputController;
    private static String selectedTestPlan = "Aucun";


    /*
     * Main menu display with component list display
     * @author Aurélien Paquet
     * @version 1.0
     */
    
    public static void displayMainMenu()
    {    	
        System.out.println("======== MAIN_MENU ========");
        System.out.println("");
        System.out.println("CPU : " + selectedCPU);
        System.out.println("Memory : " + selectedMemory);
        System.out.println("Contrôleur de sortie : " + selectedController);
        System.out.println("Plan de test : " + selectedTestPlan);
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
        File folder = new File("TestPlanList");
        File[] files = folder.listFiles();
        int choice = 1;

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    System.out.println(choice + ". " + file.getName().replace(".txt", ""));
                    choice++;
                }
            }
        }

        System.out.println("0. Quitter");
        System.out.println("");
        System.out.println("-----------------------------------");

        int userChoice = getTestPlanChoice(choice); // Obtenez le choix de l'utilisateur

        if (userChoice >= 1 && userChoice < choice) {
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
        File folder = new File("./configFiles/cpuList");
        File[] files = folder.listFiles();
        int choice = 1;

        while (true) {
            System.out.println("======== CPU_CHOICE ========\n");
            System.out.println("CPU disponibles : ");

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        System.out.println(choice + ". " + file.getName().replace(".txt", ""));
                        choice++;
                    }
                }
            }

            System.out.println("0. Quitter");
            System.out.println("");
            System.out.println("-----------------------------------");

            int userChoice = getCpuChoice(choice); // Obtenez le choix de l'utilisateur

            if (userChoice >= 1 && userChoice < choice) {
                selectedCPU = files[userChoice - 1].getName().replace(".txt", "");
                FileReader fileReader = new FileReader();
                cpu = fileReader.getCpu("./configFiles/cpuList/" + files[userChoice - 1].getName());
                break; // Sortez de la boucle si l'utilisateur a fait un choix valide
            } else if (userChoice == 0) {
                break; // Sortez de la boucle si l'utilisateur choisit de quitter
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
        File folder = new File("./configFiles/memoryList");
        File[] files = folder.listFiles();
        int choice = 1;

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    System.out.println(choice + ". " + file.getName().replace(".txt", ""));
                    choice++;
                }
            }
        }

        System.out.println("0. Quitter");
        System.out.println("");
        System.out.println("-----------------------------------");

        int userChoice = getMemoryChoice(choice); // Obtenez le choix de l'utilisateur

        if (userChoice >= 1 && userChoice < choice) {
            selectedMemory = files[userChoice - 1].getName().replace(".txt", "");
            FileReader fileReader = new FileReader();
            memory = fileReader.getMemory("./configFiles/memoryList/" + files[userChoice - 1].getName());
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
        File folder = new File("./configFiles/outputList");
        File[] files = folder.listFiles();
        int choice = 1;

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    System.out.println(choice + ". " + file.getName().replace(".txt", ""));
                    choice++;
                }
            }
        }

        System.out.println("0. Quitter");
        System.out.println("");
        System.out.println("-----------------------------------");

        int userChoice = getOutputCtrlChoice(choice); // Obtenez le choix de l'utilisateur

        if (userChoice >= 1 && userChoice < choice) {
            selectedController = files[userChoice - 1].getName().replace(".txt", "");
            FileReader fileReader = new FileReader();
            outputController = fileReader.getOutputController("./configFiles/outputList/" + files[userChoice - 1].getName());
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

        while (true) {
            System.out.print("Votre choix : ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 0 && choice <= maxChoice) {
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
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 0 && choice <= maxChoice) {
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

        while (true) {
            System.out.print("Votre choix : ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 0 && choice <= maxChoice) {
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

        while (true) {
            System.out.print("Votre choix : ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 0 && choice <= maxChoice) {
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

    public static void clearConsole() 
    {

    }
}
