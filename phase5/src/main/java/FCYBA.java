//import com.sun.codemodel.internal.JOp;

import javax.swing.*;
import java.util.IllegalFormatException;

/**
 * Created by nidas on 4/14/17.
 */
public class FCYBA {
    public static void main (String[] args)
    {
        Coach coach = new Coach();
        Team team = new Team();
        Player[] players = new Player[12];

        final int MAX_PLAYERS = 15;


        JOptionPane.showMessageDialog(null,"Welcome to the Fairfax County Youth Basketball Association (FCYBA) Team" +
                "Management software. Please login with your credentials.");

        createExistingUserData(coach, team, players, MAX_PLAYERS);

    }

    public static void createExistingUserData(Coach coach, Team team, Player[] players, int MAX_PLAYERS)
    {
        coach = new Coach("coach@coaches.com", "password");
        coach.setCoachName("John Smithson");
        coach.setCoachPhone("703-111-1111");

        int count = 0;
        int counter = 0;

       for(counter = 0; counter > MAX_PLAYERS; counter ++) {
           players[counter] = new Player();
           count++;
           players[counter].setPName("John Smith" + count);
           players[counter].setGamesPlayed(5 + count);
           players[counter].setPoints(5 + count);
           players[counter].setAssists(6 + count);
           players[counter].setRebounds(7 + count);
           players[counter].setSteals(8 + count);
           players[counter].setPassword("password");
       }

        team = new Team();
        for(int x = 0; x > players.length; x++)
        {
            team.addPlayer(players[x]);
        }
        team.setPlayerCount(players.length);
        team.setTCoach(coach.getCoachName());
        team.setTColor("blue");
        team.setTName("FCYBA");

        loginPage(coach, players, counter);
    }

    public static void loginPage(Coach coach, Player[] players, int counter)
    {
        int reply = JOptionPane.showConfirmDialog(null, "Are you the coach?");

        if(reply == JOptionPane.YES_OPTION)
        {
            JPanel fields= new JPanel();
            JTextField usernameField = new JTextField(10);
            JTextField passwordField = new JTextField(10);
            fields.add(new JLabel("Username:"));
            fields.add(usernameField);
            fields.add(new JLabel("\nPassword:"));
            fields.add(passwordField);

            String username = usernameField.getText();
            String password = passwordField.getText();

            try
            {
                boolean bool = false;
                while(bool == false)
                {
                    JOptionPane.showMessageDialog(null, fields);
                    username = usernameField.getText();
                    password = passwordField.getText();
                    if (username.equals("")) {
                        JOptionPane.showMessageDialog(null, "Your username field cannot be blank.");
                        bool = false;
                    }
                    else if (password.equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Your password field cannot be blank.");
                        bool = false;
                    }
                    if(coach.getCoachEmail().equals(username) && coach.getPassword().equals(password))
                    {
                        coachMenu(coach);
                    }
                    else
                    {
                        bool = false;
                    }
                }

            }
            catch (IllegalFormatException e)
            {
                JOptionPane.showMessageDialog(null, "Error occurred.");
            }
        }
        else if(reply == JOptionPane.NO_OPTION)
        {
            JPanel fields= new JPanel();
            JTextField usernameField = new JTextField(10);
            JTextField passwordField = new JTextField(10);
            fields.add(new JLabel("Username:"));
            fields.add(usernameField);
            fields.add(new JLabel("\nPassword:"));
            fields.add(passwordField);

            String username = usernameField.getText();
            String password = passwordField.getText();

            try
            {
                boolean bool = false;
                while(bool == false)
                {
                    JOptionPane.showMessageDialog(null, fields);
                    username = usernameField.getText();
                    password = passwordField.getText();
                    if (username.equals("")) {
                        JOptionPane.showMessageDialog(null, "Your username field cannot be blank.");
                        bool = false;
                    }
                    else if (password.equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Your password field cannot be blank.");
                        bool = false;
                    }
                    if(coach.getCoachEmail().equals(username) && coach.getPassword().equals(password))
                    {
                        playersMenu(players, counter);
                    }
                    else
                    {
                        bool = false;
                    }
                }

            }
            catch (IllegalFormatException e)
            {
                JOptionPane.showMessageDialog(null, "Error occurred.");
            }
        }
    }

    public static void coachMenu(Coach coach)
    {
        int userChoice = 0;
        try
        {
            boolean bool = false;
            while (bool == false)
            {
                userChoice = Integer.parseInt(JOptionPane.showInputDialog(null, "Welcome " + coach.getCoachName() +
                        "! \n Team Management Software \n" +
                        "Please select from the options below: \n" +
                        "1. View and edit profile \n" +
                        "2. View and edit team info \n" +
                        "3. View and edit player info \n" +
                        "4. Create, view and print reports \n" +
                        "5. Import personal file. \n" +
                        "6. Send and receive messages. \n" +
                        "7. Exit. "));
                if (userChoice > 7 || userChoice < 1) {
                    bool = false;
                    JOptionPane.showMessageDialog(null, "Please choose from the choices given.");
                } else {
                    bool = true;
                }
            }
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Error occurred.");
        }

        if(userChoice == 1)
        {
            profile(coach);
        }
        else if(userChoice == 2)
        {
            teamInfo();
        }
        else if(userChoice == 3)
        {
        	//TODO we need to get which player the coach wants to edit here.
        	playerProfile(player);
        }
        else if(userChoice == 4)
        {
            reports();
        }
        else if(userChoice == 5)
        {
            personalFile();
        }
        else if(userChoice == 6)
        {
            messages();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "You have been successfully logged out. \n Have a great day.");
            System.exit(0);
        }
    }

    public static void profile(Coach coach)
    {
        int menuChoice = -1;
    	String input = "";
    	boolean hasAt = false;
    	boolean hasDot = false;
    	
    	try{
    		do{
    		menuChoice = Integer.parseInt(JOptionPane.showInputDialog("Welcome " + coach.getCoachName() + ", \n\n"
    													+ "Please select an option: \n"
    								    				+ "1. View your profile. \n"
    													+ "2. Edit your profile."));
    		if(menuChoice != 1 && menuChoice != 2)
    			JOptionPane.showMessageDialog(null, "Please enter either a '1' or a '2'");
    		}while(menuChoice != 1 && menuChoice != 2);
    		
    	}
    	catch(NumberFormatException e){
    		JOptionPane.showMessageDialog(null, "Please enter either a '1' or a '2'");
    	}
    	
    	if(menuChoice == 1){
    		JOptionPane.showMessageDialog(null, coach.toString());
    	}
    	else if(menuChoice == 2){
    		menuChoice = -1;
    		
    		try{
        		do{
        		menuChoice = Integer.parseInt(JOptionPane.showInputDialog("Please select the information you would like to update: \n"
        													+ "1. Name \n"
        													+ "2. Phone\n"
        													+ "3. Email"));
        		if(menuChoice != 1 && menuChoice != 2 && menuChoice != 3)
        			JOptionPane.showMessageDialog(null, "Please enter a number 1 through 3.");
        		}while(menuChoice != 1 && menuChoice != 2 && menuChoice != 3);
        		
        	}
        	catch(NumberFormatException e){
        		JOptionPane.showMessageDialog(null, "Please enter a number 1 through 3.");
        	}
    		
    		if(menuChoice == 1){
    			do{
    				input = JOptionPane.showInputDialog("Please enter the new name you would like to use:");
    				
    				if(input.length() <= 0)
    					JOptionPane.showMessageDialog(null, "Please enter a name at least one character long.");
    			}while(input.length() <= 0);
    			
    			coach.setCoachName(input);
    			JOptionPane.showMessageDialog(null, "Here is your new information: \n\n" + coach.toString());
    		}
    		else if(menuChoice == 2){
    			do{
    				input = JOptionPane.showInputDialog("Please enter the new phone you would like to use (just numbers please):");
    				
    				if(input.length() != 10)
    					JOptionPane.showMessageDialog(null, "Please enter a phone of 10 digits, just numeric digits.");
    			}while(input.length() != 10);
    			
    			coach.setCoachPhone(input);
    			JOptionPane.showMessageDialog(null, "Here is your new information: \n\n" + coach.toString());
    		}
    		else if(menuChoice == 3){
    			do{
    				input = JOptionPane.showInputDialog("Please enter the new email you would like to use:");
    				
    				for(int i = 0; i < input.length(); i++){
    					if(i > 1 && input.charAt(i) == '@')
    						hasAt = true;
    					
    					if(i > 3 && input.charAt(i) == '.')
    						hasDot = true;
    					
    					if(i == (input.length() - 1) && input.charAt(i) == '.')
    						hasDot = false;
    				}
    				
    				if(!hasAt || !hasDot)
    					JOptionPane.showMessageDialog(null, "Please enter a valid email: '___@___.___'");
    			}while(!hasAt || !hasDot);
    			
    			coach.setCoachEmail(input);
    			JOptionPane.showMessageDialog(null, "Here is your new information: \n\n" + coach.toString());
    		}
    	}
    }

    public static void teamInfo()
    {

    }


    public static void reports(Team team)
    {
    	int menuChoice = -1;
    	String output = "";
    	Player[] playerList = team.getPlayers();
    	boolean bool = false;
    	Player temp;
    	
    	menuChoice = Integer.parseInt(JOptionPane.showInputDialog("Please select the report you want to view:\n\n"
    			+ "1. Alphabetically\n"
    			+ "2. Points scored\n"
    			+ "3. Games played\n"));
    	
    	if(menuChoice == 1){
    		for(int i = 0; i < playerList.length; i++){
    			for(int j = i; j < (playerList.length-1); j++){
    				if(playerList[j].getPName().toLowerCase().charAt(0) > playerList[j+1].getPName().toLowerCase().charAt(0)){
    					temp = playerList[j];
    					playerList[j] = playerList[j+1];
    					playerList[j+1] = temp;
    				}
    				else if(playerList[j].getPName().toLowerCase().charAt(0) == playerList[j+1].getPName().toLowerCase().charAt(0)){
    					for(int k = 1; k < playerList[j].getPName().length() && k < playerList[j+1].getPName().length(); k++){
    						if(playerList[j].getPName().toLowerCase().charAt(k) > playerList[j+1].getPName().toLowerCase().charAt(k)){
    	    					temp = playerList[j];
    	    					playerList[j] = playerList[j+1];
    	    					playerList[j+1] = temp;
    	    					bool = true;
    	    				}
    						if(bool)
    							break;
    					}
    				}
    			}
    		}
    		
    		output += "Sorted on player name:\n\n";
			output += "Player name | Games played | Points scored | Assists | Rebounds | Steals\n";
			
    		for(int i = 0; i < playerList.length; i++){
    			output += (i+1) + ". " + playerList[i].getPName() + " | " + playerList[i].getGamesPlayed() + " | " 
    					+ playerList[i].getPoints() + " | "  + playerList[i].getAssists() + " | "
    					+ playerList[i].getRebounds() + " | " + playerList[i].getSteals() + "\n";
    		}
    	}
    	else if(menuChoice == 2){
    		//sort
    	}
    	else if(menuChoice == 3){
    		//sort
    	}
    	
    	JOptionPane.showMessageDialog(null, output);
    }

    public static void playersMenu(Player[] players, int counter)
    {
        int userChoice = 0;
        try
        {
            boolean bool = false;
            while (bool == false)
            {
                userChoice = Integer.parseInt(JOptionPane.showInputDialog(null, "Welcome " + players[counter].getPName()+
                        "! \n Team Management Software \n" +
                        "Please select from the options below: \n" +
                        "1. View and edit profile \n" +
                        "2. Exit. "));
                if (userChoice > 2 || userChoice < 1) {
                    bool = false;
                    JOptionPane.showMessageDialog(null, "Please choose from the choices given.");
                } else {
                    bool = true;
                }
            }
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Error occurred.");
        }

        if(userChoice == 1) {
            playerProfile(players[counter]);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "You have been successfully logged out. \n Have a great day.");
            System.exit(0);
        }
    }

    public static void playerProfile(Player player)
    {
        int menuChoice = -1;
    	String input = "";
    	int num = -1;
    	
    	try{
    		do{
    		menuChoice = Integer.parseInt(JOptionPane.showInputDialog("Welcome " + player.getPName() + ", \n\n"
    																	+ "Please select an option: \n"
    																	+ "1. View your profile. \n"
    																	+ "2. Edit your profile."));
    		if(menuChoice != 1 && menuChoice != 2)
    			JOptionPane.showMessageDialog(null, "Please enter either a '1' or a '2'");
    		}while(menuChoice != 1 && menuChoice != 2);
    		
    	}
    	catch(NumberFormatException e){
    		JOptionPane.showMessageDialog(null, "Please enter either a '1' or a '2'");
    	}
    	
    	if(menuChoice == 1){
    		JOptionPane.showMessageDialog(null, player.toString());
    	}
    	else if(menuChoice == 2){
    		menuChoice = -1;
    		
    		try{
        		do{
        		menuChoice = Integer.parseInt(JOptionPane.showInputDialog("Please select the information you would like to update: \n"
        																	+ "1. Name \n"
        																	+ "2. Number of games played\n"
        																	+ "3. Points earned \n"
        																	+ "4. Assists\n"
        																	+ "5. Rebounds\n"
        																	+ "6. Steals"));
        		if(menuChoice >= 1 && menuChoice <= 6)
        			JOptionPane.showMessageDialog(null, "Please enter a number 1 through 6.");
        		}while(menuChoice >= 1 && menuChoice <= 6);
        		
        	}
        	catch(NumberFormatException e){
        		JOptionPane.showMessageDialog(null, "Please enter a number 1 through 6.");
        	}
    		
    		if(menuChoice == 1){
    			do{
    				input = JOptionPane.showInputDialog("Please enter the new name you would like to use:");
    				
    				if(input.length() <= 0)
    					JOptionPane.showMessageDialog(null, "Please enter a name at least one character long.");
    			}while(input.length() <= 0);
    			
    			player.setPName(input);
    			JOptionPane.showMessageDialog(null, "Here is your new information: \n\n" + player.toString());
    		}
    		else if(menuChoice == 2){
    			do{
    				num = Integer.parseInt(JOptionPane.showInputDialog("Please enter new number of games played:"));
    				
    				if(num < 0 || num < player.getGamesPlayed())
    					JOptionPane.showMessageDialog(null, "Please enter a number greater than the last number of games played.");
    			}while(num < 0 || num < player.getGamesPlayed());
    			
    			player.setGamesPlayed(num);
    			JOptionPane.showMessageDialog(null, "Here is your new information: \n\n" + player.toString());
    		}
    	}
    }
}
