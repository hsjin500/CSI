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
	
	public static void init() {//init�� ����ؼ� DB������ �� ����.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; // ��������
			String user_id = "temp";
			String pw = "12345";

			conn = DriverManager.getConnection(url, user_id, pw);
			
			String sql = "insert into info (id, pw) "
						+ "values(?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			if (conn != null) {
				System.out.println("===DB ���� �Ϸ�===");
			} else {
				System.out.println("===DB ���� ����===");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC ����̹� �ε� ����");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB ���� ���� �Ǵ� ����(����) ����");
			e.printStackTrace();
		}
	}
//////------�Ʒ� �ΰ� �޼ҵ带 ����� ���ұ� ������ �ʿ��Ҷ� ��밡���ϴ�.
	// ��ȸ.
	public static ResultSet getResultSet(String sql) {//�������� �׶� �׶� ���� �� �ֵ��� �޼ҵ� �ΰ��� ������.
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			return pstmt.executeQuery(sql);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	// ����, ����, ����
	public static void executeSqlUpdate(String sql) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate(sql);//���� �������� ���������� ���ุ �ϰ� ����.
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
				System.out.println("===DB ���� ����===");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
