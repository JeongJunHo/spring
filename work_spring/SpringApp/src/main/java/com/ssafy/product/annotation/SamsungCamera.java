package com.ssafy.product.annotation;

import org.springframework.stereotype.Component;

@Component("samsungcam")
public class SamsungCamera implements Camera {

	@Override
	public void takePicture() {
		// TODO Auto-generated method stub
		System.out.println("삼성카메라로 사진을 찍어요");
	}

}
