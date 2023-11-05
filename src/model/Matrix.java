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
    
    public Matrix generateRandomMatrix() {
        Random random = new Random();
        int[][] data = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                data[i][j] = random.nextInt(9); // Générer un nombre aléatoire entre 0 et 9
            }
        }
        return new Matrix(2, data);
    }
    
    public void printMatrix() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(data[i][j] + " ");
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
