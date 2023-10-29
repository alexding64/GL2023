import java.util.Scanner;

public class MonSuperSysteme 
{
	
    public Computer computer;
    public InputController inputController;

    public void run() 
    {
        Scanner scanner = new Scanner(System.in);
        int choix = 0;

        do {
            InputController.displayMainMenu();
            choix = InputController.getMainMenuChoice();

            switch (choix) {
                case 1:
                	InputController.displayCpuList();
                    break;
                case 2:
                	InputController.displayMemoryList();
                    break;
                case 3:
                	InputController.displayOutputCtrlList();
                    break;
                case 4:
                	InputController.displayTestPlanList();
                    break;
                case 5:
                    // Exécution
                    Memory memory = InputController.getMemory();
                    Cpu cpu = InputController.getCpu();
                    OutputController outputController = InputController.getOutputController();
                    TestPlan testPlan = InputController.getTestPlan();

                    if (memory != null && cpu != null && outputController != null && testPlan != null) {
                        System.out.println("Work in progress...");
                        Computer computer = new Computer(memory, outputController, cpu, testPlan);
                        computer.exec();
                    }
                    break;
                case 6:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez sélectionner une option valide.");
            }
        } while (choix != 6);

        scanner.close();
    }
}

