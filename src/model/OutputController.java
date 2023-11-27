package model;

import java.util.logging.Logger;

/** Class related to the logging of the operations on matrixes
 * @author Célian Pithon
 * @version 1
 */
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
}
