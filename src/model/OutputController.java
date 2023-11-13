package model;

import model.Component;

import java.util.logging.Logger;

public class OutputController extends Component
{
	
    private int logCost;

    /**
     * Constructor of OutputController class
     * @param name the name of the output controller
     * @param logCost the cost of log
     */
    public OutputController(String name, int logCost)
    {
        super(name);
        this.logCost = logCost;
    }

    /**
     * Display a message
     * @param msg to log
     */
    public void log(Object msg) 
    {
        Logger logger = Logger.getLogger(OutputController.class.getName());
    	logger.info(msg.toString());
    }

    /**
     * Display a message
     * @param msg to log
     */
    public void logFree(Object msg)
    {
    	
    }
}
