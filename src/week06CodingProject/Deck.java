package week06CodingProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
List<Card> cards = new ArrayList<Card>();
Deck() {
	String[] cardSuits = {"Clubs", "Diamonds", "Hearts", "Spades"};
	String[] cardNumbers = { "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
	for (String cardSuit : cardSuits) {
		int counter = 2;
		for (String cardNumber : cardNumbers) {
			Card card = new Card(cardNumber, cardSuit, counter);
			this.cards.add(card);
			counter++;
		}
	}
}
public List<Card> getCards() {
	return cards;
}
public void setCards(List<Card> cards) {
	this.cards = cards;

}

public void describe() {
for (Card card: this.cards) {
	card.describe();
}
}


public void shuffle() {
Collections.shuffle(cards);
}
public Card draw() {
Card card = this.cards.remove(0);
return card;
}
}
