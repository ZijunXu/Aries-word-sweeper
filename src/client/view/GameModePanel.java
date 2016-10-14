package client.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GameModePanel extends JFrame {

	protected JPanel contentPane;
	protected JButton btnPractice;

	/**
	 * Create the frame.
	 */
	public GameModePanel() {
		setTitle("WordSweeper");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnJoinAGame = new JButton("Join a game");
		btnJoinAGame.setBounds(351, 266, 117, 29);
		getContentPane().add(btnJoinAGame);

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
					PlayingPanel frame1= new PlayingPanel();
					frame1.setVisible(true);
					
				}
			}
		});
		btnPractice.setBounds(17, 278, 117, 29);
		getContentPane().add(btnPractice);

		ButtonGroup passwordButtonGroup = new ButtonGroup();

		JPanel panel = new JPanel();
		panel.setBounds(261, 109, 241, 116);
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

		JButton btnLogIn = new JButton("Create a game");
		btnLogIn.setBounds(138, 109, 111, 38);
		getContentPane().add(btnLogIn);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

	}

}
