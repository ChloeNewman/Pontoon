import java.util.ArrayList;

public class Card {

	//declare the suits
	public static enum Suit {
		CLUBS, HEARTS, DIAMONDS, SPADES;
	}

	//declare the values
	public static enum Value {
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
	}

	Suit cardSuit;
	Value cardValue;
	
	//set card suit
	public void setSuit(Suit suit) {
		this.cardSuit = suit;
	}
	
	//get card suit
	public Suit getSuit() {
		return cardSuit;
	}

	//set card value
	public void setValue(Value value) {
		this.cardValue = value;
	}
	
	//get card value
	public Value getValue() {
		return cardValue;
	}

	//method to compute the numerical value of a card
	//if card is ace, method should return 0 and 11
	//else method returns arraylist returning one value
	public ArrayList<Integer> getNumericalValue() {
		ArrayList<Integer> numericalValue = new ArrayList<Integer>();	
		
			switch (cardValue) {
				case ACE:
					numericalValue.add(1);
					numericalValue.add(11);
					break;
					
				case TWO:
					numericalValue.add(2);
					break;
					
				case THREE:
					numericalValue.add(3);
					break;
		
				case FOUR:
					numericalValue.add(4);
					break;
					
				case FIVE:
					numericalValue.add(5);
					break;
					
				case SIX:
					numericalValue.add(6);
					break;
					
				case SEVEN:
					numericalValue.add(7);
					break;
					
				case EIGHT:
					numericalValue.add(8);
					break;
					
				case NINE:
					numericalValue.add(9);
					break;
				
				case TEN:
				case JACK:
				case QUEEN:
				case KING:
					numericalValue.add(10);
					break;			
		}
			
		return numericalValue;		
	}
	
	public Card(Suit suit, Value value) {
		cardSuit = suit;
		cardValue = value;
	}
}

