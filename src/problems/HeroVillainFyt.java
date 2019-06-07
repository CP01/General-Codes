package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HeroVillainFyt {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int tc = Integer.parseInt(br.readLine());
			while(tc-->0) {
				int n = Integer.parseInt(br.readLine());
				Integer[] villains = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
				Integer[] heroes = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
				Arrays.parallelSort(villains);
				Arrays.parallelSort(heroes);
				boolean canWin = true;
				for(int i=0;i<n;i++) {
					if(heroes[i]<villains[i]) {
						canWin = false;
						break;
					}
				}
				if(canWin) {
					System.out.println("WIN");
				}
				else {
					System.out.println("LOSE");
				}
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}
