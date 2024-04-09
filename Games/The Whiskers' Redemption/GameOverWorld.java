import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverWorld extends World
{
    /**
     * Constructor for objects of class GameOverWorld.
     * 
     */
    public GameOverWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1260, 600, 1); 
        GreenfootImage backgroundImage = new GreenfootImage("lost.png");
        backgroundImage.scale(getWidth(), getHeight());
        setBackground(backgroundImage);
        Greenfoot.playSound("defeat.mp3");
        Greenfoot.stop();
    }
}
