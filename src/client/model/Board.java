package client.model;

import java.util.ArrayList;
/**
 * responsible for the board entity
 *@author Zijun Xu
 */
public class Board {

    protected int[] globalPosition;
	protected int colNum = 4;
	protected int rowNum = 4;
	protected int timeRemained = 2;
	public Cell[][] cells = new Cell[colNum][rowNum];
	public ArrayList<Cell> selectedCells;
	boolean couldRefresh = false;
	
	/** set each cell's letter */
    public Board(String letters[][]){
		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				Cell a = new Cell(i, j);
				a.setLetter(letters[i][j]);
				cells[i][j] = a;
			}
		}
    }

    /** refresh every cell's letter */
    public void refreshBoard(String letters[][]){
    	for (int i = 0; i < rowNum; i++){
    		for(int j = 0; j < colNum; j++){
    			cells[i][j].setLetter(letters[i][j]);
    		}
    	}
    }

    /** initial board with the inputting string */
    public void setBoard(String letters){
        letters = letters.replaceAll(",", "");
        char [] stringArr = letters.toCharArray();
        int m = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cells[j][i].resetBonus();
                cells[j][i].setSharedTimes(0);
                if(stringArr[m] == 'Q'){
                    cells[j][i].setLetter(String.valueOf(stringArr[m]) + String.valueOf(stringArr[m+1]));
                    m += 2;
                }else {
                    cells[j][i].setLetter(String.valueOf(stringArr[m]));
                    m += 1;
                }
            }
        }
        timeRemained -= 1;
        if (timeRemained ==0){
            couldRefresh = true;
        }
    }

    /** check if the board could be refresh */
    public boolean getCouldRefresh(){
        return this.couldRefresh;
    }

    /** get the current board's global position */
    public int[] getGlobalPosition(){
        return this.globalPosition;
    }

    /** set the current board's global position */
	public void setGlobalPosition(int[] globalPosition) {
		this.globalPosition = globalPosition;
	}
}
