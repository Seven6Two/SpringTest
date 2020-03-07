package com.seven6two.examples.springtest.services;

import com.seven6two.examples.springtest.models.Account;
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

    // Untested
    public List<Customer> findCustomersByAccountId(int accountId){
        List<Customer> customerList = new ArrayList<>();
        List<Customer> allCustomers = customerRepository.findAll();
        for(Customer customer : allCustomers){
            if(customer.getAccountIds().contains(accountId)){
                customerList.add(customer);
            }
        }
        allCustomers = null;
        return customerList;
    }

    // Untested
    public List<Account> findAccountsByCustomerId(int customerId){
        List<Account> accountList = new ArrayList<>();
        List<Account> allAccounts = accountRepository.findAll();
        for(Account account : allAccounts){
            if(account.getCustomerIds().contains(customerId)){
                accountList.add(account);
            }
        }
        allAccounts = null;
        return accountList;
    }

}
