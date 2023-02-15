package mru.game.model;

public class Player {
	
	/**
	 * This class represent each player record in the Database
	 * It is basically a model class for each record in the txt file
	 */
	private String name;
	private int balance;
	private int wins;
	
	public Player(String name, int balance, int wins) {
		this.name = name;
		this.balance = balance;
		this.wins = wins;
		
		
	}
	public String GetName() {
		return name;
	}
	public int GetBalance() {
		return balance;
	}
	public int GetWins() {
		return wins;
	}
	public void AddWins() {
		wins = wins + 1;
	}
	public void AdjustBalance(int amout) {
		balance = balance + amout;
	}
	
	public String format() {
		return name+"," +balance+ "," +wins;
		
	}
	
}
