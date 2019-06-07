package stringProblems;

import java.util.LinkedHashSet;
import java.util.Set;

public class AllSubStringsOfGivenString {

	public static void main(String[] args) {

		String str = "abc";
		Set<String> set = new LinkedHashSet<>(); // for handling cases of repeated char in string
		printAllSubStringsIteratively(str, set);
		for(String s : set) {
			System.out.println(s);
		}
	}

	public static void printAllSubStringsRecursively(String str) {
		
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
