package com.jx372.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jx372.bookmall.vo.CategoryVO;
import com.jx372.bookmall.vo.MemberVO;

public class MemberDao {
	// Connection
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/dev?useUnicode=true&characterEncoding=utf8";
			conn = DriverManager.getConnection(url, "dev", "dev");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver를 찾을 수 없습니다.");
		}
		return conn;
	}

	public boolean insert(MemberVO memberVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			String sql = "insert into customer values(null, ?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVO.getEmail());
			pstmt.setString(2, memberVO.getPassword());
			pstmt.setString(3, memberVO.getName());
			pstmt.setString(4, memberVO.getPhone());

			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<MemberVO> getlist() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			stmt = conn.createStatement();

			String sql = "select * from customer";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int customerNo = rs.getInt(1);
				String email = rs.getString(2);
				String password = rs.getString(3);
				String name = rs.getString(4);
				String phone = rs.getString(5);

				MemberVO memberVO = new MemberVO();
				memberVO.setCustomerNo(customerNo);
				memberVO.setName(name);
				memberVO.setPhone(phone);
				memberVO.setEmail(email);
				memberVO.setPassword(password);

				list.add(memberVO);

			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
