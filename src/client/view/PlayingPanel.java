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
	protected String gameId;
	protected int wordScore;
	protected long score;
    protected JButton btnMoveRight;
    protected JButton btnMoveLeft;
    protected JButton btnMoveUp;
    protected JButton btnMoveDown;
    protected JButton btnLockGame;
    protected JButton btnResetGame;
    protected JButton btnExitGame;
    protected JLabel gameIdDisplay;
    protected JLabel wordScoreDisplay;
    protected JLabel managingUserDisplay;
    protected JLabel chosenWordDisplay;
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
		wordLable.setBounds(65, 330, 61, 21);
		contentPane.add(wordLable);
		
		JLabel wordScoreLable = new JLabel("Word Score:");
		wordScoreLable.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		wordScoreLable.setBounds(41, 360, 106, 21);
		contentPane.add(wordScoreLable);
		
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
		
		btnLockGame = new JButton("Lock Game");
		btnLockGame.setBounds(506, 326, 117, 29);
        getContentPane().add(btnLockGame);
        btnLockGame.addActionListener(myReaction);

        btnResetGame = new JButton("Reset Game");
		btnResetGame.setBounds(622, 326, 117, 29);
		getContentPane().add(btnResetGame);
		btnResetGame.addActionListener(myReaction);
		
		btnExitGame = new JButton("Exit Game");
		btnExitGame.setBounds(732, 326, 117, 29);
        getContentPane().add(btnExitGame);
		btnExitGame.addActionListener(myReaction);
		
		gameIdDisplay = new JLabel(model.getGame().getMyName());
		gameIdDisplay.setBounds(670, 26, 106, 26);
		contentPane.add(gameIdDisplay);
		
		managingUserDisplay = new JLabel(model.getGame().getManagingUser());
		managingUserDisplay.setBounds(668, 275, 108, 21);
		contentPane.add(managingUserDisplay);
		
		chosenWordDisplay = new JLabel("");
		chosenWordDisplay.setBounds(148, 330, 106, 21);
		contentPane.add(chosenWordDisplay);
		
		wordScoreDisplay = new JLabel("");
		wordScoreDisplay.setBounds(148, 360, 106, 21);
		contentPane.add(wordScoreDisplay);
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
            } else if(e.getSource() == btnExitGame){
                new ExitGameController(app, model).process();
            } else if (e.getSource() == btnLockGame){
                new LockGameController(app, model).process();
            } else if (e.getSource() == btnResetGame){
                new ResetGameController(app, model).process();
            }
        }
    }

    public void setGameId(String gameId){
	    this.gameIdDisplay.setText(gameId);
    }

    public void setManagingUser(String managingUser){
        this.managingUserDisplay.setText(managingUser);
    }

    public void setWordScore(int score){
        if(score == 0){
            this.wordScoreDisplay.setText("");
        } else {
            this.wordScoreDisplay.setText(String.valueOf(score));
        }
    }

    public void setChosenWord(String word){
        this.chosenWordDisplay.setText(word);
    }
}
