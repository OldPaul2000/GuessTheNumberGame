package guessTheNumberV2;

import java.util.Random;
import java.util.Scanner;

public class Main {
  private static Scanner scan = new Scanner(System.in);
  private static Random rand = new Random();
	public static void main(String[] args) {
		
		Game g1 = new Game();
		options();
		System.out.print("Write a command:");
		int command = scan.nextInt();
		String name;
		scan.nextLine();
		
		while(command != 7)
		{
			if(command == 1)
			{
				int round = 1;
				int score = 0;
				int number = 0;
				int attempts = 3;
				int attemptsCopy = attempts;
				int inNumber = 0;
				boolean lost = false;
				//If the player is in the list and you introduce the player's name you
			    //will play with that player,else a new player will be created and play with.
				System.out.print("Write the name of the existing/new player:");
				name = scan.nextLine();
				int playerIndex = g1.queryPlayer(name);
				if(playerIndex < 0)
				{
					g1.createPlayer(name);
					playerIndex = g1.getPlayersList().size() - 1;
				}
				
				while(command != 6 && command != 7)
				{
					lost = false;
					System.out.println("Round " + round);
					number = rand.nextInt(5 + (round - 1) * 2) + 1;
					System.out.println("Guess the number between 1 and " + (5 + ((round - 1) * 2)) + " inclusive.");
					System.out.println("You have " + attempts + " attempts.");
					System.out.print("Write the number:");
					while(attempts > 0 && inNumber != number)
					{			
						inNumber = scan.nextInt();
						scan.nextLine();
				        if(inNumber == number)
				        {
				        	System.out.println("You won");
				        	System.out.println();
				        	score += (round * 2) + attempts;
				        	System.out.println("Score:" + score);
				        	round++;	
				        	attempts = attemptsCopy + 1;
				        	attemptsCopy = attempts;
				        	inNumber = 0;
				        	break;
				        }
				        else if(attempts > 1)
				        {
				        	System.out.print("Write again:");
				        	attempts--;
				        }
				        else
				        {
				        	System.out.println("Game over.The number was " + number);
				        	System.out.println();
				        	attempts = 3;
				        	attemptsCopy = attempts;
				        	round = 1;
				            lost = true;
				            g1.getPlayersList().get(playerIndex).addScore(score);
							g1.getPlayersList().get(playerIndex).setHighScore(score);
				        	break;
				        }
					}
					System.out.println("6 - exit the game\n7 - exit to windows\n8 - continue/replay");
					command = scan.nextInt();
					scan.nextLine();
					while(command != 6 && command != 7 && command != 8)
					{
						System.out.println("Incorrect command.Write again");
						command = scan.nextInt();
						scan.nextLine();
					}
					if((command == 6 || command == 7) && !lost)
					{
						g1.getPlayersList().get(playerIndex).addScore(score);
						g1.getPlayersList().get(playerIndex).setHighScore(score);
					}
				}
				System.out.println();
			}
			if(command == 2)
			{
				System.out.print("Write the player's name you want to delete:");
				name = scan.nextLine();
				g1.deletePlayer(name);
				System.out.println();
			}
			else if(command == 3)
			{
				System.out.print("Write the name:");
			    if(g1.queryPlayer(scan.nextLine()) >= 0)
			    {
			    	System.out.println("Player found.");
			    }
			    else
			    {
			    	System.out.println("This player doesn't exist.");
			    }
			    System.out.println();
			}
			else if(command == 4)
			{
				System.out.println("Players list:");
				g1.displayPlayersList();
				System.out.println();
			}
			else if(command == 5)
			{
				System.out.print("Write the name:");
				name = scan.nextLine();
				int index = g1.queryPlayer(name);
				if(index >= 0)
				{
					g1.getPlayersList().get(index).displayScores();
					g1.getPlayersList().get(index).displayHighscore();
				}
				else
				{
					System.out.println("This player doesn't exist.");
				}
				System.out.println();
			}
			if(command != 7)
			{
				System.out.print("Write the command:");
				command = scan.nextInt();
				scan.nextLine();
			}
			else if(command == 7)
			{
				System.out.println("Exit");
				System.exit(0);
			}
		}	
		if(command == 7)
		{
			System.out.println("Exit");
		}
	}
	
	public static void options() {
		System.out.println("1 - Play the game");
		System.out.println("2 - Delete a player");
		System.out.println("3 - Query a player");
		System.out.println("4 - Display players list");
		System.out.println("5 - Print a player's scores");
		System.out.println("6 - Exit the game");
		System.out.println("7 - Exit to windows");
	}

}
