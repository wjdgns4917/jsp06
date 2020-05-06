package notice.dao;

import java.sql.*;

import notice.db.DBCon;
import notice.vo.Notice;

public class NoticeDao {
	
	public int delete(String seq) throws Exception {
//		//connect db
		String sql="delete from notices where seq=?";
//		//드라이버 로드
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//
//		//접속
//		String url="jdbc:oracle:thin:@localhost:1521:orcl";
//		String user="scott";
//		String pw="123456";
//		Connection con=DriverManager.getConnection(url, user, pw);
		
		Connection con= DBCon.getConnection();
		//실행
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, seq);
		int af=pstmt.executeUpdate(); //return int
		return af;
	}
	public int insert(Notice notice) throws Exception {
		//db connect
		String sql="insert into notices values("+"(select max(seq)+1 from notices),"+"?,'cj',?,sysdate,0)";
//		//드라이버 로드
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		//접속
//		String url="jdbc:oracle:thin:@localhost:1521:orcl";
//		String user="scott";
//		String pw="123456";
//		Connection conn=DriverManager.getConnection(url, user, pw);
		Connection con= DBCon.getConnection();
		//실행
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, notice.getTitle());
		pstmt.setString(2, notice.getContent());
		//결과
		int af=pstmt.executeUpdate(); //insert 실행
		
		pstmt.close();
		con.close();
		return af;
	}
	public int update(Notice notice) throws Exception {
		String sql="update notices set title=?,content=?where seq=?";
		//db connect
		//드라이버 로드
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		//접속
//		String url="jdbc:oracle:thin:@localhost:1521:orcl";
//		String user="scott";
//		String pw="123456";
//		Connection conn=DriverManager.getConnection(url, user, pw);
		Connection con= DBCon.getConnection();
		//실행
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, notice.getTitle());
		pstmt.setString(2, notice.getContent());
		pstmt.setString(3, notice.getSeq());

		//결과
		int af=pstmt.executeUpdate();
		System.out.println("af : "+af);
		return af;
	}
	public Notice getNotice(String seq) throws Exception {
		System.out.println("dao getNotice 지나감");
		String sql="select * from notices where seq="+seq;
		//db connect
		//드라이버 로드
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		//접속
//		String url="jdbc:oracle:thin:@localhost:1521:orcl";
//		String user="scott";
//		String pw="123456";
//		Connection conn=DriverManager.getConnection(url, user, pw);
		Connection con= DBCon.getConnection();
		//실행
		Statement st=con.createStatement();

		//결과
		ResultSet rs=st.executeQuery(sql); //select 실행
		rs.next();
		
		//Notice에 임시 저장하기
		Notice n=new Notice();
		n.setSeq(rs.getString("seq"));
		n.setWriter(rs.getString("writer"));
		n.setTitle(rs.getString("title"));
		n.setContent(rs.getString("content"));
		n.setRegdate(rs.getDate("regdate"));
		n.setHit(rs.getInt("hit"));
		
		rs.close();
		st.close();
		con.close();
		
		return n;
	}
}
