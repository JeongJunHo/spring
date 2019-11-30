package edu.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ssafy.dto.ProductDTO;
import edu.ssafy.exception.MyException;
import edu.ssafy.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	@Qualifier("ProductMybatisRepositoryImpl")
	ProductRepository productRepository;

	@Override
	@Transactional
	public int insert(String num, String name, int price) throws MyException {
		return productRepository.insert(new ProductDTO(num, name, price));
	}

	@Override
	@Transactional
	public int update(String num, String name, int price) {
		return productRepository.update(new ProductDTO(num, name, price));
	}

	@Override
	@Transactional
	public int delete(String num) {
		return productRepository.delete(num);
	}

	@Override
	public ProductDTO selectOne(String num) {
		// TODO Auto-generated method stub
		return productRepository.selectOne(num);
	}

	@Override
	public List<ProductDTO> selectList() {
		// TODO Auto-generated method stub
		return productRepository.selectList();
	}
}
