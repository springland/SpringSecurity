package com.springland365.springsecuritymfa.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class EmailMFAAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    AuthenticationManager  authenticationManager ;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String username = request.getParameter("emailmfausername");
        String password = request.getParameter("emailmfapassword");
        String token = request.getParameter("emailmfatoken");

        if(username != null) {
            EmailMFAToken emailMAFToken = new EmailMFAToken(username, password, token);
            Authentication authentication = authenticationManager.authenticate(emailMAFToken);
            if (authentication != null) {
                SecurityContextHolder.getContext().setAuthentication(authentication);
                return ;
            }
        }
        filterChain.doFilter(request , response);
    }

}
