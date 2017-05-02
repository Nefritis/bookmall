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

public class CategoryDao {
	// Connection
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		// 1. 드라이버 로딩
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 2. Connection 하기
			String url = "jdbc:mysql://localhost:3306/dev?useUnicode=true&characterEncoding=utf8";

			conn = DriverManager.getConnection(url, "dev", "dev");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver를 찾을 수 없습니다.");
		} 
		return conn;
	}

	public boolean insert(CategoryVO categoryVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = getConnection();
			String sql = "insert into category values(null, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, categoryVO.getCategory());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e);
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

	public List<CategoryVO> getlist() {
		List<CategoryVO> list = new ArrayList<CategoryVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			stmt = conn.createStatement();

			String sql = "select * from category";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int categoryNo = rs.getInt(1);
				String categoryName = rs.getString(2);

				CategoryVO categoryVO = new CategoryVO();
				categoryVO.setCategoryNo(categoryNo);
				categoryVO.setCategory(categoryName);

				list.add(categoryVO);
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
