
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class EmployeeDetails {
	int enumber;
	String ename;
	int salary;
	String designation;
	String department;
	
	static int sortfield = 1;
	static int sortorder = 1;

	static Scanner sc = new Scanner(System.in);

	public void addEmp() {

		System.out.println("Enter employee Number");
		enumber = sc.nextInt();
		System.out.println("Enter employee Name");
		ename = sc.next();
		System.out.println("Enter employee Salary");
		salary = sc.nextInt();
		System.out.println("Enter employee Designation");
		designation = sc.next();
		System.out.println("Enter employee Department");
		department = sc.next();
	}
	public static HashMap<Integer, EmployeeDetails> sortByValue(
			HashMap<Integer, EmployeeDetails> hm) {

		List<Map.Entry<Integer, EmployeeDetails>> list = new LinkedList<Map.Entry<Integer, EmployeeDetails>>(
				hm.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Integer, EmployeeDetails>>() {
			public int compare(Map.Entry<Integer, EmployeeDetails> o1,
					Map.Entry<Integer, EmployeeDetails> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		HashMap<Integer, EmployeeDetails> temp = new LinkedHashMap<Integer, EmployeeDetails>();
		for (Map.Entry<Integer, EmployeeDetails> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}

	protected int compareTo(EmployeeDetails emp) {
		if (sortfield == 1) {
			if (sortorder == 2) {
				sortorder = -1;
			}
			return sortorder * ename.compareTo(emp.ename);
		}
		if (sortfield == 2) {
			if (sortorder == 2) {
				sortorder = -1;
			}
			return sortorder * (salary - emp.salary);
		}

		return 0;
	}
	public static void main(String... sd) {
		HashMap<Integer, EmployeeDetails> hm = new HashMap<>();
		outer: while (true) {
			System.out.println("1. Add Emp \n 2.View All Emp \n 3.Remove Emp \n 4. Clear Data \n 5. Change Sal \n 6.Search Emp \n 7. View dept Wise \n 8. Sort employees \n 9: Exit");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				EmployeeDetails e = new EmployeeDetails();
				e.addEmp();
				hm.put(e.enumber, e);

				break;
			case 2:
				for (EmployeeDetails e1 : hm.values()) {
					System.out.println(e1.enumber + " " + e1.ename + " " + e1.salary + " " + e1.designation + " " + e1.department);

				}
				break;
			case 3:
				for (EmployeeDetails e1 : hm.values()) {
					System.out.println(e1.enumber + " " + e1.ename + " " + e1.salary + " " + e1.designation + " " + e1.department);

				}
				System.out.println("Enter Eno from above table to delete emp");
				int del = sc.nextInt();
				hm.remove(del);
				for (EmployeeDetails e1 : hm.values()) {
					System.out.println(e1.enumber + " " + e1.ename + " " + e1.salary + " " + e1.designation + " " + e1.department);

				}
				break;
			case 4:
				Set<Integer> s = hm.keySet();
				for (int i : s) {
					hm.remove(i);

				}
				for (EmployeeDetails e1 : hm.values()) {
					System.out.println(e1.enumber + " " + e1.ename + " " + e1.salary + " " + e1.designation + " " + e1.department);

				}
				break;
			case 5:
				for (EmployeeDetails e1 : hm.values()) {
					System.out.println(e1.enumber + " " + e1.ename + " " + e1.salary + " " + e1.designation + " " + e1.department);

				}
				System.out.println("enter eno to update salary");
				int empno = sc.nextInt();
				System.out.println("enter new salary");
				int sal = sc.nextInt();
				EmployeeDetails e2 = hm.get(empno);
				e2.salary = sal;
				hm.put(empno, e2);
				for (EmployeeDetails e1 : hm.values()) {
					System.out.println(e1.enumber + " " + e1.ename + " " + e1.salary + " " + e1.designation + " " + e1.department);

				}

				break;
			case 6:
				System.out.println("enter eno to search");
				int empno1 = sc.nextInt();
			
				EmployeeDetails e3 = hm.get(empno1);
				System.out.println(e3.enumber + " " + e3.ename + " " + e3.salary + " " + e3.designation + " " + e3.department);
				break;
			case 7:
				
				System.out.println("enter dept to search all employee");
				String deptSearch = sc.next();
				 for(EmployeeDetails empl :hm.values()){
					 if(empl.department.equals(deptSearch)){
						 System.out.println(empl.enumber + " " + empl.ename + " " + empl.salary + " " + empl.designation + " " + empl.department);
					 }	 
				 }
				 break;
			case 8:
				System.out.println("Sort on Basis of \n 1.Employee Name \n 2.Employee Salary");
				EmployeeDetails.sortfield = sc.nextInt();
				System.out.println("Select a Sorting Order \n 1.asceding \n 2. descending");
				EmployeeDetails.sortorder = sc.nextInt();
				hm = sortByValue(hm);
				for (EmployeeDetails e1 : hm.values()) {
					System.out.println(e1.enumber + " " + e1.ename + " " + e1.salary + " " + e1.designation + " " + e1.department);

				}
				break;
			case 9:
				break outer;
			}

		}

	}
}