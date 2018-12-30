package gs;

public class CompressedString {

	public static void main(String[] args) {

		StringBuilder str = new StringBuilder("aaabaaaaccaaaaba");
		int n = str.length();
		if(n<2)
			System.out.println(str.toString());
		else {
			int cnt = 1;
			for(int i=0;i<n;i++)
			{
				if(i<n-1 && str.charAt(i) == str.charAt(i+1))
				{
					cnt++;
				}
				else {
					if(cnt!=1)
						str.append(str.charAt(i)+""+cnt);
					else
						str.append(str.charAt(i));
					cnt = 1;
				}
			}
			System.out.println(str);
		}
	}

}
