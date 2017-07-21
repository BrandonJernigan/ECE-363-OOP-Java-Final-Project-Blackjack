package game.GUI;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import game.GUI.MainMenu;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Main extends JFrame {

	private JPanel contentPane;
	private String playerName = "Player";


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame1 = new Main();
					frame1.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setResizable(false);
		int h = 850;
		int w = 1280;
		setTitle("Casino");
		setBackground(new Color(0, 128, 0));
		setForeground(new Color(0, 128, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/game/graphics/backdrops/icon.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, w + 6, h + 40);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Feild for entering Player's name
		JTextField textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 38));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	setPlayerName(textField.getText());
            	setVisible(false);
            	dispose();
            	MainMenu window = new MainMenu(getPlayerName());
            	window.setVisible(true);

            }
        });
		
		textField.setBounds(455, 440, 385, 54);
		contentPane.add(textField);
		
		//Ok button submits name and moves to next screen
		JButton buttonOk = new JButton("Ok");
		buttonOk.setFont(new Font("Tahoma", Font.PLAIN, 20));


        buttonOk.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	setPlayerName(textField.getText());
            	setVisible(false);
            	dispose();
            	MainMenu window = new MainMenu(getPlayerName());
            	window.setVisible(true);           	

            }
        });
        
		buttonOk.setBounds(568, 518, 180, 54);
		contentPane.add(buttonOk);
		
		//Exit button quits program
		JButton buttonExit = new JButton("Exit Game");
		buttonExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonExit.setForeground(Color.WHITE);
		buttonExit.setBackground(new Color(128, 0, 0));
		buttonExit.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
		    System.exit(0);
		  }
		});
		buttonExit.setBounds(1085, 780, 180, 54);
		contentPane.add(buttonExit);
		
		//Label for name field
		JLabel lblNewLabel = new JLabel("What is your name?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(15, 227, 1250, 54);
		contentPane.add(lblNewLabel);
		

		
		JLabel label = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(Main.class.getResource("/game/graphics/backdrops/menu.jpg")).getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
		label.setIcon(imageIcon);
		label.setBounds(0, 0, w, h);
		contentPane.add(label);

		

		
	}
	public String getPlayerName(){
		return this.playerName;
	}
	public void setPlayerName(String playerName){
		this.playerName = playerName;
	}
}
