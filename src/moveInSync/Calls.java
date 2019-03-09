package moveInSync;

public class Calls {
	private static int overallCallSeq = 0;
	private Employee emp;
	private int callNum;
	
	Calls() {
		this.emp = null;
		overallCallSeq++;
		this.callNum = overallCallSeq;
	}
	
	public void allocate(Employee e) {
		this.emp = e;
	}
	
	public Employee getEmp() {
		return emp;
	}
	
	public int getCallNum() {
		return callNum;
	}

}
