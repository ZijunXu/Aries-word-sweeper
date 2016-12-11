package client.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import client.MockServerAccess;
import client.controller.FindWordController;
import client.model.Model;
import client.model.Player;
import client.view.Application;
import xml.Message;
import client.model.Word;
import client.model.Board;
import client.model.Cell;
import junit.framework.TestCase;

/**
 *@author Zhanfeng Huang
 */
public class TestFindWordController extends TestCase {
	
	// Mock server object that extends (and overrides) ServerAccess for its purposes
	MockServerAccess mockServer;
	
	// client to connect
	Application client;
	
	// model being maintained by client.
	Model model;
	
	Word word;
	
	Cell cell;
	
	Board board;
	
	int column = 0;
	int row = 0;

	
	protected void setUp() {
		// FIRST thing to do is register the protocol being used.
		if (!Message.configure("wordsweeper.xsd")) {
			fail ("unable to configure protocol");
		}
		
		// prepare client and connect to server.
		model = new Model();
		word = new Word();
		cell = new Cell(column, row);
		cell.selectCell();
		cell.setLetter("A");
		word.addCell(cell);
		
		
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
	 * It is for the test case of FindWordController
	 * 
	 */
	public void testFindWordProcess() {
		
		String roomNumber = "1";
		String playerName = "player1";
		int[] position = {2,1};

		model.getGame().setRoomID(roomNumber);
		model.getGame().setMyName(playerName);
		model.setWord(word);
		model.getBoard().setBoard("A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P");
		model.getBoard().setGlobalPosition(position);
		
		new FindWordController(client, model).process();
		
		// validate from mockServer
		
		ArrayList<Message> reqs = mockServer.getAndClearMessages();
		assertTrue (reqs.size() == 1);
		Message r = reqs.get(0);
		 
		// a lock request is sent out.
		assertEquals ("findWordRequest", r.contents.getFirstChild().getLocalName());
		System.out.println (r.toString());
		assertEquals(roomNumber, r.contents.getFirstChild().getAttributes().getNamedItem("gameId").getNodeValue());
		assertEquals(playerName, r.contents.getFirstChild().getAttributes().getNamedItem("name").getNodeValue());
		assertEquals(cell.getLetter(), r.contents.getFirstChild().getAttributes().getNamedItem("word").getNodeValue());
	}
}
