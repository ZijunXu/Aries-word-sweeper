package com.wpi.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ExitListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        JOptionPane.showMessageDialog(null, "Exiting the Game");
        System.exit(0);
    }

}
