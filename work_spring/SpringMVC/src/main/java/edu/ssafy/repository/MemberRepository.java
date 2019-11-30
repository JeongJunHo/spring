package edu.ssafy.repository;

import java.util.List;

import edu.ssafy.dto.MemDTO;
import edu.ssafy.exception.MyException;

public interface MemberRepository {
	public int insert(MemDTO m) throws MyException;
	public int update(MemDTO m);
	public int delete(String num);
	public MemDTO selectOne(String num);
	public List<MemDTO> selectList();
}
