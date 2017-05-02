package com.jx372.bookmall.vo;

public class CartVO {
	private int cartNo;
	private String ISBN;
	private int CustomerNo;
	private int quantity;
	private String title;
	private int price;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCartNo() {
		return cartNo;
	}
	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public int getCustomerNo() {
		return CustomerNo;
	}
	public void setCustomerNo(int customerNo) {
		CustomerNo = customerNo;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return cartNo + ", " +  title + ", " + quantity +", " + price;
	}
	
	
	
}
