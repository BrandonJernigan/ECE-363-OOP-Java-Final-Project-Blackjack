package game.GUI;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.EventQueue;
import java.awt.Image;
import game.GUI.MainApp;
import game.people.BlackjackPlayer;
import game.backend.*;
import game.people.BlackjackPlayer;
import game.people.Player;
import game.physical.*;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.ImageIcon;
import java.awt.image.*;
import java.util.Vector;
import java.awt.Button;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import java.awt.SystemColor;


public class BlackjackGUI extends JFrame {

	//attributes
	private Blackjack bgame; //added the game
	private BlackjackPlayer player; //added the player
	private int betAmt;
	private int totAmt;
	private int cardsInDeck;
	
	
	
	//GUI
	private JPanel contentPane;
	private String playerName;
	private JTextField txtBetAmount;
	
	//labels
	private JLabel bet_field;
	private JLabel tot_field;
	private JLabel deck;
	
	private JLabel chips1;
	private JLabel chips2;
	private JLabel chips3;
	private JLabel chips4;
	private JLabel chips5;
	private JLabel chips6;
	
	private JLabel player_card1;
	private JLabel player_card2;
	private JLabel player_card3;
	private JLabel player_card4;
	private JLabel player_card5;
	private JLabel player_card6;
	private JLabel player_card7;
	
	private JLabel dealer_card1;
	private JLabel dealer_card2;
	private JLabel dealer_card3;
	private JLabel dealer_card4;
	private JLabel dealer_card5;
	private JLabel dealer_card6;
	private JLabel dealer_card7;
	//buttons
	private JButton btnBet;
	private JButton btnHit;
	private JButton btnStay;
	private JButton btnSplit;
	private JButton btnDD;
	private JButton btnExit;
	
	//constants
	private final int h = 850;
	private final int w = 1280;
	private final int card_w = 853/6;
	private final int card_h = 1280/6;
	private final int chip_w = 853/6;
	private final int chip_h = 1280/6;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	//constructor
	public BlackjackGUI(String playerName) 
	{
		this.bgame = new Blackjack(1);
		this.player = new BlackjackPlayer(this.playerName, this.bgame);
		betAmt = bgame.getLastWager();
		totAmt = player.getBank();
		cardsInDeck = bgame.getDeck().remainingCards();
		setPlayerName(playerName);
		setResizable(false);
		setTitle("Casino");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		
		buildBlackjackGUI();
		setVisible(true);
	}
		
	public void buildBlackjackGUI()
	{
	
		
		int deckHeight = findDeckSize();
		setBackground(new Color(0, 128, 0));
		setForeground(new Color(0, 128, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Blackjack.class.getResource("/game/graphics/backdrops/icon.png")));

		setBounds(100, 100, w + 6, h + 35);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon imageIcon1 = new ImageIcon(new ImageIcon(Blackjack.class.getResource("/game/graphics/backdrops/tabletop.jpg")).getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
		
		JLabel deck = new JLabel("");
		
		//deck
		deck.setBounds(1123, 26 + (255 - deckHeight), card_w, deckHeight);
		contentPane.add(deck);
		String deck_img = String.format("/game/graphics/cards/back/back_%s.png", cardsInDeck);
		ImageIcon deck_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(deck_img)).getImage().getScaledInstance(card_w, deckHeight, Image.SCALE_DEFAULT));
		deck.setIcon(deck_icon);
		deck.setIcon(deck_icon);
		contentPane.add(deck);
		
		//cards
		String dealer_card7_img = "/game/graphics/cards/back/back_0.png";
		ImageIcon dealer_card7_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(dealer_card7_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		dealer_card7 = new JLabel("");
		dealer_card7.setBounds(957, 67, 142, 213);
		dealer_card7.setIcon(dealer_card7_icon);
		contentPane.add(dealer_card7);
		
		String dealer_card6_img = "/game/graphics/cards/back/back_0.png";
		ImageIcon dealer_card6_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(dealer_card6_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		dealer_card6 = new JLabel("");
		dealer_card6.setBounds(800, 67, 142, 213);
		dealer_card6.setIcon(dealer_card6_icon);
		contentPane.add(dealer_card6);
		
		String dealer_card5_img = "/game/graphics/cards/back/back_0.png";
		ImageIcon dealer_card5_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(dealer_card5_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		dealer_card5 = new JLabel("");
		dealer_card5.setBounds(643, 67, card_w, card_h);
		dealer_card5.setIcon(dealer_card5_icon);
		contentPane.add(dealer_card5);
		
		String dealer_card4_img = "/game/graphics/cards/back/back_0.png";
		ImageIcon dealer_card4_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(dealer_card4_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		dealer_card4 = new JLabel("");
		dealer_card4.setBounds(486, 67, card_w, card_h);
		dealer_card4.setIcon(dealer_card4_icon);
		contentPane.add(dealer_card4);
		
		String dealer_card3_img = "/game/graphics/cards/back/back_0.png";
		ImageIcon dealer_card3_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(dealer_card3_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		dealer_card3 = new JLabel("");
		dealer_card3.setBounds(329, 67, card_w, card_h);
		dealer_card3.setIcon(dealer_card3_icon);
		contentPane.add(dealer_card3);
		
		String dealer_card2_img = "/game/graphics/cards/back/back_0.png";
		ImageIcon dealer_card2_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(dealer_card2_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		dealer_card2 = new JLabel("");
		dealer_card2.setBounds(172, 67, card_w, card_h);
		dealer_card2.setIcon(dealer_card2_icon);
		contentPane.add(dealer_card2);
		
		String dealer_card1_img = "/game/graphics/cards/back/back_0.png";
		ImageIcon dealer_card1_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(dealer_card1_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		dealer_card1 = new JLabel("");
		dealer_card1.setBounds(15, 67, card_w, card_h);
		dealer_card1.setIcon(dealer_card1_icon);
		contentPane.add(dealer_card1);
		
		String player_card7_img = "/game/graphics/cards/back/back_0.png";
		ImageIcon player_card7_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(player_card7_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		player_card7 = new JLabel("");
		player_card7.setBounds(957, 621, 142, 213);
		player_card7.setIcon(player_card7_icon);
		contentPane.add(player_card7);
		
		String player_card6_img = "/game/graphics/cards/back/back_0.png";
		ImageIcon player_card6_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(player_card6_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		player_card6 = new JLabel("");
		player_card6.setBounds(800, 621, 142, 213);
		player_card6.setIcon(player_card6_icon);
		contentPane.add(player_card6);
		
		String player_card5_img = "/game/graphics/cards/back/back_0.png";
		ImageIcon player_card5_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(player_card5_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		player_card5 = new JLabel("");
		player_card5.setBounds(643, 621, card_w, card_h);
		player_card5.setIcon(player_card5_icon);
		contentPane.add(player_card5);
		
		String player_card4_img = "/game/graphics/cards/back/back_0.png";
		ImageIcon player_card4_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(player_card4_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		player_card4 = new JLabel("");
		player_card4.setBounds(486, 621, card_w, card_h);
		player_card4.setIcon(player_card4_icon);
		contentPane.add(player_card4);
		
		String player_card3_img = "/game/graphics/cards/back/back_0.png";
		ImageIcon player_card3_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(player_card3_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		player_card3 = new JLabel("");
		player_card3.setBounds(329, 621, card_w, card_h);
		player_card3.setIcon(player_card3_icon);
		contentPane.add(player_card3);
		
		String player_card2_img = "/game/graphics/cards/back/back_0.png";
		ImageIcon player_card2_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(player_card2_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		player_card2 = new JLabel("");
		player_card2.setBounds(172, 621, card_w, card_h);
		player_card2.setIcon(player_card2_icon);
		contentPane.add(player_card2);
		
		String player_card1_img = "/game/graphics/cards/back/back_0.png";
		ImageIcon player_card1_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(player_card1_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		player_card1 = new JLabel("");
		player_card1.setBounds(15, 619, card_w, card_h);
		player_card1.setIcon(player_card1_icon);
		contentPane.add(player_card1);
		Border border = BorderFactory.createLineBorder(Color.WHITE);
		
		String chips6_img = "/game/graphics/chips/0_empty_0.png";
		ImageIcon chips6_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(chips6_img)).getImage().getScaledInstance(chip_w, chip_h, Image.SCALE_DEFAULT));
		chips6 = new JLabel("");
		chips6.setBounds(800, 339, 142, 213);
		chips6.setIcon(chips6_icon);
		contentPane.add(chips6);
    	
		String chips5_img = "/game/graphics/chips/0_empty_0.png";
		ImageIcon chips5_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(chips5_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		chips5 = new JLabel("");
		chips5.setBounds(643, 339, 142, 213);
		chips5.setIcon(chips5_icon);
		contentPane.add(chips5);
		
		String chips4_img = "/game/graphics/chips/0_empty_0.png";
		ImageIcon chips4_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(chips4_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		
		String chips3_img = "/game/graphics/chips/0_empty_0.png";
		ImageIcon chips3_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(chips3_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		chips4 = new JLabel("");
		chips4.setBounds(486, 339, 142, 213);
		chips4.setIcon(chips4_icon);
		contentPane.add(chips4);
		chips3 = new JLabel("");
		chips3.setBounds(329, 339, 142, 213);
		chips3.setIcon(chips3_icon);
		contentPane.add(chips3);
		
		String chips2_img = "/game/graphics/chips/0_empty_0.png";
		ImageIcon chips2_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(chips2_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		chips2 = new JLabel("");
		chips2.setBounds(172, 339, 142, 213);
		chips2.setIcon(chips2_icon);
		contentPane.add(chips2);
		
		String chips1_img = "/game/graphics/chips/0_empty_0.png";
		ImageIcon chips1_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(chips1_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		chips1 = new JLabel("");
		chips1.setBounds(15, 339, 142, 213);
		chips1.setIcon(chips1_icon);
		contentPane.add(chips1);
		
		//buttons
		btnBet = new JButton("Bet");
		btnBet.setBounds(1085, 547, 142, 29);
		contentPane.add(btnBet);
		
		btnHit = new JButton("Hit");
		btnHit.setBounds(1123, 621, 142, 29);
		contentPane.add(btnHit);
		
		btnStay = new JButton("Stay");
		btnStay.setBounds(1123, 667, 142, 29);
		contentPane.add(btnStay);
		
		btnSplit = new JButton("Split");
		btnSplit.setBounds(1123, 715, 142, 29);
		contentPane.add(btnSplit);
		
		btnDD = new JButton("Double Down");
		btnDD.setBounds(1123, 760, 142, 29);
		contentPane.add(btnDD);
		
		btnExit = new JButton("Exit Blackjack");
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(new Color(153, 0, 0));
		btnExit.setBounds(1123, 805, 142, 29);
		contentPane.add(btnExit);

		//labels
		tot_field = new JLabel(String.format("$%s", totAmt));
		tot_field.setHorizontalAlignment(SwingConstants.CENTER);
		tot_field.setForeground(Color.WHITE);
		tot_field.setFont(new Font("Bauhaus 93", Font.PLAIN, 24));
		tot_field.setBounds(1033, 385, 232, 29);
		contentPane.add(tot_field);

		bet_field = new JLabel(String.format("$%s", betAmt));
		bet_field.setHorizontalAlignment(SwingConstants.CENTER);
		bet_field.setForeground(Color.WHITE);
		bet_field.setFont(new Font("Bauhaus 93", Font.PLAIN, 24));
		bet_field.setBounds(1033, 459, 232, 29);
		contentPane.add(bet_field);
		
		this.betAmt = 0;
		txtBetAmount = new JTextField();
		txtBetAmount.setText("0");
		txtBetAmount.setHorizontalAlignment(SwingConstants.CENTER);
		txtBetAmount.setBounds(1085, 505, 142, 26);
		contentPane.add(txtBetAmount);
		txtBetAmount.setColumns(10);
		
		JLabel lblCurrentBet = new JLabel("Current Bet:");
		lblCurrentBet.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentBet.setForeground(SystemColor.textHighlight);
		lblCurrentBet.setFont(new Font("Bauhaus 93", Font.PLAIN, 24));
		lblCurrentBet.setBounds(1033, 430, 232, 29);
		contentPane.add(lblCurrentBet);
		
		JLabel lblNewLabel = new JLabel("Total Money:");
		lblNewLabel.setForeground(new Color(255, 0, 51));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bauhaus 93", Font.PLAIN, 24));
		lblNewLabel.setBounds(1033, 358, 232, 29);
		contentPane.add(lblNewLabel);
		
		JLabel playerLabel = new JLabel(playerName);
		playerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerLabel.setForeground(new Color(255, 204, 51));
		playerLabel.setFont(new Font("Bauhaus 93", Font.PLAIN, 28));
		playerLabel.setBounds(1034, 313, 231, 29);
		contentPane.add(playerLabel);
		
		JLabel score_field = new JLabel("");
		score_field.setForeground(new Color(0, 0, 0));
		score_field.setBackground(Color.DARK_GRAY);
		score_field.setFont(new Font("Bauhaus 93", Font.PLAIN, 24));
		score_field.setOpaque(true);
		score_field.setBounds(1033, 304, 232, 294);
		score_field.setBorder(border);
		contentPane.add(score_field);
		
		JLabel label = new JLabel("");
		label.setBackground(new Color(105, 105, 105));
		label.setIcon(imageIcon1);
		label.setBounds(0, 0, w, h);
		contentPane.add(label);	
		
		//listeners
		btnBet.addActionListener(new ButtonListener());
		btnHit.addActionListener(new ButtonListener());
		btnStay.addActionListener(new ButtonListener());
		btnSplit.addActionListener(new ButtonListener());
		btnDD.addActionListener(new ButtonListener());
		btnExit.addActionListener(new ButtonListener());
	}
	
	private class ButtonListener implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			JButton source = (JButton) (e.getSource());
			
			if (source.equals(btnBet))
			{
				handleBet();
			}
			else if (source.equals(btnHit))
			{
				handleHit();
			}
			else if (source.equals(btnStay))
			{
				handleStay();
			}
			else if (source.equals(btnSplit))
			{
				handleSplit();
			}
			else if (source.equals(btnDD))
			{
				handleDD();
			}
			else if (source.equals(btnExit))
			{
				handleExit();
			}
			
		}
		
		//handlers
		private void handleBet()
		{
			if ((Integer.parseInt(txtBetAmount.getText()) <= 0)) //checking to make sure the bet is valid
        	{
        		JOptionPane.showMessageDialog(null, "Bet must be greater than 0.","Bet Error", JOptionPane.ERROR_MESSAGE);
        	}
        	else if (Integer.parseInt(txtBetAmount.getText()) > getTotAmt())

        	{
        		JOptionPane.showMessageDialog(null, "Bet must be less than the \"Total Money\".","Bet Error", JOptionPane.ERROR_MESSAGE);
        	}
        	else
        	{
            	btnBet.setVisible(false);
            	txtBetAmount.setVisible(false);
            	setBetAmt(Integer.parseInt(txtBetAmount.getText()));
            	setTotAmt(getTotAmt() - Integer.parseInt(txtBetAmount.getText()));
            	player.makeWager(Integer.parseInt(txtBetAmount.getText()));
            	bet_field.setText(String.format("%d",bgame.getLastWager()));
            	tot_field.setText(String.format("$%s", totAmt));
        		
        		String[] chipImageNames = makeChipImageNames();
        		int[] chipSizes = findChipSizes();        		
        		
        		String chips6_img = chipImageNames[5];
        		ImageIcon chips6_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(chips6_img)).getImage().getScaledInstance(chip_w, chipSizes[5], Image.SCALE_DEFAULT));
        		chips6.setBounds(800, 339 + (214 - chipSizes[5]), chip_w, chipSizes[5]);
        		chips6.setIcon(chips6_icon);
            	
        		String chips5_img = chipImageNames[4];
        		ImageIcon chips5_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(chips5_img)).getImage().getScaledInstance(chip_w, chipSizes[4], Image.SCALE_DEFAULT));
        		chips5.setBounds(643, 339 + (214 - chipSizes[4]), chip_w, chipSizes[4]);
        		chips5.setIcon(chips5_icon);
        		
        		String chips4_img = chipImageNames[3];
        		ImageIcon chips4_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(chips4_img)).getImage().getScaledInstance(chip_w, chipSizes[3], Image.SCALE_DEFAULT));
        		chips4.setBounds(486, 339 + (214 - chipSizes[3]), chip_w, chipSizes[3]);
        		chips4.setIcon(chips4_icon);
        		
        		String chips3_img = chipImageNames[2];
        		ImageIcon chips3_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(chips3_img)).getImage().getScaledInstance(chip_w, chipSizes[2], Image.SCALE_DEFAULT));
        		chips3.setBounds(329, 339 + (214 - chipSizes[2]), chip_w, chipSizes[2]);
        		chips3.setIcon(chips3_icon);

        		String chips2_img = chipImageNames[1];
        		ImageIcon chips2_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(chips2_img)).getImage().getScaledInstance(chip_w, chipSizes[1], Image.SCALE_DEFAULT));
        		chips2.setBounds(172, 339 + (214 - chipSizes[1]), chip_w, chipSizes[1]);
        		chips2.setIcon(chips2_icon);
        		
        		String chips1_img = chipImageNames[0];
        		ImageIcon chips1_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(chips1_img)).getImage().getScaledInstance(chip_w, chipSizes[0], Image.SCALE_DEFAULT));
        		chips1.setBounds(15, 339 + (214 - chipSizes[0]), chip_w, chipSizes[0]);
        		chips1.setIcon(chips1_icon);
        		
        		if(totAmt != 99){
        			System.out.println("here");
        		}
        		player.initializeHand();
        		bgame.getDealer().initializeHand();
        		
        		Vector<Card> dealerHand = bgame.getDealer().getCurHand();

        		String dealer_card1_img = String.format("/game/graphics/cards/front/%s_%s.png", dealerHand.get(0).getName(), dealerHand.get(0).getSuit());
        		ImageIcon dealer_card1_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(dealer_card1_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
        		dealer_card1.setIcon(dealer_card1_icon);
        		
        		String dealer_card2_img = "/game/graphics/cards/back/back_1.png";
        		ImageIcon dealer_card2_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(dealer_card2_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
        		dealer_card2.setIcon(dealer_card2_icon);
        		
        		showPlayerHand();

//        		Border border = BorderFactory.createLineBorder(Color.WHITE);
        		
//        		for(String item : chipImageNames)
//        		{
//        			System.out.println(item);
//        		}
        	}
		}
		private void handleHit()
		{
			if (getBetAmt() <= 0)
			{
				JOptionPane.showMessageDialog(null, "A bet must be placed first.","Hit Error", JOptionPane.ERROR_MESSAGE);
			}
			else if (player.getCurHand().isEmpty())
			{
				player.initializeHand();
				showPlayerHand();
				if(player.getSum() >= 21 || player.getSplitSum() >= 21) handleStay();
			}
			else if (player.getStay())
			{
				JOptionPane.showMessageDialog(null, "Your turn has ended.", "End of turn", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				player.drawCard();
				showPlayerHand();
				if(player.getSum() >= 21 || player.getSplitSum() >= 21) handleStay();
				
			}
			
		}
		private void handleStay()
		{
			int input = 0;
			if (player.getCurHand().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Cards must be drawn first.","Stay Error", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				
				player.Stay();
				if(player.getStay())
				{
					bgame.getDealer().AIMove();
					showDealerHand();
				}
				
				if(player.getSplitSum() == 0 && player.getSum() <= 21 && (player.getSum() > bgame.getDealer().getSum() ||
						bgame.getDealer().getSum() > 21))
				{
					
					bgame.givePot(player);
					input = JOptionPane.showOptionDialog(null, "Congratulations!","Winner", JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, null, null);
					bgame.resetGame();
					resetTable();
				}
				else if(player.getSplitSum() == 0 && ((player.getSum() > 21 && bgame.getDealer().getSum() > 21) || (player.getSum() == bgame.getDealer().getSum())))
				{
					bgame.giveSplitPot(player);
					bgame.givePot(bgame.getDealer());
					input = JOptionPane.showOptionDialog(null, "You win your money back","Tie", JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, null, null);
					bgame.resetGame();
					resetTable();
				}
				else if(player.getSplitSum() == 0)
				{
					bgame.givePot(bgame.getDealer());
					input = JOptionPane.showOptionDialog(null, "Better luck next time.","Loser", JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, null, null);
					bgame.resetGame();
					resetTable();

				}
				else
				{
					if(player.getSum() <= 21 && (player.getSum() > bgame.getDealer().getSum() ||
							bgame.getDealer().getSum() > 21) && !player.getStay())
					{
						bgame.giveSplitPot(player);
						input = JOptionPane.showOptionDialog(null, "You won the first hand!","Winner", JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, null, null);
						player.drawCard();
						showPlayerHand();

					}
					else if(!player.getStay())
					{
						bgame.giveSplitPot(bgame.getDealer());
						input = JOptionPane.showOptionDialog(null, "You lost the first hand!","Loser", JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, null, null);
						player.drawCard();
						showPlayerHand();

					}
					if(player.getSplitSum() <= 21 && (player.getSplitSum() > bgame.getDealer().getSum() ||
							bgame.getDealer().getSum() > 21) && player.getStay())
					{
						bgame.givePot(player);
						input = JOptionPane.showOptionDialog(null, "You won the second hand!","Winner", JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, null, null);
						bgame.resetGame();
						resetTable();

					}
					else if(player.getStay())
					{
						bgame.givePot(bgame.getDealer());
						input = JOptionPane.showOptionDialog(null, "You lost the second hand!","Loser", JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, null, null);
						bgame.resetGame();
						resetTable();

					}
					
				}
				
			}
		}
		private void handleSplit()
		{
			if (player.getCurHand().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Cards must be drawn first.","Split Error", JOptionPane.ERROR_MESSAGE);
			}
			else if (player.getCurHand().get(0).getNumber() != player.getCurHand().get(1).getNumber() && player.getCurHand().size() == 2)
			{
				JOptionPane.showMessageDialog(null, "Cards must be the same value in order to split.","Split Error", JOptionPane.ERROR_MESSAGE);
			}
			else if (player.getStay())
			{
				JOptionPane.showMessageDialog(null, "Your turn has ended.","End of turn", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				player.Split();
				showPlayerHand();
			}
		}
		private void handleDD() 
		{
			if (player.getCurHand().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Cards must be drawn first.","Double Down Error", JOptionPane.ERROR_MESSAGE);
			}
			else if (player.getStay())
			{
				JOptionPane.showMessageDialog(null, "Your turn has ended.","End of turn", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				player.doubleDown();
				showPlayerHand();
				handleStay();
				
			}
		}
		private void handleExit()
		{
        	setVisible(false);
        	dispose();
        	MainMenu window = new MainMenu(getPlayerName());
        	window.setVisible(true);
		}
	}
	
	//other methods
	public String getPlayerName(){
		return this.playerName;
	}
	public void setPlayerName(String playerName){
		this.playerName = playerName;
	}
	public int getBetAmt(){
		return this.betAmt;
	}
	public void setBetAmt(int betAmt){
		this.betAmt = betAmt;
	}
	public int getTotAmt(){
		return this.totAmt;
	}
	public void setTotAmt(int totAmt){
		this.totAmt = totAmt;
	}
	public int[] makeChange(){
		int betAmt = this.betAmt;
		int twentyfives_piles = 0;
		int twentyfives = betAmt/25;
		if(twentyfives > 0){
			twentyfives_piles = 1 + (twentyfives - 1)/25;
		}
		betAmt = betAmt - (twentyfives * 25);
		int tens = betAmt/10;
		betAmt = betAmt - tens * 10;
		int fives = betAmt/5; 
		betAmt = betAmt - fives * 5;
		int ones = betAmt;
		int[] change_list = {ones, fives, tens, twentyfives, twentyfives_piles};
		return change_list;
	}
	public String[] makeChipImageNames(){
		int[] change = makeChange();
		int ones = change[0];
		int fives = change[1];
		int tens = change[2];
		int twentyfives = change[3];
		int twentyfives_piles = change[4];
		int pile = 0;
		String img1 = "/game/graphics/chips/0_empty_0.png";
		String img2 = "/game/graphics/chips/0_empty_0.png";
		String img3 = "/game/graphics/chips/0_empty_0.png";
		String img4 = "/game/graphics/chips/0_empty_0.png";
		String img5 = "/game/graphics/chips/0_empty_0.png";
		String img6 = "/game/graphics/chips/0_empty_0.png";
		for(int item : change){
			System.out.println(item);
		}
		if(ones != 0){
			img1 = String.format("/game/graphics/chips/1_white_%s.png", ones);
		}
		
		if(fives != 0){
			img2 = String.format("/game/graphics/chips/5_red_%s.png", fives);
		}
		
		if(tens != 0){
			img3 = String.format("/game/graphics/chips/10_blue_%s.png", tens);
		}
		
		if(twentyfives_piles > 1){
			img4 = String.format("/game/graphics/chips/25_black_25.png");
		} else if(twentyfives_piles == 1){
			pile = twentyfives - (twentyfives_piles - 1) * 25;
			img4 = String.format("/game/graphics/chips/25_black_%s.png", pile);
		}
		
		if (twentyfives_piles > 2){
			img5 = String.format("/game/graphics/chips/25_black_25.png");
		} else if(twentyfives_piles == 2){
			pile = twentyfives - (twentyfives_piles - 1)* 25;
			img5 = String.format("/game/graphics/chips/25_black_%s.png", pile);
		}
		
		if (twentyfives_piles > 3){
			img6 = String.format("/game/graphics/chips/25_black_25.png");
		} else if(twentyfives_piles == 3){
			pile = twentyfives - (twentyfives_piles - 1)* 25;
			img6 = String.format("/game/graphics/chips/25_black_%s.png", pile);
		}

		
		String[] imageNames = {img1, img2, img3, img4, img5, img6};
		return imageNames;
		
	}
	
	public int[] findChipSizes(){
		String[] imageNames = makeChipImageNames();
		int num = 0;
		int[] chipSizes = new int[6];
		String chip_num = "";
		for(int ii = 0; ii < imageNames.length; ii++){
			chip_num = imageNames[ii].split("_|\\.")[2];
			System.out.println(chip_num);
			num = Integer.parseInt(chip_num);
			num = (num * 3) + 139;
			chipSizes[ii] = num;
		}
		
		
		return chipSizes;
	}
	public int findDeckSize(){
		int deck_size = 0;
		float value = 0;
		value = 213 + (0.82f * cardsInDeck);
		deck_size = Math.round(value);
		return deck_size;
	}
	public void showPlayerHand(){
		Vector<Card> playerHand;
		if(!player.getSplitStay()) playerHand = player.getCurHand();
		else playerHand = player.getSplitHand();
		
		
		if(playerHand.size() >= 7){
    		String player_card7_img = String.format("/game/graphics/cards/front/%s_%s.png", playerHand.get(6).getName(), playerHand.get(6).getSuit());
    		ImageIcon player_card7_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(player_card7_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
    		player_card7.setIcon(player_card7_icon);
		}
		
		if(playerHand.size() >= 6){
    		String player_card6_img = String.format("/game/graphics/cards/front/%s_%s.png", playerHand.get(5).getName(), playerHand.get(5).getSuit());
    		ImageIcon player_card6_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(player_card6_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
    		player_card6.setIcon(player_card6_icon);
		}
		
		if(playerHand.size() >= 5){
        	String player_card5_img = String.format("/game/graphics/cards/front/%s_%s.png", playerHand.get(4).getName(), playerHand.get(4).getSuit());
    		ImageIcon player_card5_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(player_card5_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
    		player_card5.setIcon(player_card5_icon);
		}
		
		if(playerHand.size() >= 4){
        	String player_card4_img = String.format("/game/graphics/cards/front/%s_%s.png", playerHand.get(3).getName(), playerHand.get(3).getSuit());
    		ImageIcon player_card4_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(player_card4_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
    		player_card4.setIcon(player_card4_icon);
		}
		
		if(playerHand.size() >= 3){
        	String player_card3img = String.format("/game/graphics/cards/front/%s_%s.png", playerHand.get(2).getName(), playerHand.get(2).getSuit());
    		ImageIcon player_card3_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(player_card3img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
    		player_card3.setIcon(player_card3_icon);
		}
		
		if(playerHand.size() >= 2){
        	String player_card2_img = String.format("/game/graphics/cards/front/%s_%s.png", playerHand.get(1).getName(), playerHand.get(1).getSuit());
    		ImageIcon player_card2_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(player_card2_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
    		player_card2.setIcon(player_card2_icon);

		}
		
		if(playerHand.size() >= 1){
        	String player_card1_img = String.format("/game/graphics/cards/front/%s_%s.png", playerHand.get(0).getName(), playerHand.get(0).getSuit());
    		ImageIcon player_card1_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(player_card1_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
    		player_card1.setIcon(player_card1_icon);
		}
	}
	public void showDealerHand(){
		Vector<Card> dealerHand = bgame.getDealer().getCurHand();
		
		if(dealerHand.size() >= 7){
    		String dealer_card7_img = String.format("/game/graphics/cards/front/%s_%s.png", dealerHand.get(6).getName(), dealerHand.get(6).getSuit());
    		ImageIcon dealer_card7_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(dealer_card7_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
    		dealer_card7.setIcon(dealer_card7_icon);
		}
		
		if(dealerHand.size() >= 6){
    		String dealer_card6_img = String.format("/game/graphics/cards/front/%s_%s.png", dealerHand.get(5).getName(), dealerHand.get(5).getSuit());
    		ImageIcon dealer_card6_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(dealer_card6_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
    		dealer_card6.setIcon(dealer_card6_icon);
		}
		
		if(dealerHand.size() >= 5){
        	String dealer_card5_img = String.format("/game/graphics/cards/front/%s_%s.png", dealerHand.get(4).getName(), dealerHand.get(4).getSuit());
    		ImageIcon dealer_card5_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(dealer_card5_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
    		dealer_card5.setIcon(dealer_card5_icon);
		}
		
		if(dealerHand.size() >= 4){
        	String dealer_card4_img = String.format("/game/graphics/cards/front/%s_%s.png", dealerHand.get(3).getName(), dealerHand.get(3).getSuit());
    		ImageIcon dealer_card4_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(dealer_card4_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
    		dealer_card4.setIcon(dealer_card4_icon);
		}
		
		if(dealerHand.size() >= 3){
        	String dealer_card3img = String.format("/game/graphics/cards/front/%s_%s.png", dealerHand.get(2).getName(), dealerHand.get(2).getSuit());
    		ImageIcon dealer_card3_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(dealer_card3img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
    		dealer_card3.setIcon(dealer_card3_icon);
		}
		
		if(dealerHand.size() >= 2){
        	String dealer_card2_img = String.format("/game/graphics/cards/front/%s_%s.png", dealerHand.get(1).getName(), dealerHand.get(1).getSuit());
    		ImageIcon dealer_card2_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(dealer_card2_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
    		dealer_card2.setIcon(dealer_card2_icon);

		}
		
		if(dealerHand.size() >= 1){
        	String dealer_card1_img = String.format("/game/graphics/cards/front/%s_%s.png", dealerHand.get(0).getName(), dealerHand.get(0).getSuit());
    		ImageIcon dealer_card1_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(dealer_card1_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
    		dealer_card1.setIcon(dealer_card1_icon);
		}
	}
	public void resetTable(){
		player.resetPlayer();
    	setBetAmt(bgame.getPot());
    	setTotAmt(player.getBank());
    	bet_field.setText(String.format("$%s", betAmt));
    	tot_field.setText(String.format("$%s", totAmt));
    	btnBet.setVisible(true);
    	txtBetAmount.setVisible(true);
    	
    	
    	
		String dealer_card7_img = "/game/graphics/cards/back/back_0.png";
		ImageIcon dealer_card7_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(dealer_card7_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		dealer_card7.setBounds(957, 67, 142, 213);
		dealer_card7.setIcon(dealer_card7_icon);

		
		String dealer_card6_img = "/game/graphics/cards/back/back_0.png";
		ImageIcon dealer_card6_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(dealer_card6_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		dealer_card6.setBounds(800, 67, 142, 213);
		dealer_card6.setIcon(dealer_card6_icon);

		
		String dealer_card5_img = "/game/graphics/cards/back/back_0.png";
		ImageIcon dealer_card5_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(dealer_card5_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		dealer_card5.setBounds(643, 67, card_w, card_h);
		dealer_card5.setIcon(dealer_card5_icon);

		
		String dealer_card4_img = "/game/graphics/cards/back/back_0.png";
		ImageIcon dealer_card4_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(dealer_card4_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		dealer_card4.setBounds(486, 67, card_w, card_h);
		dealer_card4.setIcon(dealer_card4_icon);

		
		String dealer_card3_img = "/game/graphics/cards/back/back_0.png";
		ImageIcon dealer_card3_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(dealer_card3_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		dealer_card3.setBounds(329, 67, card_w, card_h);
		dealer_card3.setIcon(dealer_card3_icon);

		
		String dealer_card2_img = "/game/graphics/cards/back/back_0.png";
		ImageIcon dealer_card2_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(dealer_card2_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		dealer_card2.setBounds(172, 67, card_w, card_h);
		dealer_card2.setIcon(dealer_card2_icon);

		
		String dealer_card1_img = "/game/graphics/cards/back/back_0.png";
		ImageIcon dealer_card1_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(dealer_card1_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		dealer_card1.setBounds(15, 67, card_w, card_h);
		dealer_card1.setIcon(dealer_card1_icon);

		
		String player_card7_img = "/game/graphics/cards/back/back_0.png";
		ImageIcon player_card7_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(player_card7_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		player_card7.setBounds(957, 621, 142, 213);
		player_card7.setIcon(player_card7_icon);

		
		String player_card6_img = "/game/graphics/cards/back/back_0.png";
		ImageIcon player_card6_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(player_card6_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		player_card6.setBounds(800, 621, 142, 213);
		player_card6.setIcon(player_card6_icon);

		
		String player_card5_img = "/game/graphics/cards/back/back_0.png";
		ImageIcon player_card5_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(player_card5_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		player_card5.setBounds(643, 621, card_w, card_h);
		player_card5.setIcon(player_card5_icon);

		
		String player_card4_img = "/game/graphics/cards/back/back_0.png";
		ImageIcon player_card4_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(player_card4_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		player_card4.setBounds(486, 621, card_w, card_h);
		player_card4.setIcon(player_card4_icon);

		
		String player_card3_img = "/game/graphics/cards/back/back_0.png";
		ImageIcon player_card3_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(player_card3_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		player_card3.setBounds(329, 621, card_w, card_h);
		player_card3.setIcon(player_card3_icon);

		
		String player_card2_img = "/game/graphics/cards/back/back_0.png";
		ImageIcon player_card2_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(player_card2_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		player_card2.setBounds(172, 621, card_w, card_h);
		player_card2.setIcon(player_card2_icon);
		
		String player_card1_img = "/game/graphics/cards/back/back_0.png";
		ImageIcon player_card1_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(player_card1_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		player_card1.setBounds(15, 619, card_w, card_h);
		player_card1.setIcon(player_card1_icon);

		String chips6_img = "/game/graphics/chips/0_empty_0.png";
		ImageIcon chips6_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(chips6_img)).getImage().getScaledInstance(chip_w, chip_h, Image.SCALE_DEFAULT));
		chips6.setBounds(800, 339, 142, 213);
		chips6.setIcon(chips6_icon);
		contentPane.add(chips6);
    	
		String chips5_img = "/game/graphics/chips/0_empty_0.png";
		ImageIcon chips5_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(chips5_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		chips5.setBounds(643, 339, 142, 213);
		chips5.setIcon(chips5_icon);
		contentPane.add(chips5);
		
		String chips4_img = "/game/graphics/chips/0_empty_0.png";
		ImageIcon chips4_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(chips4_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		chips4.setBounds(486, 339, 142, 213);
		chips4.setIcon(chips4_icon);
		
		String chips3_img = "/game/graphics/chips/0_empty_0.png";
		ImageIcon chips3_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(chips3_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		chips3.setBounds(329, 339, 142, 213);
		chips3.setIcon(chips3_icon);
		
		String chips2_img = "/game/graphics/chips/0_empty_0.png";
		ImageIcon chips2_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(chips2_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		chips2.setBounds(172, 339, 142, 213);
		chips2.setIcon(chips2_icon);
		
		String chips1_img = "/game/graphics/chips/0_empty_0.png";
		ImageIcon chips1_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(chips1_img)).getImage().getScaledInstance(card_w, card_h, Image.SCALE_DEFAULT));
		chips1.setBounds(15, 339, 142, 213);
		chips1.setIcon(chips1_icon);
//    	dispose();
//    	MainMenu window = new MainMenu(getPlayerName());
//    	window.setVisible(true);
    	

	}

}

//OLD CODE JUST IN CASE
/*txtBetAmount.addActionListener(new java.awt.event.ActionListener() {
@Override
public void actionPerformed(java.awt.event.ActionEvent evt) {
	btnBet.setVisible(false);
	txtBetAmount.setVisible(false);
	setBetAmt(Integer.parseInt(txtBetAmount.getText()));
	setTotAmt(getTotAmt() - Integer.parseInt(txtBetAmount.getText()));
	bet_field.setText(String.format("$%s", betAmt));
	tot_field.setText(String.format("$%s", totAmt));
}
});
btnBet.addActionListener(new java.awt.event.ActionListener() {
@Override
public void actionPerformed(java.awt.event.ActionEvent evt) {
if ((Integer.parseInt(txtBetAmount.getText()) <= 0)) //checking to make sure the bet is valid
{
	JOptionPane.showMessageDialog(null, "Bet must be greater than 0.","Bet Error", JOptionPane.ERROR_MESSAGE);
}
else if (Integer.parseInt(txtBetAmount.getText()) > getTotAmt())
{
	JOptionPane.showMessageDialog(null, "Bet must be less than the total money.","Bet Error", JOptionPane.ERROR_MESSAGE);
}
else
{
	btnBet.setVisible(false);
	txtBetAmount.setVisible(false);
	setBetAmt(Integer.parseInt(txtBetAmount.getText()));
	setTotAmt(getTotAmt() - Integer.parseInt(txtBetAmount.getText()));
	bet_field.setText(String.format("$%s", betAmt));
	tot_field.setText(String.format("$%s", totAmt));
}
}
});		
btnExit.addActionListener(new java.awt.event.ActionListener() {
@Override
public void actionPerformed(java.awt.event.ActionEvent evt) {
setVisible(false);
dispose();
MainMenu window = new MainMenu(getPlayerName());
window.setVisible(true);           	
}
});
*/
//*****************************************************//
// WHAT I'M ADDING //
//Buttons 
/*btnHit.addActionListener(new java.awt.event.ActionListener() {
@Override
public void actionPerformed(java.awt.event.ActionEvent evt) {
if (getBetAmt() <= 0)
{
	JOptionPane.showMessageDialog(null, "A bet must be placed first.","Bet Error", JOptionPane.ERROR_MESSAGE);
}
else
{
	//hit
}
}
});
btnStay.addActionListener(new java.awt.event.ActionListener() {
@Override
public void actionPerformed(java.awt.event.ActionEvent evt) {
}
});
btnSplit.addActionListener(new java.awt.event.ActionListener() {
@Override
public void actionPerformed(java.awt.event.ActionEvent evt) {
}
});
btnInsurance.addActionListener(new java.awt.event.ActionListener() {
@Override
public void actionPerformed(java.awt.event.ActionEvent evt) {
}
});*/

//*****************************************************//
/*
btnBet.addActionListener(new java.awt.event.ActionListener() {
@Override
public void actionPerformed(java.awt.event.ActionEvent evt) {
if ((Integer.parseInt(txtBetAmount.getText()) <= 0)) //checking to make sure the bet is valid
{
	JOptionPane.showMessageDialog(null, "Bet must be greater than 0.","Bet Error", JOptionPane.ERROR_MESSAGE);
}
else if (Integer.parseInt(txtBetAmount.getText()) > getTotAmt())
{
	JOptionPane.showMessageDialog(null, "Bet must be less than the total money.","Bet Error", JOptionPane.ERROR_MESSAGE);
}
else
{
	btnBet.setVisible(false);
	txtBetAmount.setVisible(false);
	setBetAmt(Integer.parseInt(txtBetAmount.getText()));
	setTotAmt(getTotAmt() - Integer.parseInt(txtBetAmount.getText()));
	bet_field.setText(String.format("$%s", betAmt));
	tot_field.setText(String.format("$%s", totAmt));
	
	String[] chipImageNames = makeChipImageNames();
	int[] chipSizes = findChipSizes();        		
	
	String chips6_img = chipImageNames[5];
	ImageIcon chips6_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(chips6_img)).getImage().getScaledInstance(chip_w, chipSizes[5], Image.SCALE_DEFAULT));
	chips6.setBounds(800, 339 + (214 - chipSizes[5]), chip_w, chipSizes[5]);
	chips6.setIcon(chips6_icon);
	
	String chips5_img = chipImageNames[4];
	ImageIcon chips5_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(chips5_img)).getImage().getScaledInstance(chip_w, chipSizes[4], Image.SCALE_DEFAULT));
	chips5.setBounds(643, 339 + (214 - chipSizes[4]), chip_w, chipSizes[4]);
	chips5.setIcon(chips5_icon);
	
	String chips4_img = chipImageNames[3];
	ImageIcon chips4_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(chips4_img)).getImage().getScaledInstance(chip_w, chipSizes[3], Image.SCALE_DEFAULT));
	chips4.setBounds(486, 339 + (214 - chipSizes[3]), chip_w, chipSizes[3]);
	chips4.setIcon(chips4_icon);
	
	String chips3_img = chipImageNames[2];
	ImageIcon chips3_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(chips3_img)).getImage().getScaledInstance(chip_w, chipSizes[2], Image.SCALE_DEFAULT));
	chips3.setBounds(329, 339 + (214 - chipSizes[2]), chip_w, chipSizes[2]);
	
	chips3.setIcon(chips3_icon);
	String chips2_img = chipImageNames[1];
	ImageIcon chips2_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(chips2_img)).getImage().getScaledInstance(chip_w, chipSizes[1], Image.SCALE_DEFAULT));
	chips2.setBounds(172, 339 + (214 - chipSizes[1]), chip_w, chipSizes[1]);
	chips2.setIcon(chips2_icon);
	
	String chips1_img = chipImageNames[0];
	ImageIcon chips1_icon = new ImageIcon(new ImageIcon(Blackjack.class.getResource(chips1_img)).getImage().getScaledInstance(chip_w, chipSizes[0], Image.SCALE_DEFAULT));
	chips1.setBounds(15, 339 + (214 - chipSizes[0]), chip_w, chipSizes[0]);
	chips1.setIcon(chips1_icon);
	
	for(String item : chipImageNames){
		System.out.println(item);
		
	}
}
}
});*/