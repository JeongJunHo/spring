package edu.ssafy.boot.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.boot.dto.MemDTO;
import edu.ssafy.boot.service.MemberService;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	MemberService ser;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/logincheck")
	public ModelAndView loginCheck(@RequestParam("num")String num, @RequestParam("pw")String pw, HttpSession session, ModelAndView mv) {
		MemDTO m = ser.selectOne(num);
		if(m != null && m.getPw().equals(pw)) {
			session.setAttribute("loginMem", m);
			mv.setViewName("redirect:/");
		}else {
			mv.setViewName("redirect:login");
		}
		
		return mv;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:login";
	}
}
