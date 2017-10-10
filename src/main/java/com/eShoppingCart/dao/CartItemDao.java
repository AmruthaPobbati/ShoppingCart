package com.eShoppingCart.dao;

import com.eShoppingCart.model.Cart;
import com.eShoppingCart.model.CartItem;

public interface CartItemDao {

	void addCartItem(CartItem cartItem);
	
	void removeCartItem(CartItem cartItem);
	
	void removeAllCartItems(Cart cart);
	
	CartItem getCartItemByProductId(int productId);
}
