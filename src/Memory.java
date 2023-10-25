import java.util.Map;

import Tools.Matrix;

<<<<<<< HEAD
public class Memory extends Component 
{
	
=======
public class Memory extends Component {
>>>>>>> 5ffa70956c5fa63be3941857ae331ff899682973
    private int set_cost;
    private int get_cost;
    private Map<String,Matrix> data;

<<<<<<< HEAD
    public Memory(String name, int set_cost, int get_cost,  Map<String, Matrix> data) 
    {
=======
    public Memory(String name, int set_cost, int get_cost,  Map<String, Matrix> data) {
>>>>>>> 5ffa70956c5fa63be3941857ae331ff899682973
        super(name);
        this.set_cost = set_cost;
        this.get_cost = get_cost;
        this.data = data;
    }
    
<<<<<<< HEAD
    public void set(String address, Matrix mat)
    {
=======
    public void set(String address, Matrix mat){
>>>>>>> 5ffa70956c5fa63be3941857ae331ff899682973
    }

    public Matrix get(String address)
    {
        return new Matrix();
    }

<<<<<<< HEAD
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
=======
    
    /*
    * 
    * Class Getter and Setter
    * 
    */
    
    public int getGetCost() {
        return get_cost;
    }

    public void setGetCost(int get_cost) {
        this.get_cost = get_cost;
    }    
    
    public int getSetCost() {
        return set_cost;
    }
    
    public void setSetCost(int set_cost) {
        this.set_cost = set_cost;
    }
    

>>>>>>> 5ffa70956c5fa63be3941857ae331ff899682973
}
