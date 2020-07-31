package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBDAO {
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	public static Connection conn = null;
	DBDTO dto = null;

	public static void init() {// init를 사용해서 DB연결을 할 것임.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 프로토콜
			String user_id = "hr";
			String pw = "hr";

			conn = DriverManager.getConnection(url, user_id, pw);

			String sql = "insert into info (id, pw) " + "values(?,?)";
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
	public static ResultSet getResultSet(String sql) {// 쿼리문을 그때 그때 날릴 수 있도록 메소드 두개를 만들자.
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			return pstmt.executeQuery(sql);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// 삽입, 수정
	public static void executeSqlUpdate(String sql) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate(sql);// 원래 정수형을 리턴하지만 수행만 하게 만듦.
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

	// 삭제
	public static int delete(String id) {
		int cnt = 0;

		try {
			String sql = "delete from clients where client_id = '" + id + "' ";

			pstmt = conn.prepareStatement(sql);

			cnt = pstmt.executeUpdate();

			System.out.println("--삭제 완료--");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}

	public int apply(String id, String ssnum, String guard) {
		int cnt = 0;

		init();
		String sql = "insert into temp values(?, ?, ?, '0')";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, id);
			pstmt.setNString(2, ssnum);
			pstmt.setNString(3, guard);

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();

		}

		return cnt;
	}

	public DBDTO loginSelect(String id, String pw) {

		init();
		DBDTO dto = null;

		try {
			String sql = "select * from clients where client_id=? and client_pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				String loginId = rs.getNString(1);
				String loginPw = rs.getNString(2);
				String name = rs.getNString(3);
				String phone = rs.getNString(4);
				String email = rs.getNString(5);
				String ssnum = rs.getNString(6);
				String guard = rs.getNString(7);
				String manager = rs.getNString(8);

				dto = new DBDTO(loginId, loginPw, name, phone, email, ssnum, guard, manager);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}

	public ArrayList<DBDTO> memberInfoSelect() {
		ArrayList<DBDTO> guardList = new ArrayList<DBDTO>();
		init();
		String sql = "select * from clients where guard != '0' ";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String loginId = rs.getString(1);
				String loginPw = rs.getString(2);
				String name = rs.getString(3);
				String phone = rs.getString(4);
				String email = rs.getString(5);
				String ssnum = rs.getString(6);
				String guard = rs.getString(7);
				String manager = rs.getString(8);

				guardList.add(new DBDTO(loginId, loginPw, name, phone, email, ssnum, guard, manager));
			}
		} catch (SQLException e) {
		}
		return guardList;
	}

	public ArrayList<mia_DTO> miaHistory(String id) {
		ArrayList<mia_DTO> arr = new ArrayList<mia_DTO>();

		init();
		String sql = "select * from mia where mia_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String mia_id = rs.getNString(1);
				String location = rs.getNString(2);
				String time = rs.getNString(3);
				String date = rs.getNString(4);
				String info = rs.getNString(5);
				String photo = rs.getNString(6);
				String upload_date = rs.getNString(7);
				String condition = rs.getNString(8);

				arr.add(new mia_DTO(mia_id, location, time, date, info, photo, upload_date, condition));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return arr;

	}

	public ArrayList<Req_DTO> reqHistory(String id) {
		ArrayList<Req_DTO> arr = new ArrayList<Req_DTO>();

		init();
		String sql = "select * from request where req_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String req_id = rs.getNString(1);
				String location = rs.getNString(2);
				String time = rs.getNString(3);
				String date = rs.getNString(4);
				String ask = rs.getNString(5);
				String upload_date = rs.getNString(6);

				arr.add(new Req_DTO(req_id, location, time, date, ask, upload_date));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return arr;
	}

	public ArrayList<DBDTO> normalSelect() {
		ArrayList<DBDTO> normalList = new ArrayList<DBDTO>();
		init();
		String sql = "select * from clients where guard = '0' ";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String loginId = rs.getString(1);
				String loginPw = rs.getString(2);
				String name = rs.getString(3);
				String phone = rs.getString(4);
				String email = rs.getString(5);
				String ssnum = rs.getString(6);
				String guard = rs.getString(7);
				String manager = rs.getString(8);

				normalList.add(new DBDTO(loginId, loginPw, name, phone, email, ssnum, guard, manager));
			}
		} catch (SQLException e) {
		}
		return normalList;
	}

	public int modify(String id, String pw) {
		int cnt = 0;

		init();
		String sql = "update clients set client_pw = ? where client_id = ?  ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, id);
			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
	public int modify2(String email, String phoneNum, String id) {
		int cnt = 0;

		init();
		String sql = "update clients set client_email = ? , phone_number = ? where client_id = ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, id);
			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
	public int modify3(String sosok, String id) {
		int cnt = 0;

		init();
		String sql = "update clients set guard = ?  where client_id = ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sosok);
			pstmt.setString(2, id);
			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
	public int request(String id, String time, String date, String location, String ask) {
	      int cnt = 0;

	      init();
	      String sql = "insert into request values(?, ?, ?,?,?,sysdate,'진행중')";

	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setNString(1, id);
	         pstmt.setNString(2, location);
	         pstmt.setNString(3, time);
	         pstmt.setNString(4, date);
	         pstmt.setNString(5, ask);

	         cnt = pstmt.executeUpdate();

	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         close();

	      }

	      return cnt;
	   }
	
	   public int mia(String id, String location, String date, String time, String ask, String photo) {
	         int cnt = 0;

	         init();
	         String sql = "insert into mia values(?, ?, ?,?,?,?,sysdate,'진행중')";

	         try {
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setNString(1, id);
	            pstmt.setNString(2, location);
	            pstmt.setNString(3, time);
	            pstmt.setNString(4, date);
	            pstmt.setNString(5, ask);
	            pstmt.setNString(6, photo);

	            cnt = pstmt.executeUpdate();

	         } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         } finally {
	            close();

	         }

	         return cnt;
	      }
	   
	   public ArrayList<mia_DTO> miaAll() {
			ArrayList<mia_DTO> arr = new ArrayList<mia_DTO>();

			init();
			String sql = "select * from mia";
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					String mia_id = rs.getNString(1);
					String location = rs.getNString(2);
					String time = rs.getNString(3);
					String date = rs.getNString(4);
					String info = rs.getNString(5);
					String photo = rs.getNString(6);
					String upload_date = rs.getNString(7);
					String condition = rs.getNString(8);

					arr.add(new mia_DTO(mia_id, location, time, date, info, photo, upload_date, condition));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close();
			}
			return arr;

		}
	   
	   public ArrayList<Req_DTO> reqAll() {
			ArrayList<Req_DTO> arr = new ArrayList<Req_DTO>();

			init();
			String sql = "select * from request";
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					String req_id = rs.getNString(1);
					String location = rs.getNString(2);
					String time = rs.getNString(3);
					String date = rs.getNString(4);
					String ask = rs.getNString(5);
					String upload_date = rs.getNString(6);

					arr.add(new Req_DTO(req_id, location, time, date, ask, upload_date));

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close();
			}
			return arr;
		}
}
