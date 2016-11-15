
package client.model;

import java.util.ArrayList;
import java.util.Collections;

public class Word {
	protected String word;
	protected int score;
	protected ArrayList<Cell> Cells;
	
	public Word(){
		this.Cells = new ArrayList<Cell>();
		this.score = 0;
	}
	
	public ArrayList<Cell> addCell(Cell c) {
		this.Cells.add(c);
		return this.Cells;
	}

	public boolean isTheFirstLetter(){
		return this.Cells.size() == 0;
	}

	public int [] lastCellPosition(){
		int [] noPosition = {-2, -2};
		if (this.Cells != null && !this.Cells.isEmpty()){
			return this.Cells.get(this.Cells.size() - 1).getPosition();
		}else {
			return noPosition;
		}
	}

	public void resetWord(){
		score = 0;
		Cells.clear();
	}

	public boolean valid(){
		return true;
	}
	
	public int computeScore(){
		return score;
	}

	public String selectedWord(){
		String word = "";
		for(Cell i : Cells ){
		word += i.getLetter();
		}
		return word;
	}
}
