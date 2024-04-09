import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Money here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DisplayMoney extends Actor
{
    /**
     * Act - do whatever the Money wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private MyWorld game;
    public DisplayMoney(MyWorld game){
        this.game = game;
        setImage(new GreenfootImage("$: " + game.getMoney(), 50, Color.WHITE, new Color(0,0,0,0)));
    }
    public void act()
    {
        setImage(new GreenfootImage("$: " + game.getMoney(), 50, Color.WHITE, new Color(0,0,0,0)));
    }
}
