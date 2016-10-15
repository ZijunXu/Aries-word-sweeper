package com.wpi.layout;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.wpi.listener.ClearListener;
import com.wpi.listener.ExitListener;
import com.wpi.listener.MouseMoveListener;
import com.wpi.listener.ResetListener;
import com.wpi.service.RandomLetter;

public class GameLayout {
    private JFrame frame = null;
    private JPanel panel = null;
    private JButton resetButton = null;
    private JButton clearButton = null;
    private JButton exitButton = null;
    private JLabel label = null;
    private JLabel[] letterLabel = null;
    private RandomLetter randomLetter = null;
    
    
    private MouseMoveListener mouseListener = null;
    private ExitListener exitListener = null;
    private ClearListener clearListener = null;
    private ResetListener resetListener = null;
    
    public static boolean ISPRESSED = false;
    
    
    public GameLayout(){
        frame = new JFrame();
        panel = new JPanel(new GridLayout(4,4,0,0));
        resetButton = new JButton();
        clearButton = new JButton();
        exitButton = new JButton();
        label = new JLabel();
        letterLabel = new JLabel[16];
        randomLetter = new RandomLetter();
        for(int i=0; i<16; i++){
            letterLabel[i] = new JLabel();
            letterLabel[i].setText("A");
        }
        
        exitListener = new ExitListener();
        clearListener = new ClearListener(letterLabel);
        resetListener = new ResetListener(letterLabel);
        
    }
    
    public void setLayout(){
        int width = 500, height = 300;
        int x = 100, y = 100;
        String[] letters = this.randomLetter.getRandomLetter(letterLabel.length);
        x = (Toolkit.getDefaultToolkit().getScreenSize().width - width) / 2;
        y = (Toolkit.getDefaultToolkit().getScreenSize().height - height) / 2;
        frame.setTitle("Word Sweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(x, y, width, height);
        frame.setLayout(null);
        label.setText("Word Sweeper");
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Lucida Bright", Font.BOLD | Font.ITALIC, 20));
        label.setBounds(180, 0, 250, 80);
        panel.setBounds(50, 60, 180, 180);
        resetButton.setBounds(310, 80, 100, 30);
        resetButton.setText("RESET");
        clearButton.setBounds(310, 135, 100, 30);
        clearButton.setText("CLEAR");
        exitButton.setBounds(310, 190, 100, 30);
        exitButton.setText("EXIT");
        /**add label**/
        for(int i=0; i < 16; i++){
            letterLabel[i].setText(letters[i]);
            letterLabel[i].setBorder(BorderFactory.createLineBorder(Color.black));
            letterLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
            letterLabel[i].setOpaque(true);
            panel.add(letterLabel[i]);
        }
        frame.add(label);
        frame.add(panel);
        frame.add(resetButton);
        frame.add(clearButton);
        frame.add(exitButton);
        frame.setVisible(true);
    }
    
    
    public void addListener(){
        for(int i=0; i<letterLabel.length; i++){
            mouseListener = new MouseMoveListener(letterLabel[i]);
            letterLabel[i].addMouseListener(mouseListener);
        }
        exitButton.addActionListener(exitListener);
        resetButton.addActionListener(resetListener);
        clearButton.addActionListener(clearListener);
    }
}
