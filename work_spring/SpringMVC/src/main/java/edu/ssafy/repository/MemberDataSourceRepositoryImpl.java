package edu.ssafy.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.dto.MemDTO;
import edu.ssafy.exception.MyException;
import edu.ssafy.util.JDBCProxy;

@Repository("MemberDataSourceRepositoryImpl")
public class MemberDataSourceRepositoryImpl implements MemberRepository {
	@Autowired
	private DataSource ds;
	
	@Override
	public int insert(MemDTO m) throws MyException {
		Connection con = null;
		PreparedStatement pst = null;
		int result = 0;
		try {
			con = ds.getConnection();
			pst = con.prepareStatement("insert into members (num,pw,name,tel) values (?,?,?,?)");
			pst.setString(1, m.getNum());
			pst.setString(2, m.getPw());
			pst.setString(3, m.getName());
			pst.setString(4, m.getTel());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql Error....");
			e.printStackTrace();
			throw new MyException(e.getMessage());
		}finally {
			JDBCProxy.close(pst, con);
		}
		return result;
	}

	@Override
	public int update(MemDTO m) {
		Connection con = null;
		PreparedStatement pst = null;
		int result = 0;
		try {
			con = ds.getConnection();
			pst = con.prepareStatement("update members set pw=?,name=?,tel=? where num=?");
			pst.setString(1, m.getPw());
			pst.setString(2, m.getName());
			pst.setString(3, m.getTel());
			pst.setString(4, m.getNum());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql Error....");
			e.printStackTrace();
		}finally {
			JDBCProxy.close(pst, con);
		}
		return result;
	}

	@Override
	public int delete(String num) {
		Connection con = null;
		PreparedStatement pst = null;
		int result = 0;
		try {
			con = ds.getConnection();
			pst = con.prepareStatement("delete from members where num=?");
			pst.setString(1, num);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql Error....");
			e.printStackTrace();
		}finally {
			JDBCProxy.close(pst, con);
		}
		return result;
	}

	@Override
	public MemDTO selectOne(String num) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pst = con.prepareStatement("select num,pw,name,tel from members where num=?");
			pst.setString(1, num);
			rs = pst.executeQuery();
			MemDTO dto = null;
			while (rs.next()) {
				dto = new MemDTO(rs.getString("num"), rs.getString("pw"), rs.getString("name"), rs.getString("tel"));
			}
			return dto;
		} catch (SQLException e) {
			System.out.println("sql Error....");
			e.printStackTrace();
		}finally {
			JDBCProxy.close(pst, con, rs);
		}
		
		return null;
	}

	@Override
	public List<MemDTO> selectList() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pst = con.prepareStatement("select num,pw,name,tel from members");
			rs = pst.executeQuery();
			ArrayList<MemDTO> list = new ArrayList<MemDTO>();
			while (rs.next()) {
				list.add(new MemDTO(rs.getString("num"), rs.getString("pw"), rs.getString("name"), rs.getString("tel")));
			}
			return list;
		} catch (SQLException e) {
			System.out.println("sql Error....");
			e.printStackTrace();
		}finally {
			JDBCProxy.close(pst, con, rs);
		}
		
		return null;
	}
	
}
