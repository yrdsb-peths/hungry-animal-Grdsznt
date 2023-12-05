import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World
 * 
 * @author  Edwin Dong
 * @version 0.1.1
 */
public class MyWorld extends World
{

    
    
    // initialize instance variables
    public int score = 0; 
    int level = 1;
    Label scoreCard, speed;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        // add an elephant object in the middle of the myWorld world
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 200);
        
        // add a score keeper object to the top left of the myWorld world
        scoreCard = new Label(0, 80);
        addObject(scoreCard, 50,  50);
        
        // add a speed label object to the top right of the myWorld world
        speed = new Label("Speed: " + level, 50);
        addObject(speed, 500, 50);
        
        // spawn a new apple
        spawnApple();
    }
    
    
    /*
     * Creates a new apple object, sets it's speed at which it falls down to the level myWorld is currently on
     * Generates a random x value between 0 and 600 to add the apple to the top of the screen 
     */
    public void spawnApple() {
        Apple apple = new Apple();
        apple.setSpeed(level);
        int randx = Greenfoot.getRandomNumber(600);
        addObject(apple, randx, 0); //spawn an apple at a random generated x, at the top of the screen
    }
    
    /*
     * When the method is called, it increments the instance variable score and updates the value of scoreCard to display this new score.
     * Every 10 points added to the score will increase the level by 1, allowing the apple to drop faster. It also updates the speed label to 
     * display the new speed
     */
    public void increaseScore() {
        ++score;
        scoreCard.setValue(score);
        if (score % 10 == 0) {
            ++level;
            speed.setValue("Speed: " + level);
        }
    }
    
    /*
     * This method adds a label to the screen that reads "GAME OVER" whenever the method is called
     */
    public void gameOver() {
        Label overLabel = new Label("GAME OVER", 100);
        addObject(overLabel, 300, 200);
    }
}
