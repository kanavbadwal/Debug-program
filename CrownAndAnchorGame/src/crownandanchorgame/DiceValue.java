package crownandanchorgame;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public enum DiceValue {
	CROWN, ANCHOR, HEART, DIAMOND, CLUB, SPADE;
	
	private static Random RANDOM = new Random();
	
	private static final Map<DiceValue, String> VALUE_REPR_MAP= new HashMap<DiceValue, String>();
	static {
		VALUE_REPR_MAP.put(DiceValue.CROWN, "Crown");
		VALUE_REPR_MAP.put(DiceValue.ANCHOR, "Anchor");
		VALUE_REPR_MAP.put(DiceValue.HEART, "Heart");
		VALUE_REPR_MAP.put(DiceValue.DIAMOND, "Diamond");
		VALUE_REPR_MAP.put(DiceValue.CLUB, "Club");
		VALUE_REPR_MAP.put(DiceValue.SPADE, "Spade");
	}
	
	public String toString(DiceValue value) {
		return VALUE_REPR_MAP.get(value);
	}
	
	public static DiceValue getRandom() {
                /* DEBUGGING: The last value of enum Dicevalue is spade.
                 * The function below picks the random value till CLUB.
                 * It does not include the value of SPADE. Due to this, the win/lose
                 * ratio comes out around 48%. The random funciton must be incremented
                 * by one to get the right result.
                 */
		int random = RANDOM.nextInt(DiceValue.SPADE.ordinal() + 1);
		return values()[random];
	}
	
}
