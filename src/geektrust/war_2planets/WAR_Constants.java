package geektrust.war_2planets;

public class WAR_Constants {
	
	// Constants for Output Format
	public static final String OUTPUT_PREFIX = "Lengaburu deploys";
	public static final String WINS = "wins";
	public static final String LOSES = "loses";
	public static final String[] UNITS_INITIALS = {"H", "E", "AT", "SG"};
	public static final String AND = "and";
	public static final String COMMA = ",";
	public static final String SPACE = " ";
	
	// Constants for Defense Army's Initial Unit Counts
	public static final int DEFENSE_UNIT_MAX_HORSE = 100;
	public static final int DEFENSE_UNIT_MAX_ELEPHANT = 50;
	public static final int DEFENSE_UNIT_MAX_ARMOURED_TANKS = 10;
	public static final int DEFENSE_UNIT_MAX_SLING_GUNS = 5;
	
	// Initial Defense Army Array
	public static final int[] DEFENSE_ARMY = {DEFENSE_UNIT_MAX_HORSE, DEFENSE_UNIT_MAX_ELEPHANT,
			DEFENSE_UNIT_MAX_ARMOURED_TANKS, DEFENSE_UNIT_MAX_SLING_GUNS};
	
	// It is as per current input format, it needs to be updated if i/p format changes
	public static final int INDEX_OF_FIRST_UNIT_COUNT = 3;
}
