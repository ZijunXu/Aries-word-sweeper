package client.model;

public class Cell {
	public int row;
	public int column;
	// the position of the cell in the board
    public String letter;
    public int bonus;
    // number of times overlapped
    public boolean isSelected;
    
    public Cell(int column, int row){
    	this.column = column;
    	this.row = row;
    }
    
    public void setLetter(String a){
    	this.letter = a;
    }
    
    public void selectCell(){
    	this.isSelected = true;
    }
    
    public void diselectCell(){
    	this.isSelected = false;
    }
    
}
