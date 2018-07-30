package com.login.system.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.login.system.beans.Customer;
import com.login.system.dao.CustomerDao;

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void saveCustomer(Customer customer) {
		
	}

}
