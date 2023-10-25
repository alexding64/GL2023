import java.util.Scanner;

<<<<<<< HEAD
public class MonSuperSysteme 
{
	
    public Computer computer;
    public InputController inputController;

    public void run() 
    {
=======
public class MonSuperSysteme {
    public Computer computer;
    public InputController inputController;

    public void run() {
>>>>>>> 5ffa70956c5fa63be3941857ae331ff899682973
        Scanner scanner = new Scanner(System.in);
        int choix = 0;

        do {
<<<<<<< HEAD
        	InputController.displayMainMenu();
=======
            System.out.println("======== MAIN_MENU ========");
            System.out.println("");
            System.out.println("CPU : " + "Aucun");
            System.out.println("Memory : " + "Aucun");
            System.out.println("Contrôleur de sortie : " + "Aucun");
            System.out.println("Plan de test : " + "Aucun");
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
            System.out.println("");
>>>>>>> 5ffa70956c5fa63be3941857ae331ff899682973
            System.out.print("Votre choix : ");

            choix = scanner.nextInt();

            switch (choix) {
                case 1:
<<<<<<< HEAD
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
=======
                    choisirCPU();
                    break;
                case 2:
                    choisirMemoire();
                    break;
                case 3:
                	choisirController();
                    break;
                case 4:
                	choisirPlanTest();
>>>>>>> 5ffa70956c5fa63be3941857ae331ff899682973
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
<<<<<<< HEAD
=======
    }
    
    public void choisirCPU() 
    {
        System.out.println("CPU");
    }

    public void choisirMemoire() 
    {
        System.out.println("Memoire");
    }
    
    public void choisirController() 
    {
        System.out.println("Contrôleur");
    }
    
    public void choisirPlanTest() 
    {
        System.out.println("Plan de test");
>>>>>>> 5ffa70956c5fa63be3941857ae331ff899682973
    }
}

