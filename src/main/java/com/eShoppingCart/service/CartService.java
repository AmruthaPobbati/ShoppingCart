package com.eShoppingCart.service;

import com.eShoppingCart.model.Cart;

public interface CartService {

	Cart getCartById(int cartId);
	
	void update(Cart cart);
}
