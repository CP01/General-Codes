package cp;

/* HackerEarth - Dialpad Hiring Challenge
 * CurrentStatus -
 *  Not tried yet */
public class AnalyticallyStable {

	public static void main(String[] args) {

		
	}

}


/*
Analytically Stable

You are given with a number
.  A 4 digit number is said to be "Analytically Stable", if the four digits of the number are of the form, , where

. 

Your task is to pick 4 digit subsequences of the given number

, such that the 4 digit number formed by them is Analytically Stable. 

Output the number of such sub-sequences. As answer may be too large, output the answer mod

.

Input
The first line of input contains an integer 
, denoting the number of test cases. 
The first line of each test case contains a number

.

Output
For each test case output the number of Analytically Stable sub-sequences mod

.

Constraints

Sample Input

2
1515732322
1351355246246

Sample Output

3
5

Explanation

Test Case #1:

There are 3 ways of achieving number: 1122 which is "Analytically Stable". Therefore the answer is 3.

Test Case #2:

There are 3 ways of achieving number: 5566, 1 way of achieving number: 1122, and 1 way of achieving number: 3344. Therefore the answer is 5.
*/