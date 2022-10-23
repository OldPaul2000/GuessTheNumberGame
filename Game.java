package guessTheNumberV2;
import java.util.ArrayList;


public class Game {
	
	private ArrayList<Player> players = new ArrayList<Player>();
	
	public ArrayList<Player> getPlayersList(){
		return players;
	}
	
	public int createPlayer(String name){
		if(queryPlayer(name) >= 0)
		{
			System.out.println("This name already exists.");
			return -1;
		}
		else
		{
			players.add(new Player(name));
			System.out.println("Player added succesfully.");
			return 1;
		}
	}
	
	public void displayPlayersList() {
		if(players.size() > 0)
		{
			for(int i = 0; i < players.size(); i++)
			{
				System.out.println((i + 1) + "." + players.get(i).getName());
			}
		}
		else
		{
			System.out.println("Empty.");
		}
	}
	
	public void deletePlayer(String name) {
		int index = queryPlayer(name);
		if(index >= 0)
		{
			players.remove(index);
			System.out.println("Removed succesfully.");
		}
		else
		{
			System.out.println("This player doesn't exist.");
		}
	}

	public int queryPlayer(String name) {
		for(int i = 0; i < players.size(); i++)
		{
			if(players.get(i).getName().equals(name))
			{
				return i;
			}
		}
		return -1;
	}
	
	
	
}


