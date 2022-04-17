package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/create-customer")
    public ModelAndView showCreateForm(){
        ModelAndView m = new ModelAndView("/edit");

        m.addObject("customer", new Customer());
        m.addObject("message", "Create customer");
        return  m;
    }

    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@ModelAttribute Customer customer){
        ModelAndView m = new ModelAndView("/edit");

        System.out.println(customer.getFirstName() +"---" + customer.getLastName());
        customerService.saveCustomer(customer);

        m.addObject("customer", new Customer(customer.getFirstName(), customer.getLastName()));
        m.addObject("message", "Create customer");
        return  m;
    }
    @GetMapping("/index")
    public ModelAndView listCustomer(){
        ModelAndView m = new ModelAndView("/index");
        List<Customer> listCustomers = customerService.findAllCustomer();

        System.out.println(listCustomers);
        m.addObject("customers", listCustomers);
        return m;
    }
}
