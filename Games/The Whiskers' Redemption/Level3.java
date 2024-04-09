import greenfoot.*;

public class Level3 extends MyWorld
{
    public int money = 150;
    private boolean actionsEnabled = false;
    int map [][] =  {
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,2,1,1,5,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,0,6,1,0,0,3,1,1,1,2,0,0,0,0},
                {0,0,0,0,0,0,1,6,0,1,0,6,1,0,6,0,1,0,0,0,0},
                {0,0,0,0,0,0,3,1,1,1,1,1,4,0,0,0,1,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,6,0,0,0},
                {0,0,0,0,0,0,0,0,6,1,0,0,0,0,0,0,1,0,0,0,0},
                {0,0,0,0,1,1,1,1,1,4,0,0,0,0,0,0,1,0,0,6,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,1,1,2,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
                };

    private static final int GRID_CELL_SIZE = 20; // Define your desired grid cell size

    public Level3(){
        super();
        Greenfoot.playSound("mainMusic.mp3");
        setMoney(225);
        displayPreparations();
        mapping();
        delTroops();
    }
    
    public void start(){
        //Method kosong supaya Level3 bisa jalan
    }
    
    public void act() {
        wave = 3;
        addTroops(2);
        if (Greenfoot.mouseClicked(null) && !actionsEnabled) {
            Actor clickedActor = Greenfoot.getMouseInfo().getActor();
            if (clickedActor instanceof StartButton) {
                Greenfoot.playSound("press.mp3");
                actionsEnabled = true;
            }
        }
        if (actionsEnabled) {
            spawnWave();
        }
    }
    
    private void mapping(){
        for(int i = 0; i < 21; i++){
            for(int j = 0; j < 10; j++){
                if (map[j][i] == 1){
                    addObject(new Path(true), 30 + i * 60, 30 + j * 60);
                }
                if (map[j][i] == 2){
                    addObject(new Path(90), 30 + i * 60, 30 + j * 60);
                }
                if (map[j][i] == 3){
                    addObject(new Path(0), 30 + i * 60, 30 + j * 60);
                }
                if (map[j][i] == 4){
                    addObject(new Path(270), 30 + i * 60, 30 + j * 60);
                }
                if (map[j][i] == 5){
                    addObject(new Path(180), 30 + i * 60, 30 + j * 60);
                }
                if (map[j][i] == 6){
                    addObject(new RedCircle(), 30 + i * 60, 30 + j * 60);
                }
            }
        }
    }
    
    public void spawnWave(){
        time++;
        if(time <= 5000 && time >= 150){
            if(time <= 500 && time %25 == 0){
                Enemy enemy1 = new Enemy(1, this);
                addObject(enemy1, 270, 450);
            }
            if(time <= 500 && time %100 == 0){
                Enemy enemy2 = new Enemy(2, this);
                addObject(enemy2, 270, 450);
            }
            if(time <= 1500 && time > 500 && time %50 == 0){
                Enemy enemy2 = new Enemy(2, this);
                addObject(enemy2, 270, 450);
            }
            if(time <= 2250 && time > 1500 && time %125 == 0){
                Enemy enemy3 = new Enemy(3, this);
                addObject(enemy3, 270, 450);
            }
            if(time <= 2250 && time > 1500 && time %25 == 0){
                Enemy enemy1 = new Enemy(1, this);
                addObject(enemy1, 270, 450);
            }
            if(time <= 3500 && time > 2250 && time %50 == 0){
                Enemy enemy2 = new Enemy(2, this);
                addObject(enemy2, 270, 450);
            }
            if(time <= 3500 && time > 2250 && time % 25 == 0){
                Enemy enemy1 = new Enemy(1, this);
                addObject(enemy1, 270, 450);
            }
            if(time <= 3500 && time > 2250 && time % 80 == 0){
                Enemy enemy3 = new Enemy(3, this);
                addObject(enemy3, 270, 450);
            }
            if(time <= 4000 && time > 3500 && time % 50 == 0){
                Enemy enemy3 = new Enemy(3, this);
                addObject(enemy3, 270, 450);
            }
            if(time == 4700){
                updateScore();
                Greenfoot.setWorld(new GameWinWorld(2));
            }
        }
    }
    
    public void displayPreparations(){
        Menu menu = new Menu();
        DisplayMoney dMoney = new DisplayMoney(this);
        DisplayCat displaybowcat = new DisplayCat(1);
        DisplayCat displayguncat = new DisplayCat(2);
        DisplayCat displaywizardcat = new DisplayCat(3);
        DisplayTextInfo displaytextinfo = new DisplayTextInfo(1, this);
        DisplayTextInfo displayprice1 = new DisplayTextInfo(2, this);
        DisplayTextInfo displayprice2 = new DisplayTextInfo(3, this);
        DisplayTextInfo displayprice3 = new DisplayTextInfo(4, this);
        DisplayTextInfo displayhealth = new DisplayTextInfo(5, this);
        DisplayTextInfo displaywave = new DisplayTextInfo(6, this);
        StartButton start = new StartButton();
        addObject(menu, 510, 300);
        addObject(dMoney, 115, 550);
        addObject(displaybowcat, 120, 200);
        addObject(displayguncat, 120, 280);
        addObject(displaywizardcat, 120, 360);
        addObject(displaytextinfo, 115, 130);
        addObject(displayprice1, 115, 250);
        addObject(displayprice2, 115, 330);
        addObject(displayprice3, 115, 410);
        addObject(displayhealth, 115, 510);
        addObject(displaywave, 115, 50);
        addObject(start, 115, 470);
    }   
}