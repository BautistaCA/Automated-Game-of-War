package week06CodingProject;

public class Card {
	String cardName;
	String cardSuit;
	int cardValue;
	
	Card(String name,String suit, int value){
		this.cardName = name;
		this.cardSuit = suit;
		this.cardValue = value;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public int getCardValue() {
		return cardValue;
	}

	public void setCardValue(int cardValue) {
		this.cardValue = cardValue;
	}
	public String getCardSuit() {
		return cardSuit;
	}

	public void setCardSuit(String cardSuit) {
		this.cardSuit = cardSuit;
	}
	public StringBuilder setCardDescribe(String name,String suit, int value) {
		StringBuilder describeCard = new StringBuilder();
		describeCard.append(name);
		describeCard.append(" of ");
		describeCard.append(suit);
		describeCard.append(" -- ");
		describeCard.append(value);
		return describeCard;
	}
	public void describe() {
	//System.out.println(setCardDescribe(cardName, cardSuit, cardValue));
//			StringBuilder describeCard = new StringBuilder();
	//	describeCard.append(this.cardName);
//		describeCard.append(" of ");
	//	describeCard.append(this.cardSuit);
//		describeCard.append(" -- ");
	//	describeCard.append(this.cardValue);
//		System.out.println(describeCard);
		System.out.println(this.cardName + " of " + this.cardSuit + " -- " + this.cardValue);
	}
}
