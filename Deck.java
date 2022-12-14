import com.bham.pij.assignments.pontoon.Card.Suit;
import com.bham.pij.assignments.pontoon.Card.Value;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

//represents a whole deck of cards
public class Deck {
ArrayList<Card> deck = new ArrayList<Card>(52);
ArrayList<Card> newDeck = new ArrayList<Card>();

	//create the deck of cards
	public Deck() {
		
		//loop through the Suit and Value enum
		for (int s = 0; s < 4; s++) {
			 Suit suit = Suit.values()[s];
			
			for (int v = 0; v < 13; v++) {
				Value value = Value.values()[v];
					
				Card card = new Card(suit, value);
				deck.add(card);
				newDeck.add(card);
			}
		}
	}

	//resets the cards in the deck
	public void reset() {
		deck = newDeck;
	}
	
	
	//random number generation shuffle card indexes
	public void shuffle() {
		
			Collections.shuffle(deck);
		
	}

	//returns the card at a given index
	public Card getCard(int i) {
		return deck.get(i);
	}
	
	//return random card from remaining cards in the deck; remove card from the deck
	public Card dealRandomCard() {
		Random chooseCard = new Random();
		
		Card randomCard = deck.get(chooseCard.nextInt(deck.size()));
		deck.remove(randomCard);

		return randomCard;
	}
	
	//returns number of cards currently in the deck
	public int size() {
		return deck.size();
	}
}
