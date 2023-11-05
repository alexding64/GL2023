package model;

import model.Component;

public class OutputController extends Component
{
	
    private int logCost;

    /**
     * Constructor of OutputController class
     * @param name
     * @param logCost
     */
    public OutputController(String name, int logCost) {
        super(name);
        this.logCost = logCost;
    }

    /**
     * Display a message
     * @param msg
     */
    public void log(Object msg) 
    {
    	System.out.println(msg.toString());
    }

    /**
     * Display a message
     * @param msg
     */
    public void logFree(Object msg)
    {
    	
    }
}
