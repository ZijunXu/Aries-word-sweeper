package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import client.model.*;

/**
 *@author Zijun Xu
 */
public class PickWordController extends MouseAdapter{

	private JPanel panel;
	Model model;
	public PickWordController(Model model,JPanel p){
		this.model = model;
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
		int x = positionInBoard(e.getX());
		int y = positionInBoard(e.getY());
		if(x == -1 || y == -1){
			select = false;
		}
//		System.out.println(e.getX());
//		System.out.println(e.getY());
//		System.out.println(Model.getModel().getBoard().cells[x][y].isSelected);
        if (!select && !model.getWord().selectedWord().equals("")){
            model.getWord().resetWord();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    model.getBoard().cells[i][j].disselectCell();
                }
            }
            System.out.println(model.getWord().selectedWord());
            PaintCellController paint = new PaintCellController(model, panel);
            paint.repaint();
        }
		if (x != -2 && y != -2){
			if (select && !model.getBoard().cells[x][y].isSelected && isAdjacentCells(x, y)) {
				model.getBoard().cells[x][y].selectCell();
				model.getWord().addCell(model.getBoard().cells[x][y]);
				System.out.println(model.getWord().computeScore());
                PaintCellController paint = new PaintCellController(model, panel);
                paint.repaint();
			}
		}
	}

	protected int positionInBoard(int position){
		int inBoardPosition = -2;
		/*
		* the mouse is in the gap of cells
		* */
		if (position < 0 || position > 220){
			inBoardPosition = -1;
			/*
			* the mouse goes out of the panel
			* */
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
		if (model.getWord().isTheFirstLetter()){
			return true;
		}else {
			return (Math.abs(model.getWord().lastCellPosition()[0] - x) < 2 &&
					Math.abs(model.getWord().lastCellPosition()[1] - y) < 2);
		}
	}
}	
