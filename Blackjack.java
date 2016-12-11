// This is the main program for the blackjack game.
public class Blackjack
{
	// This method should:
	//	- Ask the user how many people want to play (up to 3, not including the dealer).
	//	- Create an array of players.
	//	- Create a Blackjack window.
	// 	- Play rounds until the players want to quit the game.
	//	- Close the window.
	public static void main(String[] args)
	{

		int numPlayers = GIO.readInt("How many people want to play? (1-3, doesn't include dealer).");
		Player[] p = new Player[numPlayers + 1];
		
		
		
		for(int pl=0; pl < numPlayers; pl++) //creates players
		{
			Integer.toString(pl);
			String pName = GIO.readString("Enter the name of the player.");
			p[pl] = new Player(pName, false);
			
		}	
		String dName = GIO.readString("Enter the name of the dealer.");
		p[numPlayers] = new Player(dName, true);
		BlackjackWindow window = new BlackjackWindow(p);
		window.redraw();
		boolean replay = true;
		while (replay == true){
			System.out.println("Hi");
			window.redraw();
			playRound(p, window);
			
		}
			
		// complete this method
	}

	// This method executes an single round of play (for all players).  It should:
	//	- Create and shuffle a deck of cards.
	//	- Start the round (deal cards) for each player, then the dealer.
	//	- Allow each player to play, then the dealer.
	//	- Finish the round (announce results) for each player.
	public static void playRound(Player[] players, BlackjackWindow window)
	{
		Deck d  = new Deck();
		d.shuffle();
		
		System.out.println(players.length);
		for (int q = 0; q < players.length; q++){
			players[q].startRound(d, window);
		}
		
		for (int qw = 0; qw < players.length; qw++){
			players[qw].playRound(d, window);
		}
		
		Hand deal = players[players.length - 1].getHand();
		Card fl = deal.getCard(0);
		fl.turnFaceUp();
		window.redraw();
		for (int qwe = 0; qwe < players.length - 1; qwe++){
			players[qwe].finishRound(deal.getScore(), window); // SWITCH TO FINISH RD
		}
		deal.discardAll();
		window.redraw();
		
	}
}