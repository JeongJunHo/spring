package edu.ssafy.boot.repository;

import java.util.List;

import edu.ssafy.boot.dto.MemDTO;
import edu.ssafy.boot.exception.MyException;

public interface MemberRepository {
	public int insert(MemDTO m) throws MyException;
	public int update(MemDTO m);
	public int delete(String num);
	public MemDTO selectOne(String num);
	public List<MemDTO> selectList();
}
