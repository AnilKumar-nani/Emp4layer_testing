# Emp4layer_testing

Requirement is to write 4 layer employee program by conncting with database and to test with junit.
Here, I added 8 class which contains their own details

The Emp class contains the details of the employee like their name, desig, sal , emailid etc.
Here i made class as abstract. so , that no one can create object to this class. and by using setters and getters methods we can initiate the values

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
    
and the Clerk class contains raisesal method which raises the sal and it is inherited from emp class

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
the Programmer class also inherited from the emp class with  a raise sal method

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

The manager class contains raiseSal method and the class was inherited from Emp class

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
And the Database class conains the conncetion between java and database with prepared, result,statements

    try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iprime_assignment","root","12345");
          ps =con.prepareStatement("insert into emp3 values(?,?,?,?,?); ");
          ps.setString(1,emp.getName());
          ps.setInt(2,emp.getAge());
          ps.setString(3,emp.getDesig());
          ps.setInt(4,emp.getSal());
          ps.setString(5,emp.getEmailId());
          return ps.executeUpdate();
          
    Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
    
and the maintain class contains 

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

and the main class contains the userinterface and conncetion among all classes

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

test class contains all the testes

class TestThisEmp {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testInsert1() {
		Emp e = new Clerk("anil",22,"anil@gmail.com");
		assertEquals(new DataBase().insert(e),1);
	}
	
	@Test
	void testInsert2() {
		Emp e = new Manager("mahesh",23,"mahesh@gmail.com");
		assertEquals(new DataBase().insert(e),1);
	}
	
	@Test
	void testInsert3() {
		Emp e = new Programmer("pokiri",24,"pokiri@gmail.com");
		assertEquals(new DataBase().insert(e),1);
	}
	
	@Test
	void testDisplay() {
		assertFalse(new DataBase().display().isEmpty());
	}
	
	@Test
	void testRaiseSal1() {
		Emp emp = new Manager();
		emp.setDesig("Manager");
		assertTrue(new DataBase().raiseSal(emp));
	}
	
	@Test
	void testRaiseSal2() {
		Emp emp = new Clerk();
		emp.setDesig("Clerk");
		assertTrue(new DataBase().raiseSal(emp));
	}
	
	@Test
	void testRaiseSal3() {
		Emp emp = new Programmer();
		emp.setDesig("Programmer");
		assertTrue(new DataBase().raiseSal(emp));
	}
 
}





