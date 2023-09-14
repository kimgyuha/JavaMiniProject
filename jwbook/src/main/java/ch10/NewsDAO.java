package ch10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//NewsDAO 객체: NewsDAO 객체는 데이터베이스와 연결하고 데이터베이스의 내용을 업데이트함
//데이터베이스와 상호 작용하고, 데이터베이스에서 뉴스 데이터를 가져오거나 데이터를 추가/삭제하는 메서드를 제공함. 
//데이터베이스 연결, SQL 쿼리 실행 및 데이터 조작에 관련된 작업을 수행
public class NewsDAO {
	final String JDBC_DRIVER = "org.h2.Driver";
	final String JDBC_URL = "jdbc:h2:tcp://localhost/~/jwbookdb";
	
	// open() <- DB와 연결하는 메서드
	public Connection open() {
		// 데이터베이스 연결(Connection)을 생성하고 반환하는 메서드
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			//드라이버 클래스 로드
			conn = DriverManager.getConnection(JDBC_URL,"jwbook","1234");
			//연결 생성
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public List<NewsDO> getAll() throws Exception {
		Connection conn = open(); //open()함수를 호출해서 db를 엶(연결)
		List<NewsDO> newsList = new ArrayList<>(); //빈 리스트 객체 생성
		
		String sql = "select aid, title, PARSEDATETIME(date,'yyyy-MM-dd hh:mm:ss') as cdate from news";
		//news 테이블의 모든 항목을 조회하는 쿼리문 
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//PreparedStatement 객체를 사용하여 데이터베이스의 쿼리를 실행함
		ResultSet rs = pstmt.executeQuery();
		//데이터베이스 쿼리를 실행해 얻은 값을 rs 변수에 저장
		try(conn; pstmt; rs) {
			while(rs.next()) {
				//ResultSet(rs)을 반복하며 
				NewsDO n = new NewsDO();
				//NewsDO객체 생성
				n.setAid(rs.getInt("aid"));
				//rs(쿼리문 실행값 중 n번째)의 순서(index개념)를 가져온 뒤
				//그 값을 NewsDO의 aid변수에 저장(setAid함수를 통해)
				n.setTitle(rs.getString("title"));
				n.setDate(rs.getString("cdate")); 
				//각 뉴스 기사의 데이터를 NewsDO객체의 변수에 저장
				newsList.add(n);
				//뉴스리스트에 뉴스를 하나씩 추가
			}
			return newsList;
			//데이터베이스 연결을 통해 가져온 값들로 newsList를 만든것을 반환 
		}
	}
	
	//뉴스를 하나만 가져온다는 것만 다르고 getAll과 같음
	public NewsDO getNews(int aid) throws SQLException {
		Connection conn = open();
		
		NewsDO n = new NewsDO();
		String sql = "select aid, title, img, PARSEDATETIME(date,'yyyy-MM-dd hh:mm:ss') as cdate, content from news where aid=?";
	
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, aid); // 1 <- 물음표 위치를 나타내는 숫자(정확한 의미: 사용자 입력값을 전달하기 위한 HTML 폼 요소의 순서)
		//jsp파일 getNews의 첫번째 물음표의 위치를 말함, aid의 값에 따라 1개의 뉴스가 선택됨
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		
		try(conn; pstmt; rs) {
			n.setAid(rs.getInt("aid"));
			n.setTitle(rs.getString("title"));
			n.setImg(rs.getString("img"));
			n.setDate(rs.getString("cdate"));
			n.setContent(rs.getString("content"));
			pstmt.executeQuery();
			return n; // 지정된 뉴스 (1개) 반환
		}
	}
	
	public void addNews(NewsDO n) throws Exception {
		Connection conn = open();
		
		String sql = "insert into news(title,img,date,content) values(?,?,CURRENT_TIMESTAMP(),?)";
		//insert쿼리문
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try(conn; pstmt) {
			pstmt.setString(1, n.getTitle()); //물음표의 위치(1)에 맞게 값을 넣음)
			pstmt.setString(2, n.getImg());
			pstmt.setString(3, n.getContent());
			pstmt.executeUpdate();
		}
		//뉴스를 추가하는 것이므로 반환하는 객체가 없음
	}
	
	public void delNews(int aid) throws SQLException {
		Connection conn = open();
		
		String sql = "delete from news where aid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try(conn; pstmt) {
			pstmt.setInt(1, aid); // 지정한 뉴스 삭제
			// 삭제된 뉴스 기사가 없을 경우
			if(pstmt.executeUpdate() == 0) {
				throw new SQLException("DB에러");
			}
		}
	}
}
