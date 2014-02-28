package interview.oop.carddeck;

public class BlackJack extends Card{

	public BlackJack(int n, Suit s) {
		super(n, s);
	}
	
	public int value() {
		if (value == 1) {
			return 11;
		}
		if (value < 10) {
			return value;
		}
		return 10;
	}
	
	
}
