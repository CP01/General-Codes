package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QueenObstacles {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t;
		try {
			t = Integer.parseInt(br.readLine());
			while(t-->0) {
				String str = br.readLine();
				int n = Integer.parseInt(str.substring(0,str.indexOf('(')-1));
				int x = Integer.parseInt(str.substring(str.indexOf('(')+1,str.indexOf(',')));
				int y = Integer.parseInt(str.substring(str.indexOf(',')+1, str.indexOf(')')));
				//System.out.println(n+" "+x+" "+y);
				int sum = 2 * (n-1);
				sum = sum + (n-1) - Math.abs((x-y));
				sum = sum + (n-1) - Math.abs((x-(n+1-y)));
				System.out.println(n*n - sum);
			}

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}
/*
Input
2
4 (1,1)
5 (3,4)

Output
7
11
 */