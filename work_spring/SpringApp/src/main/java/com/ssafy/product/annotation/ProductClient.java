package com.ssafy.product.annotation;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductClient {
	public static void main(String[] args) {
//		BeanFactory fac = new ClassPathXmlApplicationContext("/app/config/productContextAnno.xml");
		BeanFactory fac = new AnnotationConfigApplicationContext(PhoneConfig.class);
		Phone ap = (Phone) fac.getBean("galaxyfold");
		ap.powerOn();
		ap.studyAlgo();
		ap.takePicture();
		ap.powerOff();
		System.out.println("2");
	}
}
