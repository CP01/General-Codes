package stringProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class MinSubStringWithAllDistinctChar {

	public static void main(String[] args) {

		String input[] = {"baacdb", "aaacbbcdcbbcaabc", "abcdabcd", "aabbccdd"};
		long start = System.nanoTime();
		approach1(input); // Efficient one
		long app1 = (System.nanoTime()-start);
		System.out.println("------");
		start = System.nanoTime();
		approach2(input); // Slower
		long app2 = (System.nanoTime()-start);
		System.out.println("app1-app2 " + (app1-app2));
	}
	
	public static void approach1(String[] input) {
		for(String str : input) {
			int size = str.length();
			HashMap<Character, Integer> map = new HashMap<>();
			for(char ch : str.toCharArray()) {
				map.put(ch,0);
			}
			int count = 0, minLen = Integer.MAX_VALUE;
			int curLen = size, startIndex = 0, start = 0;
			for(int i=0;i<size;i++) {
				char ch = str.charAt(i);
				if(map.containsKey(ch)) {
					map.put(ch, map.get(ch)+1);
					if(map.get(ch) == 1) {
						count++;
					}
				}
				
				if(count == map.size()) {
					while(map.containsKey(str.charAt(start)) && map.get(str.charAt(start))>1) {
						map.put(str.charAt(start), map.get(str.charAt(start))-1);
						start++;
					}
					
					curLen = i-start;
					if(curLen<minLen) {
						minLen = curLen;
						startIndex = start;
					}
				}
				
			}
			System.out.println(str.substring(startIndex, startIndex+minLen+1));
		}
	}
	
	public static void approach2(String[] input) {
		for(String str : input) {
			int size = str.length();
			HashSet<String> distinctSet = new HashSet<>();
			for(char ch : str.toCharArray()) {
				distinctSet.add(Character.toString(ch));
			}
			int distinctCount = distinctSet.size();
			boolean isFound = false;
			for(int i=distinctCount; i<size; i++) { //Considering window size and increasing it in every loop
				if(isFound) {
					break;
				}
				HashMap<String, Integer> distElementCount = new HashMap<>();
				for(char ch : str.toCharArray()) {
					distElementCount.put(Character.toString(ch), 0);
				}
				
				StringBuilder sb = new StringBuilder("");
				List<String> list = new ArrayList<>(distinctSet);
				int j = 0;
				for(; j<i; j++) {
					if(isFound) {
						break;
					}
					String st = str.substring(j,j+1);
					list.remove(st);
					distElementCount.put(st, distElementCount.get(st)+1);
					sb.append(st);
				}
				if(list.isEmpty()) {
					System.out.println(sb.toString());
					isFound = true;
					break;
				}
				for(;j<size;j++) {
					String latest = str.substring(j,j+1);
					String oldest = sb.substring(0, 1);
					sb.append(latest);
					distElementCount.put(latest, distElementCount.get(latest)+1);
					distElementCount.put(oldest, distElementCount.get(oldest)-1);
					sb.replace(0, 1, "");
					if(validateMap(distElementCount)) {
						System.out.println(sb.toString());
						isFound = true;
						break;
					}
				}
				
			}
		}
	}

	public static boolean validateMap(HashMap<String, Integer> map) {
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue()<1) {
				return false;
			}
		}
		return true;
	}

}
