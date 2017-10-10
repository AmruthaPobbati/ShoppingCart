package com.eShoppingCart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eShoppingCart.dao.CustomerDao;
import com.eShoppingCart.model.Customer;
import com.eShoppingCart.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	 @Autowired
	    private CustomerDao customerDao;

	    public void addCustomer (Customer customer) {
	        customerDao.addCustomer(customer);
	    }

	    public Customer getCustomerById(int customerId) {
	        return customerDao.getCustomerById(customerId);
	    }

	    public List<Customer> getAllCustomers() {
	        return customerDao.getAllCustomers();
	    }

	    public Customer getCustomerByUsername (String username) {
	        return customerDao.getCustomerByUsername(username);
	    }
}
