package client.controller;

import client.model.Model;
import client.view.Application;

import javax.swing.*;
import java.awt.Color;

/**
 * responsible for painting cells according to the cell's status.
 * if the cell is selected, paint it blue
 * if the cell is a bonus cell, paint it yellow
 * if the cell is a shared cell, paint it gray
 * other cells paint them white
 *  @author Zijun Xu
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
                        model.getGrid()[i][j].setBackground(new Color(
                                255 - model.getBoard().cells[i][j].getSharedTimes() * 30,
                                255 - model.getBoard().cells[i][j].getSharedTimes() * 30,
                                255 - model.getBoard().cells[i][j].getSharedTimes() * 30));
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

