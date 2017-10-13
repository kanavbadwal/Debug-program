package crownandanchorgame;

public class Dice {
			
	private DiceValue value;
	
	public Dice() {
		value =  DiceValue.getRandom();
	}
	
	public DiceValue getValue() {
		return value;
	}

	public DiceValue roll() {
            //DEBUGGING: The value must be stored in variable value.
                value = DiceValue.getRandom();
        	return value;
	}		
	
	public String toString() {
		return value.toString();
	}
}
