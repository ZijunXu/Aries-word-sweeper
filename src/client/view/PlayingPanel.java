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
import javax.swing.JTextArea;
/**
 * 
 * responsible for the playing GUI
 *
 */

public class PlayingPanel extends JFrame {

    protected JPanel contentPane;
    Application app;
    Model model;
    protected String gameId;
    protected int wordScore;
    protected long score;
    private boolean isLocked;
    private JButton btnMoveRight;
    private JButton btnMoveLeft;
    private JButton btnMoveUp;
    private JButton btnMoveDown;
    private JButton btnLockGame;
    private JButton btnResetGame;
    private JButton btnExitGame;
    private JLabel gameIdDisplay;
    private JLabel wordScoreDisplay;
    private JLabel managingUserDisplay;
    private JLabel chosenWordDisplay;
    private JLabel myNameDisplay;
    private JLabel myScoreDisplay;
    protected JPanel Panel;
    protected JTextArea playersListArea;
    protected JScrollPane jScrollPane1;
    private JLabel lblMyName;
    private JLabel lblMyScore;


    /**
     * Create the frame.
     */
    public PlayingPanel(Application app, Model model) {
        this.model = model;
        this.app = app;
        this.go();
    }

    public void go() {
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
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JLabel label = new JLabel();
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setSize(gridSize, gridSize);
                label.setLocation(i * gridSize, j * gridSize);
                label.setOpaque(true);
                if (model.getBoard().cells[i][j].getBonus() == 10) {
                    label.setBackground(Color.yellow);
                } else {
                    label.setBackground(Color.white);
                }
                label.setText(model.getBoard().cells[i][j].getLetter());
                label.setFont(new Font("Arial", Font.BOLD, 17));
                label.setBorder(BorderFactory.createLineBorder(Color.black));
                panel.add(label);
                getContentPane().add(panel, BorderLayout.CENTER);
                grid[i][j] = label;
            }
        }
        model.setGrid(grid);

        PaintCellController repaint = new PaintCellController(model);
        repaint.repaint();

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
        btnMoveLeft.setBounds(324, 149, 117, 29);
        getContentPane().add(btnMoveLeft);
        btnMoveLeft.addActionListener(myReaction);

        btnMoveRight = new JButton("Move Right");
        btnMoveRight.setBounds(324, 188, 117, 29);
        getContentPane().add(btnMoveRight);
        btnMoveRight.addActionListener(myReaction);

        btnMoveUp = new JButton("Move Up");
        btnMoveUp.setBounds(324, 227, 117, 29);
        getContentPane().add(btnMoveUp);
        btnMoveUp.addActionListener(myReaction);

        btnMoveDown = new JButton("Move Down");
        btnMoveDown.setBounds(324, 266, 117, 29);
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
        gameIDLable.setBounds(324, 31, 77, 16);
        contentPane.add(gameIDLable);

        JLabel playerNameLable = new JLabel("Name");
        playerNameLable.setBounds(622, 31, 61, 16);
        contentPane.add(playerNameLable);

        JLabel playerScoreLable = new JLabel("Score");
        playerScoreLable.setBounds(735, 31, 61, 16);
        contentPane.add(playerScoreLable);

        JLabel managerLable = new JLabel("ManagingUser:");
        managerLable.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        managerLable.setBounds(522, 293, 117, 21);
        contentPane.add(managerLable);

        btnLockGame = new JButton("Lock Game");
        btnLockGame.setBounds(505, 336, 117, 29);
        getContentPane().add(btnLockGame);
        btnLockGame.addActionListener(myReaction);

        btnResetGame = new JButton("Reset Game");
        btnResetGame.setBounds(620, 336, 117, 29);
        getContentPane().add(btnResetGame);
        btnResetGame.addActionListener(myReaction);

        btnExitGame = new JButton("Exit Game");
        btnExitGame.setBounds(732, 336, 117, 29);
        getContentPane().add(btnExitGame);
        btnExitGame.addActionListener(myReaction);

        gameIdDisplay = new JLabel(model.getGame().getRoomID());
        gameIdDisplay.setBounds(424, 26, 106, 26);
        contentPane.add(gameIdDisplay);

        managingUserDisplay = new JLabel(model.getGame().getManagingUser());
        managingUserDisplay.setBounds(658, 293, 108, 21);
        contentPane.add(managingUserDisplay);

        chosenWordDisplay = new JLabel("");
        chosenWordDisplay.setBounds(148, 330, 106, 21);
        contentPane.add(chosenWordDisplay);

        wordScoreDisplay = new JLabel("");
        wordScoreDisplay.setBounds(148, 360, 106, 21);
        contentPane.add(wordScoreDisplay);

        playersListArea = new JTextArea(String.format("  1\t %s\t %s\n",
                model.getGame().getMyName(), model.getGame().getScore()) + model.getGame().getPlayerList());
        playersListArea.setForeground(Color.BLACK);
        playersListArea.setColumns(20);
        playersListArea.setRows(10);
        playersListArea.setEditable(false);

        jScrollPane1 = new JScrollPane();
        jScrollPane1.setBounds(554, 52, 283, 231);
        jScrollPane1.setViewportView(playersListArea);
        getContentPane().add(jScrollPane1);

        lblMyName = new JLabel("My Name:");
        lblMyName.setFont(new Font("Dialog", Font.BOLD, 15));
        lblMyName.setBounds(324, 72, 91, 19);
        contentPane.add(lblMyName);

        lblMyScore = new JLabel("My Score:");
        lblMyScore.setFont(new Font("Dialog", Font.BOLD, 15));
        lblMyScore.setBounds(324, 105, 106, 29);
        contentPane.add(lblMyScore);

        myNameDisplay = new JLabel(model.getGame().getMyName());
        myNameDisplay.setBounds(424, 74, 84, 17);
        contentPane.add(myNameDisplay);

        myScoreDisplay = new JLabel(String.valueOf(model.getGame().getScore()));
        myScoreDisplay.setBounds(424, 112, 54, 15);
        contentPane.add(myScoreDisplay);
    }

    /** use ActionListener to listen button click events and perform corresponding actions */
    private class ButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnMoveLeft) {
                new MoveBoardController(app, model, -1, 0).process();
            } else if (e.getSource() == btnMoveRight) {
                new MoveBoardController(app, model, 1, 0).process();
            } else if (e.getSource() == btnMoveUp) {
                new MoveBoardController(app, model, 0, -1).process();
            } else if (e.getSource() == btnMoveDown) {
                new MoveBoardController(app, model, 0, 1).process();
            } else if (e.getSource() == btnExitGame) {
                new ExitGameController(app, model).process();
            } else if (e.getSource() == btnLockGame) {
                new LockGameController(app, model).process();
            } else if (e.getSource() == btnResetGame) {
                new ResetGameController(app, model).process();
            }
        }
    }

    /** set the label of gameID display in the panel */
    public void setGameId(String gameId) {
        this.gameIdDisplay.setText(gameId);
    }

    /** set manager of the game and perform corresponding action on the lock and reset buttons */
    public void setManagingUser(String managingUser, boolean isManagingUser) {
        this.managingUserDisplay.setText(managingUser);
        if (!isManagingUser) {
            btnResetGame.setEnabled(false);
            btnLockGame.setEnabled(false);
        } else {
            if (isLocked) {
                btnLockGame.setEnabled(false);
                btnResetGame.setEnabled(true);
            } else {
                btnLockGame.setEnabled(true);
                btnResetGame.setEnabled(true);
            }
        }
    }

    /** set the label of score display in the panel */
    public void setWordScore(int score) {
        if (score == 0) {
            this.wordScoreDisplay.setText("");
        } else {
            this.wordScoreDisplay.setText(String.valueOf(score));
        }
    }

    /** set the label of chosen word display in the panel */
    public void setChosenWord(String word) {
        this.chosenWordDisplay.setText(word);
    }

    /** lock the game and disable the lock game button */
    public void lockGame() {
        this.isLocked = true;
        btnLockGame.setEnabled(false);
    }
    
    /**
     * @author Zhanfeng Huang
     * for test case use
     * @return check whether the game is locked
     * to test if the lock game method worked
     */
    public boolean returnLockStatus() {
    	return this.isLocked;
    }

    /** set the player list display in the panel */
    public void setPlayersListArea(String playersList) {
        this.playersListArea.setText(playersList);
    }

    /** set the score display in the panel */
    public void setMyScoreDisplay(String score) {
        myScoreDisplay.setText(score);
    }

    public void setMyNameDisplay(String myName){
        myNameDisplay.setText(myName);
    }
}