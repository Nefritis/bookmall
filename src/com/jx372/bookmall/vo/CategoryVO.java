package com.jx372.bookmall.vo;

public class CategoryVO {

	private int categoryNo;
	private String category;
	
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return  categoryNo + " " + category;
	}
}
