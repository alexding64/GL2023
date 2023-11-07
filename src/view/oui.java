package view;
import java.util.Scanner;
import model.Matrix;
import model.Cpu;

public class oui {

	//soucis pour rotation et permutation trouvé un moyen de remettre dans le bonne ordre
	
	
    public static void test() {
    	 Scanner scanner = new Scanner(System.in);
         Matrix matrix = null;
         int matrixSize = 0;

         while (true) {
             System.out.println("Menu :");
             System.out.println("1. Générer une matrice");
             System.out.println("2. Résolution");
             System.out.println("3. Rotation");
             System.out.println("4. Permutation");
             System.out.println("5. Quitter");
             System.out.print("Votre choix : ");

             int choice = scanner.nextInt();

             switch (choice) {
                 case 1:
                	 do {
                		    System.out.print("Entrez la taille de la matrice (2, 4, 8, ou 16) : ");
                		    matrixSize = scanner.nextInt();
                		} while (!(matrixSize == 2 || matrixSize == 4 || matrixSize == 8 || matrixSize == 16));
                     
                     matrix = Matrix.generateRandomSquareMatrix(matrixSize);
                     System.out.println("Matrice générée :");
                     Matrix.printMatrix(matrix);
                     break;
                 case 2:
                	    if (matrix != null) {
                	        int totalSum = 0;
                	        if (matrix.getSize() == 2) {
                	            // Matrice 2x2 : Appliquer la résolution directement
                	            totalSum = Cpu.resolution(matrix);
                	        } else {
                	            // Matrice plus grande : Divisez-la en sous-matrices, appliquez la résolution et additionnez les résultats
                	            int subMatrixSize = 2;
                	            for (int i = 0; i < matrixSize; i += subMatrixSize) {
                	                for (int j = 0; j < matrixSize; j += subMatrixSize) {
                	                    int[][] subMatrixData = getSubMatrix(matrix.getData(), i, j, subMatrixSize);
                	                    Matrix subMatrix = new Matrix(subMatrixSize, subMatrixData);

                	                    // Appliquer la résolution sur la sous-matrice
                	                    int subMatrixResolution = Cpu.resolution(subMatrix);
                	                    totalSum += subMatrixResolution;

                	                    // Afficher la résolution de la sous-matrice
                	                    System.out.println("Résolution de la sous-matrice en position (" + i + ", " + j + ") : " + subMatrixResolution);
                	                }
                	            }
                	        }

                	        // Afficher le résultat de la résolution totale
                	        System.out.println("Résolution de la matrice : " + totalSum);
                	    } else {
                	        System.out.println("Générez d'abord une matrice.");
                	    }
                	    break;
                 case 3: // Rotation
                     if (matrix != null) {
                         Matrix rotatedMatrix = Cpu.rotation(matrix);
                         System.out.println("Rotated matrix :");
                         Matrix.printMatrix(rotatedMatrix);
                     }
                     else {
                         System.out.println("Générez d'abord une matrice.");
                     }
                     break;
                 case 4: // Permutation
                     if (matrix != null) {
                         Matrix permutatedMatrix = Cpu.permutation(matrix);
                         System.out.println("Matrice permutée :");
                         Matrix.printMatrix(permutatedMatrix);
                     }
                     else {
                         System.out.println("Générez d'abord une matrice.");
                     }
                     break;
                 case 5:
                     System.out.println("Au revoir !");
                     scanner.close();
                     System.exit(0);
                 default:
                     System.out.println("Choix invalide. Veuillez sélectionner une option valide.");
             }
         }
    }
    
	

	
    public static int[][] getSubMatrix(int[][] matrix, int startRow, int startCol, int size) {
        int[][] subMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                subMatrix[i][j] = matrix[startRow + i][startCol + j];
            }
        }
        return subMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void updateMatrix(Matrix matrix, Matrix subMatrix, int startRow, int startCol) {
        int size = subMatrix.getSize();
        int[][] data = matrix.getData();

        System.out.println("Sous-matrice (" + startRow + ", " + startCol + ") :");

        
        for (int i = 0; i < size; i++) {
        	for (int j = 0; j < size; j++) {
        		data[startRow + i][startCol + j] = subMatrix.getData()[i][j];
        	}
        }
    }
    
    public static void printMatrixWithSubMatrices(int[][] matrix) {
        int n = matrix.length;
        int subMatrixSize = 2; // Taille des sous-matrices (2x2)
        
        System.out.println("Matrice de base :");
        printMatrix(matrix);
        
        for (int i = 0; i < n; i += subMatrixSize) {
            for (int j = 0; j < n; j += subMatrixSize) {
                int[][] subMatrix = getSubMatrix(matrix, i, j, subMatrixSize);
                System.out.println("Sous-matrice en position [" + i + "," + j + "] :");
                printMatrix(subMatrix);
            }
        }
    }
    
}
