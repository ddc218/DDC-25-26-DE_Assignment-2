/**
 * David De Costa
 * CS 876 
 * Assignment 2
 * 10/8/25
 * 
 * This class represents a Deck of cards. 
 */
import java.util.Random;

public class Deck {
	private Card[] cards;
	private int topCard;
	
	/**
	 * Default constructor.
	 * Creates a full, sorted deck of 52 cards (by suit then rank).
	 */
	public Deck() {
		cards = new Card[52];
		int index = 0;
		for (int s = 0; s < 4; s++) {
			for (int r = 1; r <= 13; r++) {
				cards[index] = new Card(s, r);
				index++;
			}
		}
		topCard = 51;
	}
	
	/**
	 * Constructor that creates either a sorted or shuffled deck.
	 * @param  whether or not deck will be shuffled
	 */
	public Deck(boolean sorted) {
		this();
		if (sorted == false) {
			shuffle();
		}
	}
	
	/**
	 * Copy constructor.
	 * @param another the deck to copy
	 */
	public Deck(Deck other) {
		this.cards = new Card[other.cards.length];
		for (int i = 0; i <= other.topCard; i++) {
			this.cards[i] = new Card(other.cards[i]);
		}
		this.topCard = other.topCard;
	}
	
	/**
	 * Shuffles the deck.
	 */
	public void shuffle() {
		Random rand = new Random();
		for (int i = topCard; i > 0; i--) {
			int j = rand.nextInt(i + 1);
			Card temp = cards[i];
			cards[i] = cards[j];
			cards[j] = temp;
		}
	}
	
	/**
	 * Returns the index of the card at the top of the deck.
	 * @return the index of the card at the top of the deck
	 */
	public int getTopCard() {
		return topCard;
	}
	
	/**
	 * Deals cards.
	 * @param # of hands to deal
	 * @param # of cards per hand
	 * @return array of decks per hand or null if not enough cards
	 */
	public Deck[] deal(int hands, int cardsPerHand) {
		int totalCardsNeeded = hands * cardsPerHand;
		if (totalCardsNeeded > topCard + 1) {
			return null;
		}
		
		Deck[] dealtHands = new Deck[hands];
		for (int i = 0; i < hands; i++) {
			dealtHands[i] = new Deck();
			dealtHands[i].cards = new Card[cardsPerHand];
			dealtHands[i].topCard = cardsPerHand - 1;
			
			for (int j = 0; j < cardsPerHand; j++) {
				dealtHands[i].cards[j] = cards[topCard];
				topCard--;
			}
		}
		return dealtHands;
	}
	
	/**
	 * Picks and removes a random card from the deck.
	 * @return the removed card
	 */
	public Card pick() {
		if (topCard < 0) return null;
		
		Random rand = new Random();
		int index = rand.nextInt(topCard + 1);
		Card picked = cards[index];
		
		// Collapse the array
		for (int i = index; i < topCard; i++) {
			cards[i] = cards[i + 1];
		}
		cards[topCard] = null;
		topCard--;
		return picked;
	}
	
	/**
	 * Checks if two decks are equal (same cards in same order).
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof Deck)) return false;
		Deck other = (Deck) obj;
		
		if (this.topCard != other.topCard) return false;
		
		for (int i = 0; i <= topCard; i++) {
			if (!this.cards[i].equals(other.cards[i])) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * String representation of the deck.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (topCard == 51) {
			for (int r = 1; r <= 13; r++) {
				for (int s = 0; s < 4; s++) {
					sb.append(String.format("%-20s", new Card(s, r).toString()));
				}
				sb.append("\n");
			}
		} else {
			for (int i = 0; i <= topCard; i++) {
				sb.append((i + 1) + ". " + cards[i].toString() + "\n");
			}
		}
		return sb.toString();
	}
	
	/**
	 * Performs a selection sort on the deck.
	 */
	public void selectionSort() {
		for (int i = 0; i <= topCard; i++) {
			int minIndex = i;
			for (int j = i + 1; j <= topCard; j++) {
				if (cards[j].compareTo(cards[minIndex]) < 0) {
					minIndex = j;
				}
			}
			Card temp = cards[i];
			cards[i] = cards[minIndex];
			cards[minIndex] = temp;
		}
	}
	
	/**
	 * Performs a merge sort on the deck.
	 */
	public void mergeSort() {
		if (topCard <= 0) return;
		cards = mergeSortHelper(cards, 0, topCard);
	}
	
	private Card[] mergeSortHelper(Card[] arr, int left, int right) {
		if (left == right) {
			Card[] single = new Card[1];
			single[0] = arr[left];
			return single;
		}
		
		int mid = (left + right) / 2;
		Card[] leftArr = mergeSortHelper(arr, left, mid);
		Card[] rightArr = mergeSortHelper(arr, mid + 1, right);
		return merge(leftArr, rightArr);
	}
	
	private Card[] merge(Card[] leftArr, Card[] rightArr) {
		Card[] merged = new Card[leftArr.length + rightArr.length];
		int i = 0, j = 0, k = 0;
		
		while (i < leftArr.length && j < rightArr.length) {
			if (leftArr[i].compareTo(rightArr[j]) <= 0) {
				merged[k++] = leftArr[i++];
			} else {
				merged[k++] = rightArr[j++];
			}
		}
		
		while (i < leftArr.length) {
			merged[k++] = leftArr[i++];
		}
		while (j < rightArr.length) {
			merged[k++] = rightArr[j++];
		}
		
		return merged;
	}
}
