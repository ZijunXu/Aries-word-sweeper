package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import client.model.*;
import client.view.Application;

/**
 * responsible for picking word
 *@author Zijun Xu
 */

public class PickWordController extends MouseAdapter{

	private JPanel panel;
	Model model;
	Application app;
	public PickWordController(Application app, Model model,JPanel p){
		this.app = app;
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
	
	protected void mouseGen(MouseEvent e, boolean select) {
		int x = positionInBoard(e.getX());
		int y = positionInBoard(e.getY());
		if(x == -1 || y == -1){
			select = false;
		}
        if (!select && !model.getWord().selectedWord().equals("")){
            new FindWordController(app, model).process();
            System.out.println(model.getWord().selectedWord());
            model.getWord().resetWord();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    model.getBoard().cells[i][j].disselectCell();
                }
            }
            this.app.getPlayingPanel().setWordScore(model.getWord().computeScore());
            this.app.getPlayingPanel().setChosenWord("");

            PaintCellController paint = new PaintCellController(model);
            paint.repaint();
        }
		if (x != -2 && y != -2){
			if (select && !model.getBoard().cells[x][y].isSelected && isAdjacentCells(x, y)) {
				model.getBoard().cells[x][y].selectCell();
				model.getWord().addCell(model.getBoard().cells[x][y]);

				this.app.getPlayingPanel().setWordScore(model.getWord().computeScore());
				this.app.getPlayingPanel().setChosenWord(model.getWord().selectedWord());

                PaintCellController paint = new PaintCellController(model);
                paint.repaint();
			}
		}
	}

	protected int positionInBoard(int position){
		int inBoardPosition = -2;
		/**
		* the mouse is in the gap of cells
		*/
		if (position < 0 || position > 220){
			inBoardPosition = -1;
			/**
			* the mouse goes out of the panel
			*/
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
	
	/** add a rule that cannot select cells which are not adjacent */
	protected boolean isAdjacentCells(int x, int y){
		if (model.getWord().isTheFirstLetter()){
			return true;
		}else {
			return (Math.abs(model.getWord().lastCellPosition()[0] - x) < 2 &&
					Math.abs(model.getWord().lastCellPosition()[1] - y) < 2);
		}
	}
}	
