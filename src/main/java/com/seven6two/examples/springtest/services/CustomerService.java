package com.seven6two.examples.springtest.services;

import com.seven6two.examples.springtest.models.Customer;
import com.seven6two.examples.springtest.repositories.AccountRepository;
import com.seven6two.examples.springtest.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("customerService")
public class CustomerService {

    private CustomerRepository customerRepository;
    private AccountRepository accountRepository;

    public CustomerService(CustomerRepository customerRepository, AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    public Customer save(Customer customer){
        if(customer.getAccountIds() == null || customer.getAccountIds().size() == 0){
            customer.setAccountIds(new ArrayList<String>());
        }
        return customerRepository.save(customer);
    }

    public Customer findById(int customerId){
        return customerRepository.findById(customerId);
    }

    public List<Customer> findCustomersByAccountId(int accountId){
        if(accountRepository.exists(accountId)){
            return accountRepository.findCustomersByAccountId(accountId);
        }else{
            return new ArrayList<Customer>();
        }
    }

}
