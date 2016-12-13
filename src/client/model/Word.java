
package client.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *Word entities class, contains the chosen word and some necessary method
 *
 *@author Zijun Xu
 */
public class Word {

    private static String[] letters = {"E","T","A","O","I","N","S","H","R","D","L","C","U","M","W","F","G","Y","P",
            "B","V","K","J","X","Qu","Z"};
    private static int[] letterScore = {1 , 1 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 4 , 4 , 4 , 4 ,
            4 , 5 , 5 , 7 , 7 , 11 , 8,};
    static Map<String, Integer> map = new HashMap<>();

	protected String word;
	protected int score;
	protected ArrayList<Cell> ChoseCells;

	public Word(){
		this.ChoseCells = new ArrayList<Cell>();
		this.score = 0;
        for(int i = 0; i < 26; i++){
            map.put(letters[i], letterScore[i]);
        }
	}
	
	/** add a cell to the ChosenCells List */
	public ArrayList<Cell> addCell(Cell c) {
		this.ChoseCells.add(c);
		return this.ChoseCells;
	}

	/** @return all the chosen cells, return them as a list */
	public ArrayList<Cell> getChoseCells(){
	    return this.ChoseCells;
    }

	/** @return check if the selected cell is the first selected cell */
	public boolean isTheFirstLetter(){
		return this.ChoseCells.size() == 0;
	}

	/** @return get the position of the last selected cell */
	public int [] lastCellPosition(){
		int [] noPosition = {-2, -2};
		if (this.ChoseCells != null && !this.ChoseCells.isEmpty()){
			return this.ChoseCells.get(this.ChoseCells.size() - 1).getPosition();
		}else {
			return noPosition;
		}
	}

	/** clear the chosen cell list and set the score of selected word as 0 */
	public void resetWord(){
		score = 0;
		ChoseCells.clear();
	}

	/** @return check if the word is valid */
	public boolean valid(){
		return true;
	}
	
	/** 
	 * 
	 * @return calculate the score of the selected word
	 * should consider all the bonus cells, shared time, and the cell letters' score
	 */
	public int computeScore(){
	    double num = 0;
	    int sum = 0;
	    int multiplier = 1;
	    int sharedTimes = 0;
		for (Cell cell : ChoseCells){
		    num +=1;
		    sum += map.get(cell.getLetter());
            if (cell.getBonus() == 10)
                multiplier *= 10;
            sharedTimes += cell.getSharedTimes();
        }
        score = (int)(2 * Math.pow(2, num + sharedTimes) * multiplier * sum);
		return score;
	}

	/** @return combine all the selected cells into word, and return the String */
	public String selectedWord(){
		String word = "";
		for(Cell i : ChoseCells){
		word += i.getLetter();
		}
		return word;
	}

	/** @return all the chosen cells' information, including cells' position and letter */
	public String getChoseCellsXMLString() {
	    /** return the XML String of the chosen cells
	    * however finds out that the server wants the global location of the cells
	    * Word class doesn't know the global position of the board
	    * so that move this function to the Model class
	    */
		String chosenCellsString = "";
		for (Cell cell : ChoseCells) {
			chosenCellsString += String.format("<cell position='%s,%s' letter='%s'/>",
					String.valueOf(cell.getPosition()[0]), String.valueOf(cell.getPosition()[1]), cell.getLetter());
		}
		return chosenCellsString;
	}
}
