package com.ssafy.app;

import java.util.ArrayList;

public interface Person {
	public String toString();
	public void init();
	public void close();
	public String getName();
	public void setName(String name);
	public int getAge();
	public void setAge(int age);
	public String getAddr();
	public void setAddr(String addr);
}
