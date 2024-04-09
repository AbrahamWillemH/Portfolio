import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Leaderboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Leaderboard extends World
{
    public Leaderboard()
    {    
        super(405, 720, 1); 
        currentUserInfo();
        prepare();
        topscore();
    }
    public void currentUserInfo(){
        if (UserInfo.isStorageAvailable()){
            UserInfo myInfo = UserInfo.getMyInfo();
            GreenfootImage ProfilePicture = myInfo.getUserImage();
            String Username = myInfo.getUserName();
            Integer TotalScore = myInfo.getScore();
            
            addObject(new Information(Username), 90, 107);
            addObject(new Information(TotalScore.toString()), 300, 110);
        }
    }
    public void topscore(){
        List<UserInfo> topGlobal = UserInfo.getTop(5);
        for (int i = 0; i < 5; i++){
            UserInfo currentPlayer = topGlobal.get(i);
            GreenfootImage ProfilePicture = currentPlayer.getUserImage();
            String Username = currentPlayer.getUserName();
            Integer TotalScore = currentPlayer.getScore();
            
            addObject (new Information(Username), 100, 160 + i*100);
            addObject (new Information(TotalScore.toString()), 300, 160 + i*100);
        }
    }
    private void prepare(){
        CurrentUser currentUser = new CurrentUser();
        addObject(currentUser, 140, 73);
        
        LeaderBoardBack leaderboardBack = new LeaderBoardBack();
        addObject(leaderboardBack, 202, 368);
        
        LeaderBoardFont leaderboardFont = new LeaderBoardFont();
        addObject(leaderboardFont, 201, 160);
        
        Back back = new Back();
        addObject(back,205,648);
    }
}
