import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CardTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

    @Test
    public void testDefaultConstructor() {
        Card card = new Card();
        assertNotNull(card);
    }

    @Test
    public void testToString() {
        Card card = new Card("Hearts", "King");
        assertEquals("King of Hearts", card.toString());
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

}

