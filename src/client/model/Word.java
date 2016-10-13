package client.model;

import java.util.ArrayList;

public class Word {
	public String word;
	public int score;
	public ArrayList<Cell> Cells;
	
	public Word(String word, boolean valid, int score){
		this.Cells = new ArrayList<Cell>();
		this.score = 0;
	}
	
	public ArrayList<Cell> addCell(Cell c) {
		this.Cells.add(c);
		return this.Cells;
	}
	
	public boolean valid(){
		return true;
	}
	
	public int computeScore(){
		return score;
	}
}
