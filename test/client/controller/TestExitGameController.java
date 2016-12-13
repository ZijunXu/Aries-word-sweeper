package client.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import client.MockServerAccess;
import client.model.Model;
import client.view.Application;
import xml.Message;
import junit.framework.TestCase;

/**
 * this test case is responsible for testing exit game controller
 * @author Zhanfeng Huang
 */
public class TestExitGameController extends TestCase {
	
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
	 * It is for the test case of ExitGameController
	 * Initialize room a room number and a player name to generate the exit game request xmlString
	 */
	public void testExitGameProcess() {
		
		String roomNumber = "1";
		String playerName = "player1";
		model.getGame().setRoomID(roomNumber);
		model.getGame().setMyName(playerName);
		new ExitGameController(client, model).process();
		 
		// validate from mockServer
		
		ArrayList<Message> reqs = mockServer.getAndClearMessages();
		assertTrue (reqs.size() == 1);
		Message r = reqs.get(0);
		 
		// a lock request is sent out.
		assertEquals ("exitGameRequest", r.contents.getFirstChild().getLocalName());
		System.out.println (r.toString());
		assertEquals(roomNumber, r.contents.getFirstChild().getAttributes().getNamedItem("gameId").getNodeValue());
		assertEquals(playerName, r.contents.getFirstChild().getAttributes().getNamedItem("name").getNodeValue());

	}
}
