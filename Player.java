// This class represents one blackjack player (or the dealer)
public class Player
{
	// define fields here
	private String name;
	private boolean isDealer;
	private Hand hand;

	// This constructor creates a player.
	// If isDealer is true, this Player object represents the dealer.
	public Player(String playerName, boolean isDealer)
	{
		name = playerName;
		this.isDealer = isDealer;
		hand = new Hand();
		
	}

	// This method retrieves the player's name.
	public String getName()
	{
		return name; // replace this line with your code
	}

	// This method retrieves the player's hand of cards.
	public Hand getHand()
	{
		return hand; // replace this line with your code
	}
	
	// This method deals two cards to the player (one face down if this is the dealer).
	// The window input should be used to redraw the window whenever a card is dealt.
	public void startRound(Deck deck, BlackjackWindow window)
	{
		if (isDealer == true){
			Card d1 = deck.deal();
			Card d2 = deck.deal();
			d1.turnFaceDown();
			window.redraw();
			hand.addCard(d1);
			hand.addCard(d2);
			window.redraw();
		}
		else{
			
			hand.addCard(deck.deal());
			window.redraw();
			hand.addCard(deck.deal());
			window.redraw();
		}
	}

	// This method executes gameplay for one player.
	// If this player is the dealer:
	//	- hits until score is at least 17
	// If this is an ordinary player:
	//	- repeatedly asks the user if they want to hit (draw another card)
	//	  until either the player wants to stand (not take any more cards) or
	//	  his/her score exceeds 21 (busts).
	// The window input should be used to redraw the window whenever a card is dealt or turned over.
	public void playRound(Deck deck, BlackjackWindow window)
	{
	
		if (isDealer == true){
			boolean hitD = true;
			while (hitD == true){
				if (hand.getScore() < 17){
					hand.addCard(deck.deal());
			
					window.redraw();
				}
				else{
					hitD = false;
				}
			}
			}
		
		else{
			
			boolean hitP = true;
			while (hitP == true){
				String ht = GIO.readString(getName() + ", Type Y if you want to hit.");
				if (ht.equals("Y") || ht.equals("y")){
					hand.addCard(deck.deal());
					window.redraw();
				}
				else{
					hitP = false;
				}
				if (hand.getScore() > 21){
					hitP = false;
					GIO.displayMessage(getName() + ", You busted!");
				}}}
			
			
			
		// complete this method
		}
	// This method informs the player about whether they won, lost, or pushed.
	// It also discards the player's cards to prepare for the next round.
	// The window input should be used to redraw the window after cards are discarded.
	public void finishRound(int dealerScore, BlackjackWindow window)
	{
	
		if (hand.getScore() > 21){
			GIO.displayMessage(getName() + ", You lost");
		}
		else if (hand.getScore() < dealerScore && dealerScore < 21){
			GIO.displayMessage(getName() + ", You lost");
		}
		else if (hand.getScore() == dealerScore){
			GIO.displayMessage(getName() + ", You pushed");
		}
		else{
			GIO.displayMessage(getName() + ", You won!");
		}
		hand.discardAll();
		window.redraw();
	}
}