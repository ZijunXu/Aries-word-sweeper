package client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import client.controller.*;
import client.model.Model;

public class PlayingPanel extends JFrame {

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
	public PlayingPanel() {
		this.go();
	}
	public void go(){
		setTitle("WordSweeper");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(60, 80, 220, 220);
		getContentPane().add(panel);
		int gridSize = 55;
		panel.setLayout(null);
		JLabel[][] grid = new JLabel[4][4];
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				Color color = Color.white;
				JLabel label = new JLabel();
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setSize(gridSize, gridSize);
				label.setLocation(i * gridSize, j * gridSize);
				boolean isSellected = Model.getModel().getBoard().cells[i][j].isSelected;
				if(isSellected)
					color = Color.blue;
				label.setOpaque(true);
				label.setBackground(color);
				label.setText(Model.getModel().getBoard().cells[i][j].getLetter());
				label.setFont(new Font("Arial", Font.BOLD, 17));
				label.setBorder(BorderFactory.createLineBorder(Color.black));
				panel.add(label);
				getContentPane().add(panel, BorderLayout.CENTER);
				grid[i][j] = label;
			}
		}
		Model.getModel().setGrid(grid);
		
		PickWordController control = new PickWordController(panel);
		panel.addMouseListener(control);
		panel.addMouseMotionListener(control);
		
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
	public void refresh(){
		contentPane.repaint();
	}
}
