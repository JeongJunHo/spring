package com.ssafy.edu.service;

import java.util.List;

import com.ssafy.edu.dto.MemDTO;

public interface MemService {
	public void insert(String num, String pw, String name, String tel);
	public void update(String num, String pw, String name, String tel);
	public void delete(String num);
	public MemDTO selectOne(String num);
	public List<MemDTO> selectList();
}
