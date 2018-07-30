package com.login.system.dao;

import com.login.system.beans.Customer;

public interface CustomerDao {

	public void saveCustomer(Customer customer);

	public Customer loginCustomer(Customer customer);
}
