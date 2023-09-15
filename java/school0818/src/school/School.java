package school;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class School {
	private static School instance = new School();
	
	private static String SCHOOL_NAME = "Good School";
	private List<Student> studentList = new ArrayList<Student>();
	private List<Subject> subjectList = new ArrayList<Subject>();
	//school이 studentList와 subjectList를 멤버변수로 가지고 있음
	List<Score> scoreList = new ArrayList<Score>(); 
	Map<Subject, Map<String, Integer>> totalMap = new HashMap<>();
	private School() {}

	public static School getInstance() {
		if(instance == null)
			instance = new School();
		return instance;
	}
	
	public List<Student> getStudentList(){
		return studentList;
	}
	
	public void addStudent(Map<Subject, Map<String, Integer>> map) {
		totalMap.putAll(map);
	}
	
	public void addSubject(Subject subject) {
		subjectList.add(subject);
	}
	
	public List<Subject> getSubjectList(){
		return subjectList;		
	}
	public void setSubjectList(List<Subject> subjectList) {
		this.subjectList = subjectList;
	}
}
