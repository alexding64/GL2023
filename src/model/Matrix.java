package model;

import java.util.Random;

public class Matrix 
{
	
    private int size;
    private int[][] data;

    /**
     * Constructor of Matrix class
     * @param size of the matrix
     * @param data of the matrix
     */
    public Matrix(int size, int[][] data) 
    {
    	this.size = size;
    	this.data = data;
    }

    /**
     * Generate a random square matrix
     * @param size of the matrix
     * @return matrix
     */
    public static Matrix generateRandomSquareMatrix(int size) 
    {
        Random random = new Random();
        int[][] data = new int[size][size];

        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                data[i][j] = random.nextInt(9) + 1; // Generate a random number between 1 and 9
            }
        }

        return new Matrix(size, data);
    }

    /**
     * Print a matrix
     * @param matrix to print
     */
    public static void printMatrix(Matrix matrix) 
    {
        int size = matrix.getSize();
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                System.out.print(matrix.getData()[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    /**
     * GETTER & SETTER
     */

    /**
     * Getter of size
     * @return the matrix size
     */
	public int getSize() 
	{
		return size;
	}

    /**
     * Setter of size
     * @param size of the matrix
     */
	public void setSize(int size) 
	{
		this.size = size;
	}

    /**
     * Getter of data
     * @return data
     */
	public int[][] getData() 
	{
		return data;
	}

    /**
     * Setter of data
     * @param data of the matrix
     */
	public void setData(int[][] data) 
	{
		this.data = data;
	}
    
}
