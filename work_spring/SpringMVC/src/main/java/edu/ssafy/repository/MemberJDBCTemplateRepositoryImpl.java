package edu.ssafy.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.ssafy.dto.MemDTO;
import edu.ssafy.exception.MyException;

@Repository("MemberJDBCTemplateRepositoryImpl")
public class MemberJDBCTemplateRepositoryImpl implements MemberRepository {
	
	@Autowired
	private JdbcTemplate jt;

	@Override
	public int insert(MemDTO m) throws MyException {
		return jt.update("insert into members(num,pw,name,tel) values(?,?,?,?)"
				, new Object[] {m.getNum(),m.getPw(),m.getName(),m.getTel()});
	}

	@Override
	public int update(MemDTO m) {
		return jt.update("update members set members pw=?,name=?,tel=? where num=?"
				, new Object[] {m.getPw(),m.getName(),m.getTel(),m.getNum()});
	}

	@Override
	public int delete(String num) {
		return jt.update("delete from members where num = ?"
				, new Object[] {num});
	}

	class MemberMapper implements RowMapper<MemDTO>{
		@Override
		public MemDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemDTO m = new MemDTO();
			m.setNum(rs.getString("num"));
			m.setPw(rs.getString("pw"));
			m.setName(rs.getString("name"));
			m.setTel(rs.getString("tel"));
			return m;
		}
	}
	
	@Override
	public MemDTO selectOne(String num) {
		MemDTO dto = jt.queryForObject("select num, pw, name, tel from members where num = ?"
				, new Object[] {num}
				, new MemberMapper());
		return dto;
	}

	@Override
	public List<MemDTO> selectList() {
		List<MemDTO> list = jt.query("select num, pw, name, tel from members", new MemberMapper());
		return list;
	}
}
