package edu.ssafy.boot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ssafy.boot.dto.ProductDTO;
import edu.ssafy.boot.exception.MyException;
import edu.ssafy.boot.service.ProductService;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/api")
public class RestPoductController {
	private static final Logger logger = LoggerFactory.getLogger(RestPoductController.class);
	
	@Autowired
	ProductService ser;
	
	@PostMapping("/productreg")
	@ApiOperation(value="product 등록 서비스")
	public ResponseEntity<Map<String,Object>> productReg(@RequestBody ProductDTO dto) throws MyException {
		ResponseEntity<Map<String,Object>> resEntity = null;
		try {
			int insert = ser.insert(dto.getNum(), dto.getName(), dto.getPrice());
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "입력 성공");
			msg.put("resvalue", insert);
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "입력 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}
	
	@GetMapping("/productlist")
	@ApiOperation(value="product 조회 서비스", response=List.class)
	public ResponseEntity<Map<String,Object>> productList() {
		ResponseEntity<Map<String,Object>> resEntity = null;
		try {
			List<ProductDTO> list = ser.selectList();
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "조회 성공");
			msg.put("resvalue", list);
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "조회 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		
		return resEntity;
	}
	
	@GetMapping("/productview/{num}")
	@ApiOperation(value="num을 받아 product 조회 서비스", response=ProductDTO.class)
	public ResponseEntity<Map<String,Object>> productView(@PathVariable("num")String num) {
		ResponseEntity<Map<String,Object>> resEntity = null;
		try {
			ProductDTO product = ser.selectOne(num);
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "조회 성공");
			msg.put("resvalue", product);
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "조회 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		
		return resEntity;
	}
	
	@DeleteMapping("/productdelete/{num}")
	@ApiOperation(value="num을 받아 product 삭제 서비스")
	public ResponseEntity<Map<String,Object>> productDelete(@PathVariable("num")String num) {
		ResponseEntity<Map<String,Object>> resEntity = null;
		try {
			int delete = ser.delete(num);
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "삭제 성공");
			msg.put("resvalue", delete);
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "삭제 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		
		return resEntity;
	}
	
	@PutMapping("/productupdate")
	@ApiOperation(value="num을 받아 product 수정 서비스")
	public ResponseEntity<Map<String,Object>> productUpdate(@RequestBody ProductDTO product) {
		ResponseEntity<Map<String,Object>> resEntity = null;
		try {
			int update = ser.update(product.getNum(), product.getName(), product.getPrice());
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "수정 성공");
			msg.put("resvalue", update);
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "수정 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		
		return resEntity;
	}
}
