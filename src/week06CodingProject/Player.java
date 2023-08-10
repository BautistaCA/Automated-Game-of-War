package week06CodingProject;

import java.util.ArrayList;
import java.util.List;

public class Player {
List<Card> hand = new ArrayList<Card>();
int score = 0;
String playerName;


public void describeHand(){
	StringBuilder fullHand = new StringBuilder();
	for (int i = 0; i < (this.hand.size()); i++) {
//		String cardInHand =
fullHand.append(this.hand.get(i).setCardDescribe(hand.get(i).getCardName(), hand.get(i).getCardSuit(), hand.get(i).getCardValue()));
	fullHand.append('\n');
	}
		System.out.println(this.playerName + '\n' + "Score: " + score + '\n' + fullHand);
}
public int getScore() {
	return score;
}
public void setScore(int score) {
	this.score = score;
}
public Card flip() {
	Card card = this.hand.remove(0);
	StringBuilder cardStats = new StringBuilder();
	cardStats.append(card.setCardDescribe(card.getCardName(), card.getCardSuit(), card.getCardValue()));
	System.out.println(playerName + "'s Card: " + cardStats);
	return card;
}
public void drawCard(Deck deck) {
	this.hand.add(deck.draw());
}
public String getPlayerName() {
	return playerName;
}
public void setPlayerName(String playerName) {
	this.playerName = playerName;
}
public void incrementScore() {
this.score+=1;
System.out.println(getPlayerName() + "'s Score: " + this.score);
		}

}
