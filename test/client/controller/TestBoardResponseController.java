package client.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import client.controller.BoardResponseController;
import client.MockServerAccess;
import client.model.Model;
import client.model.Board;
import client.model.Cell;
import client.model.Game;
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
public class TestBoardResponseController extends TestCase {
	
	// Mock server object that extends (and overrides) ServerAccess for its purposes
	MockServerAccess mockServer;
	
	// client to connect
	Application client;
	
	// model being maintained by client.
	Model model;
	
	Player player;
	
	protected void setUp() {
		// FIRST thing to do is register the protocol being used.
		if (!Message.configure("wordsweeper.xsd")) {
			fail ("unable to configure protocol");
		}
		
		// prepare client and connect to server.
		model = new Model();
		player = new Player();
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
	 * The real test case whose purpose is to validate that selecting the Locked button
	 * sends a GrabLock request to the server.
	 */
	public void testBoardResponseProcess() {
		
		//gameId, managingUser, bonus, name, position, board, score

		String roomNumber = "1";
		String playerName = "player1";
		String manager = playerName;
		String bonus = "5,3";
		
		String position = "2,1";
		String positionLetters = position.replaceAll(",", "");
		char [] positionLettersArray = positionLetters.toCharArray();
		
		//String board = "U,U,I,D,T,F,F,D,E,O,L,R,T,S,M,E";
		String board = "A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P";
		String boardLetters = board.replaceAll(",", "");
        char [] boardLettersArray = boardLetters.toCharArray();
        
		String score = "20";
		
		int flag = 0;
		
		String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><response id=\"RandomUUID\" success=\"true\">" + String.format("<boardResponse bonus=\"%s\" gameId=\"%s\" managingUser=\"%s\">" + "<player board=\"%s\" name=\"%s\" position=\"%s\" score=\"%s\"/>" + "</boardResponse></response>", bonus, roomNumber, manager, board, playerName, position, score);
			
		model.getGame().setRoomID(roomNumber);
		model.getGame().setMyName(playerName);
		Message m = new Message(xmlString);
		new BoardResponseController(client, model).process(m);
		Board boardResult = model.getBoard();
		Game gameResult = model.getGame();

		assertEquals (gameResult.getManagingUser(), manager);
		assertEquals (gameResult.getMyName(), playerName);
		assertEquals (gameResult.getRoomID(), roomNumber);
		
		// board verification
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				char [] cellLetter = boardResult.cells[j][i].getLetter().toCharArray();
				assertEquals (cellLetter[0], boardLettersArray[flag]);
				flag++;
			}
		}
		
		// - 48 means the char number convert to int according to the ASCII code
		// global position verification
		int positionn_x = positionLettersArray[0] - 48;
		int positionn_y = positionLettersArray[1] - 48;
		int [] p = boardResult.getGlobalPosition();
		assertEquals (p[0], positionn_x);
		assertEquals (p[1], positionn_y);
		
		// score
		assertEquals (Long.toString(gameResult.getScore()), score);
		
		//assertEquals (boardResult.cells[3][2].getBonus(), 10);
		
	}
	

	/**
	 * The real test case whose purpose is to validate that selecting the Locked button
	 * sends a GrabLock request to the server.
	 */
}
