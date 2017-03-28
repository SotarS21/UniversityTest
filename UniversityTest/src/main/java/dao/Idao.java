package dao;

import java.util.List;

import bean.Student;

public interface Idao {

	public void addStudentInBD(Student student);
	
	public void updateStudentInBD(Student student);
	
	public void deleteStudentById(long id);
	
	public List<Student> listOfStudent();
	
	public Student haveStudentById(long idStudent);
}
