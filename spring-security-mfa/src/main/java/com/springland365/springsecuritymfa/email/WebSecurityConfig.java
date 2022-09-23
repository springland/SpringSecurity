package com.springland365.springsecuritymfa.email;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@Profile("email")
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http  ) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .mvcMatchers("/email/login").permitAll()
                        .mvcMatchers("/email/signup").permitAll()
                        .anyRequest().permitAll()
                );

        http.formLogin().loginPage("/email/login") ;

        return http.build();
    }

}
