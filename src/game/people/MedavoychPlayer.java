package game.people;

import java.util.Vector;

import game.backend.Medavoych;
import game.physical.Card;

public class MedavoychPlayer extends Player {

	private Vector<Card> visHand;
	private Vector<Card> invisHand;
	private Medavoych mvGame;
	
	public void drawCard()
	{
		if(curHand.size() < 3 && mvGame.getDeck().remainingCards() != 0)
		{
			int amountToDraw;
			amountToDraw = Math.min((3-curHand.size()),mvGame.getDeck().remainingCards());
			for(int i = 0; i < amountToDraw; i++)
			{
				curHand.add(mvGame.getDeck().drawCard());
			}
		}
		
	}
	//Plays card and removes it from proper hand
	public void playCard(Card playedCard)
	{
		if(curHand.size() == 0 && visHand.size() == 0)
		{
			mvGame.addToPile(playedCard,this);
			invisHand.remove(playedCard);
		}
		else if(curHand.size() == 0)
		{
			mvGame.addToPile(playedCard,this);
			visHand.remove(playedCard);
		}
		else
		{
			mvGame.addToPile(playedCard,this);
			curHand.remove(playedCard);
		}
		this.drawCard();
	}
	
	public void initializeHand() 
	{
		for(int i = 0; i < 3; i++)
		{
			curHand.add(mvGame.getDeck().drawCard());
			visHand.add(mvGame.getDeck().drawCard());
			invisHand.add(mvGame.getDeck().drawCard());
		}

	}

	public void AIMove() 
	{
		if(curHand.size() == 0 && visHand.size() == 0)
		{
			mvGame.addToPile(invisHand.get(0), this);
			invisHand.remove(0);
		}
		else if(curHand.size() == 0)
		{
			for(int i = 0; i < visHand.size(); i++)
			{
				if(mvGame.checkMove(visHand.get(i))) mvGame.addToPile(visHand.get(i), this);
				visHand.remove(i);
			}
		}
		else
		{
			for(int i = 0; i < curHand.size(); i++)
			{
				if(mvGame.checkMove(curHand.get(i))) mvGame.addToPile(curHand.get(i), this);
				curHand.remove(i);
			}
		}
	}

	public boolean makeWager(int wager)
	{
		if(wager < mvGame.getLastWager() || wager > bank) return false;
		else 
		{
			mvGame.addWager(wager);
			bank -= wager;
			return true;
		}
		
	}
	//Getters and Setters
	public Vector<Card> getHand(int handNumber)
	{
		if(handNumber == 1) return this.curHand;
		else if(handNumber == 2) return this.visHand;
		else if(handNumber == 3) return this.invisHand;
		else return null;
	}


}
