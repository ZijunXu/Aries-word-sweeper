package client.model;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

public class Game {
       protected boolean isLocked;
       protected String roomID;
       protected String password;
       protected String managingUser;
       protected double score;
       protected ArrayList<Player> players;

       public Game(){
    	   roomID = "";
    	   managingUser = null;
    	   isLocked = false;

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

       public void LockGame(){
           this.isLocked = true;
       }

       public void resetGame(){

       }

       public double computerScore(Word words,Cell[] cells){
    	   return score;
       }

       public void updateBoard(Player[] playInfo,Board board){
    	   
       }
       
}
