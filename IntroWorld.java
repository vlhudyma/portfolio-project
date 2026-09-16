import greenfoot.*;

public class IntroWorld extends World
{
    private static final int WORLD_WIDTH = 500;
    private static final int WORLD_HEIGHT = 700;


    public IntroWorld()
    {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1);
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        Label text = new Label("PING PONG", 60);
        text.setFillColor(Color.BLACK);
        addObject(text, WORLD_WIDTH / 2, WORLD_HEIGHT - 630);
        background.drawString("Hit <enter> to start game. ", WORLD_WIDTH / 2 - 70, WORLD_HEIGHT - 70);
        background.drawString("Use <left> and <right> button to steer Paddle. ", WORLD_WIDTH / 2 - 130, WORLD_HEIGHT - 40);
    }
    /**
    The game will start if "enter" button is pressed. New PingWorld screen appeares instead of IntroWorld.
    */
    public void act()
    {
        String key = Greenfoot.getKey();
        if (key != null && key.equals("enter"))
        {
            Greenfoot.setWorld(new PingWorld(true));
        }
    }
    
}
