package game.physical;

public class Card {
	private int cardNumber;
	private String cardSuit;
	private String cardName;
	private boolean hasChanged;
	
	public Card()
	{

	}
	public Card(int number, String suit)
	{
		
		String name = "";
		hasChanged = false;
		if(number == 14){
			name = "A";
		} else if(number == 13){
			name = "K";
		} else if(number == 12){
			name = "Q";
		} else if(number == 11){
			name = "J";
		} else{
			name = Integer.toString(number);
		}
		cardName = name;
		cardNumber = number;
		cardSuit = suit;
	}
	public int getNumber()
	{
		return this.cardNumber;
	}
	public String getSuit()
	{
		return this.cardSuit;
	}
	public String getName()
	{
		return this.cardName;
	}
	public boolean getHasChanged()
	{
		return this.hasChanged;
	}
	public void setChange(boolean newState)
	{
		hasChanged = newState;
	}
}
