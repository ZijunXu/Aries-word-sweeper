package client.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JLabel;

/**
 *@author Zijun Xu
 */
public class Model {

    private Game game;
	private Board board;
    private Player player;
    private Word word;
	private JLabel[][] grid;
	protected boolean isExistedGame;
    protected Map<String, Integer> gameList = new HashMap<>();
	private static final String[] LETTER_SET={"A",
            "B","C","D","E","F","G","H","I","J","K",
            "L","M","N","O","P","Qu","R","S","T","U",
            "V","W","X","Y","Z"};
	Random random = new Random();
	public Model(){
		String[][] letters = new String[4][4];
		String str = "";
		for (int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++){
				letters[i][j] = LETTER_SET[random.nextInt(26)];
			}	
		}
		this.game = new Game();
		this.board = new Board(letters);
        this.player = new Player();
        this.word = new Word();
	}

	/** @return a game entity */
	public Game getGame(){
        return game;
    }

	/** set a game entity, initialize */
    public void setGame(Game game){
        this.game = game;
    }

    /** @return a board entity */
	public Board getBoard() {
		return board;
	}
	
	/** 
	 * @author Zhanfeng Huang
	 * for test case use
	 * set a word entity
	 */
	public void setWord(Word word){
		this.word = word;
	}

	/** @return a word entity */
	public Word getWord(){
        return word;
    }
	
	/** set a board entity */
	public void setBoard(Board board) {
		this.board = board;
	}

	/** @return get grid labels of the cells */
	public JLabel[][] getGrid() {
		return grid;
	}

	/** set grid labels of the cells */
	public void setGrid(JLabel[][] grid) {
		this.grid = grid;
	}

	/** @return all games as a Map */
	public Map<String, Integer> getGameList(){
	    return this.gameList;
    }

	/** add a new game to the Game List, where stores all games */
    public void addGameToGameList(String gameID, int playerNumber){
	    gameList.put(gameID, playerNumber);
    }

    /** reset a game */
	public void resetGame(){

    }

	/** by calculating players position and others' positions, get the cell is shared or not, and how many times does it shared */
    public void setSharedCells(){
	    int[][] sharedTimes;
	    sharedTimes = new int[4][4];
	    int[] myPosition = this.getBoard().getGlobalPosition();
	    for (Player eachPlayer : this.getGame().getPlayers()){
	        int[] otherPlyerPosition = eachPlayer.getGlobalPosition();
	        if(Math.abs(otherPlyerPosition[0] - myPosition[0]) < 4 &&
                    Math.abs(otherPlyerPosition[1] - myPosition[1]) < 4){
	            for(int i = sharedCellIndex(otherPlyerPosition[0], myPosition[0])[0];
                    i <= sharedCellIndex(otherPlyerPosition[0], myPosition[0])[1]; i++){
	                for (int j = sharedCellIndex(otherPlyerPosition[1], myPosition[1])[0];
                         j <= sharedCellIndex(otherPlyerPosition[1], myPosition[1])[1]; j++){
	                    this.getBoard().cells[i][j].sharedTimes +=1;
                    }
                }
            }
        }
    }

    protected int[] sharedCellIndex(int others, int me){
        int[] result = new int[2];
        if (others >= me){
            result[0] = others - me;
            result[1] = 3;
        }else if (me > others){
            result[0] = 0;
            result[1] = others - me + 3;
        }
        return result;
    }

    public String getChoseCellsXMLString() {
        String chosenCellsString = "";
        for (Cell cell : getWord().ChoseCells) {
            chosenCellsString += String.format("<cell position='%s,%s' letter='%s'/>",
                    String.valueOf(cell.getPosition()[0] + getBoard().getGlobalPosition()[0]),
                    String.valueOf(cell.getPosition()[1] + getBoard().getGlobalPosition()[1]), cell.getLetter());
        }
        return chosenCellsString;
    }

    public void setIsExistedGame(boolean isExisted){
    	this.isExistedGame = isExisted;
	}

	public boolean getIsExitedGame(){
        return this.isExistedGame;
    }
}
