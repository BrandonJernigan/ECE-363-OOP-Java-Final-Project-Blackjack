package game.backend;

import game.people.BlackjackPlayer;
import game.people.Player;
import game.physical.Deck;

public class Blackjack extends Game {

	private BlackjackPlayer player;
	private BlackjackPlayer dealer;

	
	public Blackjack()
	{
		
	}
	public Blackjack(int humans)
	{
		super();
		gameName = "Blackjack";
		if(humans == 1)
		{
			dealer = new BlackjackPlayer(this);
		}
	}


	@Override
	public Player checkWin() 
	{
		if(player.getStay() == false || dealer.getStay() == false) return null;
		if(player.getSum() > 21)
		{
			this.givePot(dealer);
			return dealer;
		}
		else if(dealer.getSum() > 21 || player.getSum() > dealer.getSum())
		{
			this.givePot(dealer);
			return player;
		}
		return null;
	}
	public void resetGame()
	{
		this.gameDeck = new Deck();
		player.resetPlayer();
		dealer.resetPlayer();
	}
	
	//Getters and Setters
	public void setPlayer(BlackjackPlayer newPlayer)
	{
		player = newPlayer;
	}
	public void setPlayer(BlackjackPlayer newPlayer1, BlackjackPlayer newPlayer2)
	{
		player = newPlayer1;
		dealer = newPlayer2;
	}
	public BlackjackPlayer getDealer()
	{
		return this.dealer;
	}
	public BlackjackPlayer getPlayer()
	{
		return this.player;
	}

}
