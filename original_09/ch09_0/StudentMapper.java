package ch09_0;

import java.util.List;

public interface StudentMapper {
	public List<Student> getStudents(); // Student List객체를가져와라 
	//매퍼와 똑같은 이름으루ㅗ 만들어줌
	public void insertStudent(Student s);
	public void deleteLastStudent(Student s);
	public void deleteSelectedStudent(Student s);
	public void deleteVersion2(String id);
}
