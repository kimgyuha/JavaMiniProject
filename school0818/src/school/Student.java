package school;


public class Student {
	private String studentName;
	static int serialNum = 1000;
	Subject majorSubject;


	public Student() {}
	public Student(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	
	public Subject getMajorSubject() {
		return majorSubject;
	}
	public void setMajorSubject(Subject majorSubject) {
		this.majorSubject = majorSubject;
	}
	public String toString() {
		return studentName;
	}
	
}
