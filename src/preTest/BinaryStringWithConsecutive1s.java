package preTest;

/*
Find the number of binary strings of length N with at least X consecutive 1s
*/

public class BinaryStringWithConsecutive1s {

	public static void main(String[] args) {

		int len = 5;
		char ch[] = new char[len];
		for(int i=0;i<len;i++) {
			ch[i] = '0';
		}
		
		System.out.println("Total count : " + countStr(len-1, ch));
		
	}
	
	//Return count of binary strings which satisfied given condition
	public static int countStr(int n, char[] ch) {
		if(n<0) {
			if(validateStr(ch))
				return 1;
			return 0;
		}
		ch[n] = '0';
		int ans = countStr(n-1, ch);
		ch[n] = '1';
		ans += countStr(n-1, ch);
		ch[n] = '0';
		return ans;
	}

	//Validating for X=2, for any other X we can modify 'if' condition in validateStr() method as required
	private static boolean validateStr(char[] ch) {
		for(int i=1;i<ch.length;i++) {
			if(ch[i] == '1' && ch[i-1] == '1')
				return true;
		}
		return false;
	}

}
