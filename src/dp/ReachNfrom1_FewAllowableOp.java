package dp;

public class ReachNfrom1_FewAllowableOp {

	public static void main(String[] args) {

		int tgt = 10;
		int src = 1;
		// Allowed ops are +1, -1, *2 all having equal cost
		for(int i=1;i<21;i++) {
		System.out.print(i + " took " + viaRecursion(src, i));
		System.out.println(" " + viaMath(src, i));
		}
		System.exit(0);
		int dp[][] = new int[tgt][tgt];
		for(int i=0;i<tgt;i++) {
			for(int j=0;j<tgt;j++) {
				if(i==j)
					continue;
				if(dp[j][i] != 0)
					dp[i][j] = dp[j][i];
				else
					viaDP(i, j, dp);
			}
		}
		
		System.out.println(dp[0][tgt]);
		
	}

	private static int viaMath(int src, int tgt) {
		int steps = 0;
		if(tgt>src) {
			int prvSq = 0, sq = 1;
			while(sq<tgt) {
				steps++;
				prvSq = sq;
				sq *= 2;
			}
			steps = steps + ((sq-tgt < tgt-prvSq) ? sq-tgt : tgt-prvSq-1);
		}
		return steps;
	}

	public static int viaRecursion(int i, int n) {
		//System.out.println(i);
		if(i==n)
		{
			return 0;
		}
		else if(i>n) {
			return 1 + viaRecursion(i-1, n);
		}
		return 1 + Math.min(viaRecursion(i+1, n),viaRecursion(2*i, n));
	}
	
	public static void viaDP(int i, int j, int[][] dp) {
		if(j>i) {// it should be i>j
			if(j==0)
				dp[i][j] = 1 + Math.min(i, j+1);
			else if(j==dp.length-1) {
				dp[i][j] = 1 + dp[i][j-1];
			}
			else {
				dp[i][j] = 1 + dp[i][j-1];//Math.min(dp[i][j-1], dp[i][j+1]);
			}
		}
		else {
			int prod = -1;
			
			if(j%2 == 0) {
				int num = j/2;
				if((num&num-1)==0)
				{
					prod = dp[i][num];
				}
			}
			dp[i][j] = 1 + Math.min(dp[i][j-1], prod);
		}
	}
}
