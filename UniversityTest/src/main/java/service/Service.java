package service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import bean.Student;

import dao.Idao;

@Named
public class Service implements Iservice {
	
	@Inject
	private Idao dao;

	@Override
	public void addStudentInBD(Student student) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateStudentInBD(Student student) {
		// TODO Auto-generated method stub

	}


	@Override
	public List<Student> listOfStudent() {
		
		return dao.listOfStudent();
	}

	@Override
	public Student haveStudentById(long idStudent) {
		
		return dao.haveStudentById(idStudent);
	}

	@Override
	public void deleteStudentById(long id) {
		dao.deleteStudentById(id);
		
	}

}
