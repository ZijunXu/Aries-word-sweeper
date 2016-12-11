package client.model;

import junit.framework.TestCase;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import client.model.Game;
import client.model.Player;

/**
 *@author Zhanfeng Huang
 */

public class TestGame extends TestCase {

	Game game;
	
	
	protected void setUp() {
		
		game = new Game();

	}
	
	/**
	 * It is for the test case of Game
	 * 
	 */
	
	public void testGetRoomIDProcess() {
		String roomID = "1";
		game.setRoomID(roomID);
		assertEquals (roomID, game.getRoomID());
	}
	
	public void testSetRoomIDProcess() {
		String roomID = "1";
		game.setRoomID(roomID);
		assertEquals (roomID, game.getRoomID());
	}
	
	public void testGetManagingUserProcess() {
		String manager = "player1";
		game.setManagingUser(manager);;
		assertEquals (manager, game.getManagingUser());
	}
	
	public void testSetManagingUserProcess() {
		String manager = "player1";
		game.setManagingUser(manager);;
		assertEquals (manager, game.getManagingUser());
	}
	
	public void testIsLockedProcess() {
		game.lockGame();
		assertTrue (game.isLocked());
	}
	
	public void testLockGameProcess() {
		game.lockGame();
		assertTrue (game.isLocked());
	}
	
	public void testSetMyNameProcess() {
		String name = "player1";
		game.setMyName(name);
		assertEquals (name, game.getMyName());
	}
	
	public void testGetMyNameProcess() {
		String name = "player1";
		game.setMyName(name);
		assertEquals (name, game.getMyName());
	}
	
	public void testSetScoreProcess() {
		long score = 10;
		game.setScore(score);
		assertEquals (score, game.getScore());
	}
	
	public void testGetScoreProcess() {
		long score = 10;
		game.setScore(score);
		assertEquals (score, game.getScore());
	}
	
	public void testGetPlayersProcess() {
    	Player player;
    	player = new Player();
    	game.addPlayers(player);
    	assertEquals (1, game.getPlayers().size());
	}

	public void testClearPlayersProcess() {
    	Player player;
    	player = new Player();
    	game.addPlayers(player);
    	game.clearPlayers();
    	assertEquals (0, game.getPlayers().size());
	}
	
	public void testAddPlayersProcess() {
    	Player player;
    	player = new Player();
    	game.addPlayers(player);
    	assertEquals (1, game.getPlayers().size());
	}
	
	public void testSetPasswordProcess() {
    	String password = "test";
		game.setPassword(password);
    	assertEquals (password, game.getPassword());
	}
	
	public void testGetPasswordProcess() {
    	String password = "test";
		game.setPassword(password);
    	assertEquals (password, game.getPassword());
	}
}
