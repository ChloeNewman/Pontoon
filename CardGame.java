import java.util.ArrayList;

//abstract class as a base class
public abstract class CardGame {
int numPlayers = 0;
ArrayList<Player> players = new ArrayList<Player>();
Deck deck;

	//creates the deck and sets the number of players for the game
	public CardGame (int nplayers) {
		deck = new Deck();
		numPlayers = nplayers;
		
		for (int i = 0; i < numPlayers; i++) {
			Player player = new Player("Player_" + (i + 1));
			players.add(player);
		}
	}

	//deals the number of initial cards to each player
	public abstract void dealInitialCards();

	//Compares the hands of two players
	public abstract int compareHands(Player hand1, Player hand2);
	
	//returns the deck
	public Deck getDeck() {
		return deck;
	}

	public Player getPlayer(int i) {
		return players.get(i);
	}
	
	//gets the number of players in the game
	public int getNumPlayers() {
		return numPlayers;
	}
}
