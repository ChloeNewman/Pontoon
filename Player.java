import java.util.ArrayList;

public class Player {
	String playerName;
	ArrayList<Card> cards;
	ArrayList<Integer> numericalHand;
	int bestNumericalHandValue;

	//constructor that stores the player's name
	public Player(String name) {
		playerName = name;
		cards = new ArrayList<Card>();
	}
	
	//return the player's name
	public String getName() {
		return playerName;
	}
	
	//Adds a card to the players hand
	public void dealToPlayer(Card card) {
		cards.add(card);
	}
	
	//removes a card from the players hand
	public void removeCard(Card card) {
		cards.remove(card);
	}

	//return all the possible numerical values of a hand
	public ArrayList<Integer> getNumericalHandValue() {
		//		int upperBound = numericalHand.size() - 1;
		//		int placeHolder;
		//		int compare = upperBound;

		numericalHand = new ArrayList<Integer>();
		ArrayList<Integer> cardValue = new ArrayList<Integer>();
		ArrayList<Integer> cardValues = new ArrayList<Integer>();
		ArrayList<Integer> aceArray = new ArrayList<Integer>();
		int newTotal = 0;
		int aceNumber = 0;
		int total = 0;

		//for every card in the cards arraylist get the numerical value
		for (int c = 0; c < cards.size(); c++) {
			
			//for each index in card get the numerical value
			cardValue = cards.get(c).getNumericalValue();
	
			//if the cardValue is equal to one it is an ace
			if (cardValue.get(0) == 1) {

				//increment ace
				aceNumber++;
			
			//else not an ace
			} else {

				//add the cardValue to the cardValues arraylist
				cardValues.add(cardValue.get(0));
			}
		}

		//find total of array without ace
		for (int i = 0; i < cardValues.size(); i++) {
			total += cardValues.get(i);	
		}	
					
			//if it contains ace
			if (aceNumber == 1 || aceNumber == 2 || aceNumber == 3 || aceNumber == 4) {
				
				//if one ace
				if (aceNumber == 1) {
					//add each potential value to aceArray arraylist
					aceArray.add(1);					
					aceArray.add(11);					
					
					//add each item in the ace array to the total and store in array
					for (int a = 0; a < aceArray.size(); a++) {
						
						//add ace to the rest of the values
						newTotal = total + aceArray.get(a);
						numericalHand.add(newTotal);
					}
				}
				
				//if two ace
				else if (aceNumber == 2) {
					aceArray.add(2);
					aceArray.add(12);
					aceArray.add(22);
					
					//add each item in the ace array to the total and store in array
					for (int a = 0; a < aceArray.size(); a++) {
						
						//add ace to the rest of the values
						newTotal = total + aceArray.get(a);
						numericalHand.add(newTotal);
					}
				}
				
				//if three ace
				else if (aceNumber == 3) {
					aceArray.add(3);
					aceArray.add(13);
					aceArray.add(23);
					aceArray.add(33);
					
					//add each item in the ace array to the total and store in array
					for (int a = 0; a < aceArray.size(); a++) {
						
						//add ace to the rest of the values
						newTotal = total + aceArray.get(a);
						numericalHand.add(newTotal);
					}
				}

				//if four ace
				else if (aceNumber == 4) {
					aceArray.add(4);
					aceArray.add(14);
					aceArray.add(24);
					aceArray.add(34);
					aceArray.add(44);

					//add each item in the ace array to the total and store in array
					for (int a = 0; a < aceArray.size(); a++) {
						
						//add ace to the rest of the values
						newTotal = total + aceArray.get(a);
						numericalHand.add(newTotal);
					}
				}

			} else {
			
			numericalHand.add(total);
			
			}

		bestNumericalHandValue = numericalHand.get(numericalHand.size() - 1);

		return numericalHand;
	}

	//returns maximum numerical value of the player's hand of cards
	public int getBestNumericalHandValue() {

		return bestNumericalHandValue;
	}

	//returns the cards in the player's hand
	public ArrayList<Card> getCards() {
		return cards;
	}

	//returns number of cards in the player's hand
	public int getHandSize() {

		int handSize = cards.size();
		return handSize;
	}
}
