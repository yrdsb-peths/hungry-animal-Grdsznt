import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World
 * 
 * @author  
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 200);
        
        Label score = new Label(0, 20);
        addObject(label, 20, 20);
        
        spawnApple();
    }
    
    public void spawnApple() {
        Apple apple = new Apple();
        int randx = Greenfoot.getRandomNumber(600);
        addObject(apple, randx, 0);
    }
}
