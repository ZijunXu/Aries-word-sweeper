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
/**
 *@author Zijun Xu
 */
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
	String errorMessage;

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

//        JRadioButton rdbtnNewRadioButton = new JRadioButton("With a password");
//        rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.TRAILING);
//        panel.add(rdbtnNewRadioButton);
//        passwordButtonGroup.add(rdbtnNewRadioButton);
        
//        passwordField = new JTextField();
//        panel.add(passwordField);
//        passwordField.setColumns(10);

//        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Without a password              ");
//        panel.add(rdbtnNewRadioButton_1);
//        passwordButtonGroup.add(rdbtnNewRadioButton_1);

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

//        rdbtnNewRadioButton.addChangeListener(new ChangeListener() {
//
//            public void stateChanged(ChangeEvent arg0) {
//                if (rdbtnNewRadioButton.isSelected()) {
//                    passwordField.setVisible(true);
//                    passwordField.setEditable(true);
//                    panel.revalidate();
//                    panel.repaint();
//                } else {
//                    passwordField.setVisible(false);
//                    passwordField.setEditable(false);
//                    panel.revalidate();
//                    panel.repaint();
//                }
//
//            }
//
//        });
//        rdbtnNewRadioButton_1.addChangeListener(new ChangeListener() {
//
//            public void stateChanged(ChangeEvent arg0) {
//                if (rdbtnNewRadioButton_1.isSelected()) {
//                    passwordField.setVisible(false);
//                    passwordField.setEditable(false);
//                    panel.revalidate();
//                    panel.repaint();
//                }
//            }
//        });

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

        passwordField = new JTextField();
        passwordField.setBounds(304, 296, 130, 26);
        contentPane.add(passwordField);
        passwordField.setColumns(10);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(219, 301, 61, 16);
        contentPane.add(passwordLabel);
	}

	private class ButtonReaction implements ActionListener{
	    public void actionPerformed(ActionEvent e){
            playerName = playerNameField.getText();
            if (e.getSource() == btnCreateAGame){
                if (playerName.length() == 0) {
                    JOptionPane.showMessageDialog(Application.this,
                            "Player Name can not be empty", "Warning", JOptionPane.WARNING_MESSAGE);
                    playerNameField.requestFocus();
                }else {
                    roomID = gameIDField.getText();
                    model.getGame().setMyName(playerName);
                    password = passwordField.getText();
                    model.getGame().setPassword(passwordField.getText());
                    new CreateGameController(Application.this, model).process();
                    Application.this.disableInputs();
                    try {Thread.sleep(500);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    playingPanel = new PlayingPanel(Application.this, model);
                    playingPanel.setVisible(true);
                }
            }
	        else if (e.getSource() == btnJoinAGame) {
                roomID = gameIDField.getText();
                password = passwordField.getText();
                if (playerName.length() == 0) {
                    JOptionPane.showMessageDialog(Application.this,
                            "Player Name can not be empty", "Warning", JOptionPane.WARNING_MESSAGE);
                    playerNameField.requestFocus();
                }else if (roomID.length() == 0){
                    JOptionPane.showMessageDialog(Application.this,
                            "GameID can not be empty", "Warning", JOptionPane.WARNING_MESSAGE);
                    gameIDField.requestFocus();
                } else {
                    playerName = playerNameField.getText();
                    model.getGame().setMyName(playerName);
                    new JoinGameController(Application.this, model).process();
                    Application.this.disableInputs();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    if (!model.getIsExitedGame()){
                        JOptionPane.showMessageDialog(Application.this, errorMessage, "ERROR",
                                JOptionPane.WARNING_MESSAGE);
                        Application.this.enableInput();
                        return;
                    }
                    playingPanel = new PlayingPanel(Application.this, model);
                    playingPanel.setVisible(true);
                }
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
	
	//for test case use @author Zhanfeng
	public void setPassword(String psw) {
		password = psw;
	}
	
	public String getRoomNumber() {
		return roomID;
	}

	private void disableInputs(){
	    btnCreateAGame.setEnabled(false);
	    btnJoinAGame.setEnabled(false);
	    gameIDField.setEnabled(false);
	    playerNameField.setEnabled(false);
    }

    private void enableInput(){
        btnCreateAGame.setEnabled(true);
        btnJoinAGame.setEnabled(true);
        gameIDField.setEnabled(true);
        playerNameField.setEnabled(true);
    }

    public PlayingPanel getPlayingPanel(){
        return this.playingPanel;
    }
    
    // for test case use @author Zhanfeng
    public void setPlayingPanel(){
    	playingPanel = new PlayingPanel(Application.this, model);
        playingPanel.setVisible(true);
    }

    public String getRoomID(){
        return this.roomID;
    }

    // for test case use @author Zhanfeng
    public void setRoomID(String roomID){
    	this.roomID = roomID;
    }
    
    public void setErrorMessege(String message){
        this.errorMessage = message;
    }
}
