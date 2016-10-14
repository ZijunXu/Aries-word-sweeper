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
		panel.setBounds(65, 94, 220, 220);
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
		
		JButton btnMoveLeft = new JButton("Move Left");
		btnMoveLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMoveLeft.setBounds(324, 127, 117, 29);
		getContentPane().add(btnMoveLeft);
		
		JButton btnMoveRight = new JButton("Move Right");
		btnMoveRight.setBounds(324, 170, 117, 29);
		contentPane.add(btnMoveRight);
		
		JButton btnMoveUp = new JButton("Move Up");
		btnMoveUp.setBounds(324, 211, 117, 29);
		contentPane.add(btnMoveUp);
		
		JButton btnMoveDown = new JButton("Move Down");
		btnMoveDown.setBounds(324, 252, 117, 29);
		contentPane.add(btnMoveDown);
		
	}
	public void refresh(){
		contentPane.repaint();
	}
}
