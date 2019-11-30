package com.ssafy.product.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("galaxyfold")
public class GalaxyFold implements Phone {
	@Value("249")
	private int price;
	@Autowired
	@Qualifier("samsungcam")
	private Camera camera;
	@Autowired
	@Qualifier("recursive")
	private Algo algo;
	
	public GalaxyFold() {
		// TODO Auto-generated constructor stub
	}
	
	public GalaxyFold(int price, Camera camera, Algo algo) {
		super();
		this.price = price;
		this.camera = camera;
		this.algo = algo;
	}

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("갤럭시 폴드 ON");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("갤럭시 폴드 OFF");
	}

	@Override
	public void calls() {
		// TODO Auto-generated method stub
		System.out.println("갤럭시 폴드 전화걸기");
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	public Algo getAlgo() {
		return algo;
	}

	public void setAlgo(Algo algo) {
		this.algo = algo;
	}

	@Override
	public String toString() {
		return "GalaxyFold [price=" + price + ", camera=" + camera + ", algo=" + algo + "]";
	}
}
