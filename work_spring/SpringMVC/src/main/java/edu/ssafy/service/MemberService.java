package edu.ssafy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.ssafy.dto.MemDTO;
import edu.ssafy.exception.MyException;

public interface MemberService {
	public int insert(String num, String pw, String name, String tel) throws MyException;
	public int update(String num, String pw, String name, String tel);
	public int delete(String num);
	public MemDTO selectOne(String num);
	public List<MemDTO> selectList();
}
