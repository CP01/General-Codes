package oops;

public class Polymorphism {

	public static void main(String[] args) {

		me("hello");
		me('c');
		me(30);
		me(30l);
		me(30f);
		Integer x = 5;
		me(x);
	}

	public static void me(String x) {
		System.out.println(x + " String");
	}
	public static void me(Object x) {
		System.out.println(x.toString()+" Object");
	}


	public static void me(int x) {
		System.out.println(x + " int");
	}
	public static void me(Integer x) {
		System.out.println(x.toString()+" Integer");
	}
}
