package view;

import controller.InputController;
import model.*;

import java.util.Scanner;

/** Class used to represent our system, interacting with the user and executing the test plans
 * @author Célian Pithon
 * @version 1
 */
public class MonSuperSystemeView
{
	
    private Computer computer;
    private InputController inputController;

    /**
     * Launch the system
     */
    public void run() 
    {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do
        {
            InputController.displayMainMenu();
            choice = InputController.getMainMenuChoice();

            switch (choice)
            {
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
                    /* Exécution */
                    Memory memory = InputController.getMemory();
                    Cpu cpu = InputController.getCpu();
                    OutputController outputController = InputController.getOutputController();
                    TestPlan testPlan = InputController.getTestPlan();

                    if (memory != null && cpu != null
                            && outputController != null && testPlan != null)
                    {
                        System.out.println("Work in progress...");
                        Computer computer = new Computer(memory, outputController, cpu, testPlan);
                        computer.exec(); // Plan test execution
                    }
                    break;
                case 6:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println(
                            "Choix invalide. Veuillez sélectionner une option valide.");
            }
        } while (choice != 6);

        scanner.close();
    }
}

