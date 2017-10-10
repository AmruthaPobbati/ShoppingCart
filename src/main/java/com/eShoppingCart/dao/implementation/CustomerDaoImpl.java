package com.eShoppingCart.dao.implementation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eShoppingCart.dao.CustomerDao;
import com.eShoppingCart.model.Authorities;
import com.eShoppingCart.model.Cart;
import com.eShoppingCart.model.Customer;
import com.eShoppingCart.model.Users;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		
		customer.getBillingAddress().setCustomer(customer);
		customer.getShippingAddress().setCustomer(customer);
		
		session.saveOrUpdate(customer);
		session.saveOrUpdate(customer.getBillingAddress());
		session.saveOrUpdate(customer.getShippingAddress());
		
		Users newUser = new Users();
		newUser.setCustomerId(customer.getCustomerId());
		newUser.setUsername(customer.getUsername());
		newUser.setPassword(customer.getPassword());
		newUser.setEnabled(true);
		
		Authorities newAuthority = new Authorities();
		newAuthority.setAuthority("ROLE_USER");
		newAuthority.setUsername(customer.getUsername());
		
		session.saveOrUpdate(newUser);
		session.saveOrUpdate(newAuthority);
		
		Cart newCart = new Cart();
		newCart.setCustomer(customer);
		
		customer.setCart(newCart);
		session.saveOrUpdate(customer);
		session.saveOrUpdate(newCart);
		
		session.flush();
		
	}

	public Customer getCustomerById(int customerId) {
		return (Customer) sessionFactory.getCurrentSession().get(Customer.class, customerId);
	}

	public List<Customer> getAllCustomers() {
		return sessionFactory.getCurrentSession().createQuery("from Customer")
                .list();
	}

	public Customer getCustomerByUsername(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Customer where username = ?");
		query.setString(0, username);
		return (Customer) query.uniqueResult();
	}

}
