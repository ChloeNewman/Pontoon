import java.util.ArrayList;

import com.bham.pij.assignments.pontoon.Card.Value;

public class Pontoon extends CardGame {
	
	public Pontoon(int nplayers) {
		//pass number of players
		super(nplayers);
	}

	@Override
	public void dealInitialCards() {
		
		for (int i = 0; i < players.size(); i++) {	
			//deal two cards
			players.get(i).dealToPlayer(deck.dealRandomCard());
			players.get(i).dealToPlayer(deck.dealRandomCard());
		}
	}

	public ArrayList<Integer> compareRank() {

		ArrayList<Card> handCards = new ArrayList<Card>();
		ArrayList<Integer> handAll = new ArrayList<Integer>();
		int handValue;
		int handRank = 0;
		ArrayList<Integer> rank = new ArrayList<Integer>();
		
		for (int i = 0; i < players.size(); i++) {
		handCards = players.get(i).getCards();
		handAll = players.get(i).getNumericalHandValue();
		handValue = players.get(i).getBestNumericalHandValue();

		//best hand for hands with aces
		//if there is ace(s) check that best value is not over 21
		if (handCards.contains(Value.ACE)) {
			//if the smallest number is over 21, set the smallest number as best hand
			if (handAll.get(0) > 21) {
				handValue = handAll.get(0);
				
			} else {
				//for loop that starts from highest number
				for (int a = handAll.size() - 1; a >= 0; a--) {
				
					if (handAll.get(a) <= 21 && handAll.get(a) >= 16) {
						handValue = handAll.get(a);
					}
				}	
			}
		}
		
		//rank hands
		//an ace and a single card with a value of 10
		if (handValue > 21) {
			handRank = 0;
			
		} else if (handCards.size() == 2 && handValue == 21) { 
			handRank = 8;
			
		//'Five Card Trick' - five cards that total under 21	
		} else if (handCards.size() == 5 && handValue <= 21) {
			handRank = 7;	
			
		//hand with any number of cards totalling 21	
		} else if (handValue == 21) {
			handRank = 6;
			
		//numerical hand with a total of 20 or less;	
		} else if (handValue == 20) {
			handRank = 5;
		} else if (handValue == 19) {
			handRank = 4;
		} else if (handValue == 18) {
			handRank = 3;
		} else if (handValue == 17) {
			handRank = 2;
		} else if (handValue == 16) {
			handRank = 1;
		}
		
			rank.add(handRank);
		}

		return rank;
	}

	@Override
	public int compareHands(Player hand1, Player hand2) {
		
		int result = 0;

		ArrayList<Integer> rank = compareRank();

		if (rank.get(0) > rank.get(1)) {
			result = -1;
		} else if (rank.get(0) < rank.get(1)) {
			result = +1;
		} else if (rank.get(0) == rank.get(1)) {
			result = 0;
		}

		return result;
	}
}
