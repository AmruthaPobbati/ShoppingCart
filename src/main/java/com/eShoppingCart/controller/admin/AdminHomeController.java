package com.eShoppingCart.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eShoppingCart.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping
	public String home(){
		return "admin";
	}
	
	@RequestMapping("/productInventory")
	public String productInventory(Model model){
		model.addAttribute("products", productService.getProductList());
		 
		return "productInventory";
	}
	
	
}
