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

import edu.ssafy.boot.dto.ProductDTO;
import edu.ssafy.boot.exception.MyException;
import edu.ssafy.boot.service.ProductService;

@Controller
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
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
	ProductService ser;
	
	@RequestMapping("/productregpage")
	public String productRegPage() {
		return "product/productreg";
	}
	
	@RequestMapping("/productreg")
	public ModelAndView productReg(HttpServletRequest req, ModelAndView mv) throws MyException {
		String num = req.getParameter("num");
		String name = req.getParameter("name");
		int price = Integer.parseInt(req.getParameter("price"));
		ser.insert(num, name, price);
		
		mv.setViewName("redirect:productlist");
		
		return mv;
	}
	
	@RequestMapping("/productlist")
	public ModelAndView productList(ModelAndView mv) {
		List<ProductDTO> list = ser.selectList();
		mv.addObject("products", list);
		mv.setViewName("product/productlist");
		
		return mv;
	}
	
	@RequestMapping("/productview")
	public ModelAndView productView(@RequestParam("num")String num, ModelAndView mv) {
		ProductDTO product = ser.selectOne(num);
		mv.addObject("product", product);
		mv.setViewName("product/productview");
		
		return mv;
	}
	
	@RequestMapping("/productdelete")
	public ModelAndView productDelete(@RequestParam("num")String num, ModelAndView mv) {
		ser.delete(num);
		mv.setViewName("redirect:/productlist");
		
		return mv;
	}
	
	@RequestMapping("/productupdate")
	public ModelAndView productUpdate(ProductDTO product, ModelAndView mv) {
		ser.update(product.getNum(), product.getName(), product.getPrice());
		mv.setViewName("redirect:/productlist");
		
		return mv;
	}
}
