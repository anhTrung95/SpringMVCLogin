/**
 * 
 */
package com.login.system.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.login.system.beans.Customer;



/**
 * @author Mayur
 *
 */
//this class is used to validate our form input fields
public class CustomerValidation implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {

		return Customer.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {

	}
	

}
