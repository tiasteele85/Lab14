import java.util.*;

public class RandomPlayer extends Player {

	@Override
	public Roshambo generateRashambo() {
		ArrayList<Roshambo> shuffle = new ArrayList<>();
		shuffle.add(Roshambo.ROCK);
		shuffle.add(Roshambo.PAPER);
		shuffle.add(Roshambo.SCISSORS);
		
		//generate random number to shuffle arrayList
		int pos = (int) (Math.random()*3);
		
		return shuffle.get(pos);
	}
	

	
	
}
