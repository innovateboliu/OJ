package oop;

import java.util.ArrayList;
import java.util.Queue;

public class CallHandler {
	private static final int LEVEL = 3;
	private ArrayList<Employee>[] employeeLevels = new ArrayList[LEVEL];
	private Queue<Call>[] callLevels = new Queue[LEVEL];
	
	public CallHandler() {
		
	}
	
	public Employee getCallHandler(Call call) {
		switch (call.getRank()) {
		case 1 :
			for (Employee e : employeeLevels[0]) {
				if (e.isFree()) {
					return e;
				}
			}
			call.setRank(2);
			return getCallHandler(call);
		case 2 :
			
		}
		return null;
	}
}
