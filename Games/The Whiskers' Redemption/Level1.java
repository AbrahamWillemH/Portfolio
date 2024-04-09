import greenfoot.*;

public class Level1 extends MyWorld
{
    private boolean actionsEnabled = false;
    int map [][] =  {
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,1,1,1,1,1,1,2,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,6,0,0,0,0,6,1,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,1,0,0,6,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,3,1,1,1,1,1,1,1,2,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,6,1,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
                };

    private static final int GRID_CELL_SIZE = 50; // Define your desired grid cell size

    public Level1(){ 
        super();
        Greenfoot.playSound("mainMusic.mp3");
        setMoney(100);
        displayPreparations();
        mapping();
    }
    
    public void act() {
        wave = 1;
        addTroops(1);
        delTroops();
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
        if(time >= 150 && time <= 2000){
            if(time < 1000 && time % 50 == 0){
                Enemy enemy1 = new Enemy(1, this);
                addObject(enemy1, 270, 90);
            }
            if(time <= 1000 && time %150 == 0 && time >= 700){
                Enemy enemy2 = new Enemy(2, this);
                addObject(enemy2, 270, 90);
            }
            if(time <= 2000 && time %75 == 0 && time >= 1000){
                Enemy enemy2 = new Enemy(2, this);
                addObject(enemy2, 270, 90);
            }
        }
        if(time >= 2500){
            updateScore();
            Greenfoot.setWorld(new GameWinWorld(0));
        }
    }
    
    public void displayPreparations(){
        Menu menu = new Menu();
        DisplayMoney dMoney = new DisplayMoney(this);
        DisplayCat displaybowcat = new DisplayCat(1);
        DisplayCat displayguncat = new DisplayCat(2);
        DisplayTextInfo displaytextinfo = new DisplayTextInfo(1, this);
        DisplayTextInfo displayprice1 = new DisplayTextInfo(2, this);
        DisplayTextInfo displayprice2 = new DisplayTextInfo(3, this);
        DisplayTextInfo displayhealth = new DisplayTextInfo(5, this);
        DisplayTextInfo displaywave = new DisplayTextInfo(6, this);
        StartButton startbutton = new StartButton();
        addObject(menu, 510, 300);
        addObject(dMoney, 115, 550);
        addObject(displaybowcat, 120, 300);
        addObject(displaytextinfo, 115, 130);
        addObject(displayprice1, 115, 350);
        addObject(displayhealth, 115, 510);
        addObject(displaywave, 115, 50);
        addObject(startbutton, 115, 470);
    }   
}