package com.eShoppingCart.dao;

import com.eShoppingCart.model.CustomerOrder;

public interface CustomerOrderDao {
	
	void addCustomerOrder(CustomerOrder customerOrder);
	
	double getCustomerOrderGrandTotal(int cartId);
}
