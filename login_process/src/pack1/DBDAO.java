package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBDAO {
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	
	public static Connection conn = null;
	
	public static void init() {//init를 사용해서 DB연결을 할 것임.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 프로토콜
			String user_id = "temp";
			String pw = "12345";

			conn = DriverManager.getConnection(url, user_id, pw);
			
			String sql = "insert into info (id, pw) "
						+ "values(?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			if (conn != null) {
				System.out.println("===DB 연결 완료===");
			} else {
				System.out.println("===DB 연결 실패===");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 연결 오류 또는 쿼리(문장) 오류");
			e.printStackTrace();
		}
	}
//////------아래 두개 메소드를 만들어 놓았기 때문에 필요할때 사용가능하다.
	// 조회.
	public static ResultSet getResultSet(String sql) {//쿼리문을 그때 그때 날릴 수 있도록 메소드 두개를 만들자.
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			return pstmt.executeQuery(sql);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	// 삽입, 수정, 삭제
	public static void executeSqlUpdate(String sql) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate(sql);//원래 정수형을 리턴하지만 수행만 하게 만듦.
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close() {

		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
				System.out.println("===DB 연결 해제===");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
