package com.ssafy.student.biz;

import java.util.ArrayList;

import com.ssafy.student.domain.StudentDTO;
import com.ssafy.student.exception.MyException;

public interface StudentService {
	public void insertStudent(String num, String name, String age) throws MyException;
	public void updateStudent(String num, String name, String age) throws MyException;
	public void deleteStudent(String num) throws MyException;
	public StudentDTO selectStudentOne(String num) throws MyException;
	public ArrayList<StudentDTO> selectStudentList() throws MyException;
}
