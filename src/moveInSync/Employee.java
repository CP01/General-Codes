package moveInSync;

public abstract class Employee {

	private int id;
	private int priority;
	
	Employee(int id, int priority) {
		this.id = id;
		this.priority = priority;
	}

	public int getId() {
		return id;
	}

	public int getPriority() {
		return priority;
	}
	
	
}
