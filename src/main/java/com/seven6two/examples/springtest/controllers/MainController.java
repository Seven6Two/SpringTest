package com.seven6two.examples.springtest.controllers;

import com.seven6two.examples.springtest.models.Customer;
import com.seven6two.examples.springtest.models.User;
import com.seven6two.examples.springtest.services.CustomerService;
import com.seven6two.examples.springtest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = {"/", "/home", "/dashboard", "/index"}, method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView addUser(){
        ModelAndView modelAndView = new ModelAndView("register");
        User user = new User();
        modelAndView.addObject("user", user);

        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView addNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        User userExists = userService.findUserByEmail(user.getEmail());
        Customer newCustomer = new Customer();
        newCustomer.setForename("");
        newCustomer.setSurname("");
        newCustomer.setDateOfBirth(new Date());
        newCustomer = customerService.save(newCustomer);
        user.setCustomerId(newCustomer.getCustomerId());

        if (userExists != null) {
            bindingResult.rejectValue("email", "error.user","There is already a user registered with the email provided");
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
        } else {
            user.setRoleDescription("USER");
            User U = userService.saveNewUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/whoops", method = RequestMethod.GET)
    public ModelAndView whoops(){
        ModelAndView modelAndView = new ModelAndView("whoops");
        return modelAndView;
    }


}
