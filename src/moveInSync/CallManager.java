package moveInSync;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class CallManager {

	static Queue<Calls> callsInWait = new LinkedList<>();
	static List<Calls> activeCalls = new ArrayList<>();
	
	static Stack<Employee> stackRespondent = new Stack();
	static Stack<Employee> stackManager = new Stack();
	static Stack<Employee> stackDirector = new Stack();
	
	public static void main(String[] args) {

		// Assuming fix numbers of employees
		
		CallManager callHandler = new CallManager();
		
		Employee e1 = new Respondent(101);
		Employee e2 = new Respondent(102);
		Employee e3 = new Respondent(103);
		Employee e4 = new Respondent(104);
		Employee e5 = new Respondent(105);
		
		Employee e6 = new Manager(201);
		Employee e7 = new Manager(202);
		Employee e8 = new Manager(203);
		
		Employee e9 = new Director(301);
		Employee e10 = new Director(302);
		
		stackRespondent.push(e1);
		stackRespondent.push(e2);
		stackRespondent.push(e3);
		stackRespondent.push(e4);
		stackRespondent.push(e5);
		
		stackManager.push(e6);
		stackManager.push(e7);
		stackManager.push(e8);
		
		stackDirector.push(e9);
		stackDirector.push(e10);
		
		for(int i=0;i<12;i++) {
			Calls call = new Calls();
			callHandler.dispatchCall(call);
		}

		callHandler.printActiveCalls();
		callHandler.printCallsInWait();
		
		callHandler.endCall(activeCalls.get(2));

		callHandler.printActiveCalls();
		callHandler.printCallsInWait();
		
		callHandler.dispatchCall(new Calls());

		callHandler.printActiveCalls();
		callHandler.printCallsInWait();
		
		callHandler.endCall(activeCalls.get(7));
		callHandler.endCall(activeCalls.get(2));
		callHandler.endCall(activeCalls.get(1));
		
		callHandler.printActiveCalls();
		callHandler.printCallsInWait();
		
		callHandler.dispatchCall(new Calls());
		
		callHandler.printActiveCalls();
		callHandler.printCallsInWait();
		

	}
	
	public void dispatchCall(Calls call) {
		if(!stackRespondent.isEmpty()) {
			call.allocate(stackRespondent.pop());
			activeCalls.add(call);
		}
		else if(!stackManager.isEmpty()) {
			call.allocate(stackManager.pop());
			activeCalls.add(call);
		}
		else if(!stackDirector.isEmpty()) {
			call.allocate(stackDirector.pop());
			activeCalls.add(call);
		}
		else {
			callsInWait.add(call);
		}
	}
	
	public void endCall(Calls call) {
		Employee emp = null;

		emp = call.getEmp();
		activeCalls.remove(call);
		call =  null;
		switch(emp.getPriority()) {
		case 3:
			stackRespondent.add(emp);
			break;
		case 2:
			stackManager.add(emp);
			break;
		case 1:
			stackDirector.add(emp);
			break;
		default:
			throw new RuntimeException("Invalid Employee Type");
		}

		if(!callsInWait.isEmpty())
		{
			call = callsInWait.poll();
			dispatchCall(call);
		}

	}
	
	public void printActiveCalls() {

		System.out.println("Printing Active Calls");
		for(Calls cal : activeCalls) {
			System.out.println("Call Num : "+cal.getCallNum() + " Emp Priority : "+cal.getEmp().getPriority()
					+" Emp Id : "+cal.getEmp().getId());
		}
	}
	
	public void printCallsInWait() {

		System.out.println("Printing Queue");
		for(Calls cal : callsInWait) {
			System.out.println(cal.getCallNum());
		}
	}

}
