package client.model;

import client.model.*;

public class Model {
	public Board board;
	private static Model mainModel;
	
	public static Model getModel() {
		if (mainModel == null) {
			mainModel = new Model();
		}
		return mainModel;
	}
	
	private Model(){
		String[][] letters = new String[4][4];
		String str = "";
		for (int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++){
				letters[i][j] = str + (char)(Math.random() * 26 + 'A');	
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
	
	
}
