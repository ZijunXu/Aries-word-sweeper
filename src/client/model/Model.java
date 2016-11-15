package client.model;

import java.util.Random;

import javax.swing.JLabel;

import client.model.*;
import client.view.PlayingPanel;
import client.model.Player;
import com.sun.org.apache.xml.internal.security.keys.keyresolver.implementations.PrivateKeyResolver;

public class Model {
    private Game game;
	private Board board;
    private Player player;
    private Word word;
	private static Model mainModel;
	private JLabel[][] grid;
	public static Model getModel() {
		if (mainModel == null) {
			mainModel = new Model();
		}
		return mainModel;
	}
	private static final String[] LETTER_SET={"A",
            "B","C","D","E","F","G","H","I","J","K",
            "L","M","N","O","P","Q","R","S","T","U",
            "V","W","X","Y","Z","Qu"};
    Random random = new Random();
	public Model(){
		String[][] letters = new String[4][4];
		String str = "";
		for (int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++){
//				letters[i][j] = str + (char)(Math.random() * 26 + 'A');	
				letters[i][j] = LETTER_SET[random.nextInt(26)+1];
			}	
		}
		this.game = new Game();
		this.board = new Board(letters);
        this.player = new Player();
        this.word = new Word();
	}

	public Game getGame(Game game){
        return game;
    }

    public void setGame(Game game){
        this.game = game;
    }

	public Board getBoard() {
		return board;
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
	
}
