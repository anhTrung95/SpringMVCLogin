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
	public void saveCustomer(Customer customer) throws Exception {
		try {
			this.customerDao.saveCustomer(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception(e.getMessage(), e);
		}
	}
	
	public Customer loginCustomer(Customer customer) {
		return this.customerDao.loginCustomer(customer);
	}

	@Override
	public Customer getCustomer(int customerId) throws Exception {
		try {
			return customerDao.getCustomer(customerId);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	/*@Override
	public boolean existsByEmail(String email, Class model_class) {
		// TODO Auto-generated method stub
		return false;
	}*/

}
