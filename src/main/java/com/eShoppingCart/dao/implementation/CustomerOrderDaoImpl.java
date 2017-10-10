package com.eShoppingCart.dao.implementation;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eShoppingCart.dao.CustomerOrderDao;
import com.eShoppingCart.model.CustomerOrder;

@Repository
@Transactional
public class CustomerOrderDaoImpl implements CustomerOrderDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addCustomerOrder(CustomerOrder customerOrder) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(customerOrder);
		
	}

	public double getCustomerOrderGrandTotal(int cartId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
