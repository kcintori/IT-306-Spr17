public class Team {
	private String teamName;
	private int playerCount;
	private String teamColor;
	private String teamCoach;
	private Player[] players;
	private int arrayCount = 0;
	
	public Team() {
		players = new Player[15];
	}
	
	public Team(String name, String coach) {
		this();
		teamName = name;
		teamCoach = coach;
	}
	
	public String getTName() {return teamName;}
	public int getPlayerCount() {return playerCount;}
	public String getTColor() {return teamColor;}
	public String getTCoach() {return teamCoach;}
	public Player[] getPlayers() {return players;}
	
	public void setTName(String name) {
		if(name.length() > 0)
			teamName = name;
	}
	
	//The user should only be able to set the number of players to an appropriate team size
	//which is between 6 and 15, inclusive. There is a separate counter for the array.
	public void setPlayerCount(int count) {
		if(count >= 6)
			if(count <= 15)
				playerCount = count;
	}
	
	public void setTColor(String color) {
		if(color.length() > 0) 
			teamColor = color;
	}
	
	public void setTCoach(String newCoach) {
		teamCoach = newCoach;
	}
	
	public void addPlayer(Player newPlayer){
		players[arrayCount++] = newPlayer;
	}
	
	public String toString() {
		String output = "";
		output = "Team name: " + teamName + "\n";
		output = "Coach: " + this.teamCoach + "\n";
		output = "Team size: " + playerCount + "\n";
		output = "No. players currently on roster: " + arrayCount + "\n";
		output = "Team color: " + teamColor;
		
		return output;
	}
	
}
