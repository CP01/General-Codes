package preTest;

import java.util.Date;

public class DateTest {

	public static void main(String[] args) {

		Date d1 = new Date();
		Date d2 = new Date();
		long diff = d2.getTime()-d1.getTime();
		System.out.println(diff);
	}

}
