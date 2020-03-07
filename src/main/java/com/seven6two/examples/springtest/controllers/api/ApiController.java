package com.seven6two.examples.springtest.controllers.api;

import com.seven6two.examples.springtest.models.Account;
import com.seven6two.examples.springtest.models.Customer;
import com.seven6two.examples.springtest.services.CustomerService;
import com.seven6two.examples.springtest.utilities.LoggingUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private CustomerService customerService;

    private LoggingUtilities log = new LoggingUtilities();

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView getApiHome(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("api/index");
        return mav;
    }

    @PostMapping("/new")
    public Customer setNewCustomer(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @GetMapping("/find")
    public Customer getCustomerById(@RequestParam(value = "customer", required = true) int customerId){
        Customer customerExists = customerService.findById(customerId);
        if(customerExists == null){
            log.message(String.format("Customer with ID of s% does not exist", customerId));
        }
        return customerExists;
    }

    // Untested
    @GetMapping("/find/customers")
    public List<Customer> getCustomersByAccount(@RequestParam(value = "account", required = true) int accountId){
        List<Customer> customers = customerService.findCustomersByAccountId(accountId);
        if(customers.size() == 0 || customers.isEmpty()){
            log.message(String.format("Account with ID of s% does not exist", accountId));
        }
        return customers;
    }

    // Untested
    @GetMapping("/find/accounts")
    public List<Account> getAccountsByCustomer(@RequestParam(value = "customer", required = true) int customerId){
        List<Account> accounts = customerService.findAccountsByCustomerId(customerId);
        if(accounts.size() == 0 || accounts.isEmpty()){
            log.message(String.format("Customer with ID of s% does not exist", customerId));
        }
        return accounts;
    }

}
