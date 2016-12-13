package client.model;

import junit.framework.TestCase;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import client.model.Game;
import client.model.Player;

/**
 * @author Zhanfeng Huang
 * this test case is responsible for testing the game entitiy
 */

public class TestGame extends TestCase {

	Game game;
	
	/** initialization */
	protected void setUp() {
		
		game = new Game();

	}
	
	/**
	 * It is for the test case of Game
	 * 
	 */
	
	/** test getting the room ID */
	public void testGetRoomIDProcess() {
		String roomID = "1";
		game.setRoomID(roomID);
		assertEquals (roomID, game.getRoomID());
	}
	
	/** test setting the room ID */
	public void testSetRoomIDProcess() {
		String roomID = "1";
		game.setRoomID(roomID);
		assertEquals (roomID, game.getRoomID());
	}
	
	/** test getting the manager user */
	public void testGetManagingUserProcess() {
		String manager = "player1";
		game.setManagingUser(manager);;
		assertEquals (manager, game.getManagingUser());
	}
	
	/** test setting the manager user */
	public void testSetManagingUserProcess() {
		String manager = "player1";
		game.setManagingUser(manager);;
		assertEquals (manager, game.getManagingUser());
	}
	
	/** check if the lock status return correctly */
	public void testIsLockedProcess() {
		game.lockGame();
		assertTrue (game.isLocked());
	}
	
	/** test locking the game */
	public void testLockGameProcess() {
		game.lockGame();
		assertTrue (game.isLocked());
	}
	
	/** test setting the player's name */
	public void testSetMyNameProcess() {
		String name = "player1";
		game.setMyName(name);
		assertEquals (name, game.getMyName());
	}
	
	/** test getting the player's name */
	public void testGetMyNameProcess() {
		String name = "player1";
		game.setMyName(name);
		assertEquals (name, game.getMyName());
	}
	
	/** test setting the score */
	public void testSetScoreProcess() {
		long score = 10;
		game.setScore(score);
		assertEquals (score, game.getScore());
	}
	
	/** test getting the score */
	public void testGetScoreProcess() {
		long score = 10;
		game.setScore(score);
		assertEquals (score, game.getScore());
	}
	
	/**
	 * test getting the players
	 * if is right, after I add a player to the empty list
	 * the size of getPlayers should be 1
	 */
	public void testGetPlayersProcess() {
    	Player player;
    	player = new Player();
    	game.addPlayers(player);
    	assertEquals (1, game.getPlayers().size());
	}

	/** 
	 * test clearing the players
	 * if is right, after i add a player and then clear players
	 * the size of getPlayers should be 0
	 */
	public void testClearPlayersProcess() {
    	Player player;
    	player = new Player();
    	game.addPlayers(player);
    	game.clearPlayers();
    	assertEquals (0, game.getPlayers().size());
	}
	
	/** test add a player */
	public void testAddPlayersProcess() {
    	Player player;
    	player = new Player();
    	game.addPlayers(player);
    	assertEquals (1, game.getPlayers().size());
	}
	
	/** test setting a password to the game */
	public void testSetPasswordProcess() {
    	String password = "test";
		game.setPassword(password);
    	assertEquals (password, game.getPassword());
	}
	
	/** test getting a password to the game */
	public void testGetPasswordProcess() {
    	String password = "test";
		game.setPassword(password);
    	assertEquals (password, game.getPassword());
	}
}
