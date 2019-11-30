package com.ssafy.edu.repository;

import java.util.List;

import com.ssafy.edu.dto.MemDTO;

public interface MemRepository {
	public void insert(MemDTO memDTO);
	public void update(MemDTO memDTO);
	public void delete(String num);
	public MemDTO selectOne(String num);
	public List<MemDTO> selectList();
}
