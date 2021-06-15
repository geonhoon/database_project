package likey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DatabaseUtil;

public class LikeyDAO {

	public int like(String userID, String evaluationID, String userIP) { //��õ �κ�.

		String SQL = "INSERT INTO likey VALUES (?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			pstmt.setString(2, evaluationID);
			pstmt.setString(3, userIP);

			return pstmt.executeUpdate(); // �����̸� 1���� ��ȯ.

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close(); // conn ����
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close(); // pstmt ����
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close(); // rs ����
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return -1; // ��õ �ߺ� ����
	}

}