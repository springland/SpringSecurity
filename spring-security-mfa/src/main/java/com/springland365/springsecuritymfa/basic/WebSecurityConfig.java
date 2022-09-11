package com.springland365.springsecuritymfa.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@Profile("basic")
public class WebSecurityConfig {

    @Autowired
    AuthenticationProvider   authenticationProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http  ) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());

        http.authenticationProvider(authenticationProvider);
        http.httpBasic();

        http.formLogin();
        http.logout();

        return http.build();
    }

}
