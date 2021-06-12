package emp4layer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Maintain {
	private String name;
	private int age;
	private String emailId;
	private boolean readData() {
		try {
			System.out.println("Enter name...");
			name = br.readLine();
			System.out.println("Enter age...");
			age = Integer.parseInt(br.readLine());
			System.out.println("Enter emailId...");
			emailId = br.readLine();
			return true;
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		} 
		return false;
	}
	private static DataBase getLogic() {
		return new DataBase();
	}
	public static Maintain getServe() {
		return new Maintain();
	}
	Scanner scanner = new Scanner(System.in);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public void insertLogic() {
		System.out.println("1.Clerk\n2.Manger\n3.Programmer\n4.Exit...");
		int choice = scanner.nextInt();
		Emp emp = null;
		String error = "error while reading data...";
		switch(choice) {
				
		case 1: if(!readData()) {
					System.out.println(error);
					return;
				}
				emp = new Clerk(name, age,emailId);
			break;
		case 2: if(!readData()) {
					System.out.println(error);
					return;
				}
				emp = new Manager(name, age,emailId);
			break;
		case 3:if(!readData()) {
					System.out.println(error);
					return;
				}
				emp = new Programmer(name, age,emailId);
			break;
		case 4:System.out.println("exiting...");
				return;
			default: System.out.println("Invalid entry..."); 
				return;
		}
		getLogic().insert(emp);
		
	}
	public void showAllRecords() {
		List<Emp> emplist = getLogic().display();
		for(Emp e: emplist) {
			System.out.println(e);
		}
	}
	public void raiseSalaryLogic() {
		System.out.println("1.Clerk\n2.Manger\n3.Programmer\n4.Exit...");
		int choice = scanner.nextInt();
		Emp emp = null;
		switch(choice) {
				
		case 1: emp = new Clerk();
				emp.setDesig("Clerk");
			break;
		case 2: emp = new Manager();
				emp.setDesig("Manager");
			break;
		case 3:	emp = new Programmer();
				emp.setDesig("Programmer");
				
			break;
		case 4:System.out.println("exiting...");
				return;
			default: System.out.println("Invalid entry..."); 
				return;
		}
		if(emp != null) getLogic().raiseSal(emp);
	}
	
}
