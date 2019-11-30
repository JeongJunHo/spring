package com.ssafy.edu.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.edu.dto.MemDTO;

@Repository("MemRepositoryImpl")
public class MemRepositoryImpl implements MemRepository {
	@Autowired
	SqlSession sqlSession;

	@Override
	public void insert(MemDTO memDTO) {
		sqlSession.insert("com.ssafy.edu.product.insert", memDTO);
	}

	@Override
	public void update(MemDTO memDTO) {
		sqlSession.update("com.ssafy.edu.product.update", memDTO);
	}

	@Override
	public void delete(String num) {
		sqlSession.delete("com.ssafy.edu.product.delete", num);
	}

	@Override
	public MemDTO selectOne(String num) {
		return sqlSession.selectOne("com.ssafy.edu.product.selectOne", num);
	}

	@Override
	public List<MemDTO> selectList() {
		return sqlSession.selectList("com.ssafy.edu.product.selectList");
	}
	
}
