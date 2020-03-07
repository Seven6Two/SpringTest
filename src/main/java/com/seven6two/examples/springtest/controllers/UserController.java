package com.seven6two.examples.springtest.controllers;

import com.seven6two.examples.springtest.models.User;
import com.seven6two.examples.springtest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = {"", "/", "/home", "/dashboard"}, method = RequestMethod.GET)
    public ModelAndView getDashboard(Authentication authentication){
        ModelAndView mav = new ModelAndView();
        User user = userService.findUserByEmail(authentication.getName());
        mav.addObject("user", user);
        mav.setViewName("user/index");
        return mav;
    }

}
