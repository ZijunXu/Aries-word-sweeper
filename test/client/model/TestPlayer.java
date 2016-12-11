package client.model;

import junit.framework.TestCase;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import client.model.Player;

/**
 *@author Zhanfeng Huang
 */

public class TestPlayer extends TestCase {

	Player player;
	
	
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
	
	public void testPlayerGetNameProcess() {
		player.setName("setPlayer");
		assertEquals ("setPlayer", player.getName());
	}
	
	public void testPlayerSetNameProcess() {
		
		player.setName("setPlayer");
		assertEquals ("setPlayer", player.getName());
	}
	
	public void testPlayerGetScoreProcess() {
		
		player.setScore(100);
		assertEquals (100, player.getScore());
	}
	
	public void testPlayerSetScoreProcess() {
		
		player.setScore(100);
		assertEquals (100, player.getScore());
	}
	
	public void testPlayerIsManagingUserProcess() {
		
		player.setAsManagingUser();
		boolean a = player.isManagingUser();
		assertTrue (a);
	}
	
	public void testPlayerSetAsManagingUserProcess() {
		
		player.setAsManagingUser();
		assertTrue (player.isManagingUser);
	}
	
	public void testPlayerSetGlobalPositionProcess() {
		
		int [] position = {2,1};
		player.setGlobalPosition(position);
		assertEquals (position, player.getGlobalPosition());
	}
	
	public void testPlayerGetGlobalPositionProcess() {
		
		int [] position = {2,1};
		player.setGlobalPosition(position);
		assertEquals (position, player.getGlobalPosition());
	}
	
	public void testPlayerClearScoreProcess() {
		
		player.clearScore();
		assertEquals (0, player.getScore());
	}
}
