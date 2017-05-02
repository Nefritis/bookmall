package com.jx372.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jx372.bookmall.vo.OrderVO;
import com.jx372.bookmall.vo.Ordered_bookVO;

public class OrderDao {
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

	public boolean insert(OrderVO orderVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into order values(null, ?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, orderVO.getPrice());
			pstmt.setString(2, orderVO.getAddr());
			pstmt.setInt(3, orderVO.getCustomerNo());

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

	public List<OrderVO> getlist() {
		List<OrderVO> list = new ArrayList<OrderVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			stmt = conn.createStatement();

			String sql = "SELECT o.orderNo, c.name, c.email, o.pay ,o.addr " + "FROM orders o , customer c "
					+ "where o.customerNo = c.customerNo";

			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int orderNo = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				int price = rs.getInt(4);
				String addr = rs.getString(5);

				OrderVO orderVO = new OrderVO();
				orderVO.setOrderNo(orderNo);
				orderVO.setName(name);
				orderVO.setEmail(email);
				orderVO.setPrice(price);
				orderVO.setAddr(addr);

				list.add(orderVO);
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
	
	public List<Ordered_bookVO> getOrderlist(){
		List<Ordered_bookVO> list = new ArrayList<Ordered_bookVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

	
			try {
				conn = getConnection();
				stmt = conn.createStatement();
				
				String sql = "SELECT o.isbn, b.title, o.quantity FROM ordered_book o, book b where o.isbn = b.isbn";
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					String isbn = rs.getString(1);
					String title = rs.getString(2);
					int quantity = rs.getInt(3);
					
					Ordered_bookVO vo = new Ordered_bookVO();
					vo.setISBN(isbn);
					vo.setTitle(title);
					vo.setQuantity(quantity);
					
					list.add(vo);			
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
					e.printStackTrace();
				}
			}
	}
}
