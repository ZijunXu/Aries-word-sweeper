package client.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import client_src.ServerAccess;
import client.controller.CreateGameController;
import client.controller.JoinGameController;
import client.model.Model;

public class Application extends JFrame {

	protected JPanel contentPane;
	protected JButton btnPractice;
	
	public final Model model;
	ServerAccess serverAccess;
	
	JTextArea requestArea;
	JTextArea responseArea;
	private JTextField userNameField;
	private JTextField gameIDField;
	
	String roomID;
	String playerName;
	String password;

	/**
	 * Create the frame.
	 */
	public Application(Model model) {
		this.model = model;
		setTitle("WordSweeper");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnJoinAGame = new JButton("Join a game");
		btnJoinAGame.setBounds(48, 179, 117, 29);
		getContentPane().add(btnJoinAGame);
		btnJoinAGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JoinGameController(Application.this, model).process();
			}
		});
		
		JButton btnLogIn = new JButton("Create a game");
		btnLogIn.setBounds(48, 115, 111, 38);
		getContentPane().add(btnLogIn);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateGameController(Application.this, model).process();
			}
		});

		JLabel lblNewLabel = new JLabel("Word Sweeper");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Lucida Bright", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setBounds(6, 3, 362, 85);
		getContentPane().add(lblNewLabel);

		JButton btnPractice = new JButton("Practice");
		getContentPane().add(btnPractice);
		btnPractice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnPractice){
					setVisible(false);
					//Model model = Model.getModel();
					PlayingPanel frame1= new PlayingPanel(model);
					frame1.setVisible(true);
					
				}
			}
		});
		btnPractice.setBounds(48, 237, 117, 29);
		getContentPane().add(btnPractice);

		ButtonGroup passwordButtonGroup = new ButtonGroup();

		JPanel panel = new JPanel();
		panel.setBounds(250, 144, 241, 97);
		getContentPane().add(panel);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("With a password");
		panel.add(rdbtnNewRadioButton);
		passwordButtonGroup.add(rdbtnNewRadioButton);

		JTextField textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Without a password");
		panel.add(rdbtnNewRadioButton_1);
		passwordButtonGroup.add(rdbtnNewRadioButton_1);
		
		JLabel userNameLable = new JLabel("User Name:");
		userNameLable.setBounds(219, 111, 87, 16);
		contentPane.add(userNameLable);
		
		userNameField = new JTextField();
		userNameField.setBounds(304, 106, 130, 26);
		contentPane.add(userNameField);
		userNameField.setColumns(10);
		
		JLabel gameIDLable = new JLabel("Game ID:");
		gameIDLable.setBounds(231, 250, 61, 16);
		contentPane.add(gameIDLable);
		
		gameIDField = new JTextField();
		gameIDField.setBounds(304, 245, 130, 26);
		contentPane.add(gameIDField);
		gameIDField.setColumns(10);

		rdbtnNewRadioButton.addChangeListener(new ChangeListener() {

		    public void stateChanged(ChangeEvent arg0) {
			    if (rdbtnNewRadioButton.isSelected()) {
				    textField.setVisible(true);
				    textField.setEditable(true);
				    panel.revalidate();
				    panel.repaint();
			    } else {
				    textField.setVisible(false);
				    textField.setEditable(false);
				    panel.revalidate();
				    panel.repaint();
				   }

			    }

		    });
		rdbtnNewRadioButton_1.addChangeListener(new ChangeListener() {

		    public void stateChanged(ChangeEvent arg0) {
			    if (rdbtnNewRadioButton_1.isSelected()) {
				    textField.setVisible(false);
				    textField.setEditable(false);
				    panel.revalidate();
				    panel.repaint();
			    }
		    }
		});
	}
	
	public void setServerAccess(ServerAccess access) {
		this.serverAccess = access;
	}
	
	public ServerAccess getServerAccess() {
		return serverAccess;
	}
	
	/** Navigation access to actionable elements in the GUI. */
	public JTextArea getRequestArea() {
		return requestArea;
	}
	
	/** Navigation access to actionable elements in the GUI. */
	public JTextArea getResponseArea() {
		return responseArea;
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
	
	
}
