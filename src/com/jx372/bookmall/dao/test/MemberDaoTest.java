package com.jx372.bookmall.dao.test;

import java.util.List;

import com.jx372.bookmall.dao.MemberDao;
import com.jx372.bookmall.vo.MemberVO;


public class MemberDaoTest {
	public static void main(String[] args) {
		//insertTest();
		System.out.println("회원 정보");
		System.out.println();
		selectTest();
	}

	public static void insertTest() {
		MemberVO memberVO = new MemberVO();
		memberVO.setName("이름이");
		memberVO.setEmail("mail@mail.com");
		memberVO.setPassword("1234");
		memberVO.setPhone("01012341234");

		new MemberDao().insert(memberVO);
	}

	public static void selectTest() {
		List<MemberVO> list = new MemberDao().getlist();
		for (MemberVO vo : list) {
			System.out.println(vo);
		}
	}
}
