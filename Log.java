/**
 * Write a description of class Log here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Log  
{
    
    static boolean debug = false;
    /**
     * Constructor for objects of class Log
     */
    public Log()
    {
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void info(int x)
    {
        if (debug) {
            System.out.println("DEBUG: Elephant posx: " + x); 
        }
    }
}
