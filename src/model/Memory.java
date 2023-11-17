package model;

import java.util.Map;

public class Memory extends Component
{

    private int setCost;
    private int getCost;
    private final Map<String, Matrix> data;

    /**
     * Constructor of Memory class
     * @param name the memory name
     * @param setCost the cost for setting data
     * @param getCost the cost for getting data
     * @param data the matrices
     */
    public Memory(String name, int setCost, int getCost,  Map<String, Matrix> data)
    {
        super(name);
        this.setCost = setCost;
        this.getCost = getCost;
        this.data = data;
    }

    /**
     * Add a matrix in the map
     * @param address in the map
     * @param mat the matrix
     */
    public void set(String address, Matrix mat)
    {
        data.put(address, mat);
    }

    /**
     * Get a matrix from its address
     * @param address in the map
     * @return the matrix founded
     */
    public Matrix get(String address)
    {
        return data.get(address);
    }


    /*
     * GETTER & SETTER
     */

    /**
     * Getter of getCost
     * @return getCost cost of getting
     */
    public int getGetCost() 
    {
        return getCost;
    }

    /**
     * Setter of getCost
     * @param getCost cost of getting
     */
    public void setGetCost(int getCost)
    {
        this.getCost = getCost;
    }

    /**
     * Getter of setCost
     * @return setCost cost of setting
     */
    public int getSetCost() 
    {
        return setCost;
    }

    /**
     * Setter of setCost
     * @param setCost cost of setting
     */
    public void setSetCost(int setCost)
    {
        this.setCost = setCost;
    }

    public Map<String, Matrix> getData() { return data; }

}
