package edu.ssafy.boot.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import edu.ssafy.boot.dto.ProductDTO;
import edu.ssafy.boot.exception.MyException;

@Repository("ProductMybatisRepositoryImpl")
public class ProductMybatisRepositoryImpl implements ProductRepository {
	@Autowired
//	@Qualifier("sqlSession")
	SqlSession session;

	@Override
	public int insert(ProductDTO p) throws MyException {
		return session.insert("ssafy.product.insert", p);
	}

	@Override
	public int update(ProductDTO p) {
		return session.update("ssafy.product.update", p);
	}

	@Override
	public int delete(String num) {
		return session.delete("ssafy.product.delete", num);
	}

	@Override
	public ProductDTO selectOne(String num) {
		ProductDTO dto = session.selectOne("ssafy.product.selectOne", num);
		return dto;
	}

	@Override
	public List<ProductDTO> selectList() {
		List<ProductDTO> list = session.selectList("ssafy.product.selectList");
		return list;
	}
}
