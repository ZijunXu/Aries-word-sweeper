package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import client.model.*;
import client.view.Grid;
import client.view.storyBoard_Practice;

public class PickWordController extends MouseAdapter{
	private Grid panel;
	private storyBoard_Practice test;
	public PickWordController(Grid p, storyBoard_Practice test){
		this.panel = p;
		this.test = test;
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
		int X = e.getX() / 40 ;
		int Y = e.getY() / 40 ;
		System.out.println(e.getX());
		System.out.println(e.getY());
		if (select) 
			Model.getModel().getBoard().cells[X][Y].selectCell();
		else 
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					Model.getModel().getBoard().cells[X][Y].diselectCell();
				}
			}
			
		panel.repaint();
		test.repaint();
	}
}	

