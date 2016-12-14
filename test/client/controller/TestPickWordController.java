package client.controller;

import static org.junit.Assert.assertEquals;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import client.MockServerAccess;
import client.model.Model;
import client.model.Word;
import client.view.Application;
import client.view.PlayingPanel;
import client.model.Board;
import client.model.Cell;
import xml.Message;
import junit.framework.TestCase;

/**
 * this test case is responsible for testing pick word controller
 * should initialize application, playingpanel views and model, word, cell, board entities and mock mouseEvents
 * @author Zhanfeng Huang
 * 
 */
public class TestPickWordController extends TestCase {
	
	// Mock server object that extends (and overrides) ServerAccess for its purposes
	MockServerAccess mockServer;
	
	// client to connect
	Application client;
	
	// model being maintained by client.
	Model model;
	
	PlayingPanel playingpanel;
	
	JPanel panel;
	
	MouseEvent me;
	
	MouseEvent me_2;
	
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
		client = new Application (model);
		client.setVisible(true);
		panel = new JPanel();
		me = new MouseEvent(panel, 1, 1, 1, 2, 3, 4, 1, 1, true, 1);
		me_2 = new MouseEvent(panel, 0, 0, 0, 0, 0, 0, false);
		word = new Word();
		cell = new Cell(column, row);
		cell.selectCell();
		cell.setLetter("A");
		word.addCell(cell);
		playingpanel = new PlayingPanel(client, model);
		playingpanel.setVisible(true);
		
		// Create mockServer to simulate server, and install 'obvious' handler
		// that simply dumps to the screen the responses.
		mockServer = new MockServerAccess("localhost");
		
		// as far as the client is concerned, it gets a real object with which
		// to communicate.
		client.setServerAccess(mockServer);
	}
	
	/**
	 * It is for the test case of PickWordController
	 * 
	 */
	public void testPickWordInitProcess() {
		
		new PickWordController(client, model, panel);
		
	}
	
	public void testMouseGenProcess() {
		
		cell.setBonus();
		
		String roomNumber = "1";
		String playerName = "player1";
		int[] position = {2,1};

		model.getGame().setRoomID(roomNumber);
		model.getGame().setMyName(playerName);
		model.setWord(word);
		model.getGame().setScore(10);
		model.getBoard().setBoard("A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P");
		model.getBoard().setGlobalPosition(position);
		
		client.setRoomID(roomNumber);
		client.setPlayingPanel();
		
		client.getPlayingPanel().setWordScore(80);
		
		PickWordController pw;
		pw = new PickWordController(client, model, panel);
		pw.mouseGen(me, false);
	}
	
	/** check if the mouse released, the process is correct or not */
	public void testMouseReleasedProcess() {
		
		PickWordController pw;
		pw = new PickWordController(client, model, panel);
		pw.mouseReleased(me_2);
		
	}
	
	/** check if the mouse pressed, the process is correct or not */
	public void testMousePressedProcess() {
	
	PickWordController pw;
	pw = new PickWordController(client, model, panel);
	pw.mousePressed(me_2);
	
	}

	/** check if the mouse dragged, the process is correct or not */
	public void testMouseDraggedProcess() {
	
	PickWordController pw;
	pw = new PickWordController(client, model, panel);
	pw.mouseDragged(me_2);
	
	}
	
	/** test if the adjacent checking worked correctly */
	public void testISAdjacentCells() {
		
		PickWordController pw;
		pw = new PickWordController(client, model, panel);
		assertTrue (pw.isAdjacentCells(1, 1));
	}
	
}
