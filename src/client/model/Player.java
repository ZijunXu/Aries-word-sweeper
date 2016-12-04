package client.model;
import client.model.Position;

public class Player {
    protected String name;
    protected int userID;
    protected long score;
    protected int[] globalPosition;
    protected   boolean isManagingUser;
    
    
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

    public long getScore(){
        return score;
    }

    public void setScore(long score){
        this.score = score;
    }

    public boolean isManagingUser(){
        return isManagingUser;
    }

    public void setAsManagingUser(){
        this.isManagingUser = true;
    }

    public void  setGlobalPosition(int[] position){
        this.globalPosition = position;
    }

    public int[] getGlobalPosition() {
        return this.globalPosition;
    }

    public void clearScore(){
        this.score = 0;
    }


}
