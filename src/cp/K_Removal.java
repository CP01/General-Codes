package cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* HackerEarth - Dialpad Hiring Challenge
 * CurrentStatus -
 *  All test cases failing except sample test case */
public class K_Removal {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String nk[] = br.readLine().split(" ");
			int n = Integer.parseInt(nk[0]);
			int k = Integer.parseInt(nk[1]);

			String numsStr[] = br.readLine().split(" ");
			//int nums[] = new int[n];
			List<Integer> list = new ArrayList<>(n);
			int mean = 0;
			// int i = 0;
			for(String str : numsStr) {
				//nums[i] = Integer.parseInt(str);
				//mean += nums[i];
				//i++;
				int tmp = Integer.parseInt(str);
				list.add(tmp);
				mean += tmp;
			}
			mean = Math.round(mean/n);
			removeK(list, mean, k);
			/*
			 * Arrays.parallelSort(nums); i = (n/2) + 1; int j = (n/2) - 1; int diffNby2 =
			 * Math.abs(nums[n/2]-mean); int diffNby2more = Math.abs(nums[i]-mean); int
			 * diffNby2less = Math.abs(nums[j]-mean); if(diffNby2 == diffNby2more &&
			 * diffNby2 == diffNby2less && diffNby2more == diffNby2less) { while(diffNby2 ==
			 * diffNby2less && diffNby2 == diffNby2more) { i++; j--; diffNby2more =
			 * Math.abs(nums[i]-mean); diffNby2less = Math.abs(nums[j]-mean); } }
			 * if(diffNby2<diffNby2less && diffNby2<diffNby2more) { i = n/2;
			 * 
			 * } else if(diffNby2less<diffNby2 && diffNby2less<diffNby2more) { i = j; }
			 * removeK(nums, mean, k , i);
			 */
			long sum = 0;
			for(int m=0;m<list.size()-1;m++) {
				sum = sum + Math.abs(list.get(m)-list.get(m+1));
			}
			System.out.println(sum);

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	private static void removeK(List<Integer> list, int mean, int k) {
		int ctr = 0;
		while(ctr<k) {
			int min = Math.abs(mean - list.get(0)), minIndex = 0;
			for(int i=1; i<list.size();i++) {
				int tmp = Math.abs(mean - list.get(i));
				if(min>tmp) {
					min = tmp;
					minIndex = i;
				}
				else if(min==tmp) {
					int oldSum = 0, newSum = 0;
					if(minIndex>0)
						oldSum = Math.abs(list.get(minIndex) - list.get(minIndex-1));
					if(minIndex<list.size()-1)
						oldSum += Math.abs(list.get(minIndex) - list.get(minIndex+1));
					if(i>0)
						newSum = Math.abs(list.get(i) - list.get(i-1));
					if(i<list.size()-1)
						newSum += Math.abs(list.get(i) - list.get(i+1));
					if(newSum>oldSum) {
						min = tmp;
						minIndex = i;
					}
				}
			}
			//list.remove(minIndex);
			System.out.println(list.remove(minIndex)+ " removed "+ mean);
			ctr++;
		}
	}

	public static void removeK(int nums[], int mean, int k, int i) { //i = index; k = how many to remove
		int j = i + 1; // j = ahead index
		int ctr  = 0;
		int diffI = Math.abs(nums[i]-mean);
		int diffJ = Math.abs(nums[j]-mean);
		while(ctr<k) {
			if(diffI <= diffJ) {
				nums[i] = -1;
				i--;
			} else if(diffI > diffJ) {
				nums[j] = -1;
				j++;
			} else {
				throw new RuntimeException("Invalid case");
			}
			ctr++;
		}
	}
}



/*

K-Removal

Teacher assigns a programming assignment to all the students in their computer programming lab. One of the students is your friend and he asks you to help him solve the problem.

Teacher gave students an Array
of size and an integer . Now the students have to remove exactly elements from the array such that the array obtained after removing exactly elements have 

 as maximum.

Here
 is the length of the array after removing exactly elements. So if the initial array size is and elements are removed from it then 

Suppose our original array
is and we remove and element from the array then length of the new array formed is and the array is

.

Now the student's task is to output the maximum value of  

.

Input
First line contains 2 integers
and

denoting the size of the array and the elements to be removed respectively.

Next line contains
space separated integers denoting the array

.

Output
Output the required answer.

Constraints

Sample Input

4 1

1 2 3 4

Sample Output

3

Explanation

We have to remove exactly one element from the array. So if we remove 2 from the array we get our array as [1,3,4] which has the value abs(1-3)+abs(3-4)=3 which is the maximum possible value that can be obtained.


*/
