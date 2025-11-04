
/**
 * 
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 
 */
public class AllTest {

	@Test
	public void testCardDefaultConstructor() {
		Card card = new Card();
		assertNotNull(card);
	}

	@Test
	public void testCard2IntConstructor() {
		Card c = new Card(3, 2);
		assertEquals(2, c.getRank());
		assertEquals(3, c.getSuitInt());
		assertEquals("Two", c.getRankStr());
		assertEquals("Spades", c.getSuit());
	}

	@Test
	public void testCard2StringConstructor() {
		Card c = new Card("Clubs", "Two");
		assertEquals(2,c.getRank());
		assertEquals(0,c.getSuitInt());
		assertEquals("Two", c.getRankStr());
		assertEquals("Clubs", c.getSuit());
	}

	@Test
	public void testCardIntSuitConstructor() {
		Card c = new Card(1, "Jack");
		assertEquals(11, c.getRank());
		assertEquals(1, c.getSuitInt());
		assertEquals("Jack", c.getRankStr());
		assertEquals("Diamonds", c.getSuit());

	}

	@Test
	public void testCardIntRankConstructor() {
		Card c = new Card("Diamonds", 2);
		assertEquals(2, c.getRank());
		assertEquals(1, c.getSuitInt());
		assertEquals("Two", c.getRankStr());
		assertEquals("Diamonds", c.getSuit());
	}

	@Test
	public void testCardCopyConstructor() {
		Card c1 = new Card("Clubs", 6);
		Card c2 = new Card(c1);
		Assertions.assertNotSame(c1, c2);
	}

	@Test
	public void testGetSuitInt() {
		Card card = new Card("Clubs", 3);
		assertEquals(0, card.getSuitInt());
	}

	@Test
	public void testGetRankStr() {
		Card card = new Card("Diamonds", 1);
		assertEquals("Ace", card.getRankStr());
	}

	@Test
	public void testCardToString() {
		Card card = new Card("Hearts", "King");
		assertEquals("King of Hearts", card.toString());
	}

	@Test
	public void testCardEqualsSame() {
		assertTrue((new Card(1, 3)).equals(new Card(1, 3)));
	}

	@Test
	public void testCardEqualsUnequal() {
		assertFalse((new Card(1, 2)).equals(new Card(1, 3)));
	}

	@Test
	public void testCardEqualsSameObj() {
		Card c = new Card(1,5);
		assertTrue(c.equals(c));
	}

	@Test
	public void testCardEqualsDiffObj() {
		assertNotEquals(new Card(1,5), "");
	}

	@Test
	public void testCardEqualsNull() {
		assertFalse((new Card(1,5)).equals(null));
	}

	@Test
	public void testCardCompareToEqual() {
		assertEquals(0, (new Card(1,5)).compareTo(new Card(1,5)));
	}

	@Test
	public void testCardCompareToLess() {
		Card c1 = new Card("Spades", "Ace");
		Card c2 = new Card("Clubs", "Ace");
		assertTrue(c2.compareTo(c1) < 0);
	}

	@Test
	public void testCardCompareToGreater() {
		Card c1 = new Card("Spades", "Queen");
		Card c2 = new Card("Spades", "Ace");
		assertTrue(c1.compareTo(c2) > 0);
	}

	@Test
	public void testDefaultDeckConstructor() {
		Deck deck = new Deck();
		assertEquals(51, deck.getTopCard());
	}

	@Test
	public void testDeckConstructorShuffled() {
		Deck d = new Deck(false);
		assertNotEquals(d.pick(), new Card("Spades", "King"));
	}

	@Test
	public void testDeckCopyConstructor() {
		Deck original = new Deck();
		Deck copy = new Deck(original);
		assertEquals(original.toString(), copy.toString());
	}

	@Test
	public void testShuffle() {
		Deck d1 = new Deck();
		for (int i = 0; i < 40; i++)
			d1.pick();
		Deck d2 = new Deck(d1);
		d2.shuffle();
		assertNotEquals(d1.toString(), d2.toString());
	}

	@Test
	public void testDeckToString() {
		Deck d1 = new Deck();
		for (int i = 0; i < 50; i++)
			d1.pick();
		System.out.println(d1.toString());

	}

	@Test
	public void testDeckToString52() {
		Deck d1 = new Deck();
		String fstLine = d1.toString().split("\n")[0];
		assertEquals("Ace of Clubs\tAce of Diamonds\tAce of Hearts\tAce of Spades", fstLine.strip());
	}

	@Test
	public void testDeckEqualsSame() {
		Deck d = new Deck();
		assertEquals(d, d);
		assertEquals(d, new Deck());
	}

	@Test
	public void testDeckEqualsFalse() {
		assertNotEquals(new Deck(), new Deck(false));
	}

	@Test
	public void testDeckEqualsNull() {
		assertNotEquals(null, new Deck());
	}

	@Test
	public void testDeckEqualsDiffObj() {
		assertNotEquals("", new Deck());
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
		System.out.println("Done");
	}

	@Test
	public void testDealTooLarge() {
		Deck deck = new Deck();
		for (int i = 0; i < 45; i++)
			deck.pick();
		Deck[] hands = deck.deal(4, 5);
		assertNull(hands);
	}
	
	@Test
	public void testDealInvalid() {
		Deck deck = new Deck();
		Deck[] hands = deck.deal(-1, 5);
		assertNull(hands);
	}

	@Test
	public void testPick() {
		Deck d = new Deck();
		d.pick();
		assertEquals(50, d.getTopCard());

		for (int i = 0; i < 50; i++)
			d.pick();
	}
	
	@Test
	public void testPickEmpty() {
		Deck d = new Deck();
		for(int i=0; i<52; i++) d.pick();
		
		assertNull(d.pick());
	}

	@Test
	public void testSelectionSort() {
		Deck d = new Deck(false);
		d.selectionSort();
		assertEquals(d, new Deck());
	}

	@Test
	public void testSelectionSortNotFull() {
		Deck d = new Deck(true);
		d.pick();
		d.pick();
		d.pick();
		Deck d2 = new Deck(d);
		d.shuffle();
		d.selectionSort();
		assertEquals(d, d2);
	}

	@Test
	public void testMergeSort() {
		Deck d = new Deck(false);
		d.mergeSort();
		assertEquals(d, new Deck());
	}

	@Test
	public void testMergeSortNotFull() {
		Deck d = new Deck(true);
		for (int i = 0; i < 47; i++)
			d.pick();
		Deck d2 = new Deck(d);
		d.shuffle();
		d.mergeSort();
		assertEquals(d, d2);
	}

	@Test
	void testCardComparatorByRankEqual() {
		CardComparatorByRank c = new CardComparatorByRank();
        Card c1 = new Card("Hearts", 1);
        Card c2 = new Card("Spades", 1);
        assertEquals(0, c.compare(c1, c2));
	}

	@Test
	void testCardComparatorByRankUnequal() {
		CardComparatorByRank c = new CardComparatorByRank();
        Card c1 = new Card("Hearts", 4);
        Card c2 = new Card("Clubs", 5);
        assertTrue(c.compare(c1, c2) < 0);
        assertTrue(c.compare(c2, c1) > 0);
	}

	@Test
	void testCardComparatorBySuitEqual() {
		CardComparatorBySuit c = new CardComparatorBySuit();
        Card c1 = new Card("Hearts", 1);
        Card c2 = new Card("Hearts", 1);
        assertEquals(0, c.compare(c1, c2));
	}

	@Test
	void testCardComparatorBySuitUnequal() {
		CardComparatorBySuit c = new CardComparatorBySuit();
        Card c1 = new Card("Hearts", 4);
        Card c2 = new Card("Spades", 5);
        assertTrue(c.compare(c1, c2) < 0);
        assertTrue(c.compare(c2, c1) > 0);

	}
}
