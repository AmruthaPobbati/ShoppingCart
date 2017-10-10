package com.eShoppingCart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eShoppingCart.dao.CartDao;
import com.eShoppingCart.model.Cart;
import com.eShoppingCart.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired 
	private CartDao cartDao;
	
	public Cart getCartById(int cartId) {
		
		return cartDao.getCartById(cartId);
	}

	public void update(Cart cart) {
		
		cartDao.update(cart);
	}

}
