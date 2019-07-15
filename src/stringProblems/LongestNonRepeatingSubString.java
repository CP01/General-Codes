package stringProblems;

import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatingSubString {

	public static void main(String[] args) {

		String str = "GEEKSFORGEEKS";
		int maxLen = 1;
		int curLen = 1;
		int prevIdx = 0;
		Map<Character, Integer> map = new HashMap<>();
		map.put(str.charAt(0),0);
		for(int i=1;i<str.length();i++) {
			char c = str.charAt(i);
			if(map.containsKey(c)) {
				if(maxLen<curLen) {
					maxLen = curLen;
					System.out.println(maxLen+" <- Current Max "+map);
				}
				curLen = i - map.get(c);
				prevIdx = map.get(c)+1;
				map.clear();
				curLen = 1;
				map.put(c, i);
			}
			else {
				map.put(str.charAt(i), i);
				curLen++;
			}
		}
		if(maxLen<curLen) {
			maxLen = curLen;
		}
		System.out.println(maxLen);
	}

}
