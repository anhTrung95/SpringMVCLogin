package com.login.system.dao;

import com.login.system.beans.Customer;

public interface CustomerDao {

	public void saveCustomer(Customer customer) throws Exception;

	public Customer loginCustomer(Customer customer);
	
	public Customer getCustomer(int customerId) throws Exception;
	
	//public boolean existsByEmail(String email, Class model_class);
}
