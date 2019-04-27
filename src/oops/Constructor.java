package oops;

public class Constructor {

	public static void main(String[] args) {

	}

}

class Parent {
	Parent(int x) {
		System.out.println("Parent Constructor");
	}
	
	
}

class Child extends Parent {
	Child(int x) {
		super(x); // if you comment this, you will get compile time error because no-arg constructor is missing in parent class
		System.out.println("Child Constructor");
	}
}