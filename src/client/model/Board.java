package client.model;

import java.util.ArrayList;

public class Board {
	
	protected int colNum = 4;
	protected int rowNum = 4;
	
	public Cell[][] cells = new Cell[colNum][rowNum];
	public ArrayList<Cell> selectedCells;
	// The cells in the board
	
    public Board(String letters[][]){
		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				Cell a = new Cell(i, j);
				a.setLetter(letters[i][j]);
				cells[i][j] = a;
			}
		}
    }
    // Fill the cells in the board with letters
    
    public void refresh(String letters[][]){
    	for (int i = 0; i < rowNum; i++){
    		for(int j = 0; j < colNum; j++){
    			cells[i][j].setLetter(letters[i][j]);
    		}
    	}
    }
}
