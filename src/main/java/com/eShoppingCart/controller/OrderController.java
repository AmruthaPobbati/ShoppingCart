package com.eShoppingCart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eShoppingCart.model.Cart;
import com.eShoppingCart.model.Customer;
import com.eShoppingCart.model.CustomerOrder;
import com.eShoppingCart.service.CartService;
import com.eShoppingCart.service.CustomerOrderService;

@Controller
public class OrderController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CustomerOrderService customerOrderService;
	
	@RequestMapping("/order/{cartId}")
	public String createOrder(@PathVariable("cartId") int cartId){
		CustomerOrder order = new CustomerOrder();
		
		Cart cart = cartService.getCartById(cartId);
		
		order.setCart(cart);
		
		Customer customer = cart.getCustomer();
		order.setCustomer(customer);
		order.setBillingAddress(customer.getBillingAddress());
		order.setShippingAddress(customer.getShippingAddress());
		
		customerOrderService.addCustomerOrder(order);
		
		return "redirect:/checkout?cartId="+cartId;
	}

}
