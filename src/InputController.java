public class InputController 
{
	
    private FileReader fileReader;
<<<<<<< HEAD
 
    /*
     * Main menu display with component list display
     * @author 
     * @version 1.0
     */
    
    public static void displayMainMenu()
    {
=======

    public void displayMainMenu(){
>>>>>>> 5ffa70956c5fa63be3941857ae331ff899682973
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
    }

<<<<<<< HEAD
    public void displayTestPlanList()
    {

    }

    /*
     * CPU list display 
     * The user will choose his controller that he wants
     * @author 
     * @version (En cours)
     */
    
    public static void displayCpuList()
    {
=======
    public void displayTestPlanList(){

    }

    public void displayCpuList(){
>>>>>>> 5ffa70956c5fa63be3941857ae331ff899682973
    	clearConsole();
        System.out.println("======== CPU_CHOICE ========\n");
        System.out.println("CPU disponibles : ");
        //affichage à faire
        /*
         *   1. <nom_cpu_1>
  			 2. <nom_cpu_2>
             3. <nom_cpu_3>
             ...
             n. <nom_cpu_n>
         */
        System.out.println("0. Quitter");
        System.out.println("");
        System.out.println("-----------------------------------");
<<<<<<< HEAD
    }
  
    /*
     * Memory Composants list display 
     * The user will choose his controller that he wants
     * @author 
     * @version (En cours)
     */
    
    public static void displayMemoryList()
    {
    	clearConsole();
        System.out.println("======== MEM_CHOICE ========\n");
        System.out.println("Mémoires disponibles : ");
        //affichage à faire
        /*
         *   1. <nom_mem_1>
  			 2. <nom_mem_2>
             3. <nom_mem_3>
             ...
             n. <nom_mem_n>
         */
        System.out.println("0. Quitter");
        System.out.println("");
        System.out.println("-----------------------------------");
    }

    
    /*
     * Output conroller list display 
     * The user will choose his controller that he wants
     * @author 
     * @version (En cours)
     */
    
    public static void displayOutputCtrlList()
    {
    	clearConsole();
        System.out.println("======== OUT_CHOICE ========\n");
        System.out.println("Controlleurs de sortie disponibles : ");
        //affichage à faire
        /*
         *   1. <nom_out_1>
  			 2. <nom_out_2>
             3. <nom_out_3>
             ...
             n. <nom_out_n>
=======
    }

    public void displayMemoryList(){
    	clearConsole();
        System.out.println("======== MEM_CHOICE ========\n");
        System.out.println("Mémoires disponibles : ");
        //affichage à faire
        /*
         *   1. <nom_mem_1>
  			 2. <nom_mem_2>
             3. <nom_mem_3>
             ...
             n. <nom_mem_n>
>>>>>>> 5ffa70956c5fa63be3941857ae331ff899682973
         */
        System.out.println("0. Quitter");
        System.out.println("");
        System.out.println("-----------------------------------");
    }

<<<<<<< HEAD
    public int getMainMenuChoice()
    {
=======
    public void displayOutputCtrlList(){
    	clearConsole();
        System.out.println("======== OUT_CHOICE ========\n");
        System.out.println("Controlleurs de sortie disponibles : ");
        //affichage à faire
        /*
         *   1. <nom_out_1>
  			 2. <nom_out_2>
             3. <nom_out_3>
             ...
             n. <nom_out_n>
         */
        System.out.println("0. Quitter");
        System.out.println("");
        System.out.println("-----------------------------------");
    }

    public int getMainMenuChoice(){
>>>>>>> 5ffa70956c5fa63be3941857ae331ff899682973
        return 0;
    }

    public TestPlan getTestPlanChoice()
    {
        return new TestPlan();
    }

    public Cpu getCpuChoice()
    {
        return new Cpu();
    }

    public Memory getMemoryChoice()
    {
        return new Memory();
    }

    public OutputController getOutputCtrlChoice()
    {
        return new OutputController();
    }
<<<<<<< HEAD
  

    public static void clearConsole()     //A revoir cette fonction
    {
=======
    
    public static void clearConsole() {
>>>>>>> 5ffa70956c5fa63be3941857ae331ff899682973
        System.out.print("\033[H\033[2J \n \n");
        System.out.flush();
    }
}
