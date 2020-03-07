package com.seven6two.examples.springtest.services;

import com.seven6two.examples.springtest.models.Customer;
import com.seven6two.examples.springtest.models.Role;
import com.seven6two.examples.springtest.models.User;
import com.seven6two.examples.springtest.repositories.CustomerRepository;
import com.seven6two.examples.springtest.repositories.RoleRepository;
import com.seven6two.examples.springtest.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("userService")
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private CustomerRepository customerRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, CustomerRepository customerRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.customerRepository = customerRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    // Create
    public User saveNewUser(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList(roleRepository.findByRole(user.getRoleDescription())));
        if(user.getCustomerId() < 0 || user.getCustomerId() == 0) {
            Customer customer = customerRepository.save(new Customer());
            user.setCustomerId(customer.getCustomerId());
        }

        return userRepository.save(user);
    }

    // Read
    public User findUserById(int ID){
        return userRepository.findById(ID);
    }

    public User findUserByEmail(String emailAddress){
        return userRepository.findByEmail(emailAddress);
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public List<Role> findAllRoles(){
        return roleRepository.findAll();
    }



}
