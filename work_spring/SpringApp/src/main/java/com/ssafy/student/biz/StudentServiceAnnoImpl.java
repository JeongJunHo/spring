package com.ssafy.student.biz;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssafy.student.dao.StudentDAO;
import com.ssafy.student.domain.StudentDTO;
import com.ssafy.student.exception.MyException;

@Component("StudentService")
public class StudentServiceAnnoImpl implements StudentService {
	@Autowired
	private StudentDAO dao;
	
	public StudentServiceAnnoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insertStudent(String num, String name, String age) throws MyException {
		try {
			dao.insertStudent(new StudentDTO(num, name, age));
			
		} catch (Exception e) {
			throw new MyException();
		}
	}

	@Override
	public void updateStudent(String num, String name, String age) throws MyException {
		try {
			dao.updateStudent(new StudentDTO(num, name, age));
		} catch (Exception e) {
			throw new MyException();
		}
	}

	@Override
	public void deleteStudent(String num) throws MyException {
		try {
			dao.deleteStudent(num);
		} catch (Exception e) {
			throw new MyException();
		}
	}

	@Override
	public StudentDTO selectStudentOne(String name) throws MyException {
		StudentDTO dto = null;
		try {
			dto = dao.selectStudentOne(name);			
		} catch (Exception e) {
			throw new MyException();
		}
		
		//logic here
		return dto;
	}

	@Override
	public ArrayList<StudentDTO> selectStudentList() throws MyException {
		ArrayList<StudentDTO> list = null;
		try {
			list = dao.selectStudentList();			
		} catch (Exception e) {
			throw new MyException();
		}
		//logic here
		return list;
	}
}
