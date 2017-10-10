package com.eShoppingCart.service;

import java.util.List;

import com.eShoppingCart.model.Product;

public interface ProductService {
	
	List<Product> getProductList();

    Product getProductById(int productId);
    
    void deleteProduct(Product product);
    
    void addProduct(Product product);
    
    void editProduct(Product product);

}
