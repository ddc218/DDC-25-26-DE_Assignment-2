import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeckTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	public void testDefaultDeckConstructor() {
		Deck deck = new Deck();
		assertEquals(51, deck.getTopCard());
	}

	@Test
	public void testCopyConstructor() {
		Deck original = new Deck();
		Deck copy = new Deck(original);
		assertEquals(original.toString(), copy.toString());
	}

	@Test
	public void testDealSuccess() {
		Deck deck = new Deck();
		Deck[] hands = deck.deal(4, 5);
		assertNotNull(hands);
		assertEquals(4, hands.length);
		for (Deck hand : hands) {
			assertEquals(4, hand.getTopCard()); 
		}
	}

}
