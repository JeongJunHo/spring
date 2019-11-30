package com.ssafy.student.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class StudentDTO {
	private String num;
	private String name;
	private String age;
	
	public StudentDTO() {
		// TODO Auto-generated constructor stub
	}
	public StudentDTO(String num, String name, String age) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "StudentDTO [num=" + num + ", name=" + name + ", age=" + age + "]";
	}
}
