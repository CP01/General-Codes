package oops;

public class InterfaceAndDefault {

	public static void main(String[] args) {

		new C().print();
	}

}

interface A{
	default void print() {
		System.out.println("A's default");
	}
}

interface B{
	default void print() {
		System.out.println("B's default");
	}
}

class C implements A, B {

	// Now C must have to provide its own implementation for duplicate default method print()
	// if not provided then it has compile time error.
	public void print() {
		//B.super.print();
		System.out.println("In C's print");
		//A.super.print();
	}
	
}