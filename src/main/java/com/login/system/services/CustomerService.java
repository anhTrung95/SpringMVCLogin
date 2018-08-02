package com.login.system.services;

import com.login.system.beans.Customer;

public interface CustomerService {

	public void saveCustomer(Customer customer) throws Exception;
	public Customer loginCustomer(Customer customer);
	//public boolean existsByEmail(String email, Class model_class);
}
