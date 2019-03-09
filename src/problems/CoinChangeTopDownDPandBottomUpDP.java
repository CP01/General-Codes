package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinChangeTopDownDPandBottomUpDP {

	public static void main(String[] args) {
		
		int total = 54;
        int coins[] = {7, 3, 6};
        CoinChangeTopDownDPandBottomUpDP cc = new CoinChangeTopDownDPandBottomUpDP();
        Map<Integer, Integer> map = new HashMap<>();
        //int bottomUpValue = cc.minimumCoinBottomUp(total, coins);

        long start = System.currentTimeMillis();
		System.out.println("by Top Down Approach "+ cc.minCoinsTopDownDP(coins, total, map));
		System.out.println("Time taken by DP "+ (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		System.out.println("by Iterative Approach "+ cc.minCoinIterative(coins, total));
		System.out.println("Time taken by Iterative "+ (System.currentTimeMillis() - start));

	}

	// map<total, minCoins>
	public int minCoinsTopDownDP(int[] coins, int total, Map<Integer,Integer> map){
		if(total == 0)
			return 0;
		if(map.containsKey(total))
			return map.get(total);
		
		int min = Integer.MAX_VALUE;
		for(int i=0;i<coins.length;i++) {
			if(total<coins[i])
				continue;
			
			int val = minCoinsTopDownDP(coins, total-coins[i], map);
			
			if(val<min)
				min = val;
			
		}
		
		if(min != Integer.MAX_VALUE)
			min = min + 1;
		
		return min;
	}
	
	
/*
 * Iterative Approach failing for cases like below :
 int total = 54;
 int coins[] = {7, 3, 6};
 
 It requires proper backtracking to resolve it.
 * */
	public int minCoinIterative(int[] coins, int total) {
		Arrays.sort(coins);
		List<Integer> list = new ArrayList<>();
		int count = 0;
		while(total>0) {
			for(int i=coins.length-1;i>=0;) {
				if(coins[i]<total) {
					total = total - coins[i];
					System.out.print(coins[i]+" ");
					list.add(coins[i]);
					count++;
				}
				else if(coins[i]==total)
				{
					total = total - coins[i];
					System.out.print(coins[i]+" ");
					list.add(coins[i]);
					count++;
					break;
				}
				else {
					if(coins[0]>total && total != 0)
					{
						int tmp = list.remove(list.size()-1);
						total = total + tmp;
						count--;
						for(int j=0;j<coins.length;j++) {
							if(coins[j] == tmp) {
								tmp = j-1;
								break;
							}
						}
						i = tmp;
						continue;
					}
					i--;
				}
			}
		}
		return count;
	}
	
}
