package week06CodingProject;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Starting the Game!" + '\n' + '\n' + "Initializing Deck..." + '\n' + '\n'
				+ "Shuffling the Deck..." + '\n');
		Deck gameTest = new Deck();
		gameTest.shuffle(); //remove this to use tieTest ***(see below)

		gameTest.describe();
		Player player1 = new Player();
		player1.setPlayerName("Player 1");
		Player player2 = new Player();
		player2.setPlayerName("Player 2");
		System.out.println('\n' + "Divvying Up the Deck..." + '\n');
		//---------------------------------------------------------
		//***
		//At the time of me doing this project, I was still learning how to unit test,
		//so i had brute-forced a test to check my code, creating the method tieTest
		//		tieTest(gameTest, player1, player2);
		//---------------------------------------------------------
		//----remove this loop to use tieTest---
		for (int i = 1; i < 27; i++) {
			player1.drawCard(gameTest);
			player2.drawCard(gameTest);
		//--------------------------------------
			// --- This was to keep track of what was being drawn ---
//	System.out.println('\n' + "Draw: " + i);
//	gameTest.describe();
//	System.out.println('\n');
			// ------------------------------------------------------

		}
//player1.drawCard(gameTest);
//player2.drawCard(gameTest);
		player1.describeHand();
		player2.describeHand();
		System.out.println('\n' + "Game START!" + '\n');
		int round = 1;
//-----------Start of the game-----------
		for (int i = 26; i > 0; i--) { // up to 26 rounds
			// --- This was originally for making sure the game didn't end with cards being
			// unused---
			// System.out.println((player1.hand.size() + player2.hand.size()));
			// --------------------------------------------------------------------------------------

			System.out.println("Round " + round + "!" + '\n' + "Each player has " + (player1.hand.size())
					+ " card(s) in their hand!" + '\n' + "Draw Your Cards!" + '\n');
//	System.out.println("Each player has " + (player1.hand.size()) + " card(s) in their hand!");
			round++;
//	System.out.println("Checking" + i);
			int cardSum = 0;
			cardSum += player1.flip().cardValue - player2.flip().cardValue; // Start of the 3 main possible loops
			// System.out.println(cardSum);
			if ((cardSum == 0) && (player1.hand.size() >= 4)) { // Start of the equal cards loop
				System.out.println('\n'+ "It's a tie!?!" +'\n' + "This Means WAR!!!" + '\n' + "Draw your Army!!");
				System.out.println('\n' + "Player 1's Soldiers: ");
				for (int draw = 1; (draw < 4) && ((player1.hand.size() + player2.hand.size()) != 0); draw++) {
//there was one scenario in which the equal cards loops crashes the app due to both players having less than 4 cards in their hand,
// I've fixed it though ***(see above)					
					player1.flip();
					i--;
					// System.out.println("Checking" + i);
				}
				System.out.println('\n' + "Player 2's Soldiers:");
				for (int draw2 = 1; draw2 < 4; draw2++) {
					player2.flip();
				}
				System.out.println('\n' + "Who wins this WAR?!?" + '\n' + "DRAW!!!" + '\n');
				if ((player1.hand.size() + player2.hand.size()) != 0) {
					cardSum += player1.flip().cardValue - player2.flip().cardValue;
					i--;
				} 
				//--didn't need this else block anymore, kept it in for reference sake--
				// else {
					// System.out.println(winningLine(player1.score, player2.score, player1,
					// player2));
					// System.out.println("This is a test");
				// }
				// System.out.println(cardSum);
				//-----------------------------------------------------------------------
			}
			// should be the end of the loop
			if (cardSum > 0) { // player 1 wins the round
				System.out.println('\n');
				System.out.println("Player 1 Wins this Round!");
				player1.incrementScore();
				System.out.println(player2.getPlayerName() + "'s Score: " + player2.getScore());
				System.out.println('\n');
			} else if (cardSum == 0) {//This works even if the tiebreaker ends early ***
				System.out.println("Its a tie! No points awarded." + '\n');

			} else { // player 2 wins wins the round
				System.out.println('\n');
				System.out.println("Player 2 Wins this Round!");
				System.out.println(player1.getPlayerName() + "'s Score: " + player1.getScore());
				player2.incrementScore();
				System.out.println('\n');
			}

		}
//player1.describeHand();
//player2.describeHand();
		System.out.println(winningLine(player1.score, player2.score, player1, player2)); // End of the game
//--Turned this into the winningLine method--
//	System.out.println("Game Over!");	
//	player1.describeHand();
//	if (player1.score == player2.score) { //|| player1.hand.size() == 0
//	System.out.println("It's a tie! No Contest.");
//} else if (player1.score > player2.score) {
//	System.out.println("Player 1 Wins the Game!");
//} else {
//	System.out.println("Player 2 Wins the Game!");
//}
//-------------------------------------------
	}

	public static StringBuilder winningLine(int scoreOne, int scoreTwo, Player p1, Player p2) {
		StringBuilder win = new StringBuilder();
		win.append("Game Over!");
		win.append('\n');
		win.append(p1.getPlayerName());
		win.append("'s Score: " + p1.score + '\n');
		win.append(p2.getPlayerName());
		win.append("'s Score: " + p2.score + '\n');
		int compare = scoreOne - scoreTwo;
		if (compare == 0) {
			win.append("It's a tie! No Contest.");
		} else if (compare > 0) {
			win.append("Player 1 Wins the Game!");
		} else {
			win.append("Player 2 Wins the Game!");
		}
		return win;
	}

	public static void tieTest(Deck deck, Player p1, Player p2) {
		for (int i = 26; i > 0; i--) {
			p1.drawCard(deck);
		}
		for (int i = 26; i > 0; i--) {
			p2.drawCard(deck);
		}
	}
}

//System.out.println(player2.getPlayerName() + "'s Score: " + player2.getScore());