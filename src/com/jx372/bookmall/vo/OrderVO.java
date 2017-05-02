package com.jx372.bookmall.vo;

public class OrderVO {
	private int orderNo;
	private int price;
	private String addr;
	private int CustomerNo;
	private String name;
	private String email;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getCustomerNo() {
		return CustomerNo;
	}
	public void setCustomerNo(int customerNo) {
		CustomerNo = customerNo;
	}
	@Override
	public String toString() {
		return orderNo + ", " + name +"/" + email + ", " + price + ", "  + addr ;
	}
	
}
