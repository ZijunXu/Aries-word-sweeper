package client.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import client.controller.*;

public class storyBoard_Practice extends JFrame {

	private JPanel contentPane;
		
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					storyBoard_Practice frame = new storyBoard_Practice();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public storyBoard_Practice(Grid grid) {
		setTitle("WordSweeper");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		JPanel panel = new JPanel();
//		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
//		panel.setBounds(90, 138, 160, 160);
//		getContentPane().add(panel);
		grid.setBounds(90, 138, 160, 160);
		this.add(grid);
		
		PickWordController control = new PickWordController(grid, this);
		grid.addMouseListener(control);
		grid.addMouseMotionListener(control);
		
		System.out.println(grid);
		JLabel label = new JLabel("Word Sweeper");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Lucida Bright", Font.BOLD | Font.ITALIC, 40));
		label.setBounds(6, 6, 362, 85);
		getContentPane().add(label);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(139, 308, 76, 29);
		getContentPane().add(btnClear);
		
		JButton button = new JButton("Reset");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(334, 138, 117, 29);
		getContentPane().add(button);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(334, 186, 117, 29);
		getContentPane().add(btnExit);
		
	}
	
}
