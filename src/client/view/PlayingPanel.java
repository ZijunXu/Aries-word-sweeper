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
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class PlayingPanel extends JFrame {

	protected JPanel contentPane;
	Application app;
	Model model;
	private JTextField wordField;
	private JTextField wordScoreField;
	private JTextField managingUserField;
    protected JButton btnMoveRight;
    protected JButton btnMoveLeft;
    protected JButton btnMoveUp;
    protected JButton btnMoveDown;
	protected JPanel Panel;

	/**
	 * Create the frame.
	 */
	public PlayingPanel(Application app, Model model) {
		this.model = model;
		this.app = app;
		this.go();
	}
	public void go(){
		setTitle("WordSweeper");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		this.Panel = panel;
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
				boolean isSellected = model.getBoard().cells[i][j].isSelected;
				if(isSellected)
					color = Color.blue;
				label.setOpaque(true);
				label.setBackground(color);
				label.setText(model.getBoard().cells[i][j].getLetter());
				label.setFont(new Font("Arial", Font.BOLD, 17));
				label.setBorder(BorderFactory.createLineBorder(Color.black));
				panel.add(label);
				getContentPane().add(panel, BorderLayout.CENTER);
				grid[i][j] = label;
			}
		}
		model.setGrid(grid);

		PickWordController control = new PickWordController(app, model, panel);
		panel.addMouseListener(control);
		panel.addMouseMotionListener(control);
		
		JLabel label = new JLabel("Word Sweeper");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Lucida Bright", Font.BOLD | Font.ITALIC, 40));
		label.setBounds(6, 6, 362, 85);
		getContentPane().add(label);

        ButtonAction myReaction;
        myReaction = new ButtonAction();

        btnMoveLeft = new JButton("Move Left");
		btnMoveLeft.setBounds(324, 127, 117, 29);
		getContentPane().add(btnMoveLeft);
        btnMoveLeft.addActionListener(myReaction);

		btnMoveRight = new JButton("Move Right");
		btnMoveRight.setBounds(324, 170, 117, 29);
		getContentPane().add(btnMoveRight);
        btnMoveRight.addActionListener(myReaction);

        btnMoveUp = new JButton("Move Up");
		btnMoveUp.setBounds(324, 211, 117, 29);
		getContentPane().add(btnMoveUp);
        btnMoveUp.addActionListener(myReaction);

        btnMoveDown = new JButton("Move Down");
		btnMoveDown.setBounds(324, 252, 117, 29);
		contentPane.add(btnMoveDown);
        btnMoveDown.addActionListener(myReaction);


        JLabel wordLable = new JLabel("Word:");
		wordLable.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		wordLable.setBounds(65, 330, 61, 16);
		contentPane.add(wordLable);
		
		wordField = new JTextField();
		wordField.setBounds(143, 326, 130, 26);
		contentPane.add(wordField);
		wordField.setColumns(10);
		
		JLabel wordScoreLable = new JLabel("Word Score:");
		wordScoreLable.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		wordScoreLable.setBounds(41, 360, 106, 16);
		contentPane.add(wordScoreLable);
		
		wordScoreField = new JTextField();
		wordScoreField.setBounds(143, 356, 130, 26);
		contentPane.add(wordScoreField);
		wordScoreField.setColumns(10);
		
		JLabel gameIDLable = new JLabel("Game ID:");
		gameIDLable.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		gameIDLable.setBounds(583, 31, 77, 16);
		contentPane.add(gameIDLable);
		
		JLabel playerNameLable = new JLabel("Name");
		playerNameLable.setBounds(622, 64, 61, 16);
		contentPane.add(playerNameLable);
		
		JLabel playerScoreLable = new JLabel("Score");
		playerScoreLable.setBounds(732, 64, 61, 16);
		contentPane.add(playerScoreLable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(594, 86, 210, 175);
		contentPane.add(scrollPane);
		
		JLabel managerLable = new JLabel("ManagingUser:");
		managerLable.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		managerLable.setBounds(543, 275, 117, 21);
		contentPane.add(managerLable);
		
		managingUserField = new JTextField();
		managingUserField.setBounds(663, 273, 130, 26);
		contentPane.add(managingUserField);
		managingUserField.setColumns(10);
		
		JButton btnLockGame = new JButton("Lock Game");
		btnLockGame.setBounds(506, 326, 117, 29);
		contentPane.add(btnLockGame);
		
		JButton btnResetGame = new JButton("Reset Game");
		btnResetGame.setBounds(622, 326, 117, 29);
		contentPane.add(btnResetGame);
		
		JButton btnExitGame = new JButton("Exit Game");
		btnExitGame.setBounds(732, 326, 117, 29);
		contentPane.add(btnExitGame);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(670, 26, 106, 26);
		contentPane.add(lblNewLabel);
	}

	private class ButtonAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == btnMoveLeft) {
                new MoveBoardController(app, model, -1, 0).process();
            } else if (e.getSource() == btnMoveRight){
                new MoveBoardController(app, model, 1, 0).process();
            } else if (e.getSource() == btnMoveUp){
                new MoveBoardController(app, model, 0, -1).process();
            } else if (e.getSource() == btnMoveDown){
                new MoveBoardController(app, model, 0, 1).process();
            }
        }
    }
}
