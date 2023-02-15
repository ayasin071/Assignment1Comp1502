
package mru.game.controller;
import org.junit.Test;
import static org.junit.Assert.*;
// Ensure you can create a hand of cards, add cards to it, and compute its score
import java.util.ArrayList;


public class CardTest2 {
@Test
public void testCard() {
    // create a new hand
    ArrayList<Card> hand = new ArrayList<Card>();

    // add some cards to the hand
    Card card1 = new Card(0, null);
    card1.setRank(10);
    card1.setSuit("Diamonds");
    hand.add(card1);

    Card card2 = new Card(0, null);
    card2.setRank(5);
    card2.setSuit("Hearts");
    hand.add(card2);

    Card card3 = new Card(0, null);
    card3.setRank(9);
    card3.setSuit("Spades");
    hand.add(card3);

    // compute the score
    int score = 0;
    for (Card card : hand) {
        int rank = card.getRank();
        if (rank >= 2 && rank <= 9) {
            score += rank;
        } else if (rank == 1) { // Ace
            score += 1;
        }
    }
    score = score % 10; // take the last digit

    // check the score
    assertEquals(4, score);
}
}


