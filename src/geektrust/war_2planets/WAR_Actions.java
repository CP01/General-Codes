package geektrust.war_2planets;

public class WAR_Actions {

	/**
	 * @param input
	 * @return enemyArmy
	 * 
	 * Takes input string and provide array of enemy army.
	 * Input Format : "Falicornia attacks with 100 H, 101 E, 20 AT, 5 SG"
	 * If we split input by SPACE then INDEX_OF_FIRST_UNIT_COUNT = 3 i.e. count of Horses attacking
	 * Next Unit Count is at +2 and so on.
	 * 
	 * Utilize the fact from Given Input Format, parse accordingly and generate enemy army array.
	 * 
	 * Throws Runtime Exception, if input is not as per given format.
	 */
	public int[] parseInput(String input) {
		String inputArr[] = input.split(" ");
		UnitTypes[] units = UnitTypes.values();
		int enemyArmy[] = new int[units.length];
		try {
			for(int i=0;i<units.length;i++) {
				enemyArmy[i] = Integer.parseInt(inputArr[WAR_Constants.INDEX_OF_FIRST_UNIT_COUNT + i * 2]);
			}
		} catch(Exception ex) {
			throw new RuntimeException("Invalid Input Format. Please Retry OR Hit Enter to Terminate...");
		}
		return enemyArmy;
	}

	/**
	 * @param defenseArmy
	 * @param enemyArmy
	 * 
	 * Perform Fight against same unit type army
	 */
	public void fightWave1(int[] defenseArmy, int[] enemyArmy) {
		for(int currentUnitIndex=0; currentUnitIndex<defenseArmy.length; currentUnitIndex++) {
			// If Enemy Unit is out-numbering Defense Unit
			if(enemyArmy[currentUnitIndex] > 2 * defenseArmy[currentUnitIndex]) {
				enemyArmy[currentUnitIndex] = enemyArmy[currentUnitIndex] - 2 * defenseArmy[currentUnitIndex];
				defenseArmy[currentUnitIndex] = 0;
			}
			// If Defense Unit is out-numbering Enemy Unit
			else {
				defenseArmy[currentUnitIndex] = 2 * defenseArmy[currentUnitIndex] - enemyArmy[currentUnitIndex];
				defenseArmy[currentUnitIndex] /= 2;
				enemyArmy[currentUnitIndex] = 0;
			}

		}

	}

	/**
	 * @param defenseArmy
	 * @param enemyArmy
	 * 
	 * Perform Substitutions
	 */
	public void fightWave2(int[] defenseArmy, int[] enemyArmy) {

		for(int currentUnitIndex=0; currentUnitIndex<defenseArmy.length; currentUnitIndex++) {
			// If current unit of enemy army is not exhausted
			if(enemyArmy[currentUnitIndex] != 0) {
				// Check for lower unit substitution
				if(currentUnitIndex > 0 && defenseArmy[currentUnitIndex-1] > 0) {
					// If Enemy Unit is out-numbering Defense Unit
					if(enemyArmy[currentUnitIndex] > defenseArmy[currentUnitIndex-1]) {
						enemyArmy[currentUnitIndex] = enemyArmy[currentUnitIndex] - defenseArmy[currentUnitIndex-1];
						defenseArmy[currentUnitIndex-1] = 0;
					}
					// If Defense Unit is out-numbering Enemy Unit
					else {
						defenseArmy[currentUnitIndex-1] = defenseArmy[currentUnitIndex-1] - enemyArmy[currentUnitIndex];
						if(defenseArmy[currentUnitIndex-1]%2==1) {
							defenseArmy[currentUnitIndex-1]--;
						}
						enemyArmy[currentUnitIndex] = 0;
					}
				}
				// If current unit of army still not exhausted and check for higher unit substitution
				if(enemyArmy[currentUnitIndex] != 0 && currentUnitIndex < defenseArmy.length-1 && defenseArmy[currentUnitIndex+1] > 0) {
					// If Enemy Unit is out-numbering Defense Unit
					if(enemyArmy[currentUnitIndex] > 4 * defenseArmy[currentUnitIndex+1]) {
						enemyArmy[currentUnitIndex] = enemyArmy[currentUnitIndex] - 4 * defenseArmy[currentUnitIndex+1];
						defenseArmy[currentUnitIndex] = 0;
					}
					// If Defense Unit is out-numbering Enemy Unit
					else {
						defenseArmy[currentUnitIndex+1] = 4 * defenseArmy[currentUnitIndex+1] - enemyArmy[currentUnitIndex];
						defenseArmy[currentUnitIndex+1] /= 4;
						enemyArmy[currentUnitIndex] = 0;
					}
				}
			}
		}

	}

	/**
	 * @param defenseArmy
	 * @param enemyArmy
	 * @return formated_String_Output
	 * 
	 * Generating the output in the given format.
	 */
	public String generateOutput(int[] defenseArmy, int[] enemyArmy) {
		StringBuilder sb = new StringBuilder(WAR_Constants.OUTPUT_PREFIX);
		boolean isWin = true;
		for(int i=0;i<defenseArmy.length;i++) {
			// If any of enemy unit left alive, our King lost the battle
			if(enemyArmy[i]!=0) {
				isWin = false;
			}
			sb.append(WAR_Constants.SPACE);
			sb.append(WAR_Constants.DEFENSE_ARMY[i]-defenseArmy[i]);
			sb.append(WAR_Constants.SPACE);
			sb.append(WAR_Constants.UNITS_INITIALS[i]);
			if(i<defenseArmy.length-1) {
				sb.append(WAR_Constants.COMMA);
			}
			else {
				sb.append(WAR_Constants.SPACE);
				sb.append(WAR_Constants.AND);
				sb.append(WAR_Constants.SPACE);
			}

		}
		if(isWin) {
			sb.append(WAR_Constants.WINS);
		}
		else {
			sb.append(WAR_Constants.LOSES);
		}
		return sb.toString();
	}
}
