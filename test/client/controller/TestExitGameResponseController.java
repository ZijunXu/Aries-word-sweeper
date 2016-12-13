package client.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import client.controller.ExitGameResponseController;
import client.MockServerAccess;
import client.model.Model;
import client.view.Application;
import client.view.PlayingPanel;
import xml.Message;
import junit.framework.TestCase;

/**
 * @author Zhanfeng Huang
 * this test case is responsible for testing the exit game response
 * should delete the System.exit(0) in the ExitGameResponseController, or all the following test cases will be terminate
 */
public class TestExitGameResponseController extends TestCase {
	
	// Mock server object that extends (and overrides) ServerAccess for its purposes
	MockServerAccess mockServer;
	
	// client to connect
	Application client;
	
	// model being maintained by client.
	Model model;
	
	PlayingPanel playingpanel;
	
	/** initialize model, application view and playingpanel view entities */
	protected void setUp() {
		// FIRST thing to do is register the protocol being used.
		if (!Message.configure("wordsweeper.xsd")) {
			fail ("unable to configure protocol");
		}
		
		// prepare client and connect to server.
		model = new Model();
		client = new Application (model);
		client.setVisible(true);
		playingpanel = new PlayingPanel (client, model);
		playingpanel.setVisible(true);
		
		// Create mockServer to simulate server, and install 'obvious' handler
		// that simply dumps to the screen the responses.
		mockServer = new MockServerAccess("localhost");
		
		// as far as the client is concerned, it gets a real object with which
		// to communicate.
		client.setServerAccess(mockServer);
	}
	
	/**
	 * It is for the test case of ExitGameResponseController
	 * initialize a room number to generate the mock xmlString response
	 * initialize a playing panel to check if the response controller dispose it correctly
	 */
	public void testExitGameResponseProcess() {

		String roomNumber = "1";
		
		client.setRoomID(roomNumber);
		client.setPlayingPanel();
		
		String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><response id=\"RandomUUID\" success=\"true\">" + String.format("<exitGameResponse gameId = \"%s\">" + "</exitGameResponse></response>", roomNumber);
		
		Message m = new Message(xmlString);
		
		assertTrue (new ExitGameResponseController(client, model).process(m));
	}
}
