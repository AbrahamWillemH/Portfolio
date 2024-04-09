import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class DisplayTextInfo extends Actor {
    private int num;
    private MyWorld game;
    private GameStartWorld start;
    public DisplayTextInfo(int num, MyWorld game) {
        this.num = num;
        this.game = game;
        if (num == 1) {
            setImage(new GreenfootImage("Press the number below with\nyour mouse hovering on the\nred circle to buy", 20, Color.WHITE, new Color(0, 0, 0, 0)));
        }
        if (num == 2) {
            setImage(new GreenfootImage("1\nPrice: 50$", 20, Color.WHITE, new Color(0, 0, 0, 0)));
        }
        if (num == 3) {
            setImage(new GreenfootImage("2\nPrice: 150$", 20, Color.WHITE, new Color(0, 0, 0, 0)));
        }
        if (num == 4) {
            setImage(new GreenfootImage("3\nPrice : 250$", 20, Color.WHITE, new Color(0, 0, 0, 0)));
        }
        if (num == 5){
            setImage(new GreenfootImage("HP: " + game.getWorldHealth(), 50, Color.WHITE, new Color(0, 0, 0, 0)));
        }
        if (num == 6){
            setImage(new GreenfootImage("Level: " + game.wave, 50, Color.WHITE, new Color(0, 0, 0, 0)));
        }
    }

    public void act() {
        // Implement behavior in the act method, using the 'num' variable if needed
        if(this.num == 5){
            setImage(new GreenfootImage("HP: " + game.getWorldHealth(), 50, Color.WHITE, new Color(0, 0, 0, 0)));
        }
        if (this.num == 6){
            setImage(new GreenfootImage("Level: " + game.wave, 50, Color.WHITE, new Color(0, 0, 0, 0)));
        }
    }
}
