import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Edwin Dong
 * @version 0.1.1
 */
public class Elephant extends Actor
{
    // initialize a sound object that contains a elephant mp3
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    
    // initialize 2 arrays to animate the elephant when he's facing left or right
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    // initialize a timer object to space the image switching
    SimpleTimer aniTimer = new SimpleTimer();
    
    // initialize a string to kepe track of what direction the elephant is facing
    String facing = "right";
    
    // initialize and integer to keep track of which index to display the elephant image
    int imageIndex = 0;
    
    public Elephant() {
        // for each index in the idleright array, add a different version of the elephant as a png, and set the scale to 75
        for (int i = 0;i<8;i++) {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png"); 
            idleRight[i].scale(75, 75);
        }
        
        // for each index in the idleLeft array, add a different version of the elephant as a png, and flip it on it's y axis to make it seem like the elephant
        // is facing left, then set the scale to 75
        for (int i = 0;i<8;i++) {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png"); 
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(75, 75);
        }
        
        // initially set the image to the first one
        setImage(idleRight[0]);
        
        // mark the timer
        aniTimer.mark();
    }
    
    public void animate() {
        // only switch an image if it has been greater than 100 miliseconds since the last switch
        if (aniTimer.millisElapsed() < 100) return;
        
        // mark the timer
        aniTimer.mark();
        
        // if it's facing right, set the image to the right facing ones, otherwise, set it to the left facing images
        if(facing.equals("right")) {
            setImage(idleRight[imageIndex]);
        } else setImage(idleLeft[imageIndex]);

        // use modulus to have a wrap around effect to control the index to keep looping nonstop
        imageIndex = (imageIndex + 1) % 8;
    }
    public void act()
    {
        // if the left arrow key is pressed down, move 4 units to the left, and set the elephant to face the left, otherwise, if the
        // right arrow key is pressed down, move 4 units to the right, and set the elephant to face the right
        if(Greenfoot.isKeyDown("left")) {
            move(-4); facing = "left";
            
        } else if (Greenfoot.isKeyDown("right")) {
            move(4); facing = "right";
        } 
        
        // log the elephant's x position
        Log.info(getX());
        
        // if the elephant touches the apple, remove the apple, get the world the elephant is in, increase the total score, spawn a new apple, then 
        // play a sound to denote that an apple has been eaten
        if(isTouching(Apple.class)){
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.increaseScore();
            world.spawnApple();
            elephantSound.play();
        }
        
        // animate the elephant using the arrays and the index
        animate();
    }
}
