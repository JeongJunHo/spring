package com.ssafy.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.ssafy.student.domain.StudentDTO;
import com.ssafy.student.util.ConnectionProxy;

@Component("StudentDAO")
public class StudentDAOAnnoImpl implements StudentDAO {
	//list -- >>>> JDBC
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
	public void insertStudent(StudentDTO s) {
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "insert into student(num,name,age) values (?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, s.getNum());
			psmt.setString(2, s.getName());
			psmt.setString(3, s.getAge());
			psmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public void updateStudent(StudentDTO s) {
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "update student set name = ?, age = ? where num = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, s.getName());
			psmt.setString(2, s.getAge());
			psmt.setString(3, s.getNum());
			psmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public void deleteStudent(String num) {
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "delete from student where num = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, num);
			psmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public StudentDTO selectStudentOne(String num) {
		StudentDTO studentDTO = null;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "select num, name, age from student where num = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, num);
			rs = psmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String age = rs.getString("age");
				studentDTO = new StudentDTO(num, name, age);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return studentDTO;
	}

	@Override
	public ArrayList<StudentDTO> selectStudentList() {
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "select num, name, age from student";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				String num = rs.getString("num");
				String name = rs.getString("name");
				String age = rs.getString("age");
				list.add(new StudentDTO(num, name, age));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}
}
