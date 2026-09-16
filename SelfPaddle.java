import greenfoot.*;

public class SelfPaddle extends Actor
{
    private int width;
    private int height;
    private int dx;
    private boolean rightDirection = true;

    /**
     * Constructs a new paddle with the given dimensions.
     */
    public SelfPaddle(int width, int height)
    {
        this.width = width;
        this.height = height;
        int direction = Greenfoot.getRandomNumber(2);
            if(direction == 0){
                dx = -1;
            }
            else{
                dx = 1;
            }
    }
    
    /**
     * Act - do whatever the SelfPaddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        oppositeRestart();
        setLocation(getX() + dx, getY());
    }    
    /**
     * Whenever the SelfPaddle touching right or left boundaries, it starts on the opposite side.
     */
    private void oppositeRestart()
    {
        //Check to see if we are touching left or right boundaries.
        // If SelfPaddle touch the left side, it appears on the right side.
        if(getX() - width/2 > 450 || getX() + width/2 < 50)
        {
            if (dx == -1){
                setLocation(500,Greenfoot.getRandomNumber(350)+10);
            }
            else{
                setLocation(0,Greenfoot.getRandomNumber(350)+10);
            }
        }
    }

}
