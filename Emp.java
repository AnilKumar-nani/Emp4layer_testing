package emp4layer;
import java.lang.*;

abstract public class Emp 
{
	private String name;
	private String desig;
	private String emailId;
	private int age;
	private int sal;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public Emp(String name, String desig, String emailId, int age, int sal) {
		super();
		this.name = name;
		this.desig = desig;
		this.emailId = emailId;
		this.age = age;
		this.sal = sal;
	}
	Emp() {}
	
	public void raiseSal() {}	
	public String toString() {
		return "----------------------------\nName    :"+name+"\nAge    :"+age+"\nDesignation    :"+desig+"\nSal    :"+sal+"\nEmailId	:"+emailId+"\n--------------------------------------";
	}
	
}

	
		
	