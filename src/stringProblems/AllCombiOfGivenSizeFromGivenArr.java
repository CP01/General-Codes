package stringProblems;

import java.util.HashSet;
import java.util.Set;

public class AllCombiOfGivenSizeFromGivenArr {

	public static void main(String[] args) {

		int x = 13;
		int y = 17;
		int n = 3;
		
		int arr[] = new int[y-x+1];
		for(int i=0;i<arr.length;i++) {
			arr[i] = x+i;
			//System.out.println(arr[i]);
		}
		int data[] = new int[n-2];
		Set<Long> set = new HashSet<>();
		getUniqueSum(arr, arr.length, n-2, 0, data, 0, set);
		System.out.println(set.size());
				
	}

	private static void getUniqueSum(int[] arr, int arrLen, int dataLen, int idx, int[] data, int i, Set<Long> set) {
        if (idx == dataLen) 
        { 
        	Long sum = 0l;
            for (int j=0; j<dataLen; j++) {
            	System.out.print(data[j]);
            	sum+=data[j];
            }
            System.out.println();
            set.add(sum);
        return; 
        } 
  
        if (i >= arrLen) 
        return; 
  
        data[idx] = arr[i]; 
        getUniqueSum(arr, arrLen, dataLen, idx+1, data, i, set); 
  
        getUniqueSum(arr, arrLen, dataLen, idx, data, i+1, set); 
	}

}
