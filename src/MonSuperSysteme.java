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
                	InputController.displayOutputCtrlList();
                    break;
                case 5:
                    // Exécution
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

