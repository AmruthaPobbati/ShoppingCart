package com.eShoppingCart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eShoppingCart.dao.CartDao;
import com.eShoppingCart.dao.CustomerOrderDao;
import com.eShoppingCart.model.Cart;
import com.eShoppingCart.model.CartItem;
import com.eShoppingCart.model.CustomerOrder;
import com.eShoppingCart.service.CartService;
import com.eShoppingCart.service.CustomerOrderService;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{
	
	@Autowired
	private CustomerOrderDao customerOrderDao;
	
	@Autowired
	private CartDao cartDao;

	public void addCustomerOrder(CustomerOrder customerOrder) {
		customerOrderDao.addCustomerOrder(customerOrder);
		
	}

	public double getCustomerOrderGrandTotal(int cartId) {
		
		double grandTotal = 0;
		
		Cart cart = cartDao.getCartById(cartId);
		
		for(CartItem c: cart.getCartItems()){
			grandTotal = grandTotal + c.getTotalPrice();
		}
		
		return grandTotal;
	}

}
