package com.capgemini.adminstore.services;

import java.util.List;

import com.capgemini.adminstore.beans.Merchant;
import com.capgemini.adminstore.beans.Product;
import com.capgemini.adminstore.exceptions.ProductNotFoundException;

public interface MerchantService 
{
	public Product addNewProduct( Product product);
	
	public String deleteProduct(int productid) throws ProductNotFoundException;

    public List<Product> findAll();

    public void save( Product product);

    public  Merchant findById(int productid);
    
	// public Order findByOrderId(Long orderid);
}
