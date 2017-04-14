package project_part_5;

public class Player {
	private String playerName;
	private int gamesPlayed;
	private int assists;
	private int pointsScored;
	private int rebounds;
	private int steals;
	
	public Player() {}
	public Player(String name){
		playerName = name;
	}
	
	public String getPName() {return playerName;}
	public int getGamesPlayed() {return gamesPlayed;}
	public int getPoints() {return pointsScored;}
	public int getAssists() {return assists;}
	public int getRebounds() {return rebounds;}
	public int getSteals() {return steals;}
	
	public void setPName(String name) {
		if(name.length() > 0)
			playerName = name;
	}
	
	
	/*
	Should we have it add based on an "after each game" basis
	(i.e. gamesPlayed += 1 instead of just gamesPlayed = 2 for the second game)
	Then we could have a reset method if they needed to go back to zero and add a final number.
	*/
	public void setGamesPlayed(int num) {
		if(num >= 0)
			gamesPlayed = num;
	}
	
	public void setAssists(int num) {
		if(num >= 0)
			assists = num;
	}
	
	public void setPoints(int num) {
		if(num >= 0)
			pointsScored = num;
	}
	
	public void setRebounds(int num) {
		if(num >= 0)
			rebounds = num;
	}
	
	public void setSteals(int num) {
		if(num >= 0)
			steals = num;
	}
	
	public String toString() {
		String output = "";
		
		output += "Player: " + playerName + "\n\n";
		output += "Games played: " + gamesPlayed + "\n";
		output += "Points Scored (total): " + pointsScored + "\n";
		output += "Assists: " + assists + "\n";
		output += "Rebounds: " + rebounds + "\n";
		output += "Steals: " + steals + "\n";
		
		return output;
	}
}
