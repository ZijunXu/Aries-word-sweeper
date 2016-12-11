package client.model;

import java.util.ArrayList;
/**
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

    public boolean getCouldRefresh(){
        return this.couldRefresh;
    }

    public int[] getGlobalPosition(){
        return this.globalPosition;
    }

	public void setGlobalPosition(int[] globalPosition) {
		this.globalPosition = globalPosition;
	}
}
