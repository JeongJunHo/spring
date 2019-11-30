package edu.ssafy.boot.service;

import java.util.List;

import edu.ssafy.boot.dto.MemDTO;
import edu.ssafy.boot.exception.MyException;

public interface MemberService {
	public int insert(String num, String pw, String name, String tel) throws MyException;
	public int update(String num, String pw, String name, String tel);
	public int delete(String num);
	public MemDTO selectOne(String num);
	public List<MemDTO> selectList();
}
