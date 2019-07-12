import java.util.Scanner;

public class TwoPlayer extends Player {

	private Scanner input = new Scanner(System.in);

	public TwoPlayer() {
	}

	public TwoPlayer(Scanner scnr) {
		input = scnr;
	}

	@Override
	public Roshambo generateRashambo() {
		System.out.println("Rock, Paper, or Scissors?  (R/P/S):");
		String choice = input.nextLine().toUpperCase();
		return validateChoice(choice);

	}

	//Method to check if the user entered valid data
	private Roshambo validateChoice(String choice) {

		Roshambo answer = Roshambo.ROCK;
		boolean valid = false;
		while (!valid) {
			if (choice.equals("R")) {
				
				valid = true;
				answer = Roshambo.ROCK;
				
			} else if (choice.equals("P")) {
				
				valid = true;
				answer =  Roshambo.PAPER;
				
			} else if (choice.equals("S")) {
				
				valid = true;
				answer =  Roshambo.SCISSORS;
				
			} else {
				System.out.println("Invalid choice. Choose again!");
				choice = input.nextLine();
			}
		}
		return answer;
	}

}
