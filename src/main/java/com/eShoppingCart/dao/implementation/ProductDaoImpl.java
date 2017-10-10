package com.eShoppingCart.dao.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eShoppingCart.dao.ProductDao;
import com.eShoppingCart.model.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Product> getProductList() {
		return sessionFactory.getCurrentSession().createQuery("from Product")
                .list();
	}

	public Product getProductById(int productId) {
		 return (Product) sessionFactory.getCurrentSession().get(
	                Product.class, productId);
	}

	@Transactional
	public void deleteProduct(Product product) {
		sessionFactory.getCurrentSession().delete(product);
		
	}

	@Transactional
	public void addProduct(Product product) {
		System.out.println("impl: " + product);
		 sessionFactory.getCurrentSession().saveOrUpdate(product);
		
	}

	public void editProduct(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		
	}

	
}
