import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class displayBowcat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DisplayCat extends Actor
{
    public DisplayCat(int num){
        if (num == 1) {
            setImage("kucingpanah.PNG");
            getImage().scale(60, 60);
        }
        if (num == 2) {
            setImage("Kucingpistol.PNG");
            getImage().scale(60, 60);
        }
        if (num == 3) {
            setImage("kucingsihir (1).png");
            getImage().scale(60, 60);
        }
    }
    public void act()
    {
        
    }
}
