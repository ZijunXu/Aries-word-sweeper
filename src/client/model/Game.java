package client.model;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

public class Game {
       protected boolean isLocked;
       protected String myName;
       protected String roomID;
       protected String password;
       protected String managingUser;
       protected double score;
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

       public String getMyName(){
           return myName;
       }

       public void updateBoard(Player[] playInfo,Board board){
    	   
       }
       
}
