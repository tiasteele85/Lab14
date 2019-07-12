
import java.util.*;

public class RoshamboApp {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);//store user input
		Player player = new TwoPlayer(); //create player object 
		Player player2;
		char choice = 'Y';
		int p1Win = 0;
		int p2Win = 0;
		int p1Lose = 0;
		int p2Lose = 0;
		
		System.out.println("Welcome to Rock Paper Scissors!");
		//Prompt user to enter name
		System.out.println("Enter your name: ");
		player.setName(in.nextLine());
		
		String selection = Validator.getString(in, "Would you like to play against Wilbur, Charleston, or Player 2?");
		if(selection.toLowerCase().equals("wilbur")) {
			player2 = new RockPlayer();
			player2.setName("Wilbur");				
		}else if(selection.toLowerCase().equals("charleston")){
			player2 = new RandomPlayer();
			player2.setName("Charleston");
		}else {
			player2 = new TwoPlayer();
			player2.setName(Validator.getString(in, "Enter player 2's name:"));
		}
		
		do {		
			
			//Play game
			Roshambo p1Played = player.generateRashambo();
			Roshambo p2Played = player2.generateRashambo();
			System.out.println(player.getName() + ": " + p1Played);
			System.out.println(player2.getName() + ": " + p2Played);
			String winner = findWinner(p1Played, p2Played);
			System.out.println(winner);	
			
			//tally wins for players
			if(winner.contains("Player 1 wins"))
			{
				p1Win++;
				p2Lose++;
				
			}else if(winner.contains("Player 2 wins")) {
				p2Win++;
				p1Lose++;
				
			}
			
			
			//Ask user to continue
			System.out.println("Play again? (y/n)");
			choice = in.nextLine().toUpperCase().charAt(0);
			
		}while(choice == 'Y');
		
		System.out.println("Scores:");
		System.out.println("Player 1 wins: " + p1Win);
		System.out.println("Player 1 loses: " + p1Lose);
		System.out.println("Player 2 wins: " + p2Win);
		System.out.println("Player 2 loses: " + p2Lose);
		
		System.out.println("Goodbye!");
		
		in.close();//close scanner object
		
	}
	
	public static String findWinner(Roshambo p1, Roshambo p2) {
		
		if(p1 == p2 ) {
			return "TIE";
		}else if (p1 == Roshambo.ROCK)
		{
			if(p2 == Roshambo.SCISSORS)
			{
				return "Player 1 wins";
			}else {
				return "Player 2 wins";
			}
		}else if(p1 == Roshambo.PAPER)
		{
			if(p2 == Roshambo.ROCK)
			{
				return "Player 1 wins";
			}else {
				return "Player 2 wins";
			}
		}else {
			if(p2 == Roshambo.PAPER)
			{
				return "Player 1 wins";
			}else {
				return "Player 2 wins";
			}
		}
		
		
	}
	
	public static Roshambo getRoshambo(String input) {
		
		if (input.equals("R"))
		{
			return Roshambo.ROCK;
		}else if(input.equals("P")) {
			return Roshambo.PAPER;
		}else {
			return Roshambo.SCISSORS;
		}
		
	}

	
}
