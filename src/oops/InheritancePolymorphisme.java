package oops;

public class InheritancePolymorphisme {

	public static void main(String[] args) {

		Shape s = new Shape();
		s.draw();
		Circle c = new Circle();
		c.draw();
		//Circle cs = (Circle) new Shape(); //java.lang.ClassCastException: oops.Shape cannot be cast to oops.Circle
		//cs.draw();
		Shape sc = new Circle();
		sc.draw();
	}

}

class Shape {
	Shape() {
		System.out.println("Shape Constructor");
	}
	public void draw() {
		System.out.println("Shape");
	}
}

class Circle extends Shape {
	Circle() {
		System.out.println("Circle Constructor");
	}
	public void draw() {
		System.out.println("Circle");
	}
}