package school;
import java.util.List;
import java.util.ArrayList;



public class Subject {
	private String subjectName;
	private int subjectId;
	private int gradeType;

	private List<Student> studentList = new ArrayList<Student>();
	public Subject() {}
	public Subject(String subjectName, int subjectId) {
		this.subjectName = subjectName;
		this.gradeType = Define.AB_TYPE;
	}
	
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String toString() {
		return subjectName;
	}
	
}
