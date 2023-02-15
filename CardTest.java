package mru.game.controller;
import org.junit.Test;
import static org.junit.Assert.*;
// Ensure you can create a card and get its suit, rank and correct string representation (especially Jack, Queen, King, Ace)
//

public class CardTest {
    
    @Test
    public void testCard() {
        Card card1 = new Card(0, null);
        card1.setSuit("Clubs"); 
        card1.setRank(1);
        assertEquals("Clubs", card1.getSuit());
        assertEquals(1, card1.getRank());
        assertEquals("Ace of Clubs", card1.toString());
        
        Card card2 = new Card(0, null);
        card2.setSuit("Hearts");
        card2.setRank(13);
        assertEquals("Hearts", card2.getSuit());
        assertEquals(13, card2.getRank());
        assertEquals("King of Hearts", card2.toString());
        
        Card card3 = new Card(0, null);
        card3.setSuit("Spades");
        card3.setRank(11);
        assertEquals("Spades", card3.getSuit());
        assertEquals(11, card3.getRank());
        assertEquals("Jack of Spades", card3.toString());
        
        Card card4 = new Card(0, null);
        card4.setSuit("Diamonds");
        card4.setRank(12);
        assertEquals("Diamonds", card4.getSuit());
        assertEquals(12, card4.getRank());
        assertEquals("Queen of Diamonds", card4.toString());
    }
}



