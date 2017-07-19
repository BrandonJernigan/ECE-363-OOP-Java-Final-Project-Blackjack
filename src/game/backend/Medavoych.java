package game.backend;

import java.util.Vector;

import game.people.MedavoychPlayer;
import game.people.Player;
import game.physical.Card;

public class Medavoych extends Game {

	private Vector<Card> curPile;  //Current hand
	private MedavoychPlayer player1; //Player 1 object
	private MedavoychPlayer player2; //Player 2 object
	
	Medavoych()
	{
		
	}
	//Constructor
	Medavoych(int humans)
	{
		super();
		this.gameName = "Medavoych";
		if(humans == 1)
		{
			player2 = new MedavoychPlayer();
		}
		
	}
	
	//First checks to see if card is a valid play, if it isn't then it returns the pile to the player
    public void addToPile(Card addCard, Player playerMove)
    {
    	if(!this.checkMove(addCard))
    	{
    		curPile.add(addCard);
    		this.givePile(playerMove);
    	}
    	else
    	{
    		curPile.add(addCard);
    		if(addCard.getNumber() == 10) this.discardCurPile();
    	}
    }

    //Forces character to pick up pile into their hand
    public void givePile(Player givenPile)
    {
    	for(int i = 0; i < curPile.size(); i++)
    	{
    		givenPile.addCard(curPile.get(i));
    	}
    	curPile.clear();
    }

    //Clears current pile
    public void discardCurPile()
    {
    	curPile.clear();
    }


    //Returns true if move is valid or false if move is against the rules
    public boolean checkMove(Card curCard)
    {
    	if(curPile.lastElement().getNumber() == 3 && curCard.getNumber() == 3)
    	{
    		return true;
    	}
    	else if(curPile.lastElement().getNumber() != 3)
    	{
    		if(curCard.getNumber() == 2 || curCard.getNumber() == 10 || curCard.getNumber() == 3) return true;
    		if(curCard.getNumber() >= curPile.lastElement().getNumber() && curPile.lastElement().getNumber() != 7) return true;
    		if(curCard.getNumber() <= curPile.lastElement().getNumber() && curPile.lastElement().getNumber() == 7) return true;
    	}
    	return false;
    	
    }


	@Override
	public Player checkWin() {
		if(player2.getHand(3).size() == 0) 
		{
			this.givePot(player2);
			return player2;
		}
		else if(player1.getHand(3).size() == 0) 
		{
			this.givePot(player1);
			return player1;
		}
		return null;
	}
	
	//Getters and Setters
	public void setPlayer(MedavoychPlayer newPlayer)
	{
		player1 = newPlayer;
	}
	public void setPlayer(MedavoychPlayer newPlayer1, MedavoychPlayer newPlayer2)
	{
		player1 = newPlayer1;
		player2 = newPlayer2;
	}

}
