package com.ssafy.app;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringClient {
	public static void main(String[] args) {
//		Person p = new Person("홍길동",21,"광산구");
//		System.out.println(p);
		
		BeanFactory fac = new ClassPathXmlApplicationContext("/app/config/applicationContext.xml");
//		PersonImpl per = (PersonImpl) fac.getBean(PersonImpl.class);
		PersonImpl per = (PersonImpl) fac.getBean("person1");
//		per.setName("홍길동");
//		per.setAge(21);
//		per.setAddr("광주");
		System.out.println(per.toString());
		
//		PersonImpl per1 = (PersonImpl) fac.getBean("person");
//		per1.setName("고길동");
//		per1.setAge(41);
//		per1.setAddr("쌍문동");
//		System.out.println(per1.toString());
//		MemberImpl mem = fac.getBean(MemberImpl.class);
		Member mem = (Member)fac.getBean("member");
		System.out.println(mem);
	}
}
