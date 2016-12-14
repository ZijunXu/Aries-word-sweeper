package client.model;

import junit.framework.TestCase;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import client.model.Player;

/**
 * this test case is responsible for testing the player entity
 * @author Zhanfeng Huang
 * 
 */

public class TestPlayer extends TestCase {

	Player player;
	
	/** initialization */
	protected void setUp() {
		
		player = new Player();

	}
	
	/**
	 * It is for the test case of Player
	 * 
	 */
	public void testSetupProcess(){
		player.Player();
	}
	
	/** test getting the player's name */
	public void testPlayerGetNameProcess() {
		player.setName("setPlayer");
		assertEquals ("setPlayer", player.getName());
	}
	
	/** test setting the player's name */
	public void testPlayerSetNameProcess() {
		
		player.setName("setPlayer");
		assertEquals ("setPlayer", player.getName());
	}
	
	/** test getting player's score */
	public void testPlayerGetScoreProcess() {
		
		player.setScore(100);
		assertEquals (100, player.getScore());
	}
	
	/** test setting the player's score */
	public void testPlayerSetScoreProcess() {
		
		player.setScore(100);
		assertEquals (100, player.getScore());
	}
	
	/** check if the return of managing user status correct */
	public void testPlayerIsManagingUserProcess() {
		
		player.setAsManagingUser();
		boolean a = player.isManagingUser();
		assertTrue (a);
	}
	
	/** test seting the player as a manager user */
	public void testPlayerSetAsManagingUserProcess() {
		
		player.setAsManagingUser();
		assertTrue (player.isManagingUser);
	}
	
	/** test setting the player's board's global position */
	public void testPlayerSetGlobalPositionProcess() {
		
		int [] position = {2,1};
		player.setGlobalPosition(position);
		assertEquals (position, player.getGlobalPosition());
	}
	
	/** test getting the player's board's global position */
	public void testPlayerGetGlobalPositionProcess() {
		
		int [] position = {2,1};
		player.setGlobalPosition(position);
		assertEquals (position, player.getGlobalPosition());
	}
	
	/** test clearing the player's score */
	public void testPlayerClearScoreProcess() {
		
		player.clearScore();
		assertEquals (0, player.getScore());
	}
}
