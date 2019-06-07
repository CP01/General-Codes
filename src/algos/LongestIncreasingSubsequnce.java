package algos;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequnce {

	public static void main(String[] args) {

		int input[] = {4, 5, -7, -5, 8, 3, 4};
		int count[] = new int[input.length];
		List<Integer>[] sequence = new ArrayList[input.length];
		for(int i=0;i<input.length;i++) {
			count[i] = 1;
			sequence[i] = new ArrayList<>();
			sequence[i].add(input[i]);
			//System.out.println(sequence[i]);
		}
		//sequence[0].add(input[0]);
		
		for(int i=1;i<input.length;i++) {
			for(int j=0;j<input.length;j++) {
				if (input[j] < input[i] /* && count[i] <= count[j] //Not required as count[j] already have all count before j */) {
					count[i] = count[j] + 1;
					sequence[i].clear();
					for(int x : sequence[j]) {
						sequence[i].add(x);
					}
					sequence[i].add(input[i]);
				}
			}
		}
		
		int index = 0;
		for(int i=1;i<count.length;i++) {
			if(count[index]<count[i]) {
				index = i;
			}
		}
		System.out.println("Length of LIS is - "+count[index]);
		System.out.print("Longest Increasing Subsequence : ");
		for(int x : sequence[index]) {
			System.out.print(x+ " ");
		}
	}

}
