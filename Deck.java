// This class represents the deck of cards from which cards are dealt to players.
public class Deck
{
	// define fields here
	Card[] d = new Card[52];
	
	// This constructor builds a deck of 52 cards.
	public Deck()
	{
		int ctC = 0;
		for (int ctF = 1; ctF < 14; ctF++){
			for(int ctS = 0; ctS < 4; ctS++){
				d[ctC] = new Card(ctS, ctF);
				ctC++;}}
	}

	
	// This method takes the top card off the deck and returns it.
	public Card deal()
	{
		Card dealt;
		for(int i = 0; i < 52; i++){
		if (d[i] != null){
			dealt = d[i];
			d[i] = null;
			return dealt;
			
		}
		}
		return null;
	}
	public void fill(){
		int ctC = 0;
		for (int ctF = 1; ctF < 14; ctF++){
			for(int ctS = 0; ctS < 4; ctS++){
				d[ctC] = new Card(ctS, ctF);
				ctC++;
}}
	}
	
	public boolean isEmpty()
	{
		for(int e = 0; e < 52; e++){
			if(d[e] == null){	
			}
			else
				return false;
		}
		return true; 
	}
	public void shuffle(){
		for ( int i = d.length-1; i > 0; i-- ) {
            int random = (int)(Math.random()*(i+1));
            Card temp = d[i];
            d[i] = d[random];
            d[random] = temp;	
		}}
	
	
}


