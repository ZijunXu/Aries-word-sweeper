package client.model;
import client.model.Position;
/**
 *@author Zijun Xu
 */
public class Player {

    protected String name;
    protected int userID;
    protected long score;
    protected int[] globalPosition;
    protected boolean isManagingUser;

    public void Player(){
    	this.name = "";
    	this.userID = 0;
    	this.score = 0;
    	this.isManagingUser = false;
    }

    /** @return get player's name */
    public String getName(){
        return name;
    }

    /** set player's name */
    public void setName(String name){
        this.name = name;
    }

    /** @return get player's score */
    public long getScore(){
        return this.score;
    }

    /** set player's score */
    public void setScore(long score){
        this.score = score;
    }

    /** @return check is the player the manager */
    public boolean isManagingUser(){
        return isManagingUser;
    }

    /** set the player as the manager */
    public void setAsManagingUser(){
        this.isManagingUser = true;
    }

    /** set player's global position */
    public void  setGlobalPosition(int[] position){
        this.globalPosition = position;
    }

    /** @return return player's globalposition in a int[] */
    public int[] getGlobalPosition() {
        return this.globalPosition;
    }

    /** clear player's score */
    public void clearScore(){
        this.score = 0;
    }
}
