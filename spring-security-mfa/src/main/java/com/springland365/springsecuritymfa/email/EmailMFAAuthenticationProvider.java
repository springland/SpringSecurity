package com.springland365.springsecuritymfa.email;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class EmailMFAAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        EmailMAFToken  emailMAFToken = (EmailMAFToken) authentication;


        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {

        return EmailMAFToken.class.isAssignableFrom(authentication);
    }
}
