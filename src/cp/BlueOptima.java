package cp;

public class BlueOptima {

	public void doIt(int i, X x)
	{
		i = 5;
		x.num = 10;
	}
	
	public static void main(String[] args) {

		int j = 0;
		X x = new X();
		new BlueOptima().doIt(j, x);
		System.out.println(j + " "+x.num);
				
	}

}
class X {
	public int num;
}


/////////////////////////
/*

import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < T; t_i++) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] arr_arr = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i_arr = 0; i_arr < arr_arr.length; i_arr++) {
                arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
            }

            int[] out_ = solve(arr);
            wr.print(out_[0]);
            for (int i_out_ = 1; i_out_ < out_.length; i_out_++) {
                wr.print(" " + out_[i_out_]);
            }
            wr.println();
        }

        wr.close();
        br.close();
    }

    static int[] solve(int[] arr) {
        // the value at first index of array to be returned is number of pairs
        // formed and value at second index is unpaired swords.
        int res[] = new int[2];
        int start=0, end=0;
        int n = arr.length;
        Arrays.sort(arr);
        int newArr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            //System.out.print(arr[i] + " ");
            newArr[i] = arr[i];
        }
        for(int i=0;i<n;i++)
        {
            start = -1;
            if(2*arr[i]>arr[n-1])
                break;
            for(int j=i+1;j<n;j++)
            {
                if(2*arr[i]<=arr[j] && newArr[j] != -1) {
                    start = i;
                    newArr[j] = -1;
                    break;
                }
            }
            if(start!=-1)
            {
                end++;
            }
        }
        
        if(end==0) {
            res[0] = 0;
            res[1] = n;
        }
        else {
            if(end>(n/2)) {
                end=n/2;
            }
            res[0] = end;
            res[1] = n- 2*end;
        }
        
    return res;
    }
}
*/
