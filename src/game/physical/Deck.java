package game.physical;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import game.physical.Card;

public class Deck {
	private ArrayList<Card> deckCards;
	//Constructs 52 cards from values 2-14 (2-A) in order then shuffles
	public Deck()
	{
		deckCards = new ArrayList<Card>();
		String[] suit = {"spades", "clubs", "hearts", "diamonds"};
		for(int i = 2; i <= 14; i++)
		{
			for(String j : suit)
			{
				Card newCard = new Card(i, j);
				deckCards.add(newCard);
			}
		}
		this.shuffleDeck();
	}
	//Removes the Top card and returns it
	public Card drawCard()
	{
		Card drawnCard = deckCards.get(0);
		deckCards.remove(0);
		return drawnCard;
	}
	//Shuffles deck by using ~500 random swaps
	public void shuffleDeck()
	{
		Random rn = new Random();
		for(int i = 0; i < 500; i++)
		{
			int m = rn.nextInt(52);
			int n = rn.nextInt(52);
			if( m != n) Collections.swap(deckCards, m, n);
		}
	}
	//returns amount of cards left in deck
	public int remainingCards()
	{
		return this.deckCards.size();
	}

}
