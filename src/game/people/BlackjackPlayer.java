package game.people;

import java.util.ArrayList;
import java.util.Vector;

import game.backend.Blackjack;
import game.physical.Card;

public class BlackjackPlayer extends Player {

	private Blackjack bjgame; //Blackjack game mechanics object
	private int playerSum; //Points in player's hand
	private Vector<Card> splitHand;//Extra hand if split (split not implemented yet)
	private boolean stay;//Indicates if player has stayed
	private boolean splitStay;//Indicates if player has stayed after a split (split not implemented yet)
	private int splitSum;//Points in player's hand if split (split not implemented yet)
	
	//Constructors
	public BlackjackPlayer(Blackjack game)
	{
		super();
		bjgame = game;
		game.setPlayer(this);
		playerSum = 0;
		stay = false;
		splitStay = false;
		splitHand = new Vector<Card>();
		
	}
	public BlackjackPlayer(String name, Blackjack game)
	{
		super(name);
		bjgame = game;
		playerSum = 0;
		stay = false;
		splitStay = false;
		splitSum = 0;
		splitHand = new Vector<Card>();
	}
	
	//Creates hand after bet
	public void initializeHand()
	{
		while(curHand.size() < 2) this.drawCard();
	}
	//Split
	public void Split()
	{
		splitHand.add(curHand.get(1));
		curHand.remove(1);
		if(splitHand.get(splitHand.size()-1).getNumber() <= 10) this.splitSum += splitHand.get(splitHand.size()-1).getNumber();
		else if(splitHand.get(splitHand.size()-1).getNumber() == 14)
		{
			if(splitSum + 11 > 21) splitSum += 1;
			else splitSum += 11;
		}
		else
		{
			this.splitSum += 10;
		}
		if(curHand.lastElement().getNumber() <= 10) this.playerSum = curHand.lastElement().getNumber();
		else if(curHand.lastElement().getNumber() == 14) playerSum = 11;
		else
		{
			this.playerSum = 10;
		}
		this.makeWager(bjgame.getLastWager());
		this.drawCard();
	}
	//Doubles down 
	public void doubleDown()
	{
		this.makeWager(bjgame.getLastWager());
		this.drawCard();
		this.Stay();
	}
	//Stays
	public void Stay()
	{
		if(this.splitHand.size() != 0 && !this.splitStay) 
		{
			this.splitStay = true;
			
		}
		else this.stay = true;
	}
	
	public void AIMove()
	{
		while(this.playerSum <= 17)
		{
			this.drawCard();
		}
		this.Stay();
	}
	// Handles card drawing, includes scenarios for split and aces
	public void drawCard()
	{
		
		if(this.playerSum < 21 && !this.splitStay)
		{
			curHand.add(bjgame.getDeck().drawCard());
			if(curHand.lastElement().getNumber() <= 10) this.playerSum += curHand.lastElement().getNumber();
			else if(curHand.lastElement().getNumber() == 14) 
			{
				if(playerSum + 11 > 21) 
				{
					this.playerSum += 1;
					curHand.lastElement().setChange(true);
				}
				else this.playerSum +=11;
			}
			else
			{
				this.playerSum += 10;
			}
			if(this.playerSum == 21) this.Stay();
			else if(playerSum > 21)
			{
				for(int i = 0; i < curHand.size(); i++)
				{
					if(curHand.get(i).getNumber() == 14 && !curHand.get(i).getHasChanged())
					{
						playerSum -= 10;
						curHand.get(i).setChange(true);
					}
					
				}
			}
		}
		else if(this.splitSum < 21 && this.splitStay)
		{
			splitHand.add(bjgame.getDeck().drawCard());
			if(splitHand.get(splitHand.size()-1).getNumber() <= 10) this.splitSum += splitHand.get(splitHand.size()-1).getNumber();
			else if(splitHand.get(splitHand.size()-1).getNumber() == 14)
			{
				if(splitSum + 11 > 21) 
				{
					splitSum += 1;
					splitHand.lastElement().setChange(true);
				}
				else splitSum += 11;
			}
			else
			{
				this.splitSum += 10;
			}
			if(this.splitSum == 21) this.Stay();
			else if(splitSum > 21)
			{
				for(int i = 0; i < splitHand.size(); i++)
				{
					if(splitHand.get(i).getNumber() == 14 && !splitHand.get(i).getHasChanged())
					{
						splitSum -= 10;
						splitHand.get(i).setChange(true);
					}
				}
			}
		}
	}

	
	//Ensure wager is acceptable, true if wager made
	public boolean makeWager(int wager)
	{
		if(wager > bank) return false;
		else 
		{
			bjgame.addWager(wager);
			bank -= wager;
			return true;
		}
		
	}
	
	//Reset hand, flags, and points for player at end of round
	public void resetPlayer()
	{
		curHand.clear();
		splitHand.clear();
		stay = false;
		splitStay = false;
		playerSum = 0;
		splitSum = 0;
	}
	//Getters and Setters
	public int getSum()
	{
		return this.playerSum;
	}
	public int getSplitSum()
	{
		return this.splitSum;
	}
	public void setSum(int newSum)
	{
		this.playerSum = newSum;
	}
	public void setSplitSum(int newsum)
	{
		this.splitSum = newsum;
	}
	public void setStay(boolean state)
	{
		this.stay = state;
	}
	public void setSplitStay(boolean state)
	{
		this.splitStay = state;
	}
	public boolean getStay()
	{
		return this.stay;
	}
	public boolean getSplitStay()
	{
		return this.splitStay;
	}
	public Vector<Card> getSplitHand()
	{
		return this.splitHand;
	}
}
