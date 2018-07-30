package com.login.system.controllers;

import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.login.system.beans.Customer;
import com.login.system.services.CustomerService;
import com.login.system.validation.CustomerValidation;


@Controller
@RequestMapping(value="/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showForm(Locale locale, ModelMap model) {
		model.put("customerData", new Customer());
		return "register/register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveForm(Locale locale, ModelMap model, @ModelAttribute("customerData") @Valid Customer customer, BindingResult br, HttpSession session) {
		CustomerValidation customerValidation = new CustomerValidation();
		customerValidation.validate(customerValidation, br);
		if (br.hasErrors()) {
			return "register/register";
		} else {
			customerService.saveCustomer(customer);
			session.setAttribute("customer", customer);
			return "redirect:success";
		}
		
	}
	
}
