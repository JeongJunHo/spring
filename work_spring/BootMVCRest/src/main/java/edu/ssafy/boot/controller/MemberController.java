package edu.ssafy.boot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.boot.dto.MemDTO;
import edu.ssafy.boot.exception.MyException;
import edu.ssafy.boot.service.MemberService;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@ExceptionHandler(MyException.class)
	public String myException(Exception e, HttpServletRequest req) {
		req.setAttribute("message", e.getMessage());
		return "myErrorPage";
	}
	
	@ExceptionHandler(Exception.class)
	public String allException(Exception e, HttpServletRequest req) {
		req.setAttribute("message", e.getMessage());
		return "allErrorPage";
	}
	
	@Autowired
	MemberService ser;
	
	@RequestMapping("/memregpage")
	public String memRegPage() {
		return "member/memreg";
	}
	
	@RequestMapping("/memreg")
	public ModelAndView memReg(HttpServletRequest req, ModelAndView mv) throws MyException {
		String num = req.getParameter("num");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		try {
			ser.insert(num, pw, name, tel);
			
			List<MemDTO> list = ser.selectList();
			mv.addObject("mems", list);
			mv.setViewName("redirect:memlist");
		}catch(RuntimeException e){
			req.setAttribute("message", e.getMessage());
			mv.setViewName("allErrorPage");
		}
		
		return mv;
	}
	
	@RequestMapping("/memlist")
	public ModelAndView memList(ModelAndView mv) {
		List<MemDTO> list = ser.selectList();
		mv.addObject("mems", list);
		mv.setViewName("member/memlist");
		
		return mv;
	}
	
	@RequestMapping("/memview")
	public ModelAndView memView(@RequestParam("num")String num, ModelAndView mv) {
		MemDTO mem = ser.selectOne(num);
		mv.addObject("mem", mem);
		mv.setViewName("member/memview");
		
		return mv;
	}
	
	@RequestMapping("/memdelete")
	public ModelAndView memDelete(@RequestParam("num")String num, ModelAndView mv) {
		ser.delete(num);
		mv.setViewName("redirect:/memlist");
		
		return mv;
	}
	
	@RequestMapping("/memupdate")
	public ModelAndView memUpdate(MemDTO mem, ModelAndView mv) {
		ser.update(mem.getNum(), mem.getPw(), mem.getName(), mem.getTel());
		mv.setViewName("redirect:/memlist");
		
		return mv;
	}
}
