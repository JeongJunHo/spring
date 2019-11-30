package com.ssafy.product;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductClient {
	public static void main(String[] args) {
		BeanFactory fac = new ClassPathXmlApplicationContext("/app/config/productContext.xml");
		Phone ap = (Phone) fac.getBean(args[0]);
		ap.powerOn();
		ap.studyAlgo();
		ap.takePicture();
		ap.powerOff();
		
//		Phone sp = (Phone) fac.getBean("samsungphone");
//		sp.powerOn();
//		sp.studyAlgo();
//		sp.takePicture();
//		sp.powerOff();
	}
}
