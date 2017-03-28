package dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import bean.Student;

@Named
public class DAO implements Idao {

	@Override
	public void addStudentInBD(Student student) {
		Connector.getInstance().AddObject(student);
	}

	@Override
	public void updateStudentInBD(Student student) {
		Connector.getInstance().updateObj(student);
		
	}

	@Override
	public void deleteStudentInBD(Student student) {
		Connector.getInstance().removeObject(student);
		
	}

	@Override
	public List<Student> listOfStudent() {
		List<Student> listStudent = new ArrayList<>();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		
		TypedQuery<Student> query = em.createQuery("select from student", Student.class);
		
		listStudent = query.getResultList();
		
		transaction.commit();
		
		return  listStudent;
	}

	@Override
	public Student haveStudentById(long idStudent) {
		Connector.getInstance().getElementById(Student.class, idStudent);
		return null;
	}

}
