package mru.game.controller;
import java.util.ArrayList;

import mru.game.view.AppMenu;
public class PuntoBancoGame {
public PuntoBancoGame() {
}
AppMenu appMen;
int cardindex = 0;
public char Play() {
	appMen = new AppMenu();
	CardDeck deck = new CardDeck();
	ArrayList<Card> cards = deck.getDeck();
	ArrayList<Card> playerCards = new ArrayList<Card>();
	playerCards.add(getNextCard(cards));
	playerCards.add(getNextCard(cards));
	ArrayList<Card> bankerCards = new ArrayList<Card>();
	bankerCards.add(getNextCard(cards));
	bankerCards.add(getNextCard(cards));
	int playerSum = ScoreCard(playerCards);
	int bankerSum = ScoreCard(bankerCards);
	

	

	if (playerSum == 8 || playerSum == 9 || bankerSum == 8 || bankerSum == 9) {
		appMen.puntoRuselts(playerCards, bankerCards, playerSum, bankerSum);
		return Winner(playerSum , bankerSum);
	} else {
		if (playerSum >= 0 && playerSum <= 5) {
		playerCards.add(getNextCard(cards));
		playerSum = ScoreCard(playerCards);
		//System.out.println("Player's third card: " + playerCards.get(2));
		//System.out.println("Player's new score: " + playerSum);
	}
	if (playerCards.size()== 3 && (playerCards.get(2).getRank() == 2 || playerCards.get(2).getRank() == 3)) {
		if (bankerSum >= 0 && bankerSum <= 4) {
			bankerCards.add(getNextCard(cards));
			bankerSum = ScoreCard(bankerCards);
			//System.out.println("Banker's third card: " + bankerCards.get(2));
			//System.out.println("Banker's new score: " + bankerSum);
		}
	} else if (playerCards.size()== 3 && (playerCards.get(2).getRank() == 4 || playerCards.get(2).getRank() == 5)) {
		if (bankerSum >= 0 && bankerSum <= 5) {
			bankerCards.add(getNextCard(cards));
			bankerSum = ScoreCard(bankerCards);
			//System.out.println("Banker's third card: " + bankerCards.get(2));
			//System.out.println("Banker's new score: " + bankerSum);
		}
		
	} else if (playerCards.size()== 3 && (playerCards.get(2).getRank() == 6 || playerCards.get(2).getRank() == 7)) {
		if (bankerSum >= 0 && bankerSum <= 6) {
			bankerCards.add(getNextCard(cards));
			bankerSum = ScoreCard(bankerCards);
			//System.out.println("Banker's third card: " + bankerCards.get(2));
			//System.out.println("Banker's new score: " + bankerSum);
		}
	} else if (playerCards.size()== 3 && (playerCards.get(2).getRank() == 8)) {
		if (bankerSum >= 0 && bankerSum <= 6) {
			bankerCards.add(getNextCard(cards));
			bankerSum = ScoreCard(bankerCards);
			//System.out.println("Banker's third card: " + bankerCards.get(2));
			//System.out.println("Banker's new score: " + bankerSum);
		}
		
	} else if (playerCards.size()== 3 && (playerCards.get(2).getRank() == 1 || playerCards.get(2).getRank() == 9)) {
		if (bankerSum >= 0 && bankerSum <= 3) {
			bankerCards.add(getNextCard(cards));
			bankerSum = ScoreCard(bankerCards);
			//System.out.println("Banker's third card: " + bankerCards.get(2));
			//System.out.println("Banker's new score: " + bankerSum);
		}
	}
	appMen.puntoRuselts(playerCards, bankerCards, playerSum, bankerSum);
	return Winner(playerSum , bankerSum);
		}
	}
	private int ScoreCard(ArrayList<Card> cards) {
		int Sum = 0;
		for (Card card : cards) {
			Sum += card.getRank();
		}
		Sum = Sum %10;
		return Sum;
	}
	private Card getNextCard(ArrayList<Card> cards) {
		Card card = cards.get(cardindex);
		cardindex++;
		return card;
	}
	private char Winner(int playerSum , int bankerSum) {	
		if (playerSum > bankerSum) {
				return 'P';
			} else if (bankerSum > playerSum) {
				return 'B';
			} else {
				return 'T';
				}

	}
}


