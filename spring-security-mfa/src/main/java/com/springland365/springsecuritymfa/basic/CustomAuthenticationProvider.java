package com.springland365.springsecuritymfa.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Profile("basic")
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    protected    UserDetailsService  userDetailsService ;

    @Autowired
    protected PasswordEncoder passwordEncoder;


    CustomAuthenticationProvider()
    {

    }
    /*
    CustomAuthenticationProvider(UserDetailsService uds , PasswordEncoder passwordEncoder){
        this.userDetailsService =uds ;
        this.passwordEncoder = passwordEncoder ;
    }

     */

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        Optional<String> userNameOptional = Optional.ofNullable(authentication.getName());

        try {
            UserDetails u = userNameOptional.map(
                    username -> userDetailsService.loadUserByUsername(username)
            ).get();

            if(passwordEncoder.matches(authentication.getCredentials().toString() , u.getPassword()))
            {
                CustomerUserNamePasswordAuthenticationToken  token = new CustomerUserNamePasswordAuthenticationToken(
                    authentication.getName(),
                    authentication.getCredentials().toString() ,
                    u.getAuthorities()
                );

                return token ;

            }
            else{
                throw new BadCredentialsException(" Wrong password");
            }
        }
        catch(UsernameNotFoundException ex){
            throw new BadCredentialsException("Wrong password");
        }


    }

    @Override
    public boolean supports(Class<?> authentication) {

        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
