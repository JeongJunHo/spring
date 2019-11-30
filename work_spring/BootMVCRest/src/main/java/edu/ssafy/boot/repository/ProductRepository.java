package edu.ssafy.boot.repository;

import java.util.List;

import edu.ssafy.boot.dto.ProductDTO;
import edu.ssafy.boot.exception.MyException;


public interface ProductRepository {
	public int insert(ProductDTO p) throws MyException;
	public int update(ProductDTO p);
	public int delete(String num);
	public ProductDTO selectOne(String num);
	public List<ProductDTO> selectList();
}
