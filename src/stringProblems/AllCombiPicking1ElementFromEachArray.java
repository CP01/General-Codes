package stringProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class AllCombiPicking1ElementFromEachArray {

	public static void main(String[] args) {

		String str = "1234567891";
		int n = str.length();
		int x = 5;
		int k = 10;
		List<List<Integer>> lOl = new ArrayList<>(); // List Of List
		List<Integer> curList = null;
		for(int i=0;i<n;i++) {
			if(i%x==0) {
				if(curList != null)
					lOl.add(curList);
				System.out.println(curList);
				curList = new ArrayList<>();
			}
			curList.add(Integer.parseInt(str.substring(i,i+1)));
		}
		if(curList != null)
			lOl.add(curList);
		System.out.println(curList);
		System.out.println(lOl);
		TreeSet<Integer> set = new TreeSet<>();
		getCombinations(lOl, set);
		System.out.println(set);
		int i = 0;
		int num = -1;
		for(int ctr : set) {
			i++;
			if(i==k) {
				num = ctr;
				break;
			}
		}
		System.out.println(num + " " + i);
	}


	public static void getCombinations(List<List<Integer>> lOl, TreeSet<Integer> set)
	{
		int n = lOl.size();
		int[] idx = new int[n];
		for (int i = 0; i < n; i++) {
			idx[i] = 0;
		}

		while (true) { 
			int num = 0;
			for (int i = 0; i < n; i++) {
				num = num*10 + lOl.get(i).get(idx[i]);
			}
			set.add(num);
			int nxt = n - 1;
			while (nxt >= 0 && (idx[nxt] + 1 >= lOl.get(nxt).size())) {
				nxt--;
			}
			if (nxt < 0)
				return;
			idx[nxt]++;
			for (int i = nxt+1; i<n; i++) {	
				idx[i] = 0; 
			}
		} 
	} 

}
