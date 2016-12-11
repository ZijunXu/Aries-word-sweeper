package client.model;

import junit.framework.TestCase;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import client.model.Word;
import client.model.Cell;

/**
 *@author Zhanfeng Huang
 */

public class TestWord extends TestCase {

	Word word;
	
	Cell cell;
	
	int column = 0;
	int row = 0;
	
	
	protected void setUp() {
		// add a cell to word
		word = new Word();
		cell = new Cell(column, row);
		cell.selectCell();
		cell.setLetter("A");
		word.addCell(cell);
	}
	
	/**
	 * It is for the test case of Word
	 * 
	 */
	
	public void testGetChoseCellsProcess() {
		word.getChoseCells();
		assertEquals (1, word.getChoseCells().size());
	}
	
	public void testIsTheFirstLetterProcess() {
		assertFalse (word.isTheFirstLetter());
	}
	
	public void testLastCellPositionProcess() {
		assertEquals(0, word.lastCellPosition()[0]);
		assertEquals(0, word.lastCellPosition()[1]);
	}
	
	public void testResetWordProcess() {
		word.resetWord();
		assertEquals(0, word.score);
		assertEquals(0, word.getChoseCells().size());
	}
	
	public void testValidProcess() {
		assertTrue(word.valid());
	}
	
	public void testComputeScoreProcess() {
		assertEquals(8, word.computeScore());
	}
	
	public void testGetChoseCellsXMLStringProcess() {
		String result = "<cell position='0,0' letter='A'/>";
		assertEquals(result, word.getChoseCellsXMLString());
	}
	
}
