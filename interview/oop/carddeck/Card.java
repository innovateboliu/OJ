package interview.oop.carddeck;

public class Card {
	public enum Suit {
		CLUBS (1), SPADES (2), HEARTS (3), DIAMONDS (4);
		int value;
		private Suit(int v) { value = v;}
	}
	
	protected int value;
	protected Suit suit;
	
	public Card(int n, Suit s) {
		suit = s;
		value = n;
	}
	
	public int value() { return value; }
	public Suit suit() { return suit; }
}
