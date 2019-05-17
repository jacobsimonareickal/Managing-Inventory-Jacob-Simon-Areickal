package com.capgemini.adminstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.capgemini.adminstore.beans.Coupon;
import com.capgemini.adminstore.beans.Customer;
import com.capgemini.adminstore.beans.Discount;
import com.capgemini.adminstore.beans.Merchant;
import com.capgemini.adminstore.beans.Product;
import com.capgemini.adminstore.exceptions.ProductNotFoundException;
import com.capgemini.adminstore.repo.AddressRepo;
import com.capgemini.adminstore.repo.AdminRepo;
import com.capgemini.adminstore.repo.CartRepo;
import com.capgemini.adminstore.repo.CategoryRepo;
import com.capgemini.adminstore.repo.CouponRepo;
import com.capgemini.adminstore.repo.CustomerRepo;
import com.capgemini.adminstore.repo.DiscountRepo;
import com.capgemini.adminstore.repo.InventoryRepo;
import com.capgemini.adminstore.repo.MerchantRepo;
import com.capgemini.adminstore.repo.OrdersRepo;
import com.capgemini.adminstore.repo.ProductRepo;
import com.capgemini.adminstore.repo.ReviewRepo;
import com.capgemini.adminstore.repo.WishlistRepo;

@Service(value="adminServices")
public class AdminServicesImpl implements AdminServices {

	@Autowired
	private AddressRepo addressRepo;
	
	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private CouponRepo couponRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private DiscountRepo discountRepo;
	
	@Autowired
	private InventoryRepo inventoryRepo;
	
	@Autowired
	private MerchantRepo merchantRepo;
	
	@Autowired
	private OrdersRepo ordersRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private ReviewRepo reviewRepo;
	
	@Autowired
	private WishlistRepo wishlistRepo;

	@Override
	public List<Merchant> viewAllMerchants() {
		
		return merchantRepo.findAll();
	
	}

	@Override
	public Merchant addMerchant(Merchant merchant) {
		
		return merchantRepo.save(merchant);
		 
	}

	@Override
	public String removeMerchant(@PathVariable int no) throws ProductNotFoundException {
		return merchantRepo.findById(no).map(account -> {
        	merchantRepo.delete(account);
            return "deleted";
        }).orElseThrow(() -> new ProductNotFoundException("Account No " + no + " not found"));	    
	}
	
	@Override
	public List<Customer> viewAllCustomers()
	{
		return customerRepo.findAll();
	}
	
	@Override
    public String removeDiscount(@PathVariable int no) throws ProductNotFoundException {
        return discountRepo.findById(no).map(account -> {
        	discountRepo.delete(account);
            return "deleted";
        }).orElseThrow(() -> new ProductNotFoundException("Account No " + no + " not found"));	    
    }
	
	@Override
    public String removeCoupon(@PathVariable int no) throws ProductNotFoundException {
        return couponRepo.findById(no).map(account -> {
        	couponRepo.delete(account);
            return "deleted";
        }).orElseThrow(() -> new ProductNotFoundException("Account No " + no + " not found"));	    
    }
	
	@Override
	public Coupon addCoupon(Coupon coupon) {
		coupon = new Coupon();
		return couponRepo.save(coupon);
	}
	
	@Override
	public Discount addDiscount(Discount discount) {
		discount = new Discount();
		return discountRepo.save(discount);
	}
	
	@Override
	public Merchant findById(int merchantid) {
		Merchant merchant=merchantRepo.findById(merchantid).get();
		return merchant;
	}
	
	
}
