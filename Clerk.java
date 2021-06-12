package emp4layer;

public class Clerk extends Emp 
{
	Clerk(){}
	public Clerk(String name, int age, String emailId) {
		super( name,"clerk", emailId, age, 22000);
	}
	public void raiseSal()
	{
		int sal = getSal();
		sal = sal+20000;
		setSal(sal);
		
	}

}
