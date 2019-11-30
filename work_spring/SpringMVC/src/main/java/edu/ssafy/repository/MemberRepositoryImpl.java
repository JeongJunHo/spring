package edu.ssafy.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.ssafy.dto.MemDTO;

@Repository("MemberRepositoryImpl")
public class MemberRepositoryImpl implements MemberRepository {
	private List<MemDTO> list = new ArrayList<MemDTO>();
	
	public int insert(MemDTO m) {
		if(list.add(m)) {
			return 1;
		}else {
			return 0;
		}
		
	}
	
	public int update(MemDTO m) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getNum().equals(m.getNum())) {
				if(list.set(i, m) != null) {
					return 1;
				}
			}
		}
		return 0;
	}
	
	public int delete(String num) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getNum().equals(num)) {
				if(list.remove(i) != null) {
					return 1;
				}
			}
		}
		return 0;
	}
	
	public MemDTO selectOne(String num) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getNum().equals(num)) {
				return list.get(i);
			}
		}
		return null;
	}
	
	public List<MemDTO> selectList(){
		return list;
	}
}
