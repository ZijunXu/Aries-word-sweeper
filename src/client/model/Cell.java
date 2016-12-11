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
    
    /** set cell's letter */
    public void setLetter(String a){
    	this.letter = a;
    }
    
    /** @return whether the cell is selected or not */
    public void selectCell(){
    	this.isSelected = true;
    }
    
    /** set a cell into not selected status */
    public void disselectCell(){
    	this.isSelected = false;
    }

    /** set a cell into selected status */
    public boolean isSelected(){
        return isSelected;
    }

    /** @return get the letter of the cell */
    public String getLetter(){
    	return this.letter;
    }

    /** @return get the position of the cell */
    public int[] getPosition(){
        int position[] = {this.column, this.row};
        return position;
    }

    /** @return get the bonus of the cell */
    public int getBonus(){
        return this.bonus;
    }

    /**set bonus of the cell */
    public void setBonus(){
        this.bonus = 10;
    }

    /** reset bonus to 0 of the cell */
    public void resetBonus(){
        this.bonus = 0;
    }

    /** set shared times of the cell */
    public void setSharedTimes(int times){
        this.sharedTimes = times;
    }

    /** @return get shared times of the cell */
    public int getSharedTimes(){
        return sharedTimes;
    }
}
