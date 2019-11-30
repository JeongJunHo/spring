package edu.ssafy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ssafy.dto.MemDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
//	@RequestMapping(value="/testmodelandview", method= {RequestMethod.GET, RequestMethod.POST})
//	public ModelAndView testModelAndView(HttpServletRequest req, HttpServletResponse res, ModelAndView mv, Locale lo) {
//		String id = req.getParameter("id");
//		String pw = req.getParameter("pw");
//		
//		mv.addObject("message", "Hello SSafy" + id + " " + pw);
//		mv.setViewName("redirect:/result.jsp");
//		mv.setViewName("forward:result");
//		mv.setViewName("result");
//		
//		return mv;
//	}
	
//	@RequestMapping(value="/testmodel", method= {RequestMethod.GET, RequestMethod.POST})
//	public String testModel(HttpServletRequest req, HttpServletResponse res, Model m, Locale lo) {
//		String id = req.getParameter("id");
//		String pw = req.getParameter("pw");
//		
//		m.addAttribute("message", "Hello SSafy" + id + " " + pw);
//		String str = "String";
//		m.addAttribute(str);
//		
//		
//		return "result";
//		return "redirect:index.jsp";
//	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	private MemDTO dto;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		System.out.println(dto.toString());
		
		return "home";
	}
}
