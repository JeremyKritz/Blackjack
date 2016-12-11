// This class represents the set of cards held by one player (or the dealer).
public class Hand
{
	private Card[] hand = new Card[11];
	

	// This constructor builds a hand (with no cards, initially).
	public Hand()
	{
	}
	
	// This method retrieves the size of this hand.
	public int getNumberOfCards()
	{
		int ct = 0;
		for(int i = 0; i < 11;i++){
			if(hand[i] == null){}
			else{
			ct++;
			}
		}
		return ct;
	}

	// This method retrieves a particular card in this hand.  The card number is zero-based.
	public Card getCard(int index)
	{
		return hand[index]; // replace this line with your code
	}

	// This method takes a card and places it into this hand.
	public void addCard(Card newcard)
	{
		for(int i = 0; i < hand.length;i++){
			if(hand[i] == null){
				hand[i] = newcard;
				break;
			
		}                                            
		}
	}
	// This method computes the score of this hand.
	public int getScore()
	{
		int score = 0;
		boolean ace = false;
		for (int w = 0; w < hand.length; w++){
			if (hand[w] != null){
				score += hand[w].getValue();
				if (hand[w].getValue() == 1){
					ace = true;
				}
			}
			
	}
		if (ace == true){
			if (score <= 10){
				score += 11;
			}
		}
		return score;
	}
	// This methods discards all cards in this hand.
	public void discardAll()
	{
		for (int w = 0; w < hand.length; w++){
			hand[w] = null;
		}
	}
}