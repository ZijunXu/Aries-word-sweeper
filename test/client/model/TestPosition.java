package client.model;

import junit.framework.TestCase;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import client.model.Position;

/**
 *@author Zhanfeng Huang
 */

public class TestPosition extends TestCase {

	Position position;
	
	
	protected void setUp() {
		
		int column = 0;
		int row = 0;
		position = new Position(column, row);

	}
	
	/**
	 * It is for the test case of Position
	 * 
	 */
	public void testGetPositionColumnProcess(){
		int column = position.column;
	}
	
	public void testGetPositionRowProcess(){
		int row = position.row;
	}
	
}
