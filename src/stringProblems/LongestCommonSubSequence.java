package stringProblems;

public class LongestCommonSubSequence {

	public static void main(String[] args) {

		String a = "abcdaf"; //"abcabcidrdef";
		String b = "abcbf"; //"bcabcaadfe";
		int dp[][] = new int[b.length()+1][a.length()+1]; //Keeping row < col, As b string is smaller so taken as row
		for(int i=0;i<=b.length();i++) {
			dp[i][0] = 0;
		}
		for(int i=0;i<=a.length();i++) {
			dp[0][i] = 0;
		}
		
		for(int i=0;i<b.length();i++) {
			for(int j=0;j<a.length();j++) {
				//if(('b'==a.charAt(j) || 'f' == a.charAt(j)) && a.charAt(j)==b.charAt(i)) {
				// Above variant can be used if subsequence must comprise of specific char set
				if(a.charAt(j)==b.charAt(i)) {
					dp[i+1][j+1] = dp[i][j] + 1;
				}
				else {
					dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
				}
			}

		}
		System.out.println("Size of LCS for given pair of Strings is "+dp[b.length()][a.length()]);
		StringBuilder lcs = new StringBuilder("");
		for(int i=b.length();i>0;) {
			for(int j=a.length();j>0;) {
				if(dp[i][j-1]==dp[i][j]) {
					j--;
					if(j==0) // Do we need this ???
						i--;
					continue;
				}
				else if(dp[i-1][j]==dp[i][j]) {
					i--;
					
					continue;
				}
				else {
					lcs.append(a.charAt(j-1));
					i--;
					j--;
				}
			}

		}
		System.out.println("LCS is "+lcs.reverse());
	}

}
