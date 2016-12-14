package client.model;

import junit.framework.TestCase;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import client.model.Position;

/**
 * this test case is responsible for testing the Position entity
 * @author Zhanfeng Huang
 * 
 */

public class TestPosition extends TestCase {

	Position position;
	
	/** initialization */
	protected void setUp() {
		
		int column = 0;
		int row = 0;
		position = new Position(column, row);

	}
	
	/**
	 * It is for the test case of Position
	 * 
	 */
	/** test getting the column of the position */
	public void testGetPositionColumnProcess(){
		int column = position.column;
	}
	
	/** test getting the row of the position */
	public void testGetPositionRowProcess(){
		int row = position.row;
	}
	
}
