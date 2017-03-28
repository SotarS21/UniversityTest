package controler;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import bean.Student;
import service.Iservice;


public class Controler {

	private List<Student> students = new ArrayList<>();
	
	@Inject
	private Iservice serv;
	
	public Student selectStudentById(long idStudent){
		return serv.haveStudentById(idStudent);
	}

	public List<Student> getStudents() {
		return serv.listOfStudent();
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	
}
