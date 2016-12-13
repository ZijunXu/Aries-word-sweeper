package client.model;

import junit.framework.TestCase;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import client.model.Cell;

/**
 * @author Zhanfeng Huang
 * this test case is responsible for testing cell entity
 */

public class TestCell extends TestCase {

	Cell cell;
	
	/** initialization */
	protected void setUp() {
		
		int column = 0;
		int row = 0;
		cell = new Cell(column, row);

	}
	
	/**
	 * It is for the test case of Cell
	 * 
	 */
	
	/** test setting the cell's letter */
	public void testSetLetterProcess() {
		String a = "A";
		cell.setLetter(a);
		assertEquals (a, cell.getLetter());
	}
	/** test selecting the cell */
	public void testSelectCellProcess() {
		cell.selectCell();
		assertTrue (cell.isSelected());
	}
	
	/** test deselect the cell */
	public void testDisselectCellProcess() {
		cell.disselectCell();
		assertFalse (cell.isSelected());
	}
	
	/** check if the selected status return correctly */
	public void testIsSelectedCellProcess() {
		cell.selectCell();
		assertTrue (cell.isSelected());
	}
	
	/** test getting the cell's letter */
	public void testGetLetterProcess(){
		String a = "A";
		cell.setLetter(a);
		assertEquals (a, cell.getLetter());
	}
	
	/** test getting the cell's position */
	public void testGetPositionProcess(){
		int[] test = cell.getPosition();
		int[] correct = {0,0};
		assertEquals (correct[0], test[0]);
		assertEquals (correct[1], test[1]);
	}
	
	/** test getting the cell's bonus */
	public void testGetBonusProcess(){
		cell.setBonus();
		assertEquals (10, cell.getBonus());
	}
	
	/** test setting the cell's bonus */
	public void testSetBonusProcess(){
		cell.setBonus();
		assertEquals (10, cell.getBonus());
	}
	
	/** test setting the cell's bonus to 0 */
	public void testResetBonusProcess(){
		cell.resetBonus();
		assertEquals (0, cell.getBonus());
	}
	
	/** test setting the cell's shared times */
	public void testSetSharedTimesProcess(){
		cell.setSharedTimes(1);;
		assertEquals (1, cell.getSharedTimes());
	}
	
	/** test getting the cell's shared times */
	public void testGetSharedTimesProcess(){
		cell.setSharedTimes(1);;
		assertEquals (1, cell.getSharedTimes());
	}
}
