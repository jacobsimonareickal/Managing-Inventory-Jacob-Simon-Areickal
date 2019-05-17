package com.capgemini.adminstore.services;

import java.util.List;

import com.capgemini.adminstore.beans.Coupon;
import com.capgemini.adminstore.beans.Customer;
import com.capgemini.adminstore.beans.Discount;
import com.capgemini.adminstore.beans.Merchant;
import com.capgemini.adminstore.exceptions.ProductNotFoundException;

public interface AdminServices {
	public List<Merchant> viewAllMerchants();
	public Merchant addMerchant(Merchant merchant);
	public String removeMerchant(int no) throws ProductNotFoundException;
	public List<Customer> viewAllCustomers();
	public String removeCoupon(int couponid) throws ProductNotFoundException;
	public String removeDiscount(int discountid) throws ProductNotFoundException;;
	public Discount addDiscount(Discount discount);
	public Coupon addCoupon(Coupon coupon);
	public  Merchant findById(int merchantid);
}
