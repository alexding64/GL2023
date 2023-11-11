package model;

import model.Component;

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
     * Method to permute a 2x2 model.Matrix
     * @param m is the matrix to be permuted
     * @return m the permuted matrix
     */
    public static Matrix permutation(Matrix m) 
    {
        int[][] data = m.getData();
        int size = m.getSize();

        if (size%2 != 0)
        {
            throw new IllegalArgumentException("La matrice doit être de taille (2^n)*(2^n)," +
                    " n entier >= 1 pour la permutation.");
        }

        if (size == 2)
        {
            /* Do the permutation action */
            int temp = data[0][1];
            data[0][1] = data[0][0];
            data[0][0] = temp;

            temp = data[1][1];
            data[1][1] = data[1][0];
            data[1][0] = temp;
            return m; // return the permuted matrix
        }
        else
        {
            int[][] dataTl = new int[size/2][size/2];
            int[][] dataBl = new int[size/2][size/2];
            int[][] dataTr = new int[size/2][size/2];
            int[][] dataBr = new int[size/2][size/2];

            for (int i = 0; i < size/2; i++)
            {
                for (int j = 0; j < size/2; j++)
                {
                    dataTl[i][j] = data[i][j];
                    dataBl[i][j] = data[i+size/2][j];
                    dataTr[i][j] = data[i][j+size/2];
                    dataBr[i][j] = data[i+size/2][j+size/2];
                }
            }
            Matrix tl = new Matrix(size/2, dataTl);
            Matrix bl = new Matrix(size/2, dataBl);
            Matrix tr = new Matrix(size/2, dataTr);
            Matrix br = new Matrix(size/2, dataBr);

            tl = permutation(tl);
            bl = permutation(bl);
            tr = permutation(tr);
            br = permutation(br);

            int[][] finalData = new int[size][size];
            for (int i = 0; i < size/2; i++)
            {
                for (int j = 0; j < size/2; j++)
                {
                    finalData[i][j] = tr.getData()[i][j];
                    finalData[i][j+size/2] = tl.getData()[i][j];
                    finalData[i+size/2][j] = br.getData()[i][j];
                    finalData[i+size/2][j+size/2] = bl.getData()[i][j];

                }
            }

            return new Matrix(size, finalData);
        }

    }

    /**
     * Method to rotate a 2x2 model.Matrix
     * @param matrix is the matrix to be rotated
     * @return m the rotated matrix
     */
    public static Matrix rotation(Matrix matrix) 
    {
        int[][] data = matrix.getData();
        int size = matrix.getSize();

        if (size%2 != 0)
        {
            throw new IllegalArgumentException("La matrice doit être de taille (2^n)*(2^n), " +
                    "n entier >= 1 pour la permutation.");
        }

        if (size == 2)
        {
            /* rotation */
            int temp = data[0][0];
            data[0][0] = data[1][0];
            data[1][0] = data[1][1];
            data[1][1] = data[0][1];
            data[0][1] = temp;

            return matrix; // Return the changed matrix
        }
        else
        {
            int[][] dataTl = new int[size/2][size/2];
            int[][] dataBl = new int[size/2][size/2];
            int[][] dataTr = new int[size/2][size/2];
            int[][] dataBr = new int[size/2][size/2];

            for (int i = 0; i < size/2; i++)
            {
                for (int j = 0; j < size/2; j++)
                {
                    dataTl[i][j] = data[i][j];
                    dataBl[i][j] = data[i+size/2][j];
                    dataTr[i][j] = data[i][j+size/2];
                    dataBr[i][j] = data[i+size/2][j+size/2];
                }
            }
            Matrix tl = new Matrix(size/2, dataTl);
            Matrix bl = new Matrix(size/2, dataBl);
            Matrix tr = new Matrix(size/2, dataTr);
            Matrix br = new Matrix(size/2, dataBr);

            tl = rotation(tl);
            bl = rotation(bl);
            tr = rotation(tr);
            br = rotation(br);

            int[][] finalData = new int[size][size];
            for (int i = 0; i < size/2; i++)
            {
                for (int j = 0; j < size/2; j++)
                {
                    finalData[i][j] = bl.getData()[i][j];
                    finalData[i][j+size/2] = tl.getData()[i][j];
                    finalData[i+size/2][j] = br.getData()[i][j];
                    finalData[i+size/2][j+size/2] = tr.getData()[i][j];

                }
            }

            return new Matrix(size, finalData);
        }
    }

    /**
     * Method to resolve a 2x2 model.Matrix
     * @param m is the matrix to be resolved
     * @return m the resolved matrix
     */
    public static int resolution(Matrix m)
    {
        int totalSum = 0;
        
        if (m.getSize() != 2)
        {
            throw new IllegalArgumentException(
                    "La matrice doit être de taille 2x2 pour la résolution.");
        }

        int[][] data = m.getData();
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                totalSum += data[i][j];
            }
        }
        
    return totalSum;
    }
    
    /**
     * GETTER & SETTER
     */

    /**
     * Getter of permutationCost
     * @return permutationCost
     */
    public int getPermutationCost() 
    {
        return permutationCost;
    }

    /**
     * Setter of permutationCost
     * @param permutationCost the permutation cost
     */
    public void setPermutationCost(int permutationCost)
    {
        this.permutationCost = permutationCost;
    }

    /**
     * Getter of rotationCost
     * @return rotationCost the rotation cost
     */
    public int getRotationCost() 
    {
        return rotationCost;
    }

    /**
     * Setter of rotationCost
     * @param rotationCost the rotation cost
     */
    public void setRotationCost(int rotationCost)
    {
        this.rotationCost = rotationCost;
    }

    /**
     * Getter of resolutionCost
     * @return resolutionCost the resolution cost
     */
    public int getResolutionCost()
    {
        return resolutionCost;
    }

    /**
     * Setter of resolutionCost
     * @param resolutionCost the resolution cost
     */
    public void setResolutionCost(int resolutionCost)
    {
        this.resolutionCost = resolutionCost;
    }
}
