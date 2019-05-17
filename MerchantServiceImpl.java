package com.capgemini.adminstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.capgemini.adminstore.beans.Merchant;
import com.capgemini.adminstore.beans.Product;
import com.capgemini.adminstore.exceptions.ProductNotFoundException;
import com.capgemini.adminstore.repo.MerchantRepo;
import com.capgemini.adminstore.repo.ProductRepo;

@Service(value="merchantServices")
public class MerchantServiceImpl implements MerchantService
{
	@Autowired
	private ProductRepo productRepos;
	
	@Autowired
	private MerchantRepo merchantRepos;
	
	@Override
	public List<Product> findAll() {

		List<Product> prolist = productRepos.findAll();

		return prolist;

	}

	@Override
	public void save(Product pro) {

		productRepos.save(pro);

	}

	@Override
	public Merchant findById(int merchantid) {
		Merchant merchant=merchantRepos.findById(merchantid).get();
		return merchant;
	}

	@Override
	public Product addNewProduct(Product product) {
		product = new Product();
		return productRepos.save(product);
	}

	@Override
	    public String deleteProduct(@PathVariable int no) throws ProductNotFoundException {
	        return productRepos.findById(no).map(account -> {
	        	productRepos.delete(account);
	            return "deleted";
	        }).orElseThrow(() -> new ProductNotFoundException("Account No " + no + " not found"));	    
	    }
}
