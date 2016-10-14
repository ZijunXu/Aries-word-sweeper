package client.model;

import java.util.Random;

import javax.swing.JLabel;

import client.model.*;
import client.view.PlayingPanel;

public class Model {
	protected Board board;
	private static Model mainModel;
	private JLabel[][] grid;
	public static Model getModel() {
		if (mainModel == null) {
			mainModel = new Model();
		}
		return mainModel;
	}
	private static final String[] LETTER_SET={"A",
            "B","C","D","E","F","G","H","I","J","K",
            "L","M","N","O","P","Q","R","S","T","U",
            "V","W","X","Y","Z","Qu"};
	 Random random = new Random();
	private Model(){
		String[][] letters = new String[4][4];
		String str = "";
		for (int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++){
//				letters[i][j] = str + (char)(Math.random() * 26 + 'A');	
				letters[i][j] = LETTER_SET[random.nextInt(26)+1];
			}	
		}
		this.board = new Board(letters);
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public JLabel[][] getGrid() {
		return grid;
	}

	public void setGrid(JLabel[][] grid) {
		this.grid = grid;
	}
	
}
