package client.model;

import junit.framework.TestCase;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import client.model.Cell;

/**
 *@author Zhanfeng Huang
 */

public class TestCell extends TestCase {

	Cell cell;
	
	
	protected void setUp() {
		
		int column = 0;
		int row = 0;
		cell = new Cell(column, row);

	}
	
	/**
	 * It is for the test case of Cell
	 * 
	 */
	
	public void testSetLetterProcess() {
		String a = "A";
		cell.setLetter(a);
		assertEquals (a, cell.getLetter());
	}
	
	public void testSelectCellProcess() {
		cell.selectCell();
		assertTrue (cell.isSelected());
	}
	
	public void testDisselectCellProcess() {
		cell.disselectCell();
		assertFalse (cell.isSelected());
	}
	
	public void testIsSelectedCellProcess() {
		cell.selectCell();
		assertTrue (cell.isSelected());
	}
	
	public void testGetLetterProcess(){
		String a = "A";
		cell.setLetter(a);
		assertEquals (a, cell.getLetter());
	}
	
	public void testGetPositionProcess(){
		int[] test = cell.getPosition();
		int[] correct = {0,0};
		assertEquals (correct[0], test[0]);
		assertEquals (correct[1], test[1]);
	}
	
	public void testGetBonusProcess(){
		cell.setBonus();
		assertEquals (10, cell.getBonus());
	}
	
	public void testSetBonusProcess(){
		cell.setBonus();
		assertEquals (10, cell.getBonus());
	}
	
	public void testResetBonusProcess(){
		cell.resetBonus();
		assertEquals (0, cell.getBonus());
	}
	
	public void testSetSharedTimesProcess(){
		cell.setSharedTimes(1);;
		assertEquals (1, cell.getSharedTimes());
	}
	
	public void testGetSharedTimesProcess(){
		cell.setSharedTimes(1);;
		assertEquals (1, cell.getSharedTimes());
	}
}
