package com.springland365.springsecuritybasic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.management.StandardEmitterMBean;
import java.util.Collections;

@Configuration
@Profile("in-memory")
@Slf4j
public class InMemoryUserConfig {

    @Bean
    public UserDetailsService  inMemoryUserService()
    {
        InMemoryUserDetailsManager  inMemoryUserDetailsManager = new InMemoryUserDetailsManager();


        String password = "password";

        String encoded = null;
        BCryptPasswordEncoder  bCryptPasswordEncoder = new BCryptPasswordEncoder();
        encoded = bCryptPasswordEncoder.encode(password);
        log.info("bcrypt : " + encoded);
        encoded = bCryptPasswordEncoder.encode(password);
        log.info("bcrypt 2: " + encoded);

        UserDetails  admin = User.withUsername("admin").password(String.format("{bcrypt}%s", encoded)).authorities("ADMIN" , "USER").build();

        inMemoryUserDetailsManager.createUser(admin);

        Pbkdf2PasswordEncoder  pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder();
        encoded = pbkdf2PasswordEncoder.encode(password);
        log.info("pbkdf2 1: " + encoded );
        encoded = pbkdf2PasswordEncoder.encode(password);
        log.info("pbkdf2 2: " + encoded );

        UserDetails user = User.withUsername("user").password(String.format("{pbkdf2}%s", encoded)).authorities("USER").build();

        inMemoryUserDetailsManager.createUser( user  );


        SCryptPasswordEncoder  sCryptPasswordEncoder = new SCryptPasswordEncoder();
        encoded = sCryptPasswordEncoder.encode(password);
        log.info("scrypt 1: " + encoded );
        encoded = sCryptPasswordEncoder.encode(password);
        log.info("scrypt 2: " + encoded );

        UserDetails manager = User.withUsername("manager").password(String.format("{scrypt}%s", encoded)).authorities("MANAGER" , "USER").build();
        inMemoryUserDetailsManager.createUser( manager   );



        return inMemoryUserDetailsManager ;

    }
}
