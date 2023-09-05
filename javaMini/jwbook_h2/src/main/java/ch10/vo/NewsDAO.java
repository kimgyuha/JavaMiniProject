package ch10.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDAO {
	final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521/orcl";
	
	public Connection open(){
		Connection conn=null;
		try {
			Class.forName(JDBC_DRIVER);
			conn=DriverManager.getConnection(JDBC_URL, "scott", "tiger");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public void addNews(NewsDO n) throws Exception { //throws : 호출한놈에게 에러 떠넘김
		Connection conn = open(); //open()을 호출하면 conn을 채워서 return해줌
		
		String sql = "insert into news(aid,title,img,newsdate,content) values(aid.nextval,?,?,SYSDATE,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		try(conn;pstmt){ //향상된 트라이캐치분
			pstmt.setString(1, n.getTitle());//타이틀을 넣어서 sql문의 values ? 에 넣음
			pstmt.setString(2, n.getImg()); // 위와 마찬가지
			pstmt.setString(3, n.getContent());
			pstmt.executeUpdate();
		}
	}
	public List<NewsDO> getAll() throws Exception { 
		Connection conn = open();
		//실행할때마다 conn을 새로 만들어줘야함
		List<NewsDO> newsList = new ArrayList<>();
		
		String sql = "select aid, title, to_char(newsdate,'yyyy/MM/dd hh24:mi:ss') as newsdate from news";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//이까지는 준비과정
		ResultSet rs = pstmt.executeQuery(); //본격적인 실행
		
		try(conn;pstmt;rs){
			while(rs.next()) { //한번만 호출 -> 하나만 가져옴
				NewsDO n = new NewsDO();
				n.setAid(rs.getInt("aid"));
				n.setTitle(rs.getString("title"));
				n.setDate(rs.getString("newsdate"));
				
				newsList.add(n);
			}
			return newsList;
		}
	}
	
	public NewsDO getNews(int aid) throws SQLException {
		Connection conn = open();
		
		NewsDO n = new NewsDO();
		String sql = "select aid, title, img, to_char(newsdate, 'yyyy/MM/dd hh24:mi:ss') as newsdate, content from news where aid=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, aid); //1번째 자리에 aid 값을 넣어준다는 뜻, getNews(d)를 호출한 쪽이 매개변수를 넘겨줌
		//?에 값이 들어감
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		
		try(conn; pstmt; rs){ //rs에서 가져온 값들
			n.setAid(rs.getInt("aid"));
			n.setTitle(rs.getString("title"));
			n.setImg(rs.getString("img"));
			n.setDate(rs.getString("newsdate"));
			n.setContent(rs.getString("content"));
			return n;
			
		}

	}
	public void delNews(int aid) throws SQLException {
		Connection conn = open();
		
		String sql = "delete from news where aid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try(conn;pstmt){
			pstmt.setInt(1, aid); //?안에 aid값이 들어감
			if(pstmt.executeUpdate() == 0) {
				throw new SQLException("DB에러"); //throw는 강제 에러발생 (throws와 다름)
				
			}
		}
	}
	
 }


	