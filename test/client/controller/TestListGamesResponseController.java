package client.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import client.MockServerAccess;
import client.controller.ListGamesController;
import client.model.Model;
import client.view.Application;
import xml.Message;
import junit.framework.TestCase;

/**
 * @author Zhanfeng Huang
 * this test case is responsible for testing the list game response controller
 */
public class TestListGamesResponseController extends TestCase {
	
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
	 * It is for the test case of ListGamesResponseController
	 * initialize a gameBrief (including room number and players), to generate the simulating xmlString response
	 * check if the controller added the game list information to the game list correctly
	 */
	public void testListGamesResponseProcess() {
		
		String roomNumber = "1";
		String players = "3";
		String gameBrief = new String("");
		gameBrief = gameBrief + "<gameBrief gameId='" + roomNumber + "' players='" + players +"'/>";
		
		String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><response id=\"RandomUUID\" success=\"true\">" + "<listGamesResponse>" + gameBrief + "</listGamesResponse>" + "</response>";
		Message m = new Message(xmlString);
		
		new ListGamesResponseController(client, model).process(m);
		
		String gameIdSet = model.getGameList().keySet().toString();
		gameIdSet = gameIdSet.replace("[", "");
		gameIdSet = gameIdSet.replace("]", "");
		
		String playersSet = model.getGameList().values().toString();
		playersSet = playersSet.replace("[", "");
		playersSet = playersSet.replace("]", "");
		
		assertEquals(roomNumber, gameIdSet);
		assertEquals(players, playersSet);
		
		
	}
}
