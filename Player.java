package guessTheNumberV2;
import java.util.ArrayList;

public class Player {
	
	private String name;
	private int highestScore = 0;
	private ArrayList<Integer> scores = new ArrayList<Integer>();
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void addScore(int score) {
		scores.add(score);
	}
	
	public void displayScores() {
		if(scores.size() > 0)
		{
			if(name.charAt(name.length() - 1) == 's') {
				System.out.println(name + "' scores list is:");
			}
			else {
				System.out.println(name + "'s scores list is:");
			}
			for(int i = 0; i < scores.size(); i++)
			{
				System.out.println(scores.get(i));
			}
		}
		else
		{
			System.out.println("There are no scores recorded.");
		}
		
	}
	
	public void setHighScore(int score) {
		if(highestScore < score) 
		{
			highestScore = score;
		}
	}
	
	public void displayHighscore() {
		if(name.charAt(name.length() - 1) == 's') 
		{
			System.out.println(name + "' highscore is:" + highestScore);
		}
		else 
		{
			System.out.println(name + "'s highscore is:" + highestScore);
		}
	}

}
