package com.jx372.bookmall.dao.test;

import java.util.List;

import com.jx372.bookmall.dao.BookDao;
import com.jx372.bookmall.vo.BookVO;


public class BookDaoTest {
	public static void main(String[] args) {
		//insertTest();
		selectTest();
	}
	
	public static void insertTest(){
		BookVO bookVO = new BookVO();
		bookVO.setISBN("1");
		bookVO.setTitle("이것이 자바다");
		bookVO.setPrice(20000);
		bookVO.setCategoryNo(3);
		
		new BookDao().insert(bookVO);
	}
	
	public static void selectTest() {
		List<BookVO> list = new BookDao().getlist();
		for (BookVO vo : list) {
			System.out.println(vo);
		}
	}
}
