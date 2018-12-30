package cp;

public class StringTest {

	public static void main(String[] args) {

		String str = "VARCHAR () FOR BIT DATA";
		str = replaceParanthesis(str);
		System.out.println(str);
	}
	public static String replaceParanthesis(String string) {
		if(string.contains(" () ")) {
			string = string.replaceAll(" \\(\\) ", "_");
		}
		if(string.contains(" ")) {
			string = string.replaceAll(" ", "_");
		}
		return string;
	}

}
