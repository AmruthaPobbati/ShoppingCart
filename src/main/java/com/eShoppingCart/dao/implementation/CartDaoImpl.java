package com.eShoppingCart.dao.implementation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eShoppingCart.dao.CartDao;
import com.eShoppingCart.model.Cart;
import com.eShoppingCart.service.CustomerOrderService;

@Repository
@Transactional
public class CartDaoImpl implements CartDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private CustomerOrderService customerOrderService;
	
	public Cart getCartById(int cartId) {
		
		return (Cart) sessionFactory.getCurrentSession().get(Cart.class,cartId);
	}

	public void update(Cart cart) {
		int cartId = cart.getCartId();
		
		double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartId);
		
		cart.setGrandTotal(grandTotal);
		
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
	}

	public Cart validate(int cartId) throws IOException {
		
		Cart cart = getCartById(cartId);
		
		if(cart == null || cart.getCartItems().size() == 0){
			throw new IOException(cartId + "");
		}
		
		update(cart);
		return cart;
	}

	

}
