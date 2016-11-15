package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import client.model.*;
//import client.view.storyBoard_Practice;

public class PickWordController extends MouseAdapter{
	private JPanel panel;
	public PickWordController(JPanel p){
		this.panel = p;
	} 
	
	public void mousePressed(MouseEvent me){
		mouseGen(me, true);
	}
	
	public void mouseDragged(MouseEvent me) {
		mouseGen(me, true);
	}
	
	public void mouseReleased(MouseEvent me) {
		mouseGen(me, false);
	}
	
	private void mouseGen(MouseEvent e, boolean select) {
//		int x = e.getX() / 55 ;
//		int y = e.getY() / 55 ;
		int x = positionInBoard(e.getX());
		int y = positionInBoard(e.getY());
		if(x == -1 || y == -1){
			select = false;
		}
//		System.out.println(e.getX());
//		System.out.println(e.getY());
//		System.out.println(Model.getModel().getBoard().cells[x][y].isSelected);
		if (x != -2 && y != -2){
			if (select && !Model.getModel().getBoard().cells[x][y].isSelected && isAdjacentCells(x, y)) {
				Model.getModel().getBoard().cells[x][y].selectCell();
				Model.getModel().getWord().addCell(Model.getModel().getBoard().cells[x][y]);
			} else if (!select){
				System.out.println(Model.getModel().getWord().selectedWord());
				Model.getModel().getWord().resetWord();
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						Model.getModel().getBoard().cells[i][j].disselectCell();
					}
				}
			}
		}
	}

	protected int positionInBoard(int position){
		int inBoardPosition = -2;
		if (position < 0 || position > 220){
			inBoardPosition = -1;
		}else if (position < 50 && position > 0){
			inBoardPosition = 0;
		}else if (position < 105 && position > 60){
			inBoardPosition = 1;
		}else if (position < 160 && position > 115){
			inBoardPosition = 2;
		}else if (position < 220 && position > 170){
			inBoardPosition = 3;
		}
		return inBoardPosition;
	}

	protected boolean isAdjacentCells(int x, int y){
		if (Model.getModel().getWord().isTheFirstLetter()){
			return true;
		}else {
			return (Math.abs(Model.getModel().getWord().lastCellPosition()[0] - x) < 2 &&
					Math.abs(Model.getModel().getWord().lastCellPosition()[1] - y) < 2);
		}
	}
}	

