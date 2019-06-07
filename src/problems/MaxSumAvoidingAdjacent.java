package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxSumAvoidingAdjacent {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int tc = Integer.parseInt(br.readLine());
			while(tc-->0) {
				int n = Integer.parseInt(br.readLine());
				Integer[] nums = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
				List<Integer> res = new ArrayList<>();
				List<Integer> old = new ArrayList<>();
				int ps = nums[0], cs = 0, ms = 0;
				int i = 1;
				int removed = 0;
				Boolean isPrev = false;
				for(i=1;i<n;i++) {
					/*if(ps>=cs) {
						int tmp = removed;
						ms = ps;
						if(res.size()>0 && i>1) {
							if(res.get(res.size()-1) == nums[i-2])
								tmp = res.remove(res.size()-1);
						}
						if(removed != 0)
							res.add(removed);
						removed = tmp;
						if(nums[i-1]!=0) {
							res.add(nums[i-1]);
						}
					}
					else {
						ms = cs;
					}*/

					if(ps > cs)
					{
						if(isPrev) {
							old.remove(old.size()-1);
							old.add(nums[i-1]);
						}
						else {
							old.add(nums[i-1]);
						}
						ms = ps;
						isPrev = true;
					}
					else {
						isPrev = false;
					}
					ps = cs + nums[i];
					cs = ms;
					System.out.println(old+ " sum "+ms);

				}
				if(ps>cs) {

					ms = ps;
					if(res.size()>0 && i>1) {
						if(res.get(res.size()-1) == nums[i-2])
						res.remove(res.size()-1);
					}
					if(nums[i-1]!=0) {
						res.add(nums[i-1]);
					}
				}
				else {
					ms = cs;
				}
				System.out.println("max sum "+ms);
				StringBuilder sb = new StringBuilder("");
				Collections.reverse(res);
				for(int x : res) {
					sb.append(x);
				}
				System.out.println(sb.toString());
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

}


/*
487
----
13
----
1211
----
454
----
105


5
5
-1 7 8 -5 4
4
3 2 1 -1
4
11 12 -2 -1
4
4 5 4 3
4
5 10 4 -1 


2
8
4 5 4 3 -9 -999 1000 -1000  
16
4 5 4 3 0 0 0 -2 -3 -4 0 -6 4 5 4 3 

*/