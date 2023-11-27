package model;

/** Class representing the central processing unit
 * @author Aubin Binaut
 * @version 1
 */
public class Cpu extends Component
{
	
    private int permutationCost;
    private int rotationCost;
    private int resolutionCost;
    private int additionCost;
    private int totalCost;

    /**
     * Constructor of Cpu
     * @param name
     * @param permutationCost
     * @param rotationCost
     * @param resolutionCost
     * @param additionCost
     */
    public Cpu(String name, int permutationCost, int rotationCost, int resolutionCost, int additionCost)
    {
        super(name);
        this.permutationCost = permutationCost;
        this.rotationCost = rotationCost;
        this.resolutionCost = resolutionCost;
        this.additionCost = additionCost;
    }

    /**
     * Method to permute a 2x2 model.Matrix
     * @param m is the matrix to be permuted
     * @return m the permuted matrix
     */
    public Matrix permutation(Matrix m)
    {
        int[][] data = m.getData();
        int size = m.getSize();

        if (size%2 != 0)
        {
            throw new IllegalArgumentException("La matrice doit être de taille (2^n)*(2^n)," +
                    " n entier >= 1 pour la permutation.");
        }

        totalCost += permutationCost;

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
        else {
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
    public Matrix rotation(Matrix matrix)
    {
        int[][] data = matrix.getData();
        int size = matrix.getSize();

        if (size%2 != 0)
        {
            throw new IllegalArgumentException("La matrice doit être de taille (2^n)*(2^n), " +
                    "n entier >= 1 pour la permutation.");
        }

        totalCost += rotationCost;

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
        else {
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
    public int resolution(Matrix m)
    {
        int totalSum = 0;
        
        if (m.getSize() != 2)
        {
            throw new IllegalArgumentException(
                    "La matrice doit être de taille 2x2 pour la résolution.");
        }

        totalCost += resolutionCost;

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
     * Method to add two different model.Matrix
     * @param matrix1 is the first matrix to be added
     * @param matrix2 is the second matrix to be added
     * @return m the summed matrix
     */
    public Matrix addition(Matrix matrix1, Matrix matrix2)
    {
        int[][] data1 = matrix1.getData();
        int size1 = matrix1.getSize();
        int[][] data2 = matrix2.getData();
        int size2 = matrix2.getSize();

        if (size1 != size2) {
            throw new IllegalArgumentException("Les matrices doivent être de même taille.");
        }

        if (size1%2 != 0)
        {
            throw new IllegalArgumentException("La matrice doit être de taille (2^n)*(2^n), " +
                    "n entier >= 1 pour l'addition de matrices.");
        }

        totalCost += additionCost;

        if (size1 == 2)
        {
            int[][] data = new int[2][2];

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    data[i][j] = data1[i][j] + data2[i][j];
                }
            }

            return new Matrix(2, data);
        }
        else {
            int[][] dataTl1 = new int[size1/2][size1/2];
            int[][] dataBl1 = new int[size1/2][size1/2];
            int[][] dataTr1 = new int[size1/2][size1/2];
            int[][] dataBr1 = new int[size1/2][size1/2];
            int[][] dataTl2 = new int[size2/2][size2/2];
            int[][] dataBl2 = new int[size2/2][size2/2];
            int[][] dataTr2 = new int[size2/2][size2/2];
            int[][] dataBr2 = new int[size2/2][size2/2];

            for (int i = 0; i < size1/2; i++)
            {
                for (int j = 0; j < size1/2; j++)
                {
                    dataTl1[i][j] = data1[i][j];
                    dataTl2[i][j] = data2[i][j];
                    dataTr1[i][j] = data1[i][j+size1/2];
                    dataTr2[i][j] = data2[i][j+size1/2];
                    dataBl1[i][j] = data1[i+size1/2][j];
                    dataBl2[i][j] = data2[i+size1/2][j];
                    dataBr1[i][j] = data1[i+size1/2][j+size1/2];
                    dataBr2[i][j] = data2[i+size1/2][j+size1/2];
                }
            }
            Matrix tl1 = new Matrix(size1/2, dataTl1);
            Matrix bl1 = new Matrix(size1/2, dataBl1);
            Matrix tr1 = new Matrix(size1/2, dataTr1);
            Matrix br1 = new Matrix(size1/2, dataBr1);
            Matrix tl2 = new Matrix(size2/2, dataTl2);
            Matrix bl2 = new Matrix(size2/2, dataBl2);
            Matrix tr2 = new Matrix(size2/2, dataTr2);
            Matrix br2 = new Matrix(size2/2, dataBr2);

            Matrix tl = addition(tl1, tl2);
            Matrix bl = addition(bl1, bl2);
            Matrix tr = addition(tr1, tr2);
            Matrix br = addition(br1, br2);

            int[][] finalData = new int[size1][size1];
            for (int i = 0; i < size1/2; i++)
            {
                for (int j = 0; j < size1/2; j++)
                {
                    finalData[i][j] = tl.getData()[i][j];
                    finalData[i][j+size1/2] = tr.getData()[i][j];
                    finalData[i+size1/2][j] = bl.getData()[i][j];
                    finalData[i+size1/2][j+size1/2] = br.getData()[i][j];

                }
            }

            return new Matrix(size1, finalData);
        }
    }

    /*
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

    /**
     * Getter of totalCost
     * @return totalCost the total cost of the operations on the cpu
     */
    public int getTotalCost()
    {
        return totalCost;
    }

    /**
     * Setter of totalCost
     * @param totalCost the total cost of the operations (should be 0 on initialization)
     */
    public void setTotalCost(int totalCost)
    {
        this.totalCost = totalCost;
    }
}
