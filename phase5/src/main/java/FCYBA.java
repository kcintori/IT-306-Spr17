import com.sun.codemodel.internal.JOp;

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
            profile();
        }
        else if(userChoice == 2)
        {
            teamInfo();
        }
        else if(userChoice == 3)
        {
           playerProfile();
        }
        else if(userChoice == 4)
        {
            reports();
        }
        else if(userChoice == 5)
        {
            personalFile()
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

    public static void profile()
    {

    }

    public static void teamInfo()
    {

    }


    public static void reports()
    {

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
            playerProfile();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "You have been successfully logged out. \n Have a great day.");
            System.exit(0);
        }
    }

    public static void playerProfile()
    {

    }
}
