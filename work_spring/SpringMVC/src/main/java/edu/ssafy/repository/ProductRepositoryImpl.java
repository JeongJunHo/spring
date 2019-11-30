package edu.ssafy.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.ssafy.dto.ProductDTO;

@Repository("ProductRepositoryImpl")
public class ProductRepositoryImpl implements ProductRepository {
	private List<ProductDTO> list = new ArrayList<ProductDTO>();
	
	public int insert(ProductDTO p) {
		if(list.add(p)) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public int update(ProductDTO p) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getNum().equals(p.getNum())) {
				if(list.set(i, p) != null) {
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
	
	public ProductDTO selectOne(String num) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getNum().equals(num)) {
				return list.get(i);
			}
		}
		return null;
	}
	
	public List<ProductDTO> selectList(){
		return list;
	}

}
