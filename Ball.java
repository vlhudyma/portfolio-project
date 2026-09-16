import greenfoot.*;

public class Ball extends SmoothMover
{
    private static final int BALL_SIZE = 25;
    private static final int BOUNCE_DEVIANCE_MAX = 5;
    private static final int STARTING_ANGLE_WIDTH = 90;
    private static final int DELAY_TIME = 100;

    private int speed;
    private boolean hasBouncedHorizontally;
    private boolean hasBouncedVertically;
    private int delay;
    private boolean bounced = false;
    private int bouncedCounter = 0;
    private int level = 1;

    /**
     * Contructs the ball and sets it in motion!
     */
    public Ball()
    {
        init();
    }

    public void act() 
    {
        if (delay > 0)
        {
            delay--;
        }
        else
        {
            move(speed);
            playWallSound();
            playCeilingSound();
            checkBounceOffWalls();
            checkBounceOffCeiling();
            playGameOverSound();
            checkRestart();
            bounceOfPaddle();
            bounceOfSelfPaddle();
            levelUp();
        }
    }

    /**
     * Returns true if the ball is touching one of the side walls.
     */
    private boolean isTouchingSides()
    {
        return (getX() <= BALL_SIZE/2 || getX() >= getWorld().getWidth() - BALL_SIZE/2);
    }
    /**
     * Play sound if touching.
     */
    private void playWallSound(){
        if (isTouchingSides()){
        
        Greenfoot.playSound("wall-hit.wav");
    }
    }

    /**
     * Returns true if the ball is touching the ceiling.
     */
    private boolean isTouchingCeiling()
    {
        return (getY() <= BALL_SIZE/2);
    }
    /**
     * Play sound if touching.
     */
    private void playCeilingSound(){
        if (isTouchingCeiling()){
        
        Greenfoot.playSound("ceiling-hit.wav");
    }
    }

    /**
     * Returns true if the ball is touching the floor.
     */
    private boolean isTouchingFloor()
    { 
        return (getY() >= getWorld().getHeight() - BALL_SIZE/2);
    }
    /**
     * Play sound if touching.
     */
    private void playGameOverSound(){
        if (isTouchingFloor()){
        
        Greenfoot.playSound("game-over.wav");
    }
    }

    /**
     * Check to see if the ball should bounce off one of the walls.
     * If touching one of the walls, the ball is bouncing off.
     */
    private void checkBounceOffWalls()
    {
        if (isTouchingSides())
        {
            if (! hasBouncedHorizontally)
            {
                revertHorizontally();
            }
        }
        else
        {
            hasBouncedHorizontally = false;
        }
    }

    /**
     * Check to see if the ball should bounce off the ceiling.
     * If touching the ceiling the ball is bouncing off.
     */
    private void checkBounceOffCeiling()
    {
        if (isTouchingCeiling())
        {
            if (! hasBouncedVertically)
            {
                revertVertically();
            }
        }
        else
        {
            hasBouncedVertically = false;
        }
    }

    /**
     * Check to see if the ball is touching floor.
     * If that is true, the screen changes to GameOver screen.
     */
    private void checkRestart()
    {
        if (isTouchingFloor())
        {
             Greenfoot.setWorld(new GameOver());
        }
    }

    /**
     * Bounces the ball back from a vertical surface.
     */
    private void revertHorizontally()
    {
        int randomness = Greenfoot.getRandomNumber(BOUNCE_DEVIANCE_MAX)- BOUNCE_DEVIANCE_MAX / 2;
        setRotation((180 - getRotation()+ randomness + 360) % 360);
        hasBouncedHorizontally = true;
    }

    /**
     * Bounces the ball back from a horizontal surface.
     */
    private void revertVertically()
    {
        int randomness = Greenfoot.getRandomNumber(BOUNCE_DEVIANCE_MAX)- BOUNCE_DEVIANCE_MAX / 2;
        setRotation((360 - getRotation()+ randomness + 360) % 360);
        hasBouncedVertically = true;
        
    }

    /**
     * Initialize the ball settings.
     */
    private void init()
    {
        speed = 2;
        delay = DELAY_TIME;
        hasBouncedHorizontally = false;
        hasBouncedVertically = false;
        setRotation(Greenfoot.getRandomNumber(STARTING_ANGLE_WIDTH)+STARTING_ANGLE_WIDTH/2);
    }
    /**
     * Increase level every time when the ball bounced 10 times on the Paddle. When it reaches 10 times, speed grows by 1 and levelUp sound is played.
     */
    public void levelUp(){
    if ( bouncedCounter >= 10){
            speed = speed +1;
            level++;
            bouncedCounter = 0;
            Greenfoot.playSound("levelUp.wav");
            
    }
    PingWorld pingWorld = (PingWorld) this.getWorld();    
    pingWorld.setStats(bouncedCounter, level);
    }

    /**
     * Check if the ball is bounced and its rotation less then 180. If that is true, the ball revert verically and bounced counter increase by 1. 
     */
    private void bounceOfPaddle(){
            if (isTouching(Paddle.class)){
                if (!bounced && this.getRotation()<180) {
                revertVertically();
                bounced=true;
                bouncedCounter ++;
                Greenfoot.playSound("hitSound.wav");
            } else {
                bounced=false;
            }
        }
    }
    /**
     * Check if the ball is bounced and its rotation more then 180, than the ball revert. 
     */
    private void bounceOfSelfPaddle(){
            if (isTouching(SelfPaddle.class)){
                if (!bounced && this.getRotation()>180) {
                revertVertically();
                bounced=true;
                Greenfoot.playSound("hitSound.wav");
            } else {
                bounced=false;
            }
        }
    }
}
