package com.ssafy.test;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ssafy.config.ProductConfig;
import com.ssafy.model.dto.Product;
import com.ssafy.model.service.ProductService;

public class BeanTest {
	public static void main(String[] args) {
		BeanFactory fac = new AnnotationConfigApplicationContext(ProductConfig.class);
		ProductService bean = fac.getBean(ProductService.class);
		System.out.print("입력 : ");
		System.out.println(bean.insert(new Product("p1", "휴대폰", 1000000, "LG")));
		System.out.print("입력 : ");
		System.out.println(bean.insert(new Product("p2", "TV", 3000000, "삼성")));
		System.out.print("입력 : ");
		System.out.println(bean.insert(new Product("p3", "키보드", 60000, "DECK")));
		
		System.out.print("수정 : ");
		System.out.println(bean.update(new Product("p1", "최신 휴대폰", 2000000, "애플")));
		
		System.out.print("삭제 : ");
		System.out.println(bean.delete("p3"));
		
		System.out.println("단일 조회(p1)");
		System.out.println(bean.select("p1"));
		
		System.out.println("전체 조회");
		List<Product> selectAll = bean.selectAll();
		for (Product product : selectAll) {
			System.out.println(product);
		}
	}
}
