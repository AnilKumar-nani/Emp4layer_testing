package emp4layer;

public class Programmer extends Emp{
	Programmer(){}
	public Programmer(String name, int age, String emailId) {
		super( name,"Programmer", emailId, age, 25000);
	}
	public void raiseSal()
	{
		int sal = getSal();
		sal = sal+10000;
		setSal(sal);
	}

}
