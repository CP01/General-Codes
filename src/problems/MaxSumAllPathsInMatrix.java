package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 Start from a[n][n] to a[0][0], directions allowed are up, left and up-left(diagonal)
 Matrix cells can have some values or obstracles
 Find the max point that can be earned while travelling and how many routes for getting max points
 */
public class MaxSumAllPathsInMatrix {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc;
		try {
			tc = Integer.parseInt(br.readLine());
			while(tc-->0) {
				int n = Integer.parseInt(br.readLine());
				int a[][] = new int[n][n];
				//int aDup[][] = new int[n][n];
				for(int i=0;i<n;i++) {
					String str[] = br.readLine().split(" ");
					for(int j=0;j<n;j++) {
						if(str[j].charAt(0)=='x' || str[j].charAt(0)=='s' || str[j].charAt(0)=='e') {
							a[i][j] = -1;
						}
						else {
							a[i][j] = Integer.parseInt(str[j]);
						}
						//aDup[i][j] = 0;
					}
				}
				a[0][0] = 0;
				a[n-1][n-1] = 0;

				int sol[][] = new int[1][2];
				findPathRecursively(a, n-1, n-1, 0, sol);
				//System.out.println("TC "+tc+" **** sol "+sol[0][0] + " " +sol[0][1]);
				System.out.println(sol[0][0]+" "+sol[0][1]);
				
				findPathViaDP(a);
			}
		} catch (NumberFormatException | IOException e) {}
	}

	
	private static void findPathViaDP(int[][] a) {

		int n = a.length;
		int[][] dp = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==0&&j==0) {
					dp[i][j] = 0;
					continue;
				}
				if(a[i][j]==-1) {
					dp[i][j] = Integer.MIN_VALUE;
					continue;
				}
				int ryt = Integer.MIN_VALUE, dwn = Integer.MIN_VALUE, diag = Integer.MIN_VALUE;
				if(i>0) {
					ryt = dp[i-1][j] + a[i][j];
				}
				if(j>0) {
					dwn = dp[i][j-1] + a[i][j];
				}
				if(i>0 && j>0) {
					diag = dp[i-1][j-1] + a[i][j];
				}
				dp[i][j] = Math.max(ryt, Math.max(dwn, diag));
			}
		}
		

		List<Integer> route = new ArrayList<>();
		//printMaxRoutes(n-1, n-1, route, dp);
		int[] ctr = new int[1];
		//ctr[0] = 0;
		countRoutes(n-1, n-1, ctr, dp);
		System.out.println(dp[n-1][n-1]+" "+ctr[0]);

	}


	private static void countRoutes(int i, int j, int[] ctr, int[][] dp) {
		System.out.print(" dp ");

		if(i==0 && j==0) {
			ctr[0]++;
		}
		
		
		int lft = Integer.MIN_VALUE, up = Integer.MIN_VALUE, diag = Integer.MIN_VALUE;
		if(i>0) {
			lft = dp[i-1][j];
		}
		if(j>0) {
			up = dp[i][j-1];
		}
		if(i>0 && j>0) {
			diag = dp[i-1][j-1];
		}
		
		int max = Math.max(lft, Math.max(up, diag));
		
		if(i>0 && max==dp[i-1][j]) {
			countRoutes(i-1, j, ctr, dp);
		}
		if(j>0 && max==dp[i][j-1]) {
			countRoutes(i, j-1, ctr, dp);
		}
		if(i>0 && j>0 && max==dp[i-1][j-1]) {
			countRoutes(i-1, j-1, ctr, dp);
		}
	}


	private static void printMaxRoutes(int i, int j, List<Integer> route, int[][] dp) {

		if(i==0 && j==0) {
			route.add(dp[i][j]);
			for(int x : route) {
				if(x==0)
					continue;
				System.out.print(x+" -> ");
			}
			System.out.println();
			return;
		}
		
		
		int lft = Integer.MIN_VALUE, up = Integer.MIN_VALUE, diag = Integer.MIN_VALUE;
		if(i>0) {
			lft = dp[i-1][j];
		}
		if(j>0) {
			up = dp[i][j-1];
		}
		if(i>0 && j>0) {
			diag = dp[i-1][j-1];
		}
		
		int max = Math.max(lft, Math.max(up, diag));
		
		if(i>0 && max==dp[i-1][j]) {
			route.add(dp[i-1][j]);
			printMaxRoutes(i-1, j, route, dp);
			route.remove((Integer)dp[i-1][j]);
		}
		if(j>0 && max==dp[i][j-1]) {
			route.add(dp[i][j-1]);
			printMaxRoutes(i, j-1, route, dp);
			route.remove((Integer)dp[i][j-1]);
		}
		if(i>0 && j>0 && max==dp[i-1][j-1]) {
			route.add(dp[i][j]);
			printMaxRoutes(i-1, j-1, route, dp);
			route.remove((Integer)dp[i-1][j-1]);
		}
	}


	private static void printMatrix(int[][] a) {
		int n = a.length;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static void findPathRecursively(int[][] a, int i, int j, int ptr, int sol[][]) {
		System.out.print(" rec ");
		if(i==0 && j==0) {
			if(ptr==sol[0][0]) {
				sol[0][1] = sol[0][1]+1;
			}
			else if(ptr>sol[0][0]) {
				sol[0][0] = ptr;
				sol[0][1] = 1;
			}
			//System.out.println("Cur Sum : "+ptr+" routes : "+sol[0][1]);
			return;
		}
		
		if(i!=0 && a[i-1][j] != -1) {
			findPathRecursively(a, i-1,j, ptr+a[i][j], sol);
		}
		
		if(j!=0 && a[i][j-1] != -1) {
			findPathRecursively(a, i,j-1, ptr+a[i][j], sol);
		}
		
		if(i!=0 && j!=0 && a[i-1][j-1] != -1) {
			findPathRecursively(a, i-1,j-1, ptr+a[i][j], sol);
		}
		
	}

}


/*
1
4
s 1 1 5
1 5 1 1
1 1 1 1
5 1 1 e


for this input
recursively calls itself 160 times
while
dp calls itself only 51 times

 */