package gs;

import java.util.Arrays;

public class CoderPad3 {

	public static void main(String[] args) {

		int[][] arr = {{0,0,0,1,5},
						{0,7,0,1,0},
						{0,9,0,0,15},
						{0,0,0,0,5}};
		int row = arr.length;
		int col = arr[0].length;

		int[][] ar = new int[row][col];

		for(int i=0;i<row;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				ar[i][j]=arr[i][j];
			}
			System.out.println();
		}
		
		for(int i=row-1;i>=0;i--)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				if(i>0)
				{
					if(arr[i-1][j] < ar[i-1][j]+arr[i][j])
						arr[i-1][j] = ar[i-1][j]+arr[i][j];
				}
				if(j<col-1)
				{
					if(arr[i][j+1] < ar[i][j+1]+arr[i][j])
					arr[i][j+1] = ar[i][j+1]+arr[i][j];
				}
			}
		}
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				System.out.print(ar[i][j]+":"+arr[i][j]+" , ");
			}
			System.out.println();
		}
		System.out.println(arr[0][col-1]);
		System.out.println("---------------------");
		System.out.println(dpSol(ar, row-1, 0));
		
	}
	
	public static int dpSol(int arr[][], int i, int j)
	{
		if(i<0)
			return 0;
		if(j>=arr[0].length)
			return 0;
		return Math.max(dpSol(arr, i-1, j), dpSol(arr, i, j+1)) + arr[i][j];
	}

}
