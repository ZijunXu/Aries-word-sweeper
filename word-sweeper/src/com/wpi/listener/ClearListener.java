package com.wpi.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class ClearListener implements ActionListener{
    
    private JLabel[] labels;
    
    public ClearListener(JLabel[] labels){
        this.labels=labels;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        for(int i=0; i<labels.length; i++){
            labels[i].setBackground(null);
        }
    }
}
