import greenfoot.*;

public class Paddle extends Actor
{
    private int width;
    private int height;
    private int dx;

    /**
     * Constructs a new paddle with the given dimensions.
     */
    public Paddle(int width, int height)
    {
        this.width = width;
        this.height = height;
        dx = 1;
    }

    /**
     * Act - do whatever the Paddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        tryChangeDirection();
        operatePaddle();
    }    
    /**
     * operatePadle - The “left” and “right” keys operate the paddle.
     */
    private void operatePaddle(){
        if(Greenfoot.isKeyDown("left")&& getX()>50){
            setLocation(getX()-6,getY());
    }
        if(Greenfoot.isKeyDown("right")&& getX()<450){
            setLocation(getX()+6,getY());
    }
        
    }
    /**
     * Will rotate the paddle 180 degrees if the paddle is at worlds edge.
     */
    private void tryChangeDirection()
    {
        //Check to see if we are touching the outer boundaries of the world:
        // IF we are touching the right boundary OR we are touching the left boundary:
        if(getX() + width/2 >= getWorld().getWidth() || getX() - width/2 <= 0)
        {
            //Change our 'x' direction to the inverted direction:
            dx = dx * -1;
        }
    }

}
