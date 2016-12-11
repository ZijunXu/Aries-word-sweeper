package client.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import client.controller.ResetGameResponseController;
import client.MockServerAccess;
import client.model.Model;
import client.view.Application;
import xml.Message;
import junit.framework.TestCase;

/**
 *@author Zhanfeng Huang
 */
public class TestResetGameResponseController extends TestCase {
	
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
	 * It is for the test case of ResetGameResponseController
	 * 
	 */
	public void testResetGameResponseProcess() {

		String roomNumber = "1";
		
		String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><response id=\"RandomUUID\" success=\"true\">" + String.format("<resetGameResponse gameId = \"%s\">" + "</resetGameResponse></response>", roomNumber);
		
		Message m = new Message(xmlString);
		
		assertTrue (new ResetGameResponseController(client, model).process(m));
	}
}
