package emp4layer;

public class Manager extends Emp {
	Manager(){}
	public Manager(String name, int age, String emailId) {
		super( name,"Manager", emailId, age, 26000);
	}
	public void raiseSal()
	{
		int sal = getSal();
		sal = sal+22000;
		setSal(sal);
	}

}
