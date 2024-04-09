import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Troop extends Actor
{
    int fireRate = 0;
    public int level;
    private MyWorld game;
    public Troop(int level){
        this.level = level;
        if(level == 1){
            setImage("kucingpanah.PNG");
            getImage().scale(60, 60);
        }
        if(level == 2){
            setImage("Kucingpistol.PNG");
            getImage().scale(60, 60);
        }
        if(level == 3){
            setImage("kucingsihir (1).png");
            getImage().scale(60, 60);
        }
    }
    
    public void act()
    {
        enemyDetector();
    }
    
    public void enemyDetector(){
        fireRate++;
        List<Enemy> enemies = getObjectsInRange(100, Enemy.class);
        for(Enemy eachEnemy : enemies){
            if(fireRate % 15 == 0 && level == 1){
                if(fireRate % 60 == 0){
                   Greenfoot.playSound("arrow.mp3"); 
                }
                Projectile projectile1 = new Projectile(1);
                getWorld().addObject(projectile1, getX(), getY());
                projectile1.turnTowards(eachEnemy.getX(), eachEnemy.getY());
                break;
            }
            if(fireRate % 15 == 0 && level == 2){
                if(fireRate % 60 == 0){
                   Greenfoot.playSound("blaster.mp3"); 
                }
                for(int i = 0; i < 3; i++){
                    Projectile projectile2 = new Projectile(2);
                    getWorld().addObject(projectile2, getX(), getY());
                    projectile2.turnTowards(eachEnemy.getX(), eachEnemy.getY());
                }
                break;
            }
            if(fireRate % 30 == 0 && level == 3){
                if(fireRate % 60 == 0){
                    Greenfoot.playSound("fire.mp3");
                }
                for(int i = 0; i < 7; i++){
                    Projectile projectile3 = new Projectile(3);
                    getWorld().addObject(projectile3, getX(), getY());
                    projectile3.turnTowards(eachEnemy.getX(), eachEnemy.getY());
                }
                break;
            }
        }
    }

}
