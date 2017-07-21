package game.GUI;

import java.awt.Image;
import game.GUI.BlackjackGUI;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	private String playerName;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public MainMenu(String playerName) {
		this.playerName = playerName;
		setResizable(false);
		int h = 850;
		int w = 1280;
		setTitle("Casino");
		setBackground(new Color(0, 128, 0));
		setForeground(new Color(0, 128, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenu.class.getResource("/game/graphics/backdrops/icon.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, w + 6, h + 40);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Blackjack button starts blackjack game
		JButton button_blackjack = new JButton("");
		ImageIcon imageIcon3 = new ImageIcon(new ImageIcon(MainMenu.class.getResource("/game/graphics/backdrops/title_blackjack.jpg")).getImage().getScaledInstance(w/4, h/4, Image.SCALE_DEFAULT));
		
		button_blackjack.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	setVisible(false);
            	dispose();
            	BlackjackGUI window = new BlackjackGUI(getPlayerName());
            	window.setVisible(true);           	

            }
        });
		
		JLabel lblNewLabel = new JLabel("Choose your game:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(15, 227, 1250, 54);
		contentPane.add(lblNewLabel);
		button_blackjack.setIcon(imageIcon3);
		button_blackjack.setBounds(258, 322, w/4, h/4);
		contentPane.add(button_blackjack);
		
		//Meda Voych button starts meda voych game (disabled)
		JButton button_meda = new JButton("");
		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon(MainMenu.class.getResource("/game/graphics/backdrops/title_medavoych_soon.jpg")).getImage().getScaledInstance(w/4, h/4, Image.SCALE_DEFAULT));
		button_meda.setIcon(imageIcon2);
		button_meda.setBounds(665, 322, w/4, h/4);
		contentPane.add(button_meda);
		
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
		
		//menu backdrop
		JLabel label = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(MainMenu.class.getResource("/game/graphics/backdrops/menu.jpg")).getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
		label.setIcon(imageIcon);
		label.setBounds(0, 0, w, h);
		contentPane.add(label);


		System.out.println(playerName);
		
	}

	public String getPlayerName(){
		return this.playerName;
	}
	public void setPlayerName(String playerName){
		this.playerName = playerName;
	}

}
