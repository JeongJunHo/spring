package com.ssafy.product.annotation;

import org.springframework.stereotype.Component;

@Component("recursive")
public class Recursive implements Algo {

	@Override
	public void solve() {
		// TODO Auto-generated method stub
		System.out.println("재귀함수로 풀어요");
	}

}
