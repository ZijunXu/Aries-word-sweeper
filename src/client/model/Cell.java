package client.model;

import java.awt.Color;

public class Cell {
	protected int row;
	protected int column;
	// the position of the cell in the board
    protected String letter;
    protected int bonus;
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
    	Model.getModel().getGrid()[column][row].setBackground(Color.blue);
    }
    
    public void disselectCell(){
    	this.isSelected = false;
    	Model.getModel().getGrid()[column][row].setBackground(Color.white);
    }

    public boolean isSelected(){
        return isSelected;
    }

    public String getLetter(){
    	return this.letter;
    }

    public int[] getPosition(){
        int position[] = {this.column, this.row};
        return position;
    }
    
}
