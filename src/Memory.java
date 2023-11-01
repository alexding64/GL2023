import java.util.Map;

public class Memory extends Component 
{

    private int setCost;
    private int getGost;
    private Map<String,Matrix> data;

    public Memory(String name, int setCost, int getGost,  Map<String, Matrix> data)
    {
        super(name);
        this.setCost = setCost;
        this.getGost = getGost;
        this.data = data;
    }
    
    public void set(String address, Matrix mat)
    {

    }

    public Matrix get(String address)
    {
        return null;
    }


    /**
     * GETTER & SETTER
     */
    
    public int getGetCost() 
    {
        return getGost;
    }

    public void setGetCost(int getGost)
    {
        this.getGost = getGost;
    }    
    
    public int getSetCost() 
    {
        return setCost;
    }
    
    public void setSetCost(int setCost)
    {
        this.setCost = setCost;
    }

}
