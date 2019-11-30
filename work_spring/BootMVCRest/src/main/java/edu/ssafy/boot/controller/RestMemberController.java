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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.ssafy.boot.dto.MemDTO;
import edu.ssafy.boot.exception.MyException;
import edu.ssafy.boot.service.MemberService;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
//RestController의 경우에는 매개변수에 RequestBody, ResponseBody 생략 가능
//@Controller
@RequestMapping("/api")
public class RestMemberController {
	private static final Logger logger = LoggerFactory.getLogger(RestMemberController.class);
	
	@Autowired
	MemberService ser;
	
//	@RequestMapping(value="/memreg", method=RequestMethod.POST)
	@PostMapping("/memreg")
	@ApiOperation(value="member 등록 서비스")
	public ResponseEntity<Map<String, Object>> memReg(@RequestBody MemDTO dto) throws MyException {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			int insert = ser.insert(dto.getNum(), dto.getPw(), dto.getName(), dto.getTel());
			//String msg = insert + " 입력했습니다.";
			Map msg = new HashMap();
			msg.put("resmsg", "입력 성공");
			msg.put("resvalue", insert);
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		}catch(RuntimeException e){
//			String msg = "입력 실패했습니다.";
			Map msg = new HashMap();
			msg.put("resmsg", "입력 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}
	
//	@RequestMapping(value="/memlist", method=RequestMethod.GET)
	@GetMapping("/memlist")
	@ApiOperation(value="member 조회 서비스", response=List.class)
	public @ResponseBody ResponseEntity<Map<String, Object>> memList() {
		ResponseEntity<Map<String, Object>> resEntity = null;
		List<MemDTO> list = null;
		try {
			list = ser.selectList();
			Map<String, Object> map = new HashMap();
			map.put("resmsg", "조회성공");
			map.put("resvalue", list);
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> map = new HashMap();
			map.put("resmsg", "조회실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		}
		
		return resEntity;
	}
	
//	@RequestMapping(value="/memview/{num}", method=RequestMethod.GET)
	@GetMapping("/memview/{num}")
	@ApiOperation(value="num을 받아 member 조회 서비스", response=MemDTO.class)
	public @ResponseBody ResponseEntity<Map<String, Object>> memView(@PathVariable("num") String num) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		MemDTO mem = null;
		try {
			mem = ser.selectOne(num);
			Map<String, Object> map = new HashMap();
			map.put("resmsg", "조회성공");
			map.put("resvalue", mem);
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> map = new HashMap();
			map.put("resmsg", "조회실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		}
		
		return resEntity;
	}
	
//	@RequestMapping(value="/memdelete/{num}", method=RequestMethod.DELETE)
	@DeleteMapping("/memdelete/{num}")
	@ApiOperation(value="num을 받아 member 삭제 서비스")
	public ResponseEntity<Map<String, Object>> memDelete(@PathVariable("num") String num) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			int delete = ser.delete(num);
			Map<String, Object> map = new HashMap();
			map.put("resmsg", "삭제성공");
			map.put("resvalue", delete);
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> map = new HashMap();
			map.put("resmsg", "삭제실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		}
		
		return resEntity;
	}
	
//	@RequestMapping(value="/memupdate", method=RequestMethod.PUT)
	@PutMapping("/memupdate")
	@ApiOperation(value="mem을 받아 member 수정 서비스")
	public ResponseEntity<Map<String, Object>> memUpdate(@RequestBody MemDTO mem) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			ser.update(mem.getNum(), mem.getPw(), mem.getName(), mem.getTel());
			Map<String, Object> map = new HashMap();
			map.put("resmsg", "수정성공");
			map.put("resvalue", map);
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> map = new HashMap();
			map.put("resmsg", "수정실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		}
		return resEntity;
	}
}
