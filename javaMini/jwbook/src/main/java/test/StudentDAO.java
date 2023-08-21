//package ch10;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class StudentDAO {
//	static Connection conn = null;
//	PreparedStatement pstmt;
//	
//	
//	final String JDBC_DRIVER ="oracle.jdbc.driver.OracleDriver";
//	final String JDBC_URL ="jdbc:oracle:thin:@localhost:1521/orcl";
//	
////	final String JDBC_DRIVER ="org.h2.Driver";
////	final String JDBC_URL ="jdbc:h2:tcp://localhost/~/jwbookdb";
////	
//	public void open() {
//	    try {
//	      Class.forName(JDBC_DRIVER);
//	      conn = DriverManager.getConnection(JDBC_URL, "scott", "tiger");
////	      conn = DriverManager.getConnection(JDBC_URL, "jwbook", "1234");
//	    }catch(Exception e) {
//	      e.printStackTrace();
//	    }
//	  }
//	public void close() {
//		try {
//			pstmt.close();
//			conn.close();
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	public void insert(Student s) {
//		open();
//		String sql = "INSERT INTO student(username, univ) values(?,?)";
//		
//		try {
//			pstmt=conn.prepareStatement(sql);
//			pstmt.setString(1, s.getUsername());
//			pstmt.setString(2, s.getUniv());
//			
//			pstmt.executeUpdate();
//		}catch(Exception e) {
//			e.printStackTrace();
//		} finally {
//			close();
//		}
//	}
//	// 여기서 부터 추가
////	public String delete(HttpServletRequest request, HttpServletResponse response) throws SQLException {
////    Student s = new Student();
////    
////    dao.delete(s);
////    return list(request, response);
////    }
//   //여기까지
//	
//	public List<Student> getAll() {
//		  open();
//		   List<Student> students = new ArrayList<>();
//		//String query = "SELECT * FROM student";
//		ResultSet rset;
//		
//		
//		try {
//			pstmt = conn.prepareStatement("select * from student");
//			rset = pstmt.executeQuery();//실행해서(~쿼리) 테이블(pstmt)로 가져옴
//			
//			while(rset.next()) {
//				Student s = new Student();
//				 s.setUsername(rset.getString("username"));
//			     s.setUniv(rset.getString("univ"));
//				
//			     students.add(s);
//			}
//		} catch (Exception e) {
//			e.printStackTrace(); 
//			}finally { 
//				close(); 
//			}
//		return students;
//	}
//}
//	
//	
//		
//
package test;


