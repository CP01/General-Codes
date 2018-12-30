package gs;

import java.util.Scanner;

public class CorrespondingClosingParantheses {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-->0)
		{
			sc.nextLine();
			String str = sc.nextLine();
			int n = sc.nextInt();
			int top = 0, ctr = 0;
			char[] chArr = new char[str.length()];
			int index = -1;
			for(int i=0;i<str.length();i++)
			{
				if(str.charAt(i) == '{')
				{
					chArr[top++] = '{';
				}
				else if(str.charAt(i) == '}')
				{
					chArr[--top] = '\0';
					if(ctr==n-1)
					{
						index = i;
						break;
					}
					ctr++;
				}
			}
			System.out.println(index);
			
		}
		
	}

}
