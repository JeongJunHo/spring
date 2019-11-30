package edu.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ssafy.dto.MemDTO;
import edu.ssafy.exception.MyException;
import edu.ssafy.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	@Qualifier(value="MemberMybatisRepositoryImpl")
	MemberRepository repo;

	@Override
	@Transactional
	public int insert(String num, String pw, String name, String tel) throws MyException {
		return repo.insert(new MemDTO(num, pw, name, tel));
	}

	@Override
	@Transactional
	public int update(String num, String pw, String name, String tel) {
		return repo.update(new MemDTO(num, pw, name, tel));
	}

	@Override
	@Transactional
	public int delete(String num) {
		return repo.delete(num);
	}

	@Override
	public MemDTO selectOne(String num) {
		return repo.selectOne(num);
	}

	@Override
	public List<MemDTO> selectList() {
		return repo.selectList();
	}
	
	
}
