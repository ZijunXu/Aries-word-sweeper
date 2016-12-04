
package client.model;

import java.util.ArrayList;

public class Word {
	protected String word;
	protected long score;
	protected ArrayList<Cell> ChoseCells;

	public Word(){
		this.ChoseCells = new ArrayList<Cell>();
		this.score = 0;
	}
	
	public ArrayList<Cell> addCell(Cell c) {
		this.ChoseCells.add(c);
		return this.ChoseCells;
	}

	public boolean isTheFirstLetter(){
		return this.ChoseCells.size() == 0;
	}

	public int [] lastCellPosition(){
		int [] noPosition = {-2, -2};
		if (this.ChoseCells != null && !this.ChoseCells.isEmpty()){
			return this.ChoseCells.get(this.ChoseCells.size() - 1).getPosition();
		}else {
			return noPosition;
		}
	}

	public void resetWord(){
		score = 0;
		ChoseCells.clear();
	}

	public boolean valid(){
		return true;
	}
	
	public long computeScore(){
	    double num = 0;
	    long sum = 0;
	    int mutiplier = 1;
		for (Cell cell : ChoseCells){
		    num +=1;
//		    sum += valueOfLetters(cell)
            if (cell.getBonus() == 10)
                mutiplier *= 10;
        }
        score = (long)(10 * Math.pow(2, num) * mutiplier);
		return score;
	}

	public String selectedWord(){
		String word = "";
		for(Cell i : ChoseCells){
		word += i.getLetter();
		}
		return word;
	}

	public String getChoseCellsXMLString() {
		String chosenCellsString = "";
		for (Cell cell : ChoseCells) {
			chosenCellsString += String.format("<cell position='%s,%s' letter='%s'/>",
					String.valueOf(cell.getPosition()[0]), String.valueOf(cell.getPosition()[1]), cell.getLetter());
		}
		return chosenCellsString;
	}

}
