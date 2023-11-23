import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    SimpleTimer aniTimer = new SimpleTimer();
    String facing = "right";
    
    public Elephant() {
        for (int i = 0;i<8;i++) {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png"); 
            idleRight[i].scale(75, 75);
        }
        for (int i = 0;i<8;i++) {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png"); 
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(75, 75);
        }
        setImage(idleRight[0]);
        
        aniTimer.mark();
    }
    int imageIndex = 0;
    public void animate() {
        if (aniTimer.millisElapsed() < 100) return;
        aniTimer.mark();
        if(facing.equals("right")) {
            setImage(idleRight[imageIndex]);
        } else setImage(idleLeft[imageIndex]);

        imageIndex = (imageIndex + 1) % 8;
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("left")) {
            move(-4); facing = "left";
        } else if (Greenfoot.isKeyDown("right")) {
            move(4); facing = "right";
        } 
        
        if(isTouching(Apple.class)){
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.increaseScore();
            world.spawnApple();
            elephantSound.play();
        }
        
        animate();
    }
}
