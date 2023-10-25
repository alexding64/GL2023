public class Matrix 
{
	
    public int size;
    public int[][] data;
    
    public Matrix(int size, int[][] data) 
    {
    	this.size = size;
    	this.data = data;
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
