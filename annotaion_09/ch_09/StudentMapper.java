package ch09MyBatisAnnotation;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper {
	@Select("SELECT * FROM student")
	public List<Student> getAll();
	
	@Insert("INSERT INTO student(username, univ, birth, email) VALUES(#{username}, #{univ}, #{birth}, #{email})")
	public void insert(Student s);
	
	@Delete("DELETE FROM student WHERE ID = #{id}")
	public void delete(String id);
}