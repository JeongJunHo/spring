package com.ssafy.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.edu.dto.MemDTO;
import com.ssafy.edu.service.MemService;

@Controller
public class MemController {
	@Autowired
	MemService memService;
	
	@RequestMapping("memlist")
	public ModelAndView list(ModelAndView mv) {
		mv.addObject("list", memService.selectList());
		mv.setViewName("members/memlist");
		
		return mv;
	}
	
	@RequestMapping(value="memreg", method=RequestMethod.GET)
	public String memregpage() {
		return "members/memreg";
	}
	
	@RequestMapping(value="memreg", method=RequestMethod.POST)
	public String memreg(MemDTO memDTO) {
		memService.insert(memDTO.getNum(), memDTO.getPw(), memDTO.getName(), memDTO.getTel());
		return "redirect:memlist";
	}
	
	@RequestMapping("memview")
	public String memview(Model model, String num) {
		memService.selectOne(num);
		model.addAttribute("member", memService.selectOne(num));
		return "members/memview";
	}
	
	@RequestMapping("memupdate")
	public String memUpdate(MemDTO memDTO) {
		memService.update(memDTO.getNum(), memDTO.getPw(), memDTO.getName(), memDTO.getTel());
		return "redirect:memlist";
	}
	
	@RequestMapping("memdelete")
	public String memdelete(String num) {
		memService.delete(num);
		return "redirect:memlist"; 
	}
}
