package client.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import client.MockServerAccess;
import client.model.Model;
import client.model.Player;
import client.view.Application;
import xml.Message;
import junit.framework.TestCase;

/**
 * This test case is needed when the job of a controller is to send a Request to the server.
 * <P> 
 * To make this work we need to create a "mock" Server whose only purpose is to WAIT for requests to come
 * from the client being pressed into service here in this test case. 
 * 
 * @author heineman
 */
public class TestJoinGameController extends TestCase {
	
	// Mock server object that extends (and overrides) ServerAccess for its purposes
	MockServerAccess mockServer;
	
	// client to connect
	Application client;
	
	// model being maintained by client.
	Model model;
	
	// Player
	Player player;
	
	protected void setUp() {
		// FIRST thing to do is register the protocol being used.
		if (!Message.configure("wordsweeper.xsd")) {
			fail ("unable to configure protocol");
		}
		
		// prepare client and connect to server.
		model = new Model();
		client = new Application (model);
		client.setVisible(true);
		player = new Player();
		
		// Create mockServer to simulate server, and install 'obvious' handler
		// that simply dumps to the screen the responses.
		mockServer = new MockServerAccess("localhost");
		
		// as far as the client is concerned, it gets a real object with which
		// to communicate.
		client.setServerAccess(mockServer);
	}
	
	/**
	 * The real test case whose purpose is to validate that selecting the Locked button
	 * sends a GrabLock request to the server.
	 */
	public void testJoinGameProcess() {
		
		//****with Password
		String roomNumber = "Number1";
		String playerName = "player1";
		String password = "test";
		model.getGame().setRoomID(roomNumber);
		player.setName(playerName);
		client.setRoomNumber(roomNumber);
		client.setPlayerName(playerName);
		client.setPassword(password);
		new JoinGameController(client, model).process();
		
		// validate from mockServer
		ArrayList<Message> reqs = mockServer.getAndClearMessages();
		assertTrue (reqs.size() == 1);
		Message r = reqs.get(0);
		
		// a lock request is sent out.
		assertEquals ("joinGameRequest", r.contents.getFirstChild().getLocalName());
		System.out.println (r.toString());
		assertEquals(roomNumber, r.contents.getFirstChild().getAttributes().getNamedItem("gameID").getNodeValue());
		assertEquals(playerName, r.contents.getFirstChild().getAttributes().getNamedItem("name").getNodeValue());
		assertEquals(password, r.contents.getFirstChild().getAttributes().getNamedItem("password").getNodeValue());
		
		//****without Password
		String roomNumber_2 = "Number2";
		String playerName_2 = "player2";
		model.getGame().setRoomID(roomNumber_2);
		player.setName(playerName_2);
		client.setRoomNumber(roomNumber_2);
		client.setPlayerName(playerName_2);
		new CreateGameController(client, model).process();
		 
		// validate from mockServer
		 
		ArrayList<Message> reqs_2 = mockServer.getAndClearMessages();
		assertTrue (reqs_2.size() == 1);
		Message r_2 = reqs_2.get(0);
		 
		// a lock request is sent out.
		assertEquals ("joinGameRequest", r_2.contents.getFirstChild().getLocalName());
		System.out.println (r_2.toString());
		assertEquals(roomNumber_2, r_2.contents.getFirstChild().getAttributes().getNamedItem("gameID").getNodeValue());
		assertEquals(playerName_2, r_2.contents.getFirstChild().getAttributes().getNamedItem("name").getNodeValue());

	}
	

	/**
	 * The real test case whose purpose is to validate that selecting the Locked button
	 * sends a GrabLock request to the server.
	 */
}
