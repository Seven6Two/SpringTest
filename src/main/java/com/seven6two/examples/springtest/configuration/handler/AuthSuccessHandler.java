package com.seven6two.examples.springtest.configuration.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class AuthSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Set<String> authTypes = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if(authTypes.contains("USER")){
            response.sendRedirect("/user/dashboard");
            return;
        }else if(authTypes.contains("ADMIN")){
            response.sendRedirect("/admin/dashboard");
            return;
        }
    }
}
