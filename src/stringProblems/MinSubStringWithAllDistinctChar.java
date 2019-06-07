package stringProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class MinSubStringWithAllDistinctChar {

	public static void main(String[] args) {

		String input[] = {"baacdb", "aaacbbcdcbbcaabc"};
		for(String str : input) {
			int size = str.length();
			HashSet<String> distinctSet = new HashSet<>();
			for(char ch : str.toCharArray()) {
				distinctSet.add(Character.toString(ch));
			}
			int distinctCount = distinctSet.size();
			boolean isFound = false;
			for(int i=distinctCount; i<size; i++) {
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
