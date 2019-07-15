package stringProblems;

import java.util.HashSet;
import java.util.Set;

public class AllCombiOfGivenSizeFromGivenArr {

	public static void main(String[] args) {

		int x = 2;
		int y = 4;
		int n = 3;

		int arr[] = new int[y-x+1];
		for(int i=0;i<arr.length;i++) {
			arr[i] = x+i;
		}
		int res[] = new int[n];
		Set<Long> set = new HashSet<>();
		getUniqueSum(arr, 0, res, 0, set);
		System.out.println(set.size());
		
		System.out.println("Print All Permutations - Alternate approach");
		printAllPermutations(arr, res, 0);
		System.out.println("Print All Combinations - Alternate approach");
		printAllCombinations(arr, 0, res, 0);

	}

	private static void getUniqueSum(int[] arr, int i, int[] res, int idx, Set<Long> set) {
		if (idx == res.length) 
		{ 
			Long sum = 0l;
			for (int j=0; j<res.length; j++) {
				System.out.print(res[j]);
				sum+=res[j];
			}
			System.out.println();
			set.add(sum);
			return; 
		} 

		if (i >= arr.length) 
			return; 

		res[idx] = arr[i]; 
		getUniqueSum(arr, i, res, idx+1, set);// considering repeatation allowed
	  //getUniqueSum(arr, i+1, res, idx+1, set);// considering repeatation not allowed

		getUniqueSum(arr, i+1, res, idx, set); 
	}

	
	private static void printAllPermutations(int[] arr, int[] res, int level) { //Considering ab != ba
		if(level==res.length) {
			for(int i=0;i<res.length;i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<arr.length;i++) {
			res[level] = arr[i];
			printAllPermutations(arr, res, level+1);
		}
	}
	

	private static void printAllCombinations(int[] arr, int idx, int[] res, int level) { //Considering ab == ba
		if(level==res.length) {
			for(int i=0;i<res.length;i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=idx;i<arr.length;i++) {
			res[level] = arr[i];
			printAllCombinations(arr, i, res, level+1);
		}
	}
}
