package edu.ssafy.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import edu.ssafy.dto.MemDTO;
import edu.ssafy.exception.MyException;

@Repository("MemberMybatisRepositoryImpl")
public class MemberMybatisRepositoryImpl implements MemberRepository {
	@Autowired
	SqlSession session;
	
	@Override
	public int insert(MemDTO m) throws MyException {
		return session.insert("ssafy.member.insert", m);
	}

	@Override
	public int update(MemDTO m) {
		return session.update("ssafy.member.update", m);
	}

	@Override
	public int delete(String num) {
		return session.delete("ssafy.member.delete", num);
	}

	@Override
	public MemDTO selectOne(String num) {
		MemDTO selectOne = session.selectOne("ssafy.member.selectOne", num);
		return selectOne;
	}

	@Override
	public List<MemDTO> selectList() {
		List<MemDTO> selectList = session.selectList("ssafy.member.selectList");
		return selectList;
	}
}
