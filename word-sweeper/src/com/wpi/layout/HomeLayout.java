package com.wpi.layout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.wpi.listener.PracticeGameListener;

import com.wpi.models.Model;
import com.wpi.client_src.ServerAccess;
import com.wpi.controller.CreateGameController;
import com.wpi.controller.JoinGameController;

public class HomeLayout {
    private JFrame frame;
    private JButton newGameButton;
    private JButton joinGameButton;
    private JButton pracGameButton;
    private JLabel label;
    
    public final Model model;
	ServerAccess serverAccess;
    
    
    public HomeLayout(Model model){
    	this.model = model;
        frame = new JFrame();
        newGameButton = new JButton();
        joinGameButton = new JButton();
        pracGameButton = new JButton();
        label = new JLabel();
        newGameButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			new CreateGameController(HomeLayout.this, model).process();
    		}
    	});
        joinGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JoinGameController(HomeLayout.this, model).process();
			}
		});
    }
    
    public void setLayout(){
        int width = 500, height = 300;
        int x = 100, y = 100;
        x = (Toolkit.getDefaultToolkit().getScreenSize().width - width) / 2;
        y = (Toolkit.getDefaultToolkit().getScreenSize().height - height) / 2;
        frame.setTitle("Word Sweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(x, y, width, height);
        frame.setLayout(null);
        label.setText("Welcome to WordSweeper");
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Lucida Bright", Font.BOLD | Font.ITALIC, 20));
        label.setBounds(100, 0, 300, 80);
        newGameButton.setText("CREATE GAME");
        newGameButton.setBounds(180, 70, 140, 30);
        joinGameButton.setText("JOIN GAME");
        joinGameButton.setBounds(180, 125, 140, 30);
        pracGameButton.setText("PRACTICE GAME");
        pracGameButton.setBounds(180, 180, 140, 30);
        frame.add(label);
        frame.add(newGameButton);
        frame.add(pracGameButton);
        frame.add(joinGameButton);
        frame.setVisible(true);
    }
    
    public void addListener(){
        this.pracGameButton.addActionListener(new PracticeGameListener(this.frame));
    }
    
    public void setServerAccess(ServerAccess access) {
		this.serverAccess = access;
	}
	
	public ServerAccess getServerAccess() {
		return serverAccess;
	}
}
