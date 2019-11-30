package edu.ssafy.dto;

import java.io.Serializable;

public class MemDTO implements Serializable {
	private String num;
	private String pw;
	private String name;
	private String tel;
	
	public MemDTO() {
		// TODO Auto-generated constructor stub
	}

	public MemDTO(String num, String pw, String name, String tel) {
		super();
		this.num = num;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "MemDTO [num=" + num + ", pw=" + pw + ", name=" + name + ", tel=" + tel + "]";
	}
}
