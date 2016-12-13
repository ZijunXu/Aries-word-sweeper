package client.controller;

import static org.junit.Assert.assertEquals;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import client.controller.FindWordResponseController;
import client.MockServerAccess;
import client.model.Model;
import client.view.Application;
import xml.Message;
import junit.framework.TestCase;

/**
 * @author Zhanfeng Huang
 * this test case is responsible for testing the findWord Response Controller
 */
public class TestFindWordResponseController extends TestCase {
	
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
	 * It is for the test case of FindWordResponseController
	 * should initialize a JLabel to simulate the 16 cells in the board
	 */
	public void testFindWordResponseProcess() {

		String roomNumber = "1";
		String playerName = "player1";
		String score = "10";
		
		JLabel[][] grid = new JLabel[4][4];
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++) {
				JLabel label = new JLabel();
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setSize(4, 4);
				label.setLocation(i * 4, j * 4);
				label.setOpaque(true);
                label.setBackground(Color.white);
				label.setText("A");
				label.setFont(new Font("Arial", Font.BOLD, 17));
				label.setBorder(BorderFactory.createLineBorder(Color.black));
				grid[i][j] = label;
			}
		}
		model.setGrid(grid);

		String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><response id=\"RandomUUID\" success=\"true\">" + String.format("<findWordResponse gameId = \"%s\" name = \"%s\" score = \"%s\">" + "</findWordResponse></response>", roomNumber, playerName, score);
		
		Message m = new Message(xmlString);
		
		assertTrue (new FindWordResponseController(client, model).process(m));
	}
}
