package com.jx372.bookmall.dao.test;

import java.util.List;

import com.jx372.bookmall.dao.OrderDao;
import com.jx372.bookmall.vo.OrderVO;
import com.jx372.bookmall.vo.Ordered_bookVO;

public class OrderDaoTest {

	public static void main(String[] args) {
		selectTest();
		selectTest2();
	}
	public static void selectTest() {
		List<OrderVO> list = new OrderDao().getlist();
		for (OrderVO vo : list) {
			System.out.println(vo);
		}
	}
	
	public static void selectTest2() {
		List<Ordered_bookVO> list = new OrderDao().getOrderlist();
		for (Ordered_bookVO vo : list) {
			System.out.println(vo);
		}
	}
}
