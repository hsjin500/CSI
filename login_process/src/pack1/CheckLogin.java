package pack1;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.DBDAO;

public class CheckLogin {
	
	public boolean checkId(String id) {//회원가입시 아이디 중복확인 할때 사용.
		String sql = "SELECT * FROM clients WHERE client_ID = '" + id + "' ";
		ResultSet rs = DBDAO.getResultSet(sql);
		
		try {
			if(rs.next()) {
				System.out.println(rs.getString(1));
				return true;
			}else {
				System.out.println("동일한 ID가 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkIdPw(String id, String pw) {
		String sql = "SELECT * FROM clients WHERE client_ID = '" + id + "' "
					+ "AND client_pw = '" + pw + "' " ;
//		System.out.println(sql);
		ResultSet rs = DBDAO.getResultSet(sql);
		
		try {
			if(rs.next()) {
				System.out.println("아이디, 비밀번호 있음"); //sql은 1부터 셈한다.(0이 아니라 1부터 시작) -->아마 Id 출력할듯?
				return true;
			}else {		
				System.out.println("해당 사용자가 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
