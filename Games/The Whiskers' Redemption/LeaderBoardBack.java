import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LeaderBoardBack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LeaderBoardBack extends Actor
{
    /**
     * Act - do whatever the LeaderBoardBack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    public LeaderBoardBack(){
        GreenfootImage myImage = getImage();
        int myNewHeight = (int)myImage.getHeight();
        int myNewWidth = (int)myImage.getWidth();
        myImage.scale(1500, 850);
    }
}
