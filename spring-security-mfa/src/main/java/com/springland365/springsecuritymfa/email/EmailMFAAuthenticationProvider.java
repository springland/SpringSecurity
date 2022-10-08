package com.springland365.springsecuritymfa.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Random;

@Component
@Slf4j
public class EmailMFAAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    UserDetailsService  userDetailsService ;

    @Autowired
    PasswordEncoder  passwordEncoder ;

    @Autowired
    EmailService emailService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        EmailMFAToken emailMAFToken = (EmailMFAToken) authentication;

        if(emailMAFToken.getToken() == null)
        {
            EmailMFAUserDetails userDetails = (EmailMFAUserDetails) userDetailsService.loadUserByUsername(emailMAFToken.getUsername());

            if(userDetails == null || !passwordEncoder.matches((String)emailMAFToken.getCredentials() , userDetails.getPassword()))
            {
                throw new BadCredentialsException("Please check your username/password");

            }

            String code = generateCode();
            userDetails.setCode(code);

            //emailService.sendEmail("noreply@springland365.com" , userDetails.getEmail() , "code" , code);

            EmailMFAToken  auth = new EmailMFAToken(userDetails , (String) authentication.getCredentials() , Collections.emptyList());
            return auth ;

        }
        else {
            EmailMFAUserDetails userDetails = (EmailMFAUserDetails) userDetailsService.loadUserByUsername(emailMAFToken.getUsername());
            if(userDetails.getCode().equals(emailMAFToken.getToken()))
            {

                EmailMFAToken  auth = new EmailMFAToken(userDetails , (String) authentication.getCredentials() , Collections.emptyList());
                return auth ;

            }
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {

        return EmailMFAToken.class.isAssignableFrom(authentication);
    }


    protected String generateCode()
    {
        Random rand = new Random();
        int value = rand.nextInt(999999);

        String  code = String.format("%6d" , value);

        return code ;

    }
}
