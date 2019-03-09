package moveInSync;

public class Manager extends Employee {

	Manager(int id) {
		this(id, 2);
	}
	
	Manager(int id, int priority) {
		super(id, priority);
	}

}
