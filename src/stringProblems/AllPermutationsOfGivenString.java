package stringProblems;

import java.util.HashMap;
import java.util.Map;

public class AllPermutationsOfGivenString {

	public static void main(String[] args) {
		String str = "abc";
		char input[] = str.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for(char ch : input) {
			map.compute(ch, (k, v) -> (v==null) ? 1 : v+1);
		}
		//System.out.println(map);
		char chArr[] = new char[map.size()];
		int countArr[] = new int[map.size()];
		int j=0;
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			chArr[j] = entry.getKey();
			countArr[j] = entry.getValue();
			j++;
		}
		char result[] = new char[input.length];
		findPermutations(chArr, countArr, result, 0);

	}

	private static void findPermutations(char[] chArr, int countArr[], char result[], int level) {

		if(level == result.length) {
			for(char ch : result) {
				System.out.print(ch);
			}
			System.out.println();
			//return;
		}
		
		for(int i=0;i<chArr.length;i++) {
			if(countArr[i] == 0)
				continue;
			result[level] = chArr[i];
			countArr[i]--;
			findPermutations(chArr, countArr, result, level+1);
			countArr[i]++;
		}
	}
	
	
}
