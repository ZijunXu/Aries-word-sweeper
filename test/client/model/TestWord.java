package client.model;

import junit.framework.TestCase;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import client.model.Word;
import client.model.Cell;

/**
 * this test case is responsible for testing the word entity
 * @author Zhanfeng Huang
 * 
 */

public class TestWord extends TestCase {

	Word word;
	
	Cell cell;
	
	int column = 0;
	int row = 0;
	
	/** initialization
	 * to initialize a word, should also initialize a cell
	 * then add the cell entity to the word entity
	 */
	protected void setUp() {
		/** add a cell to word */
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
	
	/** 
	 * test getting the chosen word
	 * as I've added a cell to the word
	 * the size should be 1
	 */
	public void testGetChoseCellsProcess() {
		word.getChoseCells();
		assertEquals (1, word.getChoseCells().size());
	}
	
	/** test the return of the first letter status correct or not */
	public void testIsTheFirstLetterProcess() {
		assertFalse (word.isTheFirstLetter());
	}
	
	/** test the return of the last cell's position correct or not */
	public void testLastCellPositionProcess() {
		assertEquals(0, word.lastCellPosition()[0]);
		assertEquals(0, word.lastCellPosition()[1]);
	}
	
	/** 
	 * test reset the word
	 * it clear all cells of the word
	 * the size of the word should be 0
	 */
	public void testResetWordProcess() {
		word.resetWord();
		assertEquals(0, word.score);
		assertEquals(0, word.getChoseCells().size());
	}
	
	/** test the return of the valid word correct or not */
	public void testValidProcess() {
		assertTrue(word.valid());
	}
	
	/** test the compute score method correct or not */
	public void testComputeScoreProcess() {
		assertEquals(8, word.computeScore());
	}
	
	/** test getting the chosen cells list */
	public void testGetChoseCellsXMLStringProcess() {
		String result = "<cell position='0,0' letter='A'/>";
		assertEquals(result, word.getChoseCellsXMLString());
	}
	
}
