package com.ssafy.student.dao;

import java.util.ArrayList;

import com.ssafy.student.domain.StudentDTO;

public interface StudentDAO {
	public void insertStudent(StudentDTO s);
	public void updateStudent(StudentDTO s);
	public void deleteStudent(String num);
	public StudentDTO selectStudentOne(String num);
	public ArrayList<StudentDTO> selectStudentList();
}
