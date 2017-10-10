package com.eShoppingCart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eShoppingCart.model.Product;
import com.eShoppingCart.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/productList/all")
	public String getProducts(Model model){
		
		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		
		return "productList";
	}
	
	@RequestMapping("/viewProduct/{id}")
	public String viewProduct(@PathVariable(value="id") int id, Model model){
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		
		return "viewProductDetail";
	
	}
	
	@RequestMapping("/productList")
	public String getProductByCategory(@RequestParam("searchCondition") String searchCondition, Model model){
		
		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		model.addAttribute("searchCondition", searchCondition);
		
		return "productList";
	}
	
}
