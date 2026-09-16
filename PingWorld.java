import greenfoot.*;

public class PingWorld extends World
{
    private static final int WORLD_WIDTH = 500;
    private static final int WORLD_HEIGHT = 700;

    public PingWorld(boolean gameStarted)
    {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1,false); // false let Paddle go out of the frame.
        if (gameStarted)
        {
            addObject(new Ball(), WORLD_WIDTH/2, WORLD_HEIGHT/2);
            addObject(new Paddle(100,20), 60, WORLD_HEIGHT - 50);
            addObject(new SelfPaddle(100,20),100, Greenfoot.getRandomNumber(WORLD_HEIGHT/2)+50);
            setStats(0, 0);
        }
        else
        {
            Greenfoot.setWorld(new IntroWorld());
        }
    }
    
    public void setStats(int level, int hits){
      GreenfootImage ig = getBackground();
      ig.drawImage(new GreenfootImage("game-background-arcade.jpg"), 0, 0);
      ig.setColor(Color.WHITE);
      ig.setFont(new Font("Arial", true, false, 18));
      ig.drawString("Game Level: "+ level, WORLD_WIDTH - 150, 35);
      ig.drawString("Hits: "+ hits, 30, 35);

      setBackground(ig);
    }

}
