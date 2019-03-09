package moveInSync;

public class Director extends Employee {

	Director(int id) {
		this(id, 1);
	}
	
	Director(int id, int priority) {
		super(id, priority);
	}

}
