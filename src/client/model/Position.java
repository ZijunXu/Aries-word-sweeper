package client.model;

public class Position {
	public int row;
	public int column;
	//player's position of the global board
	
	public Position(int column, int row){
		this.column = column;
		this.row = row;
	}
}
