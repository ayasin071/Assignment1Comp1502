package mru.game.controller;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*; 
import mru.game.model.Player;
import mru.game.view.AppMenu;

public class GameManager {
	

	/* In this class toy'll need these methods:
	 * A constructor
	 * A method to load the txt file into an arraylist (if it exists, so you check if the txt file exists first)
	 * A save method to store the arraylist into the the txt file 
	 * A method to search for a player based their name
	 * A method to find the top players
	 * Depending on your designing technique you may need and you can add more methods here 
	 */
	private final String FILE_PATH = "Assignment 1 - Skeleton/res/CasinoInfo.txt";
	private ArrayList <Player> listOfPlayers;
	AppMenu appMen;
	
	
	
	public GameManager() throws IOException{
		listOfPlayers = new ArrayList<>();
		appMen = new AppMenu();
		try {
			loadData();
		}catch(Exception ee) {
			System.out.print("file not found");
		}
		lunchApplication();
		
	
		
	}
	private void lunchApplication() throws IOException {
		boolean flag = true;
		char option;
		while (flag) {
			option = appMen.showMainMenu();
			switch (option) {
			case 'P':
				PlayGame();
				break;
			case 'S':
				 Search();
				 break;
			case 'E':
				Save();
				flag = false;
				break;
			
			}
		
		}
		
	}
	
	private void PlayGame() {
		String name = appMen.prompName();
		Player plyr = checkUser(name);
		if (plyr == null) {
			plyr = new Player(name , 100 , 0);
			listOfPlayers.add(0, plyr);
			appMen.welcome(name , 100 , true);
		
		}else {
			appMen.welcome(plyr.GetName(), plyr.GetBalance(), false);
		}
			char betOn = appMen.showBet();
			int bet = appMen.betAmount();
			
			PuntoBancoGame PbGame = new PuntoBancoGame();
			char winner = PbGame.Play();
			if (winner == betOn){
				if (betOn == 'T') {
					bet = bet * 5;
				}
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				System.out.printf("$       PLAYER WON %-4d        $\n", bet);
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");
				plyr.AddWins();
				plyr.AdjustBalance(bet);
			}
			else {
					System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
					System.out.printf("$       PLAYER LOST %-4d       $\n", bet);
					System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");
					plyr.AdjustBalance(- bet);
			}
			Store(plyr);
			char Again = appMen.PlayAgin();
			
		
	}
	private void Store(Player ply) {
		for (Player p: listOfPlayers) {
			String name = p.GetName();
			if (name.equals(ply.GetName())){
				p = ply;
			
			}
		}
	}
	private Player checkUser(String user) {
		for (Player p: listOfPlayers) {
			String name = p.GetName();
			if (name.equals(user)){
				return p;
			
			}
		
		}
		return null;
	}
	private void Search() {
		char option = appMen.showSubMenu();
		
		switch (option) {
		case 'T':
			ArrayList <Player> topPly = FindTopPlayer();
			appMen.showTopPlayer(topPly);
			break;
		case 'S':
			 Player ply = lookingByName();
			 appMen.showPlayer(ply);
			 break;
		case 'B':
			break;
		}
	}

	private ArrayList <Player> FindTopPlayer() {
		ArrayList <Player> listOfTopPly;
		listOfTopPly = new ArrayList<>();
		int highest = 0;
		for (Player p: listOfPlayers) {
			if (p.GetWins() > highest){
				highest = p.GetWins();

			
			}
				
		}
		for (Player p: listOfPlayers) {
			if (p.GetWins() == highest){
				listOfTopPly.add(p);

			}
				
		}
		return listOfTopPly;
	}
	
	
	private Player lookingByName() {
		String name = appMen.prompName();
		Player ply = null;
		for (Player p: listOfPlayers) {
			if (p.GetName().equals(name)){
				ply = p; 
				break;
			
			}
				
		}
		return ply;
			
	}
	private void Save() throws IOException {
		File info = new File(FILE_PATH);
		PrintWriter pw = new PrintWriter(info);
		
		for (Player p: listOfPlayers) {
			pw.println(p.format());
		}
		pw.close();
	}

	public void loadData() throws Exception {
		File info = new File(FILE_PATH);
		String currentLine;
		String[] splittedLine;
		
		if(info.exists()) {
			Scanner fileReader = new Scanner(info);
			while (fileReader.hasNextLine()){
				currentLine = fileReader.nextLine();
				splittedLine = currentLine.split(",");
				Player newPlayer = new Player(splittedLine[0],Integer.parseInt(splittedLine[1]), Integer.parseInt(splittedLine[2]));
				listOfPlayers.add(newPlayer);
			}
			fileReader.close();
		}
		
	}	
}
	
		

	


