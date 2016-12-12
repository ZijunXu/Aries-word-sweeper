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

    /** @return get current game's room ID */
    public String getRoomID(){
        return roomID;
    }

    /** set current game's room ID */
    public void setRoomID(String roomID){
        this.roomID = roomID;
    }

    /** @return get current game's manager */
    public String getManagingUser(){
        return managingUser;
    }

    /** set current game's manager */
    public void setManagingUser(String managingUser){
        this.managingUser = managingUser;
    }

    /** @return whether the current game is locked or not */
    public boolean isLocked(){
        return isLocked;
    }

    /** lock the current game */
    public void lockGame(){
        this.isLocked = true;
    }

    /** set player's name */
    public void setMyName(String myName){
        this.myName = myName;
    }

    /** @return get player's name */
    public String getMyName(){
        return myName;
    }

    /** @return get current game's all players information, including name and score, return as a String */
    public String getPlayerList(){
        String playersList = "";
        int i = 1;
        for(Player eachPlayer : players){
            playersList += String.format("  %d\t %s\t %s\n", i + 1, eachPlayer.getName(), eachPlayer.getScore());
            i += 1;
        }
        return playersList;
    }

    /** set current game's score */
    public void setScore(long score){
        this.score = score;
    }
    
    /** @return get current game's score */
    public long getScore(){
    	return this.score;
    }

    /** @return get all the palyer's in current game */
    public ArrayList<Player> getPlayers(){
        return this.players;
    }

    /** clear all players */
    public void clearPlayers(){
        players.clear();
    }

    /** add a new player to players */
    public void addPlayers(Player newPlayer){
        this.players.add(newPlayer);
    }

    /** set password for the current game */
    public void setPassword(String password){
        this.password = password;
    }

    /** @return get password of the current game */
    public String getPassword(){
        return this.password;
    }
}
