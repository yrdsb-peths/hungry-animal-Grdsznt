/**
 * Write a description of class Log here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Log  
{
    
    // initialize a debug boolean to toggle whether or not to print to console
    static boolean debug = false;
    /**
     * Constructor for objects of class Log
     */
    public Log()
    {
    }

    /**
     * If debug is set to true, it will print the elephant's x position to the console 
     * 
     * @param x Elphant's x position
     *
     */
    public static void info(int x)
    {
        if (debug) {
            System.out.println("DEBUG: Elephant posx: " + x); 
        }
    }
}
