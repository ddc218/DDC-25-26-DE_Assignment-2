/**
 * David De Costa
 * CS 876 
 * Assignment 2
 * 10/24/25
 * 
 * This class represents a Card object. 
 */
public class Card {
	private int suit;
	private int rank;
	
	private static final String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades", "invalid suit"};
	private static final String[] ranks = {"invalid rank", "Ace", "Two", "Three", "Four", "Five", "Six", 
			"Seven", "Eight", "Nine", "Ten", "Jack","Queen", "King"};
	
	public Card() {
		suit = 0;
		rank = 1;
	}
	
	public Card(int s, int r) {
		suit = s;
		rank = r;
	}
	
	public Card(String s, String r) {
    	s = s.toLowerCase();
    	r = r.toLowerCase();
    	
    	if (s.equals("clubs")) {
    		suit = 0;
    	}
    	if (s.equals("diamonds")) {
    		suit = 1;
    	}
    	if (s.equals("hearts")) {
    		suit = 2;
    	}
    	if (s.equals("spades")) {
    		suit = 3;
    	}
    	else {
    		suit = 4;
    	}
    	
    	if (r.equals("ace")) {
    		rank = 1;
    	}
    	if (r.equals("jack")) {
    		rank = 11;
    	}
    	if (r.equals("queen")) {
    		rank = 12;
    	}
    	if (r.equals("king")) {
    		rank = 13;
    	}
    	else {
    		rank = 0;
    	}
	}
	
	public Card(String s, int r) {
    	s = s.toLowerCase();
    	
    	if (s.equals("clubs")) {
    		suit = 0;
    	}
    	if (s.equals("diamonds")) {
    		suit = 1;
    	}
    	if (s.equals("hearts")) {
    		suit = 2;
    	}
    	if (s.equals("spades")) {
    		suit = 3;
    	}
    	else {
    		suit = 4;
    	}
    	
    	rank = r;
	}
	
	public Card(int s, String r) {
    	r = r.toLowerCase();
    	
    	suit = s;
    	
    	if (r.equals("ace")) {
    		rank = 1;
    	}
    	if (r.equals("jack")) {
    		rank = 11;
    	}
    	if (r.equals("queen")) {
    		rank = 12;
    	}
    	if (r.equals("king")) {
    		rank = 13;
    	}
    	else {
    		rank = 0;
    	}
	}
	
	public Card(Card card2) {
		suit = card2.getSuitInt();
		rank = card2.getRank();
	}
	
	
	public String getSuit(){
		return (suits[suit]);
	}
	
	public int getSuitInt() {
		return rank;
	}
	
	
	
	public int getRank() {
		return rank;
	}
	
	public String getRankStr() {
		return (ranks[rank]);
	}
	
	public int compareTo(Card card2) {
		if (suit != card2.getSuitInt()) { 
			return suit - card2.getSuitInt();
		}
		return rank - card2.getSuitInt();
	}
	
	public boolean equals(Object obj) {
		Card temp = (Card) obj;
		return (suit == temp.getSuitInt()) && (rank == temp.getRank());
	}
	
    
    public String toString() {
        return ranks[rank] + " of " + suits[suit];
    }
	
}
