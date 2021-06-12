package emp4layer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
