package client.model;

public class Board {
	
	public int colNum = 4;
	public int rowNum = 4;
	
	public Cell[][] cells = new Cell[colNum][rowNum];
	// The cells in the board
	
    public Board(String letters[][]){
    	this.refresh(letters);
    }
    // Fill the cells in the board with letters
    
    public void refresh(String letters[][]){
    	for (int i = 0; i < rowNum; i++){
    		for(int j = 0; j < colNum; j++){
    			Cell a = new Cell(i,j);
    			a.setLetter(letters[i][j]);
    			cells[i][j] = a;
    		}
    	}
    }
}
