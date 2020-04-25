package com.arpita.Product_thymleaf.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.arpita.Product_thymleaf.model.*;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.arpita.Product_thymleaf.Service.ProductService;

@Controller
public class AppController {

	@Autowired
	private ProductService services;
	
	@RequestMapping("/")
	public String viewPage(Model model) {
		List<Product> list=services.listAll();
		model.addAttribute("listProduct", list);
		return "index";
	}
	
	@RequestMapping("/new")
	public String newProduct(Model model) {
		Product p=new Product();
		model.addAttribute("product",p);
		return "home";
	}
	
	@RequestMapping(value="/save" ,method=RequestMethod.POST)
	public String saveProduct(@ModelAttribute() Product product) {
		services.save(product);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView editProduct(@PathVariable(name ="id") Long id) {
		ModelAndView mav=new ModelAndView("edit");
		Product p=services.get(id);
		mav.addObject("product",p);
		return mav;
	}
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name ="id") Long id) {
	
		services.delete(id);
		
		return "redirect:/";
	}
}
