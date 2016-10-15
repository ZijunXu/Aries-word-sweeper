package com.wpi.listener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import com.wpi.layout.GameLayout;

public class MouseMoveListener implements MouseListener{
    
    private JLabel label = null;
    
    public MouseMoveListener(JLabel label){
        this.label = label;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        GameLayout.ISPRESSED = true;
//        System.out.println(this.press);
        this.label.setBackground(Color.gray);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
//        System.out.println(this.press);
        GameLayout.ISPRESSED = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
//        System.out.println(this.press);
        if(GameLayout.ISPRESSED)
            this.label.setBackground(Color.gray);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }

}
