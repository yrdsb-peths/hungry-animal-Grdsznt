import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Edwin Dong
 * @version 0.1.1
 */
public class Apple extends Actor
{
    
    // initialize instance variables such as speed, hiscore and initialize a timer object
    int speed = 1;    
    SimpleTimer timer = new SimpleTimer();
    public int hiScore = 0;
    
    /**
     * Act - do whatever the Apple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // move the apple down speed units
        setLocation(getX(), getY()+speed);
        
        // get the world the apple is currently in
        MyWorld world = (MyWorld) getWorld();
        
        // if the apple has reached about the bottom of the world, note the high score, call the gameover function and remove the apple.
        // then, wait 120 milliseconds and set the world to the title screen
        if (getY() >= world.getHeight()-5) {
            hiScore = Math.max(hiScore, world.score);
            world.gameOver(); world.removeObject(this); 
            Greenfoot.delay(120);
            TitleScreen start = new TitleScreen(hiScore);
            Greenfoot.setWorld(start);
        }
    }
    
    /*
     * Setter method for speed
     */
    public void setSpeed(int speed) { 
        this.speed = speed;
    }
}
