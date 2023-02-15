package mru.game.view;

import java.util.ArrayList;
import java.util.Scanner;

import mru.game.controller.Card;
import mru.game.model.Player;
public class AppMenu {

	/**
	 * This class will be used to show the menus and sub menus to the user
	 * It also prompts the user for the inputs and validates them 
	 */
	Scanner input; 
	
	public AppMenu() {
		input = new Scanner(System.in);
	
	}
	
	private char getOption() {
		char c=' ';
		while (c==' ' ) {
		
			String option = input.nextLine().toUpperCase();
			if (option.length()==0) { c= ' ';}
			else
			{c = option.charAt(0);}
		
		}
		return c;
		
	}
	public char showMainMenu() {
		System.out.println("Select one of these options:\n");
		System.out.println("\t(P) Play game");
		System.out.println("\t(S) Search");
		System.out.println("\t(E) Exit\n");
		System.out.println("Enter a choice here:");
		return getOption();
	}
	
	public char showSubMenu() {
		System.out.println("Select one of these options:\n");
		System.out.println("\t(T) Top player(Most number of wins)");
		System.out.println("\t(S) Look for a name");
		System.out.println("\t(B) Back to Main menu\n");
		System.out.println("Enter a choice here:");
		return getOption();
	}
	
	public String prompName() {
		System.out.print("Enter a name here:");
		String name = input.nextLine().trim();
		return name;
	}
	
	public void showPlayer(Player  ply) {
		System.out.println(ply);
		System.out.println("             - PLAYER INFO -       ");
		System.out.println("+==================+============+==================+");
		System.out.println("|NAME              |# WINS      |BALANCE           |");
		System.out.println("+==================+============+==================+");
		System.out.printf("|%-5s             |%-4d        |%-5d             |\n",ply.GetName() ,ply.GetWins() ,ply.GetBalance());
		System.out.println("+==================+============+==================+\n");
		System.out.println("Press (Enter) to continue...");
		input.nextLine();
	}
	public void showTopPlayer(ArrayList <Player> topPly) {
		System.out.println("          - TOP PLAYER -       ");
		System.out.println("+==================+==================+");
		System.out.println("|NAME              |# WINS            |");
		System.out.println("+==================+==================+");
		for (Player p: topPly) {
			System.out.printf("|%-7s           |%-4d              |\n",p.GetName(),p.GetWins());
			System.out.println("+------------------+------------------+");
		
		}
		System.out.println("Press (Enter) to continue...");
		input.nextLine();
	}
	
	public char showBet() {
		System.out.println("Who do you want to bet on?\n");
		System.out.println("\t(P) Player Wins");
		System.out.println("\t(B) Banker Wins");
		System.out.println("\t(T) tie Game\n");
		System.out.println("Enter a choice here:\n");
		return getOption();
	}
	public void welcome(String name , int balance , boolean isnew) {
		System.out.println("*************************************************************************");
		if (isnew) {
			System.out.printf("***  Welcome %-7s             ---   Your balence is:%-4d           ***\n",name , balance);
		}else {
			System.out.printf("***  Welcome back %-7s           ---   Your balence is:%-4d        ***\n",name , balance);
		}
		System.out.println("*************************************************************************\n");
	}
	public int betAmount() {
		System.out.println("How much do you want to bet this round?");
		int option = input.nextInt();
		return option;
	}
	public void puntoRuselts(ArrayList<Card> playerCards, ArrayList<Card> bankerCards, int playerSum, int bankerSum) {
		System.out.println("          - PUNTO BANCO -       ");
		System.out.println("+===================+===================+");
		System.out.println("|PLAYER             |BANKER             |");
		System.out.println("+===================+===================+");
		for (int n=0; n<playerCards.size(); n++ ) {
			System.out.printf("| %-7s     | %-7s        |\n",playerCards.get(n),bankerCards.get(n));
			System.out.println("+-------------------+-------------------+");
		}
		System.out.printf("|%-7s            |%-4d               |\n", playerSum , bankerSum);
		System.out.println("+===================+===================+\n");
		
	}
	public char PlayAgin() {
	System.out.println("Do you want to play again(Y/N)?");
	return getOption();
	}
	
}
