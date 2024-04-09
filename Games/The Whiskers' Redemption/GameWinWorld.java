import greenfoot.*;

public class GameWinWorld extends World
{
    private DisplayTextInfo3 keypress;
    private int check;
    public int test = 0;

    public GameWinWorld(int check)
    {   
        super(1260, 600, 1);
        Greenfoot.playSound("victory.mp3");
        GreenfootImage backgroundImage = new GreenfootImage("WIN.png");
        backgroundImage.scale(getWidth(), getHeight());
        setBackground(backgroundImage);
        this.check = check;
    
        DisplayTextInfo3 keypress = new DisplayTextInfo3();
        addObject(keypress, 630, 550);
    }

    public void act() {
        if (Greenfoot.isKeyDown("enter")) {
            if (check == 0) {
                Level2 level2 = new Level2();
                check = 1;
                Greenfoot.setWorld(level2);
            } else if (check == 1) {
                Level3 level3 = new Level3();
                Greenfoot.setWorld(level3);
            } else if (check == 2){
                Level4 level4 = new Level4();
                Greenfoot.setWorld(level4);
            } else if (check == 3) {
                Greenfoot.setWorld(new Leaderboard());
            }
        }
    }
}
