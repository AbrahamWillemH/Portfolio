import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LeaderBoardFont here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LeaderBoardFont extends Actor
{
    /**
     * Act - do whatever the LeaderBoardFont wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    public LeaderBoardFont(){
        GreenfootImage myImage = getImage();
        int myNewHeight = (int)myImage.getHeight()/2;
        int myNewWidth = (int)myImage.getWidth()/2;
        myImage.scale(myNewWidth, myNewHeight);
    }
}
