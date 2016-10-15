package com.wpi.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import com.wpi.service.RandomLetter;

public class ResetListener implements ActionListener{

    private JLabel[] labels;
    private RandomLetter randomLetter;
    
    public ResetListener(JLabel[] labels){
        this.labels=labels;
        randomLetter = new RandomLetter();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String[] letters = randomLetter.getRandomLetter(labels.length);
        for(int i=0; i<labels.length; i++){
            labels[i].setBackground(null);
            labels[i].setText(letters[i]);
        }
    }

}
