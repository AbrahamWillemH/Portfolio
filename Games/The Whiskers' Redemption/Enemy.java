    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    import java.util.*;
    /**
     * Write a description of class Ghost here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
    public class Enemy extends Actor
    {
        /**
         * Act - do whatever the Ghost wants to do. This method is called whenever
         * the 'Act' or 'Run' button gets pressed in the environment.
         */
        private int enemy_health;
        private int level;
        private MyWorld game;
        private boolean isFlipped;
        private int originalY;
        private int originalX;
        private int bobbingRange = 3; // Adjust this value to control the bobbing range
        private int bobbingSpeed = 3; // Adjust this value to control the bobbing speed
        private int bobbingTimer = 0;
        public Enemy(int level, MyWorld game){
            this.level = level;
            this.game = game;
            if(level == 1){
                setImage("mousefinal.png");
                getImage().scale(60, 60);
                enemy_health = 5;
            }
            else if(level == 2){
                setImage("anjingzombie.png");
                getImage().scale(40, 40);
                enemy_health = 13;
            }
            else if(level == 3){
                setImage("zombie.png");
                getImage().scale(60, 60);
                enemy_health = 21;
            }
            else if(level == 4){
                setImage("blimp.png");
                getImage().scale(100, 100);
                enemy_health = 100;
            }
        }
        public void act()
        {
            moveEnemy();
            hitByProjectile();
            isFinish(game);
        }
        public void moveEnemy() {
            bobbingTimer++;
            int yOffset = (int) (bobbingRange * Math.sin((double) bobbingTimer / bobbingSpeed));
            int xOffset = (int) (bobbingRange * Math.sin((double) bobbingTimer / bobbingSpeed));
            if (level != 4) {
                move(2);
            } else {
                move(1);
            }
            List<Path> path90 = getObjectsAtOffset(-30, 0, Path.class);
            for (Path paths : path90) {
                originalY = getY();
                if (paths.straight == true && getRotation() == 0) {
                    setLocation(getX(), originalY - yOffset);
                } else if (paths.straight == false && getRotation() == 0) {
                    if (isFlipped == true) {
                        getImage().mirrorVertically();
                        isFlipped = false;
                    }
                    setRotation(paths.turn);
                }
            }
            
            List<Path> path0 = getObjectsAtOffset(0, -30, Path.class);
            for (Path paths : path0) {
                originalX = getX();
                if (paths.straight == true && getRotation() == 90) {
                    setLocation(originalX - xOffset, getY());
                } else if (paths.straight == false && getRotation() == 90) {
                    setRotation(paths.turn);
                }
            }
            
            List<Path> path270 = getObjectsAtOffset(+30, 0, Path.class);
            for (Path paths : path270) {
                originalY = getY();
                if (paths.straight == true && getRotation() == 180) {
                    setLocation(getX(), originalY - yOffset);
                }
                if (paths.straight == false && getRotation() == 180) {
                    if (!isFlipped) {
                        getImage().mirrorVertically();
                        isFlipped = true;
                    }
                    setRotation(paths.turn);
                }
            }
            
            List<Path> path180 = getObjectsAtOffset(0, +30, Path.class);
            for (Path paths : path180) {
                originalX = getX();
                if (paths.straight == true && getRotation() == 270) {
                    setLocation(originalX - xOffset, getY());
                }
                if (paths.straight == false && getRotation() == 270) {
                    setRotation(paths.turn);
                }
            }
        }

        
        public void hitByProjectile() {
            int time = 0;
            int count = 0;
            time++;
            try {
                Actor projectile = getOneIntersectingObject(Projectile.class);
                if (projectile != null) {
                    enemy_health --;
                    if (enemy_health == 1 && level == 4){
                        int locX = this.getX();
                        int locY = this.getY();
                        Greenfoot.delay(2);
                        game.addPrecil(locX, locY);
                    }
                    if (enemy_health < 1) {
                            World world = getWorld();
                            if (world != null) {
                                world.removeObject(this);
                                if(level == 1)
                                    game.setMoney(4);
                                if(level == 2)
                                    game.setMoney(8);
                                if(level == 3)
                                    game.setMoney(16);
                                if (level == 4){
                                    game.setMoney(75);
                                }
                            }
                        }
                    if (projectile.getWorld() != null) {
                        projectile.getWorld().removeObject(projectile);
                    }
                }
            } catch (NullPointerException e) {
                System.out.println("Error: tidak ada proyektil yang ditemukan");
            }
        }
    
        public void isFinish(MyWorld game){
            this.game = game;
            if(this.getWorld() != null && this.getX() == 1170 && this.getY() == 599){
                getWorld().removeObject(this);
                if (level != 4){
                    game.worldHealth--;    
                } else {
                    game.worldHealth -= 10;
                }
                if(game.worldHealth <= 0){
                    Greenfoot.setWorld(new GameOverWorld());
                }
            }
        }
    }
    
    
        
