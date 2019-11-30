package com.ssafy.student.biz;

import java.util.ArrayList;

import com.ssafy.student.dao.StudentDAO;
import com.ssafy.student.domain.StudentDTO;

public class StudentServiceImpl implements StudentService{
	private StudentDAO dao;
	
	public StudentServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public StudentServiceImpl(StudentDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public void insertStudent(String num, String name, String age) {
		dao.insertStudent(new StudentDTO(num, name, age));
	}

	@Override
	public void updateStudent(String num, String name, String age) {
		dao.updateStudent(new StudentDTO(num, name, age));
	}

	@Override
	public void deleteStudent(String num) {
		dao.deleteStudent(num);
	}

	@Override
	public StudentDTO selectStudentOne(String name) {
		StudentDTO dto = dao.selectStudentOne(name);
		//logic here
		return dto;
	}

	@Override
	public ArrayList<StudentDTO> selectStudentList() {
		ArrayList<StudentDTO> list = dao.selectStudentList();
		//logic here
		return list;
	}
}
