package com.springland365.springsecuritymfa.basic;

import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@Profile("basic")
public class InMemoryUserDetailsManager implements UserDetailsService {

    Map<String , CustomUser>  usersMap  ;


    public InMemoryUserDetailsManager()
    {
        usersMap = new HashMap<>();

        CustomUser  user = CustomUser.builder()
                .userName("user")
                .password("password")
                .authorities(
                        List.of( () -> "USER")
                ).build();

        usersMap.put("user" , user);
        CustomUser  admin = CustomUser.builder()
                .userName("admin")
                .password("password")
                .authorities(
                        List.of( () -> "ADMIN")
                ).build();

        usersMap.put("admin" , admin);

    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<? extends UserDetails>  optionalUserDetails =  Optional.ofNullable(usersMap.get(username));

        return optionalUserDetails.orElseThrow( () -> new UsernameNotFoundException(" user " + username + " is not found"));

    }
}
