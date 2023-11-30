import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TitleScreen extends World
{

    Label title = new Label("Hungry Elephant", 70);
    
    public TitleScreen(int hiScore)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(title, 260, 80);
        prepare(hiScore);
    }
    
    public TitleScreen() {
        super(600, 400, 1);
        addObject(title, 260, 80);
        prepare(0);
    }

    public void act() {
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
        Elephant elephant = new Elephant();
        addObject(elephant,410,150);
        elephant.setLocation(535,79);
        Label label = new Label("Use \u2190 and \u2192 to move", 40);
        addObject(label,284,210);
        Label label2 = new Label("Press <space> to start", 40);
        addObject(label2,284,240);
        Label label3 = new Label("Highest score:" + hiScore, 40);
        addObject(label3, 284, 300);
    }
}
