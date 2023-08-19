package ch09MyBatisAnnotation;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class StudentDAO implements StudentMapper {
	SqlSessionFactory sqlSessionFactory;
	
	public StudentDAO() {
		try {
			String resource = "ch09MyBatisAnnotation/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void insert(Student s) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			mapper.insert(s);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Student> getAll() {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			return mapper.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Student>();
		}
	}
	
	@Override
	public void delete(String id) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			mapper.delete(id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
