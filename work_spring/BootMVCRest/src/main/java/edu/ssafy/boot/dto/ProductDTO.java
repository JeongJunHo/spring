package edu.ssafy.boot.dto;

import java.io.Serializable;

public class ProductDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5082197221029317535L;
	private String num;
	private String name;
	private int price;
	
	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}
	public ProductDTO(String num, String name, int price) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "ProductDTO [num=" + num + ", name=" + name + ", price=" + price + "]";
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
