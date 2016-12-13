package client.view;

import junit.framework.TestCase;
import xml.Message;

import client.model.Model;
import client.view.Application;

public class TextApplication extends TestCase {

	// client to connect
	Application client;
		
	// model being maintained by client.
	Model model;
	
	protected void setUp() {
		// FIRST thing to do is register the protocol being used.
		if (!Message.configure("wordsweeper.xsd")) {
			fail ("unable to configure protocol");
		}
		
		// prepare client
		model = new Model();
		
	}
	
	/**
	 * It is for the test case of Application View
	 * 
	 */
	public void testApplicationViewProcess() {
		
		String roomNumber = "1";
		String playerName = "player1";
		String message = "testError";
		model.getGame().setMyName(playerName);
		client = new Application (model);
		client.setVisible(true);
		
		client.setRoomID(roomNumber);
		client.playerName = playerName;
		client.disableInputs();
		client.enableInput();
		client.setErrorMessege(message);
		assertEquals (playerName, client.getPlayerName());
		assertEquals (roomNumber, client.getRoomNumber());
		assertEquals (message, client.errorMessage);
	}
	
	
}
