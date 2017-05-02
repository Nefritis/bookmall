package com.jx372.bookmall.dao.test;

import java.util.List;

import com.jx372.bookmall.dao.CategoryDao;
import com.jx372.bookmall.vo.CategoryVO;

public class CategoryDaoTest {

	public static void main(String[] args) {
		//insertTest();
		selectTest();
	}

	public static void insertTest(){
		CategoryVO categoryVO = new CategoryVO();
		categoryVO.setCategory("수필");
		
		System.out.println("테스트");
		
		new CategoryDao().insert(categoryVO);
	}
	
	public static void selectTest(){
		List<CategoryVO> list = new CategoryDao().getlist();
		for (CategoryVO vo : list) {
			System.out.println(vo);

		}
	}
}
