package client.model;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
/**
 *@author Zijun Xu
 */
public class Game {

    protected boolean isLocked;
    protected String myName;
    protected String roomID;
    protected String password;
    protected String managingUser;
    protected long score;
    protected ArrayList<Player> players;

    public Game(){
        this.roomID = "";
        this.managingUser = null;
        this.isLocked = false;
        this.players = new ArrayList<Player>();
    }

    public String getRoomID(){
        return roomID;
    }

    public void setRoomID(String roomID){
        this.roomID = roomID;
    }

    public String getManagingUser(){
        return managingUser;
    }

    public void setManagingUser(String managingUser){
        this.managingUser = managingUser;
    }

    public boolean isLocked(){
        return isLocked;
    }

    public void lockGame(){
        this.isLocked = true;
    }

    public void setMyName(String myName){
        this.myName = myName;
    }

    public String getMyName(){
        return myName;
    }

    public String getPlayerList(){
        String playersList = "";
        int i = 1;
        for(Player eachPlayer : players){
            playersList += String.format("  %d\t %s\t %s\n", i + 1, eachPlayer.getName(), eachPlayer.getScore());
            i += 1;
        }
        return playersList;
    }

    public void setScore(long score){
        this.score = score;
    }
    
    public long getScore(){
    	return this.score;
    }

    public ArrayList<Player> getPlayers(){
        return this.players;
    }

    public void clearPlayers(){
        players.clear();
    }

    public void addPlayers(Player newPlayer){
        this.players.add(newPlayer);
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }
}
