package client.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import client_src.ServerAccess;
import client.model.Model;
import client.model.Player;
import client.controller.CreateGameController;
import client.controller.JoinGameController;

public class Application extends JFrame {

	protected JPanel contentPane;
	protected JButton btnPractice;
	protected JButton btnCreateAGame;
	protected JButton btnJoinAGame;

    protected Model model;
    protected Player player;
	ServerAccess serverAccess;
	
	JTextArea requestArea;
	JTextArea responseArea;
	private JTextField playerNameField;
	private JTextField gameIDField;
    private JTextField passwordField;

    String roomID;
	String playerName;
	String password;

    protected PlayingPanel playingPanel;

	/**
	 * Create the frame.
	 */
	public Application(Model model) {
		this.model = model;
		setTitle("WordSweeper");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(100, 100, 534, 386);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ButtonGroup passwordButtonGroup = new ButtonGroup();

        JPanel panel = new JPanel();
        panel.setBounds(207, 160, 289, 75);
        getContentPane().add(panel);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("With a password");
        rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.TRAILING);
        panel.add(rdbtnNewRadioButton);
        passwordButtonGroup.add(rdbtnNewRadioButton);
        
                passwordField = new JTextField();
                panel.add(passwordField);
                passwordField.setColumns(10);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Without a password              ");
        panel.add(rdbtnNewRadioButton_1);
        passwordButtonGroup.add(rdbtnNewRadioButton_1);

        JLabel playerNameLable = new JLabel("User Name:");
        playerNameLable.setBounds(219, 111, 87, 16);
        contentPane.add(playerNameLable);

        playerNameField = new JTextField();
        playerNameField.setBounds(304, 106, 130, 26);
        contentPane.add(playerNameField);
        playerNameField.setColumns(10);

        JLabel gameIDLable = new JLabel("Game ID:");
        gameIDLable.setBounds(231, 268, 61, 16);
        contentPane.add(gameIDLable);

        gameIDField = new JTextField();
        gameIDField.setBounds(304, 263, 130, 26);
        contentPane.add(gameIDField);
        gameIDField.setColumns(10);

        rdbtnNewRadioButton.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent arg0) {
                if (rdbtnNewRadioButton.isSelected()) {
                    passwordField.setVisible(true);
                    passwordField.setEditable(true);
                    panel.revalidate();
                    panel.repaint();
                } else {
                    passwordField.setVisible(false);
                    passwordField.setEditable(false);
                    panel.revalidate();
                    panel.repaint();
                }

            }

        });
        rdbtnNewRadioButton_1.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent arg0) {
                if (rdbtnNewRadioButton_1.isSelected()) {
                    passwordField.setVisible(false);
                    passwordField.setEditable(false);
                    panel.revalidate();
                    panel.repaint();
                }
            }
        });

        ButtonReaction myReaction = new ButtonReaction();

        btnJoinAGame = new JButton("Join a game");
        btnJoinAGame.setBounds(35, 163, 130, 38);
        getContentPane().add(btnJoinAGame);
        btnJoinAGame.addActionListener(myReaction);


        btnCreateAGame = new JButton("Create a game");
        btnCreateAGame.setBounds(35, 105, 130, 38);
        getContentPane().add(btnCreateAGame);
        btnCreateAGame.addActionListener(myReaction);


        JLabel lblNewLabel = new JLabel("Word Sweeper");
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setFont(new Font("Lucida Bright", Font.BOLD | Font.ITALIC, 40));
        lblNewLabel.setBounds(10, 10, 362, 85);
        getContentPane().add(lblNewLabel);

        btnPractice = new JButton("Practice");
        btnPractice.setBounds(35, 221, 130, 38);
        getContentPane().add(btnPractice);
		btnPractice.addActionListener(myReaction);
	}

	private class ButtonReaction implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	        if (e.getSource() == btnCreateAGame){
                playerName = playerNameField.getText();
			    if (playerName.length() == 0){
                    JOptionPane.showMessageDialog(Application.this,
                            "PlayerName can not be empty", "Warning", JOptionPane.WARNING_MESSAGE);
                    playerNameField.requestFocus();
                } else {model.getGame().setMyName(playerName);
                    model.getGame().setPassword(passwordField.getText());
                    new CreateGameController(Application.this, model).process();
                    Application.this.disableInputs();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    playingPanel = new PlayingPanel(Application.this, model);
                    playingPanel.setVisible(true);
                }

            }else if (e.getSource() == btnJoinAGame){


            }else if (e.getSource() == btnPractice){
                setVisible(false);
                PlayingPanel frame1= new PlayingPanel(Application.this, model);
                frame1.setVisible(true);
            }
        }
    }
	
	public void setServerAccess(ServerAccess access) {
		this.serverAccess = access;
	}
	
	public ServerAccess getServerAccess() {
		return serverAccess;
	}
	
	/** Navigation access to actionable elements in the GUI. */
/*	public JTextArea getRequestArea() {
		return requestArea;
	}
*/	
	/** Navigation access to actionable elements in the GUI. */
/*	public JTextArea getResponseArea() {
		return responseArea;
	}
*/	
	public String getPlayerName() {
		return playerName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getRoomNumber() {
		return roomID;
	}
	
	public void setPlayerName(String name) {
		this.playerName = name;
	}
	
	public void setPassword(String pass) {
		this.password = pass;
	}
	
	public void setRoomNumber(String id) {
		this.roomID = id;
	}

	private void disableInputs(){
	    btnPractice.setEnabled(false);
	    btnCreateAGame.setEnabled(false);
	    btnJoinAGame.setEnabled(false);
	    gameIDField.setEnabled(false);
	    playerNameField.setEnabled(false);
    }

    private void enableInput(){
        btnPractice.setEnabled(true);
        btnCreateAGame.setEnabled(true);
        btnJoinAGame.setEnabled(true);
        gameIDField.setEnabled(true);
        playerNameField.setEnabled(true);
    }

    protected PlayingPanel getPlayingPanel(){
        return this.playingPanel;
    }
}
