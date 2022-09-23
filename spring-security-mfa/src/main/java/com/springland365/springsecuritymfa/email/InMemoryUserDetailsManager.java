package com.springland365.springsecuritymfa.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
@Profile("email")
public class InMemoryUserDetailsManager implements UserDetailsService  , UserDetailsRepo{

    @Autowired
    PasswordEncoder  passwordEncoder ;

    Map<String , EmailMFAUserDetails> userDetailsMap = new HashMap<>();


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userDetailsMap.get(username);

    }

    @Override
    public void createUser(String userName, String password, String email) {
        EmailMFAUserDetails  userDetails =
                new EmailMFAUserDetails(
                        userName , passwordEncoder.encode(password) , email , Collections.EMPTY_LIST
                );

        userDetailsMap.put(userName , userDetails);
    }
}
