package com.ssafy.product.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ssafy.app.Member;
import com.ssafy.app.MemberImpl;

@Configuration
@ComponentScan(basePackages="com.ssafy.product.annotation")
public class PhoneConfig {
	@Bean
	public Member getMember() {
		return new MemberImpl();
	}
}
