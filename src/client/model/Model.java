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

	public Game getGame(){
        return game;
    }

    public void setGame(Game game){
        this.game = game;
    }

	public Board getBoard() {
		return board;
	}
	
	//for test case use @author Zhanfeng
	public void setWord(Word word){
		this.word = word;
	}

	public Word getWord(){
        return word;
    }
	

	public void setBoard(Board board) {
		this.board = board;
	}

	public JLabel[][] getGrid() {
		return grid;
	}

	public void setGrid(JLabel[][] grid) {
		this.grid = grid;
	}

	public Map<String, Integer> getGameList(){
	    return this.gameList;
    }

    public void addGameToGameList(String gameID, int playerNumber){
	    gameList.put(gameID, playerNumber);
    }

	public  void resetGame(){

    }

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
