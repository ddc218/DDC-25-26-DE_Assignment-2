import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CardComparatorByRankTest {

    @Test
    public void testCompareDifferentRanks() {
        Card low = new Card("Hearts", "Two");
        Card high = new Card("Hearts", "King");
        CardComparatorByRank comp = new CardComparatorByRank();
        assertEquals(-1, Integer.signum(comp.compare(low, high)));
        assertEquals(1, Integer.signum(comp.compare(high, low)));
    }

    @Test
    public void testCompareSameRankDifferentSuit() {
        Card c1 = new Card("Clubs", "Queen");
        Card c2 = new Card("Spades", "Queen");
        CardComparatorByRank comp = new CardComparatorByRank();
        assertEquals(0, comp.compare(c1, c2));
    }

    @Test
    public void testCompareEqualCards() {
        Card c1 = new Card("Hearts", "Ace");
        Card c2 = new Card("Hearts", "Ace");
        CardComparatorByRank comp = new CardComparatorByRank();
        assertEquals(0, comp.compare(c1, c2));
    }

}
