package com.jx372.bookmall.dao.test;

import java.util.List;

import com.jx372.bookmall.dao.CartDao;
import com.jx372.bookmall.vo.CartVO;

public class CartDaoTest {
	public static void main(String[] args) {
		//insertTest();
		selectTest();
	}
	
	public static void insertTest(){
		CartVO cartVO  = new CartVO();
		cartVO.setISBN("1");
		cartVO.setCustomerNo(1);
		cartVO.setQuantity(1);
		
		new CartDao().insert(cartVO);
	}
	
	public static void selectTest(){
		List<CartVO> list = new CartDao().getlist();
		for (CartVO vo : list){
			System.out.println(vo);
		}
	}
}
