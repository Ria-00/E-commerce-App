package org.ncu.E_commerce.entity;

import java.util.List;

import javax.validation.constraints.NotEmpty;

public class product {
	private String sname;
	private String category;
	private String pname;
	private String qty;
	private String desc;
	private int price;
	
	private List<String> products;
	
	public List<String> getProducts() {
		return products;
	}
	public void setProducts(List<String> products) {
		this.products = products;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "product [sname=" + sname + ", category=" + category + ", pname=" + pname + ", qty=" + qty + ", desc="
				+ desc + ", price=" + price + "]";
	}
	
	
	
	
}

