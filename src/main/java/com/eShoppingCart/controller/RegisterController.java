package com.eShoppingCart.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eShoppingCart.model.BillingAddress;
import com.eShoppingCart.model.Customer;
import com.eShoppingCart.model.ShippingAddress;
import com.eShoppingCart.service.CustomerService;

@Controller
public class RegisterController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/register")
	public String registerCustomer(Model model){
		
		Customer customer = new Customer();
		BillingAddress billingAddress = new BillingAddress();
		ShippingAddress shippingAddress = new ShippingAddress();
		
		customer.setBillingAddress(billingAddress);
		customer.setShippingAddress(shippingAddress);
		
		model.addAttribute("customer", customer);
		
		return "registerCustomer";
		
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String registerCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model model){
		
		if(result.hasErrors()){
			return "registerCustomer";
		}
		
		List<Customer> customers = customerService.getAllCustomers();
		
		for(Customer c: customers){
			if(c.getUsername().equals(customer.getUsername())){
				model.addAttribute("userNameMsg", "Username already exists");
				
				return "registerCustomer";
			}
			
			if(c.getCustomerEmail().equals(customer.getCustomerEmail())){
				model.addAttribute("emailMsg", "Email already exists");
				
				return "registerCustomer";
			}
		}
		customerService.addCustomer(customer);
		
		return "registerCustomerSuccess";
	}
	
}
