import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TitleScreen extends World
{
    
    // initialize a label object called title
    Label title = new Label("Hungry Elephant", 70);
    
    
    /*
     * First constructor that takes a int parameter called hiScore
     */
    public TitleScreen(int hiScore)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        // add the title label to the world
        addObject(title, 260, 80);
        
        // call prepare method to set up the world
        prepare(hiScore);
    }
    
    /*
     * Second constructor that has no parameters 
     */
    public TitleScreen() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        // add the title label to the world
        addObject(title, 260, 80);
        
        // call prepare method to set up the world
        prepare(0);
    }
    
    
    public void act() {
        // if you press the space key, it will send you to the game world
        if(Greenfoot.isKeyDown("space")) {
            MyWorld game = new MyWorld();
            Greenfoot.setWorld(game);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare(int hiScore)
    {
        //initialize elephant and add it to top right of screen
        Elephant elephant = new Elephant();
        addObject(elephant,410,150);
        elephant.setLocation(535,79);
        
        //initialize instruction label and set it to middle of screen
        Label label = new Label("Use \u2190 and \u2192 to move", 40);
        addObject(label,284,210);
        
        //initialize instruction label and set it to middle of screen
        Label label2 = new Label("Press <space> to start", 40);
        addObject(label2,284,240);
        
        //initialize high score label and set it to middle of screen
        Label label3 = new Label("Highest score:" + hiScore, 40);
        addObject(label3, 284, 300);
    }
}
