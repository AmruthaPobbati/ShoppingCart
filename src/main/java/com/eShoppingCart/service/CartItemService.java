package com.eShoppingCart.service;

import com.eShoppingCart.model.Cart;
import com.eShoppingCart.model.CartItem;

public interface CartItemService {

	void addCartItem(CartItem cartItem);
	
	void removeCartItem(CartItem cartItem);
	
	void removeAllCartItems(Cart cart);
	
	CartItem getCartItemByProductId(int productId);
}
