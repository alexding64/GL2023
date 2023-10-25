import java.util.Map;

import Tools.Matrix;

public class Memory extends Component 
{
	
    private int set_cost;
    private int get_cost;
    private Map<String,Matrix> data;

    public Memory(String name, int set_cost, int get_cost,  Map<String, Matrix> data) 
    {
        super(name);
        this.set_cost = set_cost;
        this.get_cost = get_cost;
        this.data = data;
    }
    
    public void set(String address, Matrix mat)
    {
    }

    public Matrix get(String address)
    {
        return new Matrix();
    }

    /**
     * GETTER & SETTER
     */
    
    public int getGetCost() 
    {
        return get_cost;
    }

    public void setGetCost(int get_cost) 
    {
        this.get_cost = get_cost;
    }    
    
    public int getSetCost() 
    {
        return set_cost;
    }
    
    public void setSetCost(int set_cost) 
    {
        this.set_cost = set_cost;
    }
}
