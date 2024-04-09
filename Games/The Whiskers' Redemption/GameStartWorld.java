import greenfoot.*;

public class GameStartWorld extends World
{
    private DisplayTextInfo2 keypress;
    private int keypressCount;

    public GameStartWorld()
    {    
        super(1260, 600, 1); 
        GreenfootImage backgroundImage = new GreenfootImage("depan.png");
        backgroundImage.scale(getWidth(), getHeight());
        setBackground(backgroundImage);
        
        keypress = new DisplayTextInfo2();
        addObject(keypress, 630, 550);
        keypressCount = 0;
    }
    
    public void act() {
        
        if (Greenfoot.getKey() != null && keypressCount < 3) {
            removeObject(keypress);
            keypress = null;
            Greenfoot.playSound("play.mp3");
            keypressCount++;
            DisplayTextInfo3 keypress2 = new DisplayTextInfo3();
            addObject(keypress2, 1000, 40);
            if (keypressCount == 1) {
                GreenfootImage backgroundImage = new GreenfootImage("linestory1.png");
                backgroundImage.scale(getWidth(), getHeight());
                setBackground(backgroundImage);
            }
            else if (keypressCount == 2) {
                GreenfootImage backgroundImage2 = new GreenfootImage("linestory2.png");
                backgroundImage2.scale(getWidth(), getHeight());
                setBackground(backgroundImage2);
            }
            else if (keypressCount == 3) {
                Level1 level4 = new Level1();
                Greenfoot.setWorld(level4);
            }
        }
    }
}
