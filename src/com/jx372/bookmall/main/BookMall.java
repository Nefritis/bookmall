package com.jx372.bookmall.main;

import java.util.List;

import com.jx372.bookmall.dao.BookDao;
import com.jx372.bookmall.dao.CartDao;
import com.jx372.bookmall.dao.CategoryDao;
import com.jx372.bookmall.dao.MemberDao;
import com.jx372.bookmall.dao.OrderDao;
import com.jx372.bookmall.vo.BookVO;
import com.jx372.bookmall.vo.CartVO;
import com.jx372.bookmall.vo.CategoryVO;
import com.jx372.bookmall.vo.MemberVO;
import com.jx372.bookmall.vo.OrderVO;
import com.jx372.bookmall.vo.Ordered_bookVO;

public class BookMall {

	public static void main(String[] args) {
		
		selectMember();
		selectCategory();
		selectBook();
		selectCart();
		selectOrder();
		selectOrderBook();
		
	}
	
	public static void selectMember() {
		List<MemberVO> list = new MemberDao().getlist();
		System.out.println("회원 정보");
		System.out.println();
		for (MemberVO vo : list) {
			System.out.println(vo);
		}
		System.out.println("==================================================");
	}
	
	public static void selectCategory(){
		System.out.println("카테고리 리스트");
		System.out.println();
		List<CategoryVO> list = new CategoryDao().getlist();
		for (CategoryVO vo : list) {
			System.out.println(vo);
		}
		System.out.println("==================================================");
	}
	
	public static void selectBook() {
		System.out.println("상품 리스트");
		System.out.println();
		List<BookVO> list = new BookDao().getlist();
		for (BookVO vo : list) {
			System.out.println(vo);
		}
		System.out.println("==================================================");
	}
	
	public static void selectCart(){
		System.out.println("카트 리스트");
		System.out.println();
		List<CartVO> list = new CartDao().getlist();
		for (CartVO vo : list){
			System.out.println(vo);
		}
		System.out.println("==================================================");
	}
	
	public static void selectOrder() {
		System.out.println("주문 리스트");
		System.out.println();
		List<OrderVO> list = new OrderDao().getlist();
		for (OrderVO vo : list) {
			System.out.println(vo);
		}
	}
	
	public static void selectOrderBook() {
		System.out.println("주문 도서 리스트");
		System.out.println();
		List<Ordered_bookVO> list = new OrderDao().getOrderlist();
		for (Ordered_bookVO vo : list) {
			System.out.println(vo);
		}
		System.out.println("==================================================");
	}
}
