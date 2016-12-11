package client.controller;

import client.model.Model;
import client.view.Application;

import javax.swing.*;
import java.awt.Color;

/**
 * @author Zijun Xu
 */
public class PaintCellController {
    Model model;
    public PaintCellController(Model m){
        this.model = m;
    }

    public void repaint(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String letters = model.getBoard().cells[i][j].getLetter();
                model.getGrid()[i][j].setText(letters);
                if (model.getBoard().cells[i][j].isSelected){
                    model.getGrid()[i][j].setBackground(Color.blue);
                }else {
                    if(model.getBoard().cells[i][j].getSharedTimes() > 0){
                        model.getGrid()[i][j].setBackground(Color.gray);
                    }else {
                        model.getGrid()[i][j].setBackground(Color.white);
                    }
                    if (model.getBoard().cells[i][j].getBonus() == 10){
                        model.getGrid()[i][j].setBackground(Color.yellow);
                    }
                }
            }
        }
    }
}

