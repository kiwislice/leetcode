package leetcode.hashtable;

import java.util.List;

/**
 * https://leetcode.com/problems/employee-importance/
 */
public class EmployeeImportance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getImportance(List<Employee> employees, int id) {
		Employee[] emps = new Employee[2000+1];
		
		for(Employee e:employees) {
			emps[e.id] = e;
		}
		return sum(emps, id);
	}
	
	public static int sum(Employee[] emps, int id) {
		int sum = emps[id].importance;
		if( emps[id].subordinates!=null ) {
			for(int eid:emps[id].subordinates) {
				sum += sum(emps, eid);
			}
		}
		return sum;
	}

	static class Employee {
		// It's the unique id of each node;
		// unique id of this employee
		public int id;
		// the importance value of this employee
		public int importance;
		// the id of direct subordinates
		public List<Integer> subordinates;
	};

}
