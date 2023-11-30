import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Apple here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Apple extends Actor
{
    /**
     * Act - do whatever the Apple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 1; boolean over = false;    
    SimpleTimer timer = new SimpleTimer();
    public int hiScore = 0;
    public void act()
    {
        setLocation(getX(), getY()+speed);
        MyWorld world = (MyWorld) getWorld();
        
        if (over || getY() >= world.getHeight()-5) {
            world.gameOver(); world.removeObject(this); 
            Greenfoot.delay(120); hiScore = Math.max(hiScore, world.score);
            TitleScreen start = new TitleScreen(hiScore);
            Greenfoot.setWorld(start);
        }
    }
    
    public void setSpeed(int speed) { // setter
        this.speed = speed;
    }
}
