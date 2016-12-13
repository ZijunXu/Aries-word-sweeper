package client.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import client.MockServerAccess;
import client.model.Model;
import client.view.Application;
import xml.Message;
import junit.framework.TestCase;

/**
 * @author Zhanfeng Huang
 * this test case is responsible for testing the join game controller
 */
public class TestJoinGameController extends TestCase {
	
	// Mock server object that extends (and overrides) ServerAccess for its purposes
	MockServerAccess mockServer;
	
	// client to connect
	Application client;
	
	// model being maintained by client.
	Model model;

	
	protected void setUp() {
		// FIRST thing to do is register the protocol being used.
		if (!Message.configure("wordsweeper.xsd")) {
			fail ("unable to configure protocol");
		}
		
		// prepare client and connect to server.
		model = new Model();
		client = new Application (model);
		client.setVisible(true);
		
		// Create mockServer to simulate server, and install 'obvious' handler
		// that simply dumps to the screen the responses.
		mockServer = new MockServerAccess("localhost");
		
		// as far as the client is concerned, it gets a real object with which
		// to communicate.
		client.setServerAccess(mockServer);
	}
	
	/**
	 * It is for the test case of JoinGameController
	 * there are two scenarios, with password or without password
	 * tested two times to check if the controller send the corresponding request correctly with or without the password
	 */
	public void testJoinGameProcess() {
		
		//****without Password
		String roomNumber = "1";
		String playerName = "player1";
		client.setRoomID(roomNumber);
		model.getGame().setMyName(playerName);
		new JoinGameController(client, model).process();
		 
		// validate from mockServer
		
		ArrayList<Message> reqs = mockServer.getAndClearMessages();
		assertTrue (reqs.size() == 1);
		Message r = reqs.get(0);
		 
		// a lock request is sent out.
		assertEquals ("joinGameRequest", r.contents.getFirstChild().getLocalName());
		System.out.println (r.toString());
		assertEquals(roomNumber, r.contents.getFirstChild().getAttributes().getNamedItem("gameId").getNodeValue());
		assertEquals(playerName, r.contents.getFirstChild().getAttributes().getNamedItem("name").getNodeValue());

		
		//****with Password
		String roomNumber_2 = "2";
		String playerName_2 = "player2";
		String password = "test";
		client.setRoomID(roomNumber_2);
		model.getGame().setMyName(playerName_2);
		client.setPassword(password);
		
		new JoinGameController(client, model).process();
		
		// validate from mockServer
		ArrayList<Message> reqs_2 = mockServer.getAndClearMessages();
		assertTrue (reqs_2.size() == 1);
		Message r_2 = reqs_2.get(0);
		
		// a lock request is sent out.
		assertEquals ("joinGameRequest", r_2.contents.getFirstChild().getLocalName());
		System.out.println (r.toString());
		assertEquals(roomNumber_2, r_2.contents.getFirstChild().getAttributes().getNamedItem("gameId").getNodeValue());
		assertEquals(playerName_2, r_2.contents.getFirstChild().getAttributes().getNamedItem("name").getNodeValue());
		assertEquals(password, r_2.contents.getFirstChild().getAttributes().getNamedItem("password").getNodeValue());

	}
}
