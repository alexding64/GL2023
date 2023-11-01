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
    
    public Matrix[] permutation(Matrix[] m)
    {
        return m;
    }

    public Matrix[] rotation(Matrix[] m)
    {
        return m;
    }

    public int resolution(Matrix[] m)
    {
        return 0;
    }
}
