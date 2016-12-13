package client.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import client.MockServerAccess;
import client.model.Model;
import client.view.Application;
import xml.Message;
import junit.framework.TestCase;

/**
 * this test case is responsible for testing create game controller, which sends a request to the server
 * @author Zhanfeng Huang
 */
public class TestCreateGameController extends TestCase {
	
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
	 * It is for the test case of CreateGameController
	 * 
	 * There are two scenarios, with password or without password
	 * generate two conditions to check if the request is send corretly
	 * 
	 */
	public void testCreateGameProcess() {
		
		/**without Password*/
		String playerName = "player1";
		model.getGame().setMyName(playerName);
		new CreateGameController(client, model).process();
		
		// validate from mockServer
		 
		ArrayList<Message> reqs = mockServer.getAndClearMessages();
		assertTrue (reqs.size() == 1);
		Message r = reqs.get(0);
		 
		// a lock request is sent out.
		assertEquals ("createGameRequest", r.contents.getFirstChild().getLocalName());
		System.out.println (r.toString());
		assertEquals(playerName, r.contents.getFirstChild().getAttributes().getNamedItem("name").getNodeValue());
		
		/**with Password*/
		String playerName_2 = "player2";
		String password = "test";
		model.getGame().setMyName(playerName_2);
		model.getGame().setPassword(password);
		new CreateGameController(client, model).process();
		
		// validate from mockServer
		ArrayList<Message> reqs_2 = mockServer.getAndClearMessages();
		assertTrue (reqs_2.size() == 1);
		Message r_2 = reqs_2.get(0);
		
		// a lock request is sent out.
		assertEquals ("createGameRequest", r_2.contents.getFirstChild().getLocalName());
		System.out.println (r_2.toString());
		assertEquals(playerName_2, r_2.contents.getFirstChild().getAttributes().getNamedItem("name").getNodeValue());
		assertEquals(password, r_2.contents.getFirstChild().getAttributes().getNamedItem("password").getNodeValue());
		
	}
}
