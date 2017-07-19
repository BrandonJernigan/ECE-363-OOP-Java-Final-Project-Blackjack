package game.backend;

import game.people.Player;
import game.physical.Deck;

public abstract class Game {
	protected String gameName; //Which game played
	protected Deck gameDeck; //Which deck type
	protected int pot; //Amount available to win
	protected int lastWager; //Amount of last bet
	
	//Default Constructor
	public Game()
	{
		gameDeck = new Deck();
		pot = 0;
	}
	//Adds a players wager to the pot
	public void addWager(int newWager)
	{
			lastWager = newWager;
			pot += (newWager*2);
	}
	//Awards winnings to player
	public void givePot(Player winner)
	{
		winner.addWinnings(pot);
		pot = 0;
	}
	public void giveSplitPot(Player winner)
	{
		winner.addWinnings(pot/2);
		pot = pot/2;
	}
	//Returns player that won or null if game is still in progress
	public abstract Player checkWin();
	
	
	//Getters and Setters
	public String getName()
	{
		return this.gameName;
	}
	public Deck getDeck()
	{
		return this.gameDeck;
	}
	public int getLastWager()
	{
		return this.lastWager;
	}
	public int getPot()
	{
		return this.pot;
	}
	public int getSplitPot()
	{
		return this.pot/2;
	}
	public void setLastWager(int newWager)
	{
		lastWager = newWager;
	}
	public void setPot(int newPot)
	{
		pot = newPot;
	}

}
