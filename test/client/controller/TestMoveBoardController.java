package client.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import client.MockServerAccess;
import client.controller.MoveBoardController;
import client.model.Model;

import client.view.Application;
import xml.Message;
import junit.framework.TestCase;

/**
 *@author Zhanfeng Huang
 */
public class TestMoveBoardController extends TestCase {
	
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
	 * It is for the test case of MoveBoardController
	 * 
	 */
	public void testMoveBoardProcess() {
		
		String roomNumber = "1";
		String playerName = "player1";
		
		// move left
		// column change
		int column = -1;
		// row change
		int row = 0;
		
		model.getGame().setRoomID(roomNumber);
		model.getGame().setMyName(playerName);
		
		new MoveBoardController(client, model, column, row).process();
		
		// validate from mockServer
		ArrayList<Message> reqs = mockServer.getAndClearMessages();
		assertTrue (reqs.size() == 1);
		Message r = reqs.get(0);
		
		// a lock request is sent out.
		assertEquals ("repositionBoardRequest", r.contents.getFirstChild().getLocalName());
		System.out.println (r.toString());
		assertEquals(playerName, r.contents.getFirstChild().getAttributes().getNamedItem("name").getNodeValue());
		assertEquals(roomNumber, r.contents.getFirstChild().getAttributes().getNamedItem("gameId").getNodeValue());
		assertEquals(Integer.toString(row), r.contents.getFirstChild().getAttributes().getNamedItem("rowChange").getNodeValue());
		assertEquals(Integer.toString(column), r.contents.getFirstChild().getAttributes().getNamedItem("colChange").getNodeValue());
	}
}
