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
    
    public int score = 0; int level = 1;
    Label scoreCard;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 200);
        
        scoreCard = new Label(0, 80);
        addObject(scoreCard, 50,  50);
        
        spawnApple();
    }
    
    public void spawnApple() {
        Apple apple = new Apple();
        apple.setSpeed(level);
        int randx = Greenfoot.getRandomNumber(600);
        addObject(apple, randx, 0); //spawn an apple at a random generated x, at the top of the screen
    }
    
    public void increaseScore() {
        ++score;
        scoreCard.setValue(score);
        
        if (score % 10 == 0) {
            ++level;
        }
    }
    
    public void gameOver() {
        Label overLabel = new Label("GAME OVER", 100);
        addObject(overLabel, 300, 200);
    }
}
