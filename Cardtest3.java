package mru.game.controller;
//Create a new deck of cards and shuffle it and get a different arrangement of cards each time

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

public class Cardtest3 {

    @Test
    public void testNewDeck() {
        // create a new deck of cards
        ArrayList<Card> deck = new ArrayList<Card>();
        for (int i = 1; i <= 13; i++) {
            Card card1 = new Card(i, null);
            card1.setRank(i);
            card1.setSuit("Diamonds");
            deck.add(card1);

            Card card2 = new Card(i, null);
            card2.setRank(i);
            card2.setSuit("Hearts");
            deck.add(card2);

            Card card3 = new Card(i, null);
            card3.setRank(i);
            card3.setSuit("Clubs");
            deck.add(card3);

            Card card4 = new Card(i, null);
            card4.setRank(i);
            card4.setSuit("Spades");
            deck.add(card4);
        }

        // shuffle the deck
        Collections.shuffle(deck);

        // draw all cards from the deck
        for (int i = 0; i < 52; i++) {
            Card card = deck.get(i);
            System.out.println(card.toString());
        }

        // check if the deck behaves as expected when the last card is drawn
        assertEquals(52, deck.size());
        Card lastCard = deck.get(51);
        deck.remove(51);
        assertFalse(deck.contains(lastCard));
        assertEquals(51, deck.size());
    }
}

