package client.model;

public class Cell {
    /**
     *@Zijun Xu
     */
	protected int row;
	protected int column;
    protected String letter;
    protected int sharedTimes;
    protected int bonus;
    public boolean isSelected;
    protected int score;
    public Cell(int column, int row){
    	this.column = column;
    	this.row = row;
    }
    
    public void setLetter(String a){
    	this.letter = a;
    }
    
    public void selectCell(){
    	this.isSelected = true;
    }
    
    public void disselectCell(){
    	this.isSelected = false;
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

    public int getBonus(){
        return this.bonus;
    }

    public void setBonus(){
        this.bonus = 10;
    }

    public void resetBonus(){
        this.bonus = 0;
    }

    public void setSharedTimes(int times){
        this.sharedTimes = times;
    }

    public int getSharedTimes(){
        return sharedTimes;
    }
}
