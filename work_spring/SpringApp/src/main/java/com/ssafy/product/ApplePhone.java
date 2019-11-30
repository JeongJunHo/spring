package com.ssafy.product;

import java.io.Serializable;

public class ApplePhone implements Phone, Serializable {
	private int price;
	private Camera camera;
	private Algo algo;
	
	public ApplePhone() {
		// TODO Auto-generated constructor stub
	}
	
	public ApplePhone(int price, Camera camera, Algo algo) {
		super();
		this.price = price;
		this.camera = camera;
		this.algo = algo;
	}

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("아이폰 ON");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("아이폰 OFF");
	}

	@Override
	public void calls() {
		// TODO Auto-generated method stub
		System.out.println("아이폰 전화걸기");
	}

	@Override
	public void takePicture() {
		// TODO Auto-generated method stub
		camera.takePicture();
	}

	@Override
	public void studyAlgo() {
		// TODO Auto-generated method stub
		algo.solve();
	}

	@Override
	public String toString() {
		return "ApplePhone [price=" + price + ", camera=" + camera + ", algo=" + algo + "]";
	}
}
