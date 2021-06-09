package com.nawaz2000.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nawaz2000.spring.entity.Customer;
import com.nawaz2000.spring.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor ste = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, ste);
	}

	@Autowired
	@Qualifier("customerService")
	CustomerService customerService;

	@GetMapping("/search")
	public String searchCustomer(Model model, @RequestParam("searchName") String searchName) {
		List<Customer> allCustomers = customerService.searchCustomers(searchName);
		model.addAttribute("customers", allCustomers);
		return "list-customers";
	}
	
	@GetMapping("/list")
	public String showCustomers(Model model) {
		System.out.println("Hi there");
		List<Customer> allCustomers = customerService.getAllCustomers();
		model.addAttribute("customers", allCustomers);
		return "list-customers";
	}

	@GetMapping("/showCustomerForm")
	public String showCustomerForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(Model model, @Valid @ModelAttribute("customer") Customer customer,
			BindingResult bindingResult) {
		System.out.println(bindingResult);
		if (bindingResult.hasErrors()) {
			System.out.println("Error at binding result");
			return "customer-form";
		} else {
			customerService.addCustomer(customer);
			return "redirect:/customer/list";
		}

	}

	@GetMapping("/showCustomerUpdateForm")
	public String showCustomerUpdateForm(Model model, @RequestParam("customerId") int id) {
		System.out.println("entered update form");
		Customer retrievedCustomer = customerService.getCustomer(id);
		model.addAttribute("customer", retrievedCustomer);
		return "customer-form";
	}

	@GetMapping("/deleteCustomer")
	public String deleteCustomer(Model model, @RequestParam("customerId") int id) {
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}

}
