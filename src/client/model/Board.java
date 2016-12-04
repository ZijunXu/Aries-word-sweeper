package client.model;

import java.util.ArrayList;

public class Board {
    protected int[] globalPosition;
	protected int colNum = 4;
	protected int rowNum = 4;
	public Cell[][] cells = new Cell[colNum][rowNum];
	public ArrayList<Cell> selectedCells;

    public Board(String letters[][]){
		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				Cell a = new Cell(i, j);
				a.setLetter(letters[i][j]);
				cells[i][j] = a;
			}
		}
    }

    public void refreshBoard(String letters[][]){
    	for (int i = 0; i < rowNum; i++){
    		for(int j = 0; j < colNum; j++){
    			cells[i][j].setLetter(letters[i][j]);
    		}
    	}
    }

    public int[] getGlobalPosition(){
        return this.globalPosition;
    }

	public void setGlobalPosition(int[] globalPosition) {
		this.globalPosition = globalPosition;
	}
}
