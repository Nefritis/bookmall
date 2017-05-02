package com.jx372.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jx372.bookmall.vo.BookVO;
import com.jx372.bookmall.vo.CategoryVO;

public class BookDao {

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

	public boolean insert(BookVO bookVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into book values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookVO.getISBN());
			pstmt.setString(2, bookVO.getTitle());
			pstmt.setInt(3, bookVO.getPrice());
			pstmt.setInt(4, bookVO.getCategoryNo());

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

	public List<BookVO> getlist() {
		List<BookVO> list = new ArrayList<BookVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			stmt = conn.createStatement();

			String sql = "select b.isbn,b.title,c.cateName,b.price from book b , category c where b.cateNo = c.cateNo";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String isbn = rs.getString(1);
				String title = rs.getString(2);
				String category = rs.getString(3);
				int price = rs.getInt(4);
		
			

				BookVO bookVO = new BookVO();
				bookVO.setISBN(isbn);
				bookVO.setTitle(title);
				bookVO.setCategory(category);
				bookVO.setPrice(price);

				list.add(bookVO);
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
