package crownandanchorgame;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Game {

	private List<Dice> dice;
	private List<DiceValue> values;
	
	public Game(Dice die1, Dice die2, Dice die3) {
		if (die1 == null || die2 == null || die3 == null) throw new IllegalArgumentException("Dice cannot be null.");
		dice = new ArrayList<Dice>();
		dice.add(die1);
		dice.add(die2);
		dice.add(die3);
		values = new ArrayList<DiceValue>();
	}

	public List<DiceValue> getDiceValues() {
		values.clear();
		for (Dice d : dice) {
			values.add(d.getValue());
		}
		return Collections.unmodifiableList(values);
	}
        
        public int playRound(Player player, DiceValue pick, int bet ) {		
		if (player == null) throw new IllegalArgumentException("Player cannot be null.");
		if (pick == null) throw new IllegalArgumentException("Pick cannot be negative.");
		if (bet < 0) throw new IllegalArgumentException("Bet cannot be negative.");
		
                // DEBUGGING: Bet is stored in player function.
		player.takeBet(bet);
		    
		int matches = 0;
                
                // DEBUGGING: Comparing player selection and dice values.
		for ( Dice d : dice) {
			d.roll();
			if (d.getValue().equals(pick)) { 
				matches += 1;
                                //DEBUGGING.
                                System.out.println("Player's chosen symbol mached with one of the symbol of dice.");
			}
		}
		
		int winnings = matches * bet;
                
		if (matches > 0) {
                        // DEBUGGING: Winning amount is sent to the function called receiveWinnings.
                        // DEBUGGING: The bet value is passed through the function.
			player.receiveWinnings(winnings, bet);
		}
        return winnings;		
	}
	
}
