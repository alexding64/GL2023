import java.util.List;

public class Cpu extends Component 
{
	
    private int permutationCost;
    private int rotationCost;
    private int resolutionCost;

    public Cpu(String name, int permutationCost, int rotationCost, int resolutionCost)
    {
        super(name);
        this.permutationCost = permutationCost;
        this.rotationCost = rotationCost;
        this.resolutionCost = resolutionCost;
    }
      
    /**
     * Method to permute a 2x2 Matrix
     * @param m is the matrix to be permuted
     * @return m the permuted matrix
     */
    public Matrix permutation(Matrix m) 
    {
        int[][] data = m.getData();
        if (m.getSize() != 2) {
            throw new IllegalArgumentException("La matrice doit être de taille 2x2 pour la permutation.");
        }

        // Effectuer la permutation (effet miroir)
        int temp = data[0][1];
        data[0][1] = data[0][0];
        data[0][0] = temp;

        temp = data[1][1];
        data[1][1] = data[1][0];
        data[1][0] = temp;

        return m; // Retourner la matrice permutée
    }

    /**
     * Method to rotate a 2x2 Matrix
     * @param m is the matrix to be rotated
     * @return m the rotated matrix
     */
    public Matrix rotation(Matrix matrix) 
    {
        int[][] data = matrix.getData();
        if (matrix.getSize() != 2) {
            throw new IllegalArgumentException("La matrice doit être de taille 2x2 pour la rotation.");
        }

        // Effectuer la rotation
        int temp = data[0][0];
        data[0][0] = data[1][0];
        data[1][0] = data[1][1];
        data[1][1] = data[0][1];
        data[0][1] = temp;

        return matrix; // Retourner la matrice modifiée
    }

    /**
     * Method to resolve a 2x2 Matrix
     * @param m is the matrix to be resolved
     * @return m the resolved matrix
     */
    public int resolution(Matrix m)
    {
        int totalSum = 0;
        
        if (m.getSize() != 2) {
            throw new IllegalArgumentException("La matrice doit être de taille 2x2 pour la résolution.");
        }

        int[][] data = m.getData();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                totalSum += data[i][j];
            }
        }
        
    return totalSum;
    }
    
    /**
     * GETTER & SETTER
     */
    
    public int getPermutationCost() 
    {
        return permutationCost;
    }

    public void setPermutationCost(int permutationCost)
    {
        this.permutationCost = permutationCost;
    }

    public int getRotationCost() 
    {
        return rotationCost;
    }

    public void setRotationCost(int rotationCost)
    {
        this.rotationCost = rotationCost;
    }

    public int getResolutionCost()
    {
        return resolutionCost;
    }

    public void setResolutionCost(int resolutionCost)
    {
        this.resolutionCost = resolutionCost;
    }
}
