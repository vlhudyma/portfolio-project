import greenfoot.*;  

public class GameOver extends World
{
    private static final int WORLD_WIDTH = 500;
    private static final int WORLD_HEIGHT = 700;


    public GameOver()
    {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1);
        GreenfootImage background = getBackground();
        background.setColor(Color.WHITE);
        background.drawString("Hit <enter> to start the game over...", WORLD_WIDTH / 2 - 100, WORLD_HEIGHT - 70);
        
    }

    public void act()
    {
        String key = Greenfoot.getKey();
        if (key != null && key.equals("enter"))
        {
            Greenfoot.setWorld(new PingWorld(true));
        }
    }
    
    }
