package pack1;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.DBDAO;

public class CheckLogin {
	
	public boolean checkId(String id) {//ȸ�����Խ� ���̵� �ߺ�Ȯ�� �Ҷ� ���.
		String sql = "SELECT * FROM clients WHERE client_ID = '" + id + "' ";
		ResultSet rs = DBDAO.getResultSet(sql);
		
		try {
			if(rs.next()) {
				System.out.println(rs.getString(1));
				return true;
			}else {
				System.out.println("������ ID�� �����ϴ�.");
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
				System.out.println("���̵�, ��й�ȣ ����"); //sql�� 1���� ���Ѵ�.(0�� �ƴ϶� 1���� ����) -->�Ƹ� Id ����ҵ�?
				return true;
			}else {		
				System.out.println("�ش� ����ڰ� �����ϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
