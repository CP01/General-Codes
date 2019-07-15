package geektrust.war_2planets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WAR_TheTwoPlanet_Main {
	
	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		WAR_Actions warRunner = new WAR_Actions();
		int[] defenseArmy = new int[WAR_Constants.DEFENSE_ARMY.length];
		String input = null;


		while(true) {

			int[] enemyArmy;
			for(int i=0;i<WAR_Constants.DEFENSE_ARMY.length;i++) {
				defenseArmy[i] = WAR_Constants.DEFENSE_ARMY[i];
			}
			
			input = null;
			try {
				input = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if(input!=null && !input.trim().isEmpty()) {
				try {
					enemyArmy = warRunner.parseInput(input);
				}catch(Exception ex) {
					System.out.println(ex);
					continue;
				}
				warRunner.fightWave1(defenseArmy, enemyArmy);
				warRunner.fightWave2(defenseArmy, enemyArmy);
				System.out.println(warRunner.generateOutput(defenseArmy, enemyArmy));
			}
			else {
				break;
			}
		}

	}

}