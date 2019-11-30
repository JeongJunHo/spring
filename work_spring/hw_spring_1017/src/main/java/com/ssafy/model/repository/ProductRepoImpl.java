package com.ssafy.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ssafy.model.dto.Product;
import com.ssafy.util.ConnectionProxy;

@Component
public class ProductRepoImpl implements ProductRepo {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Product> selectAll() {
		List<Product> list = new ArrayList<Product>();
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "select id,name,price,description from product";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				Integer price = rs.getInt("price");
				String description = rs.getString("description");
				list.add(new Product(id, name, price, description));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}

	@Override
	public Product select(String id) {
		Product product = null;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "select id,name,price,description from product where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				Integer price = rs.getInt("price");
				String description = rs.getString("description");
				product = new Product(id, name, price, description);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return product;
	}

	@Override
	public int insert(Product product) {
		int result = 0;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "insert into product(id,name,price,description) values (?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, product.getId());
			psmt.setString(2, product.getName());
			psmt.setInt(3, product.getPrice());
			psmt.setString(4, product.getDescription());
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}

	@Override
	public int update(Product product) {
		int result = 0;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "update product set name = ?, price = ?, description = ? where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, product.getName());
			psmt.setInt(2, product.getPrice());
			psmt.setString(3, product.getDescription());
			psmt.setString(4, product.getId());
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}

	@Override
	public int delete(String id) {
		int result = 0;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "delete from product where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}
}
