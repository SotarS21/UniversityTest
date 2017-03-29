package controler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import bean.Student;
import service.Iservice;


@Named
@SessionScoped
public class Controler implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Student> students = new ArrayList<>();
	
	@Inject
	private Iservice serv;
	
	public Student selectStudentById(long idStudent){
		return serv.haveStudentById(idStudent);
	}

	public List<Student> getStudents() {
		return students;
	}

	
	public String selectStudent(long id) {
	//	Student t = (Student)dataTable.getRowData();
		Student tmp = serv.haveStudentById(id);
		
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		
		Map<String, Object> map = context.getRequestMap();
		map.put("student", tmp);
		//t = DBManager.getInstance().loadFullTopic(t.getId());
//		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
//		request.setAttribute("student", t);
		return "updateStudent";
	}
	
	public void loadStudents()
	{
		students.clear();
		
		students = serv.listOfStudent();

	}
	
	
	public String addStudent(Student student)
	{
		this.serv.addStudentInBD(student);
		
		return "index?faces-redirect=true";
	}
	
	public String updateStudent(Student student)
	{
		this.serv.updateStudentInBD(student);
		return "index?faces-redirect=true";
	}
	
	public String deleteStudent(long studentId)
	{
		this.serv.deleteStudentById(studentId);
		return "index?faces-redirect=true";
	}
	
}
