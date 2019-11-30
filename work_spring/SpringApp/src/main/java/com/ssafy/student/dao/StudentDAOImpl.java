package com.ssafy.student.dao;

import java.util.ArrayList;

import com.ssafy.student.domain.StudentDTO;

public class StudentDAOImpl implements StudentDAO {
	//list -- >>>> JDBC
	private ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
	@Override
	public void insertStudent(StudentDTO s) {
		list.add(s);
	}

	@Override
	public void updateStudent(StudentDTO s) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getNum().equals(s.getNum())){
				list.set(i, s);
			}
		}
	}

	@Override
	public void deleteStudent(String num) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getNum().equals(num)){
				list.remove(i);
			}
		}
	}

	@Override
	public StudentDTO selectStudentOne(String name) {
		return null;
	}

	@Override
	public ArrayList<StudentDTO> selectStudentList() {
		return list;
	}
}
