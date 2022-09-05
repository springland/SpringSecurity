package com.springland365.springsecuritybasic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfig {

    @Bean
    @Profile("bcrypt")
    public PasswordEncoder  bcryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PasswordEncoder delegatingPasswordEncoder()
    {
        PasswordEncoder passwordEncoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();

        return passwordEncoder ;
    }

}
