package client.model;
import client.model.Position;

public class Player {
    public String name;
    public int userID;
    public int score;
    public  boolean isManagingUser;
    
    
    public void Player(){
    	this.name = "";
    	this.userID = 0;
    	this.score = 0;
    	this.isManagingUser = false;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getScore(){
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }

    public boolean isManagingUser(){
        return isManagingUser;
    }

    public void setAsManagingUser(){
        this.isManagingUser = true;
    }

    public void clearScore(){
        this.score = 0;
    }
}
