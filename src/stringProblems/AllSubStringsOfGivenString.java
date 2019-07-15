package stringProblems;

import java.util.LinkedHashSet;
import java.util.Set;

public class AllSubStringsOfGivenString {

	public static void main(String[] args) {

		// Has issue - not printing cases like abd
		String str = "abcd";
		Set<String> set = new LinkedHashSet<>(); // for handling cases of repeated char in string
		bestSolution(str);
		for(String s : set) {
			System.out.println(s);
		}
	}

	public static void bestSolution(String str) {
		// https://stackoverflow.com/questions/15726641/find-all-possible-substring-in-fastest-way
		// This is the only best solution O(N^2) for this problem. Refer stackoverflow answer.
		int n = str.length();
		for (int i = 0; i < n; i++)  
	           for (int j = i+1; j <= n; j++) 
	                System.out.println(str.substring(i, j)); 
	}

	public static void printAllSubStringsIteratively(String str, Set<String> set) {
		int len = str.length();
		for(int i=1;i<=len;i++) {
			printAllSubStringsOfGivenLength(str, i, set);
		}
	}

	private static void printAllSubStringsOfGivenLength(String str, int curLength, Set<String> set) {

		for(int i=0;i<=str.length()-curLength;i++) {
			int count = 1;
			StringBuilder sb = new StringBuilder(str.charAt(i)+"");
			//System.out.print(str.charAt(i));
			for(int j=i+1;count!=curLength && j<=str.length()-curLength+1;j++) {
				for(int k=j;count<curLength;k++) {
					//System.out.print(str.charAt(k));
					sb.append(str.charAt(k));
					count++;
				}
				if(count==curLength)
					//System.out.println(sb.toString());
					set.add(sb.toString());
					sb = new StringBuilder(str.charAt(i)+"");
					count = 1;
			}
			if(curLength==1) {
				//System.out.println(sb.toString());
				set.add(sb.toString());
			}
		}
	}
}
