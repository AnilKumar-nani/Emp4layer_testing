package emp4layer;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("1.Insert \n2.Display\n3.RaiseSalary\n4.exit...");
			choice = scanner.nextInt();
			switch(choice) {
			case 1: Maintain.getServe().insertLogic();
				break;
			case 2: Maintain.getServe().showAllRecords();
				break;
			case 3:	Maintain.getServe().raiseSalaryLogic();
				break;
			case 4: System.out.println("exiting...");
			        break;
				default: System.out.println("invalid choice..."); 
						break;
			}
		} while(choice != 4);
		scanner.close();
	}
}