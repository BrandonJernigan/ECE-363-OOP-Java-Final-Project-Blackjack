package game.people;

import java.util.Vector;

import game.physical.Card;

public abstract class Player {
	
	protected String playerName;
	protected Vector<Card> curHand;
	protected boolean isAI;
	protected int bank;
	
	public Player()
	{
		playerName = "AI Opponent";
		isAI = true;
		bank = 10000;
		curHand = new Vector<Card>();
	}
	public Player(String name)
	{
		playerName = name;
		isAI = false;
		bank = 10000;
		curHand = new Vector<Card>();
	}
	//Adds card to current hand
	public void addCard(Card nCard)
	{
		curHand.add(nCard);
	}
	//Adds winnings to bank
	public void addWinnings(int winnings)
	{
		bank += winnings;
	}
	//Abstract classes
	
	//Creates initial hand
	public abstract void initializeHand();
	//Checks if wager meets requirements and places it if it does
	public abstract boolean makeWager(int wager);
	//Plays according to AI
	public abstract void AIMove();
	//Draws card to current hand
	public abstract void drawCard();
	
	//Getters and Setters
	public String getPlayerName()
	{
		return playerName;
	}
	public Vector<Card> getCurHand()
	{
		return curHand;
	}
	public int getBank()
	{
		return this.bank;
	}


}
