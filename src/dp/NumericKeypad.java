package dp;

public class NumericKeypad {
	// https://www.geeksforgeeks.org/mobile-numeric-keypad-problem/
	public static void main(String[] args) {

		int len = 2;
		long paths = 0;

		/*for(int i=0;i<=9;i++) {
			paths = paths + getPathsStartingFromNviaRecursion(i, len);
		}
		System.out.println(paths);*/

		// Alternate Approach with recursion but avoid switch case
		int [][] arr = new int[4][3];
		arr[3][0] = arr[3][2] = -1;
		arr[3][1] = 0;
		for(int i=0;i<3;i++ ) {
			for(int j=0;j<3;j++) {
				arr[i][j] = 3*i + j + 1;
			}
		}
		/*paths = 0;
		for(int i=0;i<4;i++) {
			for(int j=0;j<3;j++) {
				paths = paths + getPathsStartingFromNviaRecursionWithoutSwitch(arr[i][j], len, arr, i, j);
			}
		}
		System.out.println(paths);*/

		// Using Dynamic Programming with Recursion
		len = 3;
		paths = 0;
		long dpR[][][] = new long[len+1][4][3];
		for(int i=0;i<4;i++) {
			for(int j=0;j<3;j++) {
				paths = paths + getPathsStartingFromNviaDPwithRecursion(arr[i][j], len, arr, i, j, dpR);
			}
		}
		System.out.println(paths);

		// Using Dynamic Programming without Recursion
		long dp[][][] = new long[len][4][3];

		for(int i=0;i<4;i++) {
			for(int j=0;j<3;j++) {
				dp[0][i][j] = 1;
			}
		}
		dp[0][3][0] = dp[0][3][2] = 0;

		for(int k=1;k<len;k++)
			for(int i=0;i<4;i++) {
				for(int j=0;j<3;j++) {
					if(i==3 && (j==0 || j==2))
						continue;
					getPathsStartingFromNviaDPwithoutRecursion(k, i, j, dp);
				}
			}
		long res = 0;
		for(int m=0;m<4;m++) {
			for(int n=0;n<3;n++) {
				res += dp[len-1][m][n];
				//System.out.print(dp[len-1][m][n]+ " ");
			}
			//System.out.println();
		}
		System.out.println(res);

		/*for(int i=0;i<4;i++) {
			for(int j=0;j<3;j++) {
				System.out.println(dp[len-1][i][j] + "<-dp dpr-> "+dpR[len][i][j]);
			}
		}*/

		// Using Dynamic Programming without Recursion and space optimized
		long dpOptimized[][][] = new long[2][4][3];

		for(int i=0;i<4;i++) {
			for(int j=0;j<3;j++) {
				dpOptimized[0][i][j] = 1;
			}
		}
		dpOptimized[0][3][0] = dpOptimized[0][3][2] = 0;

		for(int k=1;k<len;k++) {
			for(int i=0;i<4;i++) {
				for(int j=0;j<3;j++) {
					if(i==3 && (j==0 || j==2))
						continue;
					getPathsStartingFrom_N_via_DP_WithoutRecursionSpaceOptimized(i, j, dpOptimized);
				}
			}
			for(int i=0;i<4;i++) {
				for(int j=0;j<3;j++) {
					dpOptimized[0][i][j] = dpOptimized[1][i][j];
				}
			}
		}
		res = 0;
		for(int m=0;m<4;m++) {
			for(int n=0;n<3;n++) {
				res += dpOptimized[1][m][n];
				System.out.print(dpOptimized[1][m][n]+ " ");
			}
			System.out.println();
		}
		System.out.println(res);
	}

	private static void getPathsStartingFrom_N_via_DP_WithoutRecursionSpaceOptimized(int i, int j, long[][][] dpOptimized) {

		int k = 1;
		dpOptimized[k][i][j] = dpOptimized[k-1][i][j];
		if(i>0)
			dpOptimized[k][i][j] += dpOptimized[k-1][i-1][j];
		if(j>0)
			dpOptimized[k][i][j] += dpOptimized[k-1][i][j-1];
		if(i<3)
			dpOptimized[k][i][j] += dpOptimized[k-1][i+1][j];
		if(j<2)
			dpOptimized[k][i][j] += dpOptimized[k-1][i][j+1];
	}

	private static void getPathsStartingFromNviaDPwithoutRecursion(int k, int i, int j, long dp[][][]) {

		dp[k][i][j] = dp[k-1][i][j];
		if(i>0)
			dp[k][i][j] += dp[k-1][i-1][j];
		if(j>0)
			dp[k][i][j] += dp[k-1][i][j-1];
		if(i<3)
			dp[k][i][j] += dp[k-1][i+1][j];
		if(j<2)
			dp[k][i][j] += dp[k-1][i][j+1];
	}

	private static long getPathsStartingFromNviaDPwithRecursion(int num, int len, int[][] a, int i, int j, long[][][] dp) {
		if(i<0||j<0||i>3||j>2) {
			return 0;
		}
		else if(i==3 && (j==0 || j==2)) {
			return 0;
		}
		else if(len==1) {
			return 1;
		}
		else if(dp[len][i][j] != 0) {
			return dp[len][i][j];
		}
		dp[len][i][j] =  getPathsStartingFromNviaDPwithRecursion(num, len-1, a, i-1, j, dp)
				+ getPathsStartingFromNviaDPwithRecursion(num, len-1, a, i+1, j, dp)
				+ getPathsStartingFromNviaDPwithRecursion(num, len-1, a, i, j-1, dp)
				+ getPathsStartingFromNviaDPwithRecursion(num, len-1, a, i, j+1, dp)
				+ getPathsStartingFromNviaDPwithRecursion(num, len-1, a, i, j, dp);
		return dp[len][i][j];
	}

	private static long getPathsStartingFromNviaRecursionWithoutSwitch(int num, int len, int[][] a, int i, int j) {
		if(i<0||j<0||i>3||j>2) {
			return 0;
		}
		else if(a[i][j] == -1) {
			return 0;
		}
		else if(len==1) {
			return 1;
		}
		return getPathsStartingFromNviaRecursionWithoutSwitch(num, len-1, a, i-1, j)
				+ getPathsStartingFromNviaRecursionWithoutSwitch(num, len-1, a, i+1, j)
				+ getPathsStartingFromNviaRecursionWithoutSwitch(num, len-1, a, i, j-1)
				+ getPathsStartingFromNviaRecursionWithoutSwitch(num, len-1, a, i, j+1)
				+ getPathsStartingFromNviaRecursionWithoutSwitch(num, len-1, a, i, j);
	}

	private static long getPathsStartingFromNviaRecursion(int i, int n) {

		if(n==0) {
			return 0;
		}
		else if(n==1) {
			return 1;
		}
		switch(i) {
		case 0:
			return getPathsStartingFromNviaRecursion(0, n-1) + getPathsStartingFromNviaRecursion(8, n-1);
		case 1:
		{
			return (getPathsStartingFromNviaRecursion(2, n-1)+getPathsStartingFromNviaRecursion(4, n-1)+getPathsStartingFromNviaRecursion(1, n-1));
		}
		case 2:
		{
			return (getPathsStartingFromNviaRecursion(1, n-1)+getPathsStartingFromNviaRecursion(3, n-1)+getPathsStartingFromNviaRecursion(5, n-1)+getPathsStartingFromNviaRecursion(2, n-1));
		}
		case 3:
		{
			return (getPathsStartingFromNviaRecursion(2, n-1)+getPathsStartingFromNviaRecursion(6, n-1)+getPathsStartingFromNviaRecursion(3, n-1));
		}
		case 4:
		{
			return (getPathsStartingFromNviaRecursion(1, n-1)+getPathsStartingFromNviaRecursion(7, n-1)+getPathsStartingFromNviaRecursion(5, n-1)+getPathsStartingFromNviaRecursion(4, n-1));
		}
		case 5:
		{
			return (getPathsStartingFromNviaRecursion(2, n-1)+getPathsStartingFromNviaRecursion(4, n-1)+getPathsStartingFromNviaRecursion(6, n-1)+getPathsStartingFromNviaRecursion(8, n-1)+getPathsStartingFromNviaRecursion(5, n-1));
		}
		case 6:
		{
			return (getPathsStartingFromNviaRecursion(3, n-1)+getPathsStartingFromNviaRecursion(9, n-1)+getPathsStartingFromNviaRecursion(5, n-1)+getPathsStartingFromNviaRecursion(6, n-1));
		}
		case 7:
		{
			return (getPathsStartingFromNviaRecursion(4, n-1)+getPathsStartingFromNviaRecursion(8, n-1)+getPathsStartingFromNviaRecursion(7, n-1));
		}
		case 8:
		{
			return (getPathsStartingFromNviaRecursion(0, n-1)+getPathsStartingFromNviaRecursion(5, n-1)+getPathsStartingFromNviaRecursion(7, n-1)+getPathsStartingFromNviaRecursion(9, n-1)+getPathsStartingFromNviaRecursion(8, n-1));
		}
		case 9:
		{
			return (getPathsStartingFromNviaRecursion(6, n-1)+getPathsStartingFromNviaRecursion(8, n-1)+getPathsStartingFromNviaRecursion(9, n-1));
		}
		default:
			System.out.println("Invalid "+i);
			return 0;
		}
	}

}
