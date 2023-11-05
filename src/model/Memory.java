package model;

import model.Component;
import model.Matrix;

import java.util.Map;

public class Memory extends Component
{

    private int setCost;
    private int getCost;
    private Map<String, Matrix> data;

    /**
     * Constructor of Memory class
     * @param name
     * @param setCost
     * @param getCost
     * @param data
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
     * @param address
     * @param mat
     */
    public void set(String address, Matrix mat)
    {
        data.put(address, mat);
    }

    /**
     * Get a matrix from its address
     * @param address
     * @return
     */
    public Matrix get(String address)
    {
        return data.get(address);
    }


    /**
     * GETTER & SETTER
     */

    /**
     * Getter of getCost
     * @return getCost
     */
    public int getGetCost() 
    {
        return getCost;
    }

    /**
     * Setter of getCost
     * @param getCost
     */
    public void setGetCost(int getCost)
    {
        this.getCost = getCost;
    }

    /**
     * Getter of setCost
     * @return setCost
     */
    public int getSetCost() 
    {
        return setCost;
    }

    /**
     * Setter of setCost
     * @param setCost
     */
    public void setSetCost(int setCost)
    {
        this.setCost = setCost;
    }

}
