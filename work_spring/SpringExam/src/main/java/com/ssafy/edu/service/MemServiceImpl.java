package com.ssafy.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.edu.dto.MemDTO;
import com.ssafy.edu.repository.MemRepository;

@Service
public class MemServiceImpl implements MemService {
	@Autowired
	MemRepository memRepository;

	@Override
	public void insert(String num, String pw, String name, String tel) {
		memRepository.insert(new MemDTO(num, pw, name, tel));
	}

	@Override
	public void update(String num, String pw, String name, String tel) {
		memRepository.update(new MemDTO(num, pw, name, tel));
		
	}

	@Override
	public void delete(String num) {
		memRepository.delete(num);
		
	}

	@Override
	public MemDTO selectOne(String num) {
		MemDTO memDTO = memRepository.selectOne(num);
		return memDTO;
	}

	@Override
	public List<MemDTO> selectList() {
		List<MemDTO> list = memRepository.selectList();
		return list;
	}
}
