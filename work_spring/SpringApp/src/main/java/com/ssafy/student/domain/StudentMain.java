package com.ssafy.student.domain;

import java.util.ArrayList;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ssafy.student.biz.StudentService;
import com.ssafy.student.config.StudentConfig;
import com.ssafy.student.exception.MyException;

public class StudentMain {
	public static void main(String[] args) {
//		BeanFactory fac = new ClassPathXmlApplicationContext("app/config/studentContext.xml");
		BeanFactory fac = new AnnotationConfigApplicationContext(StudentConfig.class);
//		StudentService service = (StudentService) fac.getBean("sservice");
		StudentService service = (StudentService) fac.getBean("StudentService");
		try {
			service.insertStudent("1", "홍길동", "21");
			service.insertStudent("2", "고길동", "31");
			service.insertStudent("3", "둘리", "7");
			System.out.println("하나 조회");
			System.out.println(service.selectStudentOne("2"));
			
			service.updateStudent("2", "이하연", "25");
			System.out.println("하나 조회");
			System.out.println(service.selectStudentOne("2"));
			service.deleteStudent("2");
			System.out.println("삭제");
			
			
			
			ArrayList<StudentDTO> list = service.selectStudentList();
			for (StudentDTO studentDTO : list) {
				System.out.println(studentDTO);
			}
		} catch (MyException e) {
			// TODO Auto-generated catch block
			System.out.println("실패");
		}
	}
}
