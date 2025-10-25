/**
 * David De Costa
 * CS 876
 * Assignment 2
 * 10/24/25
 *
 * The {@code Card} class represents a single playing card from a standard deck.
 * Each card has a {@code suit} and a {@code rank}, which can be represented as
 * either integers or strings. The class includes constructors for different
 * input formats and provides methods for comparing, copying, and printing cards.
 */
public class Card {

    /** Integer representing the suit of the card. */
    private int suit;

    /** Integer representing the rank of the card. */
    private int rank;

    /** Array of suit names, indexed by suit value. */
    private static final String[] suits = {
        "Clubs", "Diamonds", "Hearts", "Spades", "invalid suit"
    };

    /** Array of rank names, indexed by rank value. */
    private static final String[] ranks = {
        "invalid rank", "Ace", "Two", "Three", "Four", "Five", "Six",
        "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"
    };

    /**
     * Default constructor that creates the Ace of Clubs.
     */
    public Card() {
        suit = 0;
        rank = 1;
    }

    /**
     * Constructs a {@code Card} with a given integer suit and rank.
     *
     * @param s the integer representing the suit (0–3)
     * @param r the integer representing the rank (1–13)
     */
    public Card(int s, int r) {
        suit = s;
        rank = r;
    }

    /**
     * Constructs a {@code Card} from string representations of suit and rank.
     * If invalid strings are provided, defaults to "invalid" values.
     *
     * @param s the suit name (e.g. "Clubs", "Hearts")
     * @param r the rank name (e.g. "Ace", "King")
     */
    public Card(String s, String r) {
        s = s.toLowerCase();
        r = r.toLowerCase();

        if (s.equals("clubs")) {
            suit = 0;
        }
        else if (s.equals("diamonds")) {
            suit = 1;
        }
        else if (s.equals("hearts")) {
            suit = 2;
        }
        else if (s.equals("spades")) {
            suit = 3;
        } 
        else {
            suit = 4;
        }

        if (r.equals("ace")) {
            rank = 1;
        }
        else if (r.equals("jack")) {
            rank = 11;
        }
        else if (r.equals("queen")) {
            rank = 12;
        }
        else if (r.equals("king")) {
            rank = 13;
        } 
        else {
            rank = 0;
        }
    }

    /**
     * Constructs a {@code Card} using a string for the suit and an integer for the rank.
     *
     * @param s the suit name (e.g. "Clubs")
     * @param r the rank value (1–13)
     */
    public Card(String s, int r) {
        s = s.toLowerCase();

        if (s.equals("clubs")) {
            suit = 0;
        }
        else if (s.equals("diamonds")) {
            suit = 1;
        }
        else if (s.equals("hearts")) {
            suit = 2;
        }
        else if (s.equals("spades")) {
            suit = 3;
        } 
        else {
            suit = 4;
        }

        rank = r;
    }

    /**
     * Constructs a {@code Card} using an integer for the suit and a string for the rank.
     *
     * @param s the integer suit (0–3)
     * @param r the string rank (e.g. "Ace", "Queen")
     */
    public Card(int s, String r) {
        r = r.toLowerCase();
        suit = s;

        if (r.equals("ace")) {
            rank = 1;
        }
        else if (r.equals("jack")) {
            rank = 11;
        }
        else if (r.equals("queen")) {
            rank = 12;
        }
        else if (r.equals("king")) {
            rank = 13;
        } 
        else {
            rank = 0;
        }
    }

    /**
     * Copy constructor that creates a new {@code Card} identical to another.
     *
     * @param card2 the card to copy
     */
    public Card(Card card2) {
        suit = card2.getSuitInt();
        rank = card2.getRank();
    }

    /**
     * Returns the name of this card's suit.
     *
     * @return the suit as a {@code String}
     */
    public String getSuit() {
        return suits[suit];
    }

    /**
     * Returns the integer representation of this card's suit.
     *
     * @return the suit as an {@code int}
     */
    public int getSuitInt() {
        return suit;
    }

    /**
     * Returns the rank value of this card.
     *
     * @return the rank as an {@code int}
     */
    public int getRank() {
        return rank;
    }

    /**
     * Returns the name of this card's rank.
     *
     * @return the rank as a {@code String}
     */
    public String getRankStr() {
        return ranks[rank];
    }

    /**
     * Compares this card to another card.
     * Cards are first compared by suit, then by rank.
     *
     * @param card2 the card to compare with
     * @return a negative value if this card is "less than" the other,
     *         zero if equal, or a positive value if "greater than" the other
     */
    public int compareTo(Card card2) {
        if (suit != card2.getSuitInt()) {
            return suit - card2.getSuitInt();
        }
        return rank - card2.getRank();
    }

    /**
     * Determines if this card is equal to another object.
     * Two cards are equal if their suits and ranks are the same.
     *
     * @param obj the object to compare
     * @return {@code true} if the cards are equal, {@code false} otherwise
     */
    public boolean equals(Object obj) {
        Card temp = (Card) obj;
        return (suit == temp.getSuitInt()) && (rank == temp.getRank());
    }

    /**
     * Returns a string representation of the card in the format:
     * "Rank of Suit"
     *
     * @return a formatted string describing the card
     */
    public String toString() {
        return ranks[rank] + " of " + suits[suit];
    }
}
