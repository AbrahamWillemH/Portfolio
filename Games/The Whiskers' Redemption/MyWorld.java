import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public int money;
    public int worldHealth = 10;
    public int temp = 0;
    public int time = 0;
    public int wave = 0;
    
    public int getMoney(){
        return money;
    }
    
    public void setMoney(int newMoney){
        money += newMoney;
    }
    
    public int getWorldHealth(){
        return worldHealth;
    }

    public void setNewWorldHealth(int newWorldHealth){
        worldHealth = newWorldHealth;
    }
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1260, 600, 1);
    }
    
    public void addTroops(int tmp){
        if (Greenfoot.isKeyDown("1") && money >= price(1) && Greenfoot.getMouseInfo().getActor() instanceof RedCircle) {
            boolean isRedCircleAtLocation = false;
            for (RedCircle redCircle : getObjectsAt((Greenfoot.getMouseInfo().getX() / 60) * 60 + 30, (Greenfoot.getMouseInfo().getY() / 60) * 60 + 10, RedCircle.class)) {
                isRedCircleAtLocation = true;
                break;
            }
            if (isRedCircleAtLocation) {
                boolean isTroopAtLocation = false;
                for (Troop troop : getObjectsAt((Greenfoot.getMouseInfo().getX() / 60) * 60 + 30, (Greenfoot.getMouseInfo().getY() / 60) * 60 + 10, Troop.class)) {
                    isTroopAtLocation = true;
                    break;
                }
                if (!isTroopAtLocation) {
                    addObject(new Troop(1), (Greenfoot.getMouseInfo().getX() / 60) * 60 + 30, (Greenfoot.getMouseInfo().getY() / 60) * 60 + 10);
                    money -= price(1);
                }
            }
        }
        if (tmp != 1){
            if(Greenfoot.isKeyDown("2") && money >= price(2) && Greenfoot.getMouseInfo().getActor() instanceof RedCircle){
                boolean isRedCircleAtLocation = false;
                for (RedCircle redCircle : getObjectsAt((Greenfoot.getMouseInfo().getX() / 60) * 60 + 30, (Greenfoot.getMouseInfo().getY() / 60) * 60 + 10, RedCircle.class)) {
                    isRedCircleAtLocation = true;
                    break;
                }
                if (isRedCircleAtLocation) {
                    boolean isTroopAtLocation = false;
                    for (Troop troop : getObjectsAt((Greenfoot.getMouseInfo().getX() / 60) * 60 + 30, (Greenfoot.getMouseInfo().getY() / 60) * 60 + 10, Troop.class)) {
                        isTroopAtLocation = true;
                        break;
                    }
                    if (!isTroopAtLocation) {
                        addObject(new Troop(2), (Greenfoot.getMouseInfo().getX() / 60) * 60 + 30, (Greenfoot.getMouseInfo().getY() / 60) * 60 + 10);
                        money -= price(2);
                    }
                }
            }
            else if(Greenfoot.isKeyDown("3") && money >= price(3) && Greenfoot.getMouseInfo().getActor() instanceof RedCircle){
                boolean isRedCircleAtLocation = false;
                for (RedCircle redCircle : getObjectsAt((Greenfoot.getMouseInfo().getX() / 60) * 60 + 30, (Greenfoot.getMouseInfo().getY() / 60) * 60 + 10, RedCircle.class)) {
                    isRedCircleAtLocation = true;
                    break;
                }
                if (isRedCircleAtLocation) {
                    boolean isTroopAtLocation = false;
                    for (Troop troop : getObjectsAt((Greenfoot.getMouseInfo().getX() / 60) * 60 + 30, (Greenfoot.getMouseInfo().getY() / 60) * 60 + 10, Troop.class)) {
                        isTroopAtLocation = true;
                        break;
                    }
                    if (!isTroopAtLocation) {
                        addObject(new Troop(3), (Greenfoot.getMouseInfo().getX() / 60) * 60 + 30, (Greenfoot.getMouseInfo().getY() / 60) * 60 + 10);
                        money -= price(3);
                    }
                }
            }
        }
    }
    
    public void delTroops() {
        if (Greenfoot.isKeyDown("4")) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse != null && mouse.getActor() instanceof Troop) {
                Troop clickedTroop = (Troop) mouse.getActor();
                removeTroop(clickedTroop);
            }
        }
    }
    
    private void removeTroop(Troop troop) {
        if (troop != null) {
            removeObject(troop);
            int refundAmount = 0;
            if (troop.level == 1)
                refundAmount = 25;
            else if (troop.level == 2)
                refundAmount = 75;
            else if (troop.level == 3)
                refundAmount = 125;
    
            setMoney(refundAmount);
        }
    }

    
    public void addPrecil(int locX, int locY) {
        Enemy enemy1 = new Enemy(2, this);
        Enemy enemy2 = new Enemy(2, this);
        Enemy enemy3 = new Enemy(2, this);
        
        if (locX == 1170){
            enemy1.setRotation(270);
            enemy2.setRotation(270);
            enemy3.setRotation(270);
        }
        
        if (locY == 390 || locY == 150){
            enemy1.setRotation(180);
            enemy2.setRotation(180);
            enemy3.setRotation(180);
            enemy1.getImage().mirrorVertically();
            enemy2.getImage().mirrorVertically();
            enemy3.getImage().mirrorVertically();
        } else {
            enemy1.setRotation(0);
            enemy2.setRotation(0);
            enemy3.setRotation(0);
        }
        addObject(enemy1, locX - 10, locY);
        addObject(enemy2, locX, locY);
        addObject(enemy3, locX + 10, locY);
    }
    
    public int price(int temp){
        if(temp == 1){
            return 50;
        }
        if(temp == 2){
            return 150;
        }
        if(temp == 3){
            return 250;
        }
        else{
           return 0; 
        }  
    }
    
    public void updateScore() {
        if(UserInfo.isStorageAvailable()){
            UserInfo myInfo = UserInfo.getMyInfo();
            int scoreBefore = myInfo.getScore();
            myInfo.setScore(scoreBefore + worldHealth);
            myInfo.store();
        }
    }
    
    public static void main(String[] args) {
        GameStartWorld gamestart = new GameStartWorld();
        Greenfoot.setWorld(gamestart);
    }
}
