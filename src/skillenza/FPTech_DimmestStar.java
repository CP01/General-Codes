package skillenza;

import java.util.LinkedList;
import java.util.Scanner;

public class FPTech_DimmestStar {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0) {
			int n = sc.nextInt();
			LinkedList<Integer> lists[] = new LinkedList[n+1];
			for (int i=0; i<=n; ++i) 
				lists[i] = new LinkedList(); 
			while(n>1) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				lists[a].add(b);
				n--;
			}
			int bright = sc.nextInt();
			trace(lists, bright, bright, 0);
			System.out.println(DIM + " " +CTR);
			CTR = 0;
			DIM = 0;

			t--;
		}
	}

	static int CTR, DIM;
	public static void trace(LinkedList<Integer> lists[], int bright, int dim, int ctr) {

		dim = bright;
		ctr++;
		for(int j=0;j<lists[bright].size();j++) {
			trace(lists, lists[bright].get(j), dim, ctr);
		}
		if(CTR<ctr) {
			CTR = ctr;
			DIM = dim;
		}
		else if(CTR==ctr) {
		    if(DIM>dim) {
		        DIM = dim;
		    }
		}

	}

}

/*
Dimmest Star

Sophia is sitting on the roof of her house on a moonless night looking up at a collection of stars. She mentally marked them with numbers from 1 to n. She picked out the brightest star in the sky and connected them with other stars in decreasing order of brightness.

She’s bewildered with such a large connected network of stars. She wants to know which star is dimmest. Can you help her?

The problem can be seen as a uni-directional non-cyclic graph with n-1 edges.

Here 5 is the brightest and 1 is the dimmest. You may assume that stars in one “level” of the graph are of the same brightness. That is, in the case above, stars 6 and 2 are of the same brightness level while 3 and 4 are also equally bright.

So the output will be 1.

Note that if there’s more than one dimmest star, the output should be the star with the lowest index.
Input Format

The first line contains ‘t’ which is the no. of test cases.

For each test case, the first line is an integer n which is the number of stars. Then n - 1 lines follows consisting of two space separated integers a b. This represents a directed edge connecting a to b.

The last line is an integer which represents the starting point (the brightest star.)
Output Format

For every test case, print out a single integer which is the index of the dimmest star.



Input :
2
7
5 6
5 2
6 4
6 3
4 7
7 1
5
10
7 2
7 3
7 6
7 4
7 10
3 5
6 8
6 1
8 9
7

Answer:
	1
	9
*/
