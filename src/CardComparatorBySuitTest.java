import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CardComparatorBySuitTest {

    @Test
    public void testCompareDifferentSuits() {
        Card c1 = new Card("Clubs", "Ten");
        Card c2 = new Card("Hearts", "Ten");
        CardComparatorBySuit comp = new CardComparatorBySuit();
        assertEquals(-1, Integer.signum(comp.compare(c1, c2)));
        assertEquals(1, Integer.signum(comp.compare(c2, c1)));
    }

    @Test
    public void testCompareSameSuitDifferentRank() {
        Card c1 = new Card("Spades", "Three");
        Card c2 = new Card("Spades", "Jack");
        CardComparatorBySuit comp = new CardComparatorBySuit();
        assertEquals(0, comp.compare(c1, c2));
    }

    @Test
    public void testCompareEqualCards() {
        Card c1 = new Card("Diamonds", "Five");
        Card c2 = new Card("Diamonds", "Five");
        CardComparatorBySuit comp = new CardComparatorBySuit();
        assertEquals(0, comp.compare(c1, c2));
    }

}
