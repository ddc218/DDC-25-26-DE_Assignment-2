/**
 * David De Costa
 * CS 876 
 * Assignment 2
 * 10/24/25
 */
public class CardComparatorBySuit {
	public int compare(Card c1, Card c2) {
		return c1.getSuitInt() - c2.getSuitInt();
	}
}
