package com.jx372.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jx372.bookmall.vo.CartVO;

public class CartDao {
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

	public boolean insert(CartVO cartVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into cart values(null,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cartVO.getISBN());
			pstmt.setInt(2, cartVO.getCustomerNo());
			pstmt.setInt(3, cartVO.getQuantity());

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

	public List<CartVO> getlist(){
		List<CartVO> list = new ArrayList<CartVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
	

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			String sql = "SELECT c.cartNo, "
					+ "b.title , c.quantity, "
					+ "b.price*c.quantity"
					+ " from cart c, book b, customer cu "
					+ "where c.isbn = b.isbn and c.customerNo = cu.customerNo";
			
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int cartNo = rs.getInt(1);
				String title = rs.getString(2);
				int quantity = rs.getInt(3);
				int price = rs.getInt(4);
				
				CartVO cartVO = new CartVO();
				cartVO.setCartNo(cartNo);
				cartVO.setTitle(title);
				cartVO.setQuantity(quantity);
				cartVO.setPrice(price);
				
				list.add(cartVO);
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
