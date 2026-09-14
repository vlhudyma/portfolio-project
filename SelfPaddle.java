import greenfoot.*;


/**
 * A paddle is an object that goes back and forth. Though it would be nice if balls would bounce of it.
 * 
 * @author The teachers 
 * @version 1
 */
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
        createImage();
        int direction = Greenfoot.getRandomNumber(2);
            if(direction == 0){
                dx = -1;
            }
            else{
                dx = 1;
            }
    }
    
    /**
     * Act - do whatever the Paddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        tryChangeDirection();
        setLocation(getX() + dx, getY());
    }    
    /**
     * Will rotate the paddle 180 degrees if the paddle is at worlds edge.
     */
    private void tryChangeDirection()
    {
        //Check to see if we are touching the outer boundaries of the world:
        // IF we are touching the right boundary OR we are touching the left boundary:
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

    /**
     * Creates and sets an image for the paddle, the image will have the same dimensions as the paddles 
width and height.
     */
    private void createImage()
    {
        GreenfootImage image = new GreenfootImage(width, height);
        setImage("paddle-orange.jpg");
    }

}
