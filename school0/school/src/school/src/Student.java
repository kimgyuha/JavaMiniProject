package school.src;


public class Student {
	private String studentName;
	static int serialNum = 1000;


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
	public String toString() {
		return studentName;
	}
}
