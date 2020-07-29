package pack1;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class loginDistrubution {
	public static boolean isGuard(String Id) {
		String id = Id;
		String sql = "select * from clients where client_id = '" + id + "' ";
		DBDAO.init();
		ResultSet rs = DBDAO.getResultSet(sql);
		String guardCheck = "";
		System.out.println("로그인 성공");
		
		try {
			if (rs.next()) {
				try {
					guardCheck = rs.getString("guard");
				} catch (NullPointerException eNull) {
					System.out.println("null 오류");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("guard값 : " + guardCheck);

		if (guardCheck.equals("1")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String userName(String Id) {
		String id = Id;
		String sql = "select * from clients where client_id = '" + id + "' ";
		DBDAO.init();
		ResultSet rs = DBDAO.getResultSet(sql);
		String name = "";
		System.out.println("로그인 성공");
		try {
			if (rs.next()) {
				try {
					name = rs.getString("client_name");
				} catch (NullPointerException eNull) {
					System.out.println("null 오류");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("이름 : " + name);

		return name ;
		
	}
}
