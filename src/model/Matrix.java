package model;

import java.util.Random;

public class Matrix 
{
	
    private int size;
    private int[][] data;

    /**
     * Constructor of MAtrix class
     * @param size
     * @param data
     */
    public Matrix(int size, int[][] data) 
    {
    	this.size = size;
    	this.data = data;
    }
    
    public static Matrix generateRandomSquareMatrix(int size) 
    {
        Random random = new Random();
        int[][] data = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                data[i][j] = random.nextInt(9) + 1; // Générer un nombre aléatoire entre 1 et 9
            }
        }

        return new Matrix(size, data);
    }
    
    public static void printMatrix(Matrix matrix) 
    {
        int size = matrix.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix.getData()[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    /**
     * GETTER & SETTER
     */
    
	public int getSize() 
	{
		return size;
	}
	public void setSize(int size) 
	{
		this.size = size;
	}
	public int[][] getData() 
	{
		return data;
	}
	public void setData(int[][] data) 
	{
		this.data = data;
	}
    
}
