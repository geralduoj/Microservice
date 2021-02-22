/** 
	Authors -----------
	Gerald Uchie-Okoro - 301064861
	Kazeem Ademola Odukale - 301021750 
	Jyoti Jairath - 301101579
**/
package com.assign.microservice;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@RequestMapping(value = "/newcustomer")
    public ModelAndView newCustomer(Customer customer)
    {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("newcustomer");
		return mv;
    }
	
	/**
	@PostMapping("/addcustomer")
    public @ResponseBody ModelAndView add(@RequestParam("custName") String custName,
            @RequestParam("city") String city,
            @RequestParam("email") String email,
            @RequestParam("address") String address,
            @RequestParam("phoneNumber") String phoneNumber)
    {
		Customer customer=new Customer(custName,city,email,address,phoneNumber);
		customerRepo.save(customer);
		ModelAndView mv = new ModelAndView();
		mv.addObject("customer", customerRepo.findAll());
		mv.setViewName("showcustomers");
		return mv;
    }**/
	
	//add a new customer
	@PostMapping("/addcustomer")
	    public String add(@Valid Customer customer, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "newcustomer";
	        }

	        customerRepo.save(customer);
	        model.addAttribute("customer", customerRepo.findAll());
	        return "showcustomers";
	    }
	
	//Get the edit request
		@GetMapping("/edit/{custId}")
		public String edit(@PathVariable("custId") int custId, Model model) {
		    Customer cust = customerRepo.findById(custId)
		      .orElseThrow(() -> new IllegalArgumentException("Invalid customer number:" + custId));

		    model.addAttribute("customer", cust);
		    return "update-customer";
		}
		
		//update the existing customer
		@PostMapping("/update/{id}")
		public String update(@PathVariable("id") int no, @Valid Customer customer,
		  BindingResult result, Model model) {
		    if (result.hasErrors()) {
		        customer.setCustId(no);
		        return "update-customer";
		    }
		    Customer customerToUpdate = customerRepo.getOne(no);
		    customerToUpdate.setCustName(customer.getCustName());
		    customerToUpdate.setCity(customer.getCity());
		    customerToUpdate.setEmail(customer.getEmail());
		    customerToUpdate.setAddress(customer.getAddress());
		    customerToUpdate.setPhoneNumber(customer.getPhoneNumber());
		    customerRepo.save(customerToUpdate);

		    model.addAttribute("customer", customerRepo.findAll());
		    return "showcustomers";
		}
		
		//delete a customer
		@GetMapping("/delete/{id}")
		public String delete(@PathVariable("id") int no, Model model) {
		    Customer cust = customerRepo.findById(no)
		      .orElseThrow(() -> new IllegalArgumentException("Invalid customer Number:" + no));
		    customerRepo.delete(cust);
		    model.addAttribute("customer", customerRepo.findAll());
		    return "showcustomers";
		}
	
	@RequestMapping("/selectcustomer/{custId}")
    public @ResponseBody ModelAndView getCustomer(@PathVariable("custId") int custId)
    {
		ModelAndView mv = new ModelAndView();
		Optional<Customer> custOBJ = customerRepo.findById(custId);
		Customer cust = custOBJ.get();
		mv.addObject("customer", cust);
		return mv;
    }
	
	@RequestMapping("/showcustomers")
    public ModelAndView show(Model model)
    {
        model.addAttribute("customer", customerRepo.findAll());
        ModelAndView mv = new ModelAndView();
		mv.setViewName("showcustomers");
		return mv;
    }

}
