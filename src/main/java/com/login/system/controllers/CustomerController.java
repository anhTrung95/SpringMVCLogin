package com.login.system.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.login.system.beans.Customer;
import com.login.system.exceptions.CustomerNotFoundException;
import com.login.system.services.CustomerService;
import com.login.system.validation.CustomerValidation;


@Controller
@RequestMapping(value="/customer")
public class CustomerController {
	
	public static Logger log = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String getCustomer(@PathVariable("id") int id, Model model) throws Exception {
		if(id==1) {
			throw new CustomerNotFoundException(id);
		} else if (id==2) {
			throw new SQLException("SQL Exception, id=" + id);
		} else if(id==3){
			throw new IOException("IOException, id="+id);
		} else {
			throw new Exception("Generic Exception, id="+id);
		}
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ModelAndView handleCustomerNotFoundException(HttpServletRequest request, Exception ex){
		log.error("Requested URL="+request.getRequestURL());
		log.error("Exception Raised="+ex);
		
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("exception", ex);
	    modelAndView.addObject("url", request.getRequestURL());
	    
	    modelAndView.setViewName("error");
	    return modelAndView;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showForm(Locale locale, ModelMap model, HttpSession session) {
		if (session.getAttribute("customer") != null) {
			return "redirect:user";
		} else {
			model.put("customerData", new Customer());
			return "register/register";
		}
		
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveForm(Locale locale, ModelMap model, @ModelAttribute("customerData") @Valid Customer customer, BindingResult br, HttpSession session) {
		if (br.hasErrors()) {
			return "register/register";
		} else {
			try {
				customerService.saveCustomer(customer);
			}
			catch (Exception e) {
				model.put("duplicate", "email existed");
				return "register/register";
			}
			session.setAttribute("customer", customer);
			return "redirect:user";
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin(Locale locale, ModelMap model, HttpSession session) {
		if (session.getAttribute("customer") == null) {
			model.put("customerData", new Customer());
			return "login/login";
		} else {
			return "redirect:user";
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(Locale locale, ModelMap model, @ModelAttribute("customerData") Customer customer, HttpSession session) {
		if (customer.getC_email() != null && customer.getC_password() != null && session.getAttribute("customer") == null) {
			customer = customerService.loginCustomer(customer);
			if (customer != null) {
				session.setAttribute("customer", customer);
				return "redirect:user";
			} else {
				model.put("failed", "Login Failed");
				return "login/login";
			}
		} else {
			return "redirect:user";
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(Locale locale, ModelMap model, HttpSession session) {
		session.removeAttribute("customer");
		return "redirect:login";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String showSuccess(Locale locale, ModelMap model, HttpSession session) {
		if (session.getAttribute("customer") == null) {
			model.put("customerData", new Customer());
			return "login/login";
		} else {
			model.put("user", new Customer());
			return "user";
		}
	}
}
