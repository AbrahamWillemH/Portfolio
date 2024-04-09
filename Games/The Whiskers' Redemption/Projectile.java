import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    int num;
    private Enemy targetEnemy;
    public Projectile(int num){
        this.num = num;
        if(num == 1){
            setImage("anakpanah2.png");
            getImage().scale(30, 30);
        }
        if(num == 2){
            setImage("peluru.png");
            getImage().scale(30, 30);
        }   
        if(num == 3){
            setImage("api.png");
            getImage().scale(30, 30);
        }   
    }
    public void act(){
        move(7);
    }
    public void setTargetEnemy (Enemy enemy){
        targetEnemy = enemy;
    }
}
