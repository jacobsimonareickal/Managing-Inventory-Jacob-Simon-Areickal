package com.capgemini.adminstore.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.adminstore.beans.Customer;
import com.capgemini.adminstore.beans.Merchant;
import com.capgemini.adminstore.beans.Product;
import com.capgemini.adminstore.exceptions.ProductNotFoundException;
import com.capgemini.adminstore.services.AdminServices;
import com.capgemini.adminstore.services.MerchantService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminServices adminservice;
	
	

    @GetMapping("/addMerchant")
	public ModelAndView addMerchant()
	{
		return new ModelAndView("addMerchant", "merchant", new Merchant());
	}
	
	@PostMapping("/addMerchant")
	public ModelAndView saveAccount(@Valid @ModelAttribute("merchant")Merchant merchant)
	{
		ModelAndView mv=new ModelAndView("addMerSucc");
		mv.addObject(adminservice.addMerchant(merchant));
		return mv;
	}
	
	@GetMapping("/removeMerchant")
	/*To create an object for creating an account */
	public String deleteMerchantPage()
	{
		return "removeMerchant";
	}
	
	@PostMapping("/removeMerchant")
	/*To create an object for creating an account */
	public String removeMerchant(@RequestParam int no) throws ProductNotFoundException
	{
		String message=adminservice.removeMerchant(no);
		if(message.equals("deleted"))
			message="Account No : "+no+"Deleted Successfully";
		else
			message="Account No : "+no+" has not been deleted";
		ModelAndView mv=new ModelAndView("adminHome");
		return message;
	}
	
	//@GetMapping("/viewMerchant")
	/*To create an object for creating an account */
//	public ModelAndView viewMerchantPage()
	//{
		//return "removeMerchant";
//	}
	
	@GetMapping("/allproducts")
	public ModelAndView getAllProducts()
	{
		Merchant merchant = new Merchant();
		ModelAndView mv=new ModelAndView("merchantIdForProducts","merchant",merchant);
		return mv;
	}
	
	@PostMapping("/allproducts")
    public ModelAndView getAllProductsByMerchantId(@RequestParam int no)
	{
	     ModelAndView mv=new ModelAndView("");
	   	 Merchant merchant = adminservice.findById(no);
	   	 List<Product> pList = merchant.getProducts();
	     mv.addObject("pList",pList);
	   	 return mv;
	}
	
	@GetMapping("/allcustomers")
    /*Method used to call the method for printing all the transactions*/
    public ModelAndView getAllProductsByMerchantId()
    {
     ModelAndView mv=new ModelAndView("allcustomers");
   	 List<Customer> cList = adminservice.viewAllCustomers();
     mv.addObject("cList",cList);
   	 return mv;
     }
}
