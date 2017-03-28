package dao;

import static org.junit.Assert.*;

import org.junit.Test;

import bean.Student;

public class TestonsDao {
	Student stud1 = new Student("albert", "Londres", "4f4f4");

	
	Idao dao = new DAO();
	
	
	@Test
	public void test() {
		Connector.getInstance().connection();
		
		dao.addStudentInBD(stud1);

		assertTrue(Connector.getInstance().getElementById(Student.class, 1l)!= null);
		Connector.getInstance().deconnection();
				
	}

}
