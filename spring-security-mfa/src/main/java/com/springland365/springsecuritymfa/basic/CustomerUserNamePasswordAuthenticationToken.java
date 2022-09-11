package com.springland365.springsecuritymfa.basic;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomerUserNamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {

    public CustomerUserNamePasswordAuthenticationToken(Object principal, Object credentials) {

        super(principal , credentials);
    }

    public CustomerUserNamePasswordAuthenticationToken(Object principal, Object credentials,
                                               Collection<? extends GrantedAuthority> authorities) {

        super(principal , credentials , authorities);
    }

}
