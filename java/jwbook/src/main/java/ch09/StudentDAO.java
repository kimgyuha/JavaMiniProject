package ch09;


import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class StudentDAO {
	String resource = "ch09/mybatis-config.xml";
	InputStream inputStream;
	SqlSessionFactory sqlSessionFactory;
	
	public StudentDAO() {
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	public void init() { 
	}
	public void insertStudent(Student s) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			 	StudentMapper mapper = session.getMapper(StudentMapper.class);
			  mapper.insertStudent(s);
			  session.commit();
			  }
		}
	
	public void deleteLastStudent(Student s) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			  StudentMapper mapper = session.getMapper(StudentMapper.class);
			  mapper.deleteLastStudent(s);
			  session.commit();
		}
	}
	public void deleteSelectedStudent(Student s) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			  StudentMapper mapper = session.getMapper(StudentMapper.class);
			  mapper.deleteSelectedStudent(s);
			  session.commit();
		}
	}
	public void deleteVersion2(String id) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			  StudentMapper mapper = session.getMapper(StudentMapper.class);
			  mapper.deleteVersion2(id);
			  session.commit();
		}
	}
	
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		try (SqlSession session = sqlSessionFactory.openSession()) {
			  StudentMapper mapper = session.getMapper(StudentMapper.class);
			  //긁어온 Blog 어쩌고를 student 어쩌고로 커스텀
			  students = mapper.getStudents();
			}

		return students;
	}
	
	
}
