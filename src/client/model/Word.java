
package client.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *@author Zijun Xu
 */
public class Word {

    private static String[] letters = {"E","T","A","O","I","N","S","H","R","D","L","C","U","M","W","F","G","Y","P",
            "B","V","K","J","X","Qu","Z"};
    private static int[] letterScore = {1 , 1 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 4 , 4 , 4 , 4 ,
            4 , 5 , 5 , 7 , 7 , 11 , 8,};
    static Map<String, Integer> map = new HashMap<>();

	protected String word;
	protected long score;
	protected ArrayList<Cell> ChoseCells;

	public Word(){
		this.ChoseCells = new ArrayList<Cell>();
		this.score = 0;
        for(int i = 0; i < 26; i++){
            map.put(letters[i], letterScore[i]);
        }
	}
	
	public ArrayList<Cell> addCell(Cell c) {
		this.ChoseCells.add(c);
		return this.ChoseCells;
	}

	public ArrayList<Cell> getChoseCells(){
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
	    int sum = 0;
	    int multiplier = 1;
	    int sharedTimes = 0;
		for (Cell cell : ChoseCells){
		    num +=1;
		    sum = map.get(cell.getLetter());
            if (cell.getBonus() == 10)
                multiplier *= 10;
            sharedTimes += cell.getSharedTimes();
        }
        score = (long)(10 * Math.pow(2, num + sharedTimes) * multiplier * sum);
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
	    /*return the XML String of the chosen cells
	    * however finds out that the server wants the global location of the cells
	    * Word class doesn't know the global position of the board
	    * so that move this function to the Model class
	    * */
		String chosenCellsString = "";
		for (Cell cell : ChoseCells) {
			chosenCellsString += String.format("<cell position='%s,%s' letter='%s'/>",
					String.valueOf(cell.getPosition()[0]), String.valueOf(cell.getPosition()[1]), cell.getLetter());
		}
		return chosenCellsString;
	}
}
