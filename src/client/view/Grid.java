package client.view;

import java.awt.Color;
import java.awt.Graphics;
import client.model.*;

import javax.swing.JPanel;

public class Grid extends JPanel {
	public Grid() {
	}
	int x = 0;
	int y = 0;
	
	
	public void paintComponent(Graphics g){
	super.paintComponent(g);
	int width = this.getWidth()/4;
	int height = this.getHeight()/4;
	for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
        	Boolean isSellected = Model.getModel().getBoard().cells[i][j].isSelected;
        	if (isSellected) {
                g.setColor(Color.blue);
              }
              else {
                g.setColor(Color.white);
              }
        	g.fillRect(x, y, width, height);
        	x += width;
        }
        x = 0;
        y += height;
      }
    }
}